package shop.mtcoding.projoctbodykey.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeJPARepository challengeJPARepository;

    public List<Challenge> ChallengeSearch(String keyword) {

        List<Challenge> challengeList;

        if (keyword.isBlank()) {
            challengeList = challengeJPARepository.findAll();

        } else {
            challengeList = challengeJPARepository.findAllKeyword(keyword);
        }

        return challengeList;
    }

    public List<Challenge> adminList() {
        return challengeJPARepository.findAll();
    }

    public Challenge adminDetail(Integer id) {
        return challengeJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    public Challenge adminUpdateForm(Integer id) {
        return challengeJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    @Transactional
    public void adminSave(ChallengeRequest.AdminSaveDTO reqDTO, String period) throws IOException, ParseException {

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


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp timestamp = new Timestamp(dateFormat.parse(period).getTime());

        // 둘의 UUID를 받아서 인설트 해주는것
        challengeJPARepository.save(reqDTO.toEntity(backgroundImgUUID, badgeImgUUID, timestamp));
    }

    @Transactional
    public void adminUpdate(Integer id, ChallengeRequest.AdminUpdateDTO reqDTO, String period) throws IOException, ParseException {
        Challenge challenge = challengeJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));

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
    }

    @Transactional
    public void adminDelete(Integer id) {
        Challenge challenge = challengeJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
        challengeJPARepository.delete(challenge);
    }
}