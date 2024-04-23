package shop.mtcoding.projoctbodykey.Challenge;

import lombok.Data;

public class ChallengeRequest {

    @Data
    public static class AdminChallengeSaveDTO {
        private String challengeName; // 챌린지명
        private String backgroundImg;// 챌린지 배경사진
        private Integer distance; // 산 높이
        private String badgeImg; // 뱃지 사진
        private String location; // 산 지역
        private String content;  // 챌린지 내용

        public Challenge toEntity() {
            return Challenge.builder()
                    .challengeName(challengeName)
                    .backgroundImg(backgroundImg)
                    .distance(distance)
                    .badgeImg(badgeImg)
                    .location(location)
                    .content(content)
                    .build();
        }
    }
}
