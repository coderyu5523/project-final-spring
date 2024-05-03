package shop.mtcoding.projoctbodykey._core.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception400;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

public class ImageUtil {

    public static String decodeAsUUID(String img) throws IOException {
        // 이미지를 디코딩하여 저장하고 파일명 생성
        byte[] imageData = Base64.getDecoder().decode(img);
        String imgUUID = UUID.randomUUID() + ".jpg";
        String imagePath = "./upload/" + imgUUID;

        // 이미지 파일로 저장
        File file = new File(imagePath);
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(imageData);
        outputStream.close();

        return imgUUID;
    }

    /**
     * 이미지를 지정된 너비와 높이로 조정하고 저장하는 메서드
     *
     * @param errorMsg     에러 메시지
     * @param img          이미지 파일명
     * @param imageFile    조정할 이미지 파일
     * @param targetWidth  원하는 이미지의 너비
     * @param targetHeight 원하는 이미지의 높이
     * @return 조정된 이미지의 UUID
     * @throws IOException 이미지 조정 중 발생한 IO 예외
     */
    public static String imgResizedAndDownloadAndUUID(String errorMsg, String img, MultipartFile imageFile, int targetWidth, int targetHeight) throws IOException {
        if (imageFile == null || imageFile.isEmpty()) {
            throw new Exception400(errorMsg + "가 없습니다.");
        }

        // MultipartFile을 BufferedImage로 변환
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageFile.getBytes()));

        // 이미지를 지정된 크기로 조정
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);

        // 조정된 이미지를 BufferedImage로 다시 변환
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        // 조정된 이미지를 바이트 배열로 변환하여 반환
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(outputImage, "jpg", outputStream);

        String imgUUID = UUID.randomUUID() + "_" + img;
        Path imgPaths = Paths.get("./upload/" + imgUUID);
        Files.write(imgPaths, outputStream.toByteArray());

        return imgUUID;
    }

    /**
     * 이미지를 지정된 너비와 높이로 조정하는 메서드
     *
     * @param imageFile    조정할 이미지 파일
     * @param targetWidth  원하는 이미지의 너비
     * @param targetHeight 원하는 이미지의 높이
     * @return 조정된 이미지를 바이트 배열로 반환
     * @throws IOException 이미지 조정 중 발생한 IO 예외
     */
    public static byte[] imgResized(MultipartFile imageFile, int targetWidth, int targetHeight) throws IOException {
        // MultipartFile을 BufferedImage로 변환
        BufferedImage originalImage = ImageIO.read(new ByteArrayInputStream(imageFile.getBytes()));

        // 이미지를 지정된 크기로 조정
        Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);

        // 조정된 이미지를 BufferedImage로 다시 변환
        BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);

        // 조정된 이미지를 바이트 배열로 변환하여 반환
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(outputImage, "jpg", outputStream);
        return outputStream.toByteArray();
    }

    /**
     * 이미지 파일을 Base64로 인코딩하는 메서드
     *
     * @param img 이미지 파일명
     * @return Base64로 인코딩된 이미지 데이터
     * @throws IOException 이미지 파일을 읽어오는 도중 발생한 예외
     */
    public static String encode(String img) throws IOException {
        String imagePath = "./upload/" + img;
        File file = new File(imagePath);

        // 파일이 존재하면 읽어들임
        if (file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            byte[] imageData = IOUtils.toByteArray(inputStream);
            inputStream.close();

            // 이미지를 Base64로 인코딩하여 직접 반환
            return Base64.getEncoder().encodeToString(imageData);
        } else {
            throw new FileNotFoundException("파일을 찾을 수 없습니다: " + imagePath);
        }
    }

    /**
     * 이미지 파일의 UUID를 생성하는 메서드
     *
     * @param img 이미지 파일명
     * @return 생성된 UUID
     */
    public static String imgUUID(String img) {
        return UUID.randomUUID() + "_" + img;
    }
}
