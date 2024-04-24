package shop.mtcoding.projoctbodykey.Challenge;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ChallengeRequest {

    @Data
    public static class AdminChallengeSaveDTO {
        private String challengeName; // 챌린지명
        private String backgroundImg;// 챌린지 배경사진 경로
        private String subTitle; // 산 지역
        private String distance; // 산 지역
        private Integer walking; // 걸어야할 걸음수
        private String badgeImg; // 뱃지 사진 경로
        private String content;  // 챌린지 내용
        private Integer coin; // 보상 코인
        private Timestamp period; //챌린지 기간
        private MultipartFile backgroundImgFile; // 챌린지 배경사진 파일
        private MultipartFile badgeImgFile; // 뱃지 사진 파일

        public Challenge toEntity(String backgroundImg, String badgeImg) {
            return Challenge.builder()
                    .challengeName(challengeName)
                    .backgroundImg(backgroundImg)
                    .subTitle(subTitle)
                    .walking(walking)
                    .distance(distance)
                    .badgeImg(badgeImg)
                    .content(content)
                    .coin(coin)
                    .period(period)
                    .build();
        }
    }
}
