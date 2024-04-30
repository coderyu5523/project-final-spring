package shop.mtcoding.projoctbodykey.challenge;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.domain.Page;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class ChallengeResponse {

    @Data
    public static class ChallengeDTO {
        private Integer id;
        private String challengeName; // 챌린지명
        private String subtitle;
        private Timestamp closingTime;
        private Integer coin;
        private Boolean status;
        private List<NonPartChallengesDTO> nonPartChallenges;
        private List<PartChallengesDTO> partChallenges;

//
//        public ChallengeDTO(Challenge challenge, Timestamp closingTime, Boolean status, List<Challenge> nonPartChallenges, List<Challenge> partChallenges) {
//            this.id = challenge.getId();
//            this.challengeName = challenge.getChallengeName();
//            this.subtitle = challenge.getSubTitle();
//            this.closingTime = closingTime;
//            this.coin = challenge.getCoin();
//            this.nonPartChallenges = nonPartChallenges.stream().map(NonPartChallengesDTO::new).toList();
//            this.partChallenges = partChallenges.stream().map(c -> new PartChallengesDTO(c, status)).collect(Collectors.toList());
//        }

        @Data
        public static class NonPartChallengesDTO {
            private Integer id;
            private String challengeName; // 챌린지명
            private String distance; // 거리
            private String badgeImg; // 뱃지 사진 경로

            public NonPartChallengesDTO(Challenge challenge) {
                this.id = challenge.getId();
                this.challengeName = challenge.getChallengeName();
                this.distance = challenge.getDistance();
                this.badgeImg = challenge.getBadgeImg();
            }
        }

        @Data
        public static class PartChallengesDTO {
            private Integer id;
            private String challengeName; // 챌린지명
            private String distance; // 거리
            private String badgeImg; // 뱃지 사진 경로
            private Boolean status;

            public PartChallengesDTO(Challenge challenge, Boolean status) {
                this.id = challenge.getId();
                this.challengeName = challenge.getChallengeName();
                this.distance = challenge.getDistance();
                this.badgeImg = challenge.getBadgeImg();
                this.status = status;
            }
        }
    }

    @Data
    public static class DetailDTO {
        private Integer id;
        private String challengeName; // 챌린지명
        private String backgroundImg;// 챌린지 배경사진
        private String subTitle; // 부 제목
//        private String distance; // 거리
        private Integer walking; // 걸어야할 걸음수
//        private String badgeImg; // 뱃지 사진 경로
        private String content;  // 챌린지 내용
//        private Integer coin; // 보상 코인
//        private Timestamp period; //챌린지 기간
//        private Timestamp createdAt;

        @Builder
        public DetailDTO(String backgroundImg, Challenge challenge) {
            this.id = challenge.getId();
            this.challengeName = challenge.getChallengeName();
            this.backgroundImg = backgroundImg;
            this.subTitle = challenge.getSubTitle();
//            this.distance = challenge.getDistance();
            this.walking = challenge.getWalking();
//            this.badgeImg = challenge.getBadgeImg();
            this.content = challenge.getContent();
//            this.coin = challenge.getCoin();
//            this.period = challenge.getPeriod();
//            this.createdAt = challenge.getCreatedAt();
        }
    }

    @Data
    public static class AdminChallengeListDTO {
        private Boolean first;
        private Boolean last;
        private Integer prev;
        private Integer next;
        private List<AdminChallengeList> challengeList;

        public AdminChallengeListDTO(Boolean first, Boolean last, Integer prev, Integer next, Page<Challenge> challengeList) {
            this.first = first;
            this.last = last;
            this.prev = prev;
            this.next = next;

            // 받아온 Page<Challenge>를 리스트로 변환
            this.challengeList = challengeList.getContent().stream()
                    .map(AdminChallengeList::new)
                    .collect(Collectors.toList());
        }

        @Data
        public static class AdminChallengeList {
            private Integer id;
            private String challengeName;
            private String subTitle;
            private Integer walking;
            private String distance;
            private Integer coin;
            private Integer period;

            @Builder
            public AdminChallengeList(Challenge challenge) {
                this.id = challenge.getId();
                this.challengeName = challenge.getChallengeName();
                this.subTitle = challenge.getSubTitle();
                this.walking = challenge.getWalking();
                this.distance = challenge.getDistance();
                this.coin = challenge.getCoin();
                this.period = challenge.getPeriod();
            }
        }
    }

    @Data
    public static class AdminChallengeSearchListDTO {
        private Boolean first;
        private Boolean last;
        private Integer prev;
        private Integer next;
        private String keyword;
        private List<AdminChallengeSearchList> challengeList;

        public AdminChallengeSearchListDTO(Boolean first, Boolean last,  Integer prev, Integer next, String keyword, Page<Challenge> challengeList) {
            this.first = first;
            this.last = last;
            this.prev = prev;
            this.next = next;
            this.keyword = keyword;

            // 받아온 Page<Challenge>를 리스트로 변환
            this.challengeList = challengeList.getContent().stream()
                    .map(AdminChallengeSearchList::new)
                    .collect(Collectors.toList());
        }

        @Data
        public static class AdminChallengeSearchList {
            private Integer id;
            private String challengeName;
            private String subTitle;
            private Integer walking;
            private String distance;
            private Integer coin;
            private Integer period;

            @Builder
            public AdminChallengeSearchList(Challenge challenge) {
                this.id = challenge.getId();
                this.challengeName = challenge.getChallengeName();
                this.subTitle = challenge.getSubTitle();
                this.walking = challenge.getWalking();
                this.distance = challenge.getDistance();
                this.coin = challenge.getCoin();
                this.period = challenge.getPeriod();
            }
        }
    }
}
