package shop.mtcoding.projoctbodykey.whichChallenge;

import lombok.Data;

public class WhichChallengeRequest {

    @Data
    public static class AdminChallengeSaveDTO {
        private String challengeName; // 챌린지명
        private String challengeFilename;// 챌린지 사진경로
        private Integer meter; // 산 높이
        private String badgeFilename; // 뱃지 사진 경로
        private String location; // 산 지역
        private String content;  // 챌린지 내용

        public WhichChallenge toEntity() {
            return WhichChallenge.builder()
                    .challengeName(challengeName)
                    .challengeFilename(challengeFilename)
                    .meter(meter)
                    .badgeFilename(badgeFilename)
                    .location(location)
                    .content(content)
                    .build();
        }
    }
}
