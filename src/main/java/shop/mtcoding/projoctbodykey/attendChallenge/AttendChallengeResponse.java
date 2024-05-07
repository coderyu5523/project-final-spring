package shop.mtcoding.projoctbodykey.attendChallenge;

import lombok.Data;

import java.sql.Timestamp;

public class AttendChallengeResponse {

    @Data
    public static class SaveDTO {
        private Integer userId;
        private Integer challengeId;
        private Timestamp openingTime;
        private Timestamp closingTime;
        private Boolean status;

        public SaveDTO(AttendChallenge attendChallenge) {
            this.userId = attendChallenge.getUser().getId();
            this.challengeId = attendChallenge.getChallenge().getId();
            this.openingTime = attendChallenge.getCreatedAt();
            this.closingTime = attendChallenge.getClosingTime();
            this.status = attendChallenge.getStatus();
        }
    }
}
