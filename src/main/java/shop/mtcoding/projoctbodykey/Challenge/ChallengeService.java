package shop.mtcoding.projoctbodykey.Challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeJPARepository challengeJPARepository;

    public List<Challenge> adminChallengeList() {

        return challengeJPARepository.findAll();
    }

    @Transactional
    public void adminChallengeSave(Timestamp period, ChallengeRequest.AdminChallengeSaveDTO reqDTO) throws IOException {
        System.out.println(period);


        // 백그라운드 이미지
        MultipartFile backgroundImg = reqDTO.getBackgroundImgFile();
        String backgroundImgUUID = UUID.randomUUID() + "_" + backgroundImg.getOriginalFilename();
        Path backgroundImgPaths = Paths.get("./upload/" + backgroundImgUUID);
        Files.write(backgroundImgPaths, backgroundImg.getBytes());

        // 배지 이미지
        MultipartFile badgeImg = reqDTO.getBadgeImgFile();
        String badgeImgUUID = UUID.randomUUID() + "_" + backgroundImg.getOriginalFilename();
        Path badgeImgPath = Paths.get("./upload/" + badgeImgUUID);
        Files.write(badgeImgPath, badgeImg.getBytes());

        // 둘의 UUID를 받아서 인설트 해주는것
        challengeJPARepository.save(reqDTO.toEntity(backgroundImgUUID, badgeImgUUID));
    }
}