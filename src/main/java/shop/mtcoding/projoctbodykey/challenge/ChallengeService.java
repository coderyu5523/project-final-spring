package shop.mtcoding.projoctbodykey.challenge;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception400;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;

import java.io.*;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeJPARepository challengeJPARepository;

    public ChallengeResponse.DetailDTO detail(Integer id) throws IOException {
        Challenge challenge = challengeJPARepository.findById(id).orElseThrow(() ->
                new Exception404("해당 챌린지를 찾을 수 없습니다."));

        // 이미지 파일을 읽어서 byte 배열로 변환
        String imagePath = "./upload/" + challenge.getBackgroundImg();
        File file = new File(imagePath);

        // 파일이 존재하면 읽어들임
        if (file.exists()) {
            InputStream inputStream = new FileInputStream(file);
            byte[] imageData = IOUtils.toByteArray(inputStream);
            inputStream.close();

            // 이미지를 Base64로 인코딩
            String backgroundImg = Base64.getEncoder().encodeToString(imageData);

            ChallengeResponse.DetailDTO reqDTO = new ChallengeResponse.DetailDTO(backgroundImg, challenge);
            return reqDTO;
        } else {
            throw new FileNotFoundException("파일을 찾을 수 없습니다: " + imagePath);
        }
    }

    // 검색 없는 관리자 페이지 챌린지 리스트
    public ChallengeResponse.AdminChallengeListDTO adminChallengeList(Integer page, Pageable pageable) {
        Page<Challenge> challenges = challengeJPARepository.findAll(pageable);

        // 페이지가 0이라면 첫번째 페이지
        Boolean first = page == 0;

        // 페이지의 토탈 페이지 수가 페이지 수에 1을 더한 값과 같다면 마지막 페이지
        Boolean last = challenges.getTotalPages() == page + 1;

        Integer prev = page - 1;
        Integer next = page + 1;

        return new ChallengeResponse.AdminChallengeListDTO(first, last, prev, next, challenges);
    }

    // 검색 있는 관리자 페이지 챌린지 리스트
    public ChallengeResponse.AdminChallengeSearchListDTO adminChallengeSearchList(String keyword, Integer page, Pageable pageable) {
        Page<Challenge> challenges = challengeJPARepository.findAllKeyword(keyword, pageable);
        
        // 페이지가 0이라면 첫번째 페이지
        Boolean first = page == 0;

        // 페이지의 토탈 페이지 수가 페이지 수에 1을 더한 값과 같다면 마지막 페이지
        Boolean last = challenges.getTotalPages() == page + 1;
        Integer prev = page - 1;
        Integer next = page + 1;

        return new ChallengeResponse.AdminChallengeSearchListDTO(first, last, prev, next, keyword, challenges);
    }

    public Challenge adminDetail(Integer id) {
        return challengeJPARepository.findById(id).orElseThrow(() ->
                new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    public Challenge adminUpdateForm(Integer id) {
        return challengeJPARepository.findById(id).orElseThrow(() ->
                new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    public void adminSave(ChallengeRequest.AdminSaveDTO reqDTO, String period) {
        try {
            int targetWidth = 800;
            int targetHeight = 600;

            // 백그라운드 이미지
            MultipartFile backgroundImg = reqDTO.getBackgroundImgFile();
            if (backgroundImg == null || backgroundImg.isEmpty()) {
                throw new Exception400("배경 이미지가 없습니다.");
            }
            String backgroundImgUUID = ImageUtil.resizeImage(reqDTO.getBackgroundImg() ,backgroundImg, targetWidth, targetHeight);

            // 배지 이미지
            MultipartFile badgeImg = reqDTO.getBadgeImgFile();
            if (badgeImg == null || badgeImg.isEmpty()) {
                throw new Exception400("배지 이미지가 없습니다.");
            }
            String badgeImgUUID = ImageUtil.resizeImage(reqDTO.getBadgeImg(), badgeImg, targetWidth, targetHeight);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp timestamp = new Timestamp(dateFormat.parse(period).getTime());

            // 둘의 UUID를 받아서 인설트 해주는것
            challengeJPARepository.save(reqDTO.toEntity(backgroundImgUUID, badgeImgUUID, timestamp));
        } catch (IOException | ParseException e) {
            // 오류 처리
            e.printStackTrace();
        }
    }

    @Transactional
    public void adminUpdate(Integer id, ChallengeRequest.AdminUpdateDTO reqDTO, String period) {
        try {
            Challenge challenge = challengeJPARepository.findById(id)
                    .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));

            int targetWidth = 800;
            int targetHeight = 600;

            // 백그라운드 이미지
            MultipartFile backgroundImg = reqDTO.getBackgroundImgFile();
            if (backgroundImg == null || backgroundImg.isEmpty()) {
                throw new Exception400("배경 이미지가 없습니다.");
            }
            String backgroundImgUUID = ImageUtil.resizeImage(reqDTO.getBackgroundImg() ,backgroundImg, targetWidth, targetHeight);

            // 배지 이미지
            MultipartFile badgeImg = reqDTO.getBadgeImgFile();
            if (badgeImg == null || badgeImg.isEmpty()) {
                throw new Exception400("배지 이미지가 없습니다.");
            }
            String badgeImgUUID = ImageUtil.resizeImage(reqDTO.getBadgeImg(), badgeImg, targetWidth, targetHeight);

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Timestamp timestamp = new Timestamp(dateFormat.parse(period).getTime());

            challenge.setChallengeName(reqDTO.getChallengeName());
            challenge.setBackgroundImg(backgroundImgUUID);
            challenge.setSubTitle(reqDTO.getSubTitle());
            challenge.setDistance(reqDTO.getDistance());
            challenge.setWalking(reqDTO.getWalking());
            challenge.setBadgeImg(badgeImgUUID);
            challenge.setContent(reqDTO.getContent());
            challenge.setCoin(reqDTO.getCoin());
            challenge.setPeriod(timestamp);
        } catch (IOException | ParseException e) {
            // 오류 처리
            e.printStackTrace();
        }
    }

    @Transactional
    public void adminDelete(Integer id) {
        Challenge challenge = challengeJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
        challengeJPARepository.delete(challenge);
    }
}