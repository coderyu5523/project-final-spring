package shop.mtcoding.projoctbodykey.attendChallenge;

import lombok.Data;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

public class AttendChallengeRequest {

    @Data
    public static class SaveDTO {
        private User user;
        private Challenge challenge;
        private Timestamp openingTime;
        private Timestamp closingTime;
        private Boolean status;

        public AttendChallenge toEntity(Timestamp closingTime, SaveDTO reqDTO, User sessionUser) {
            return AttendChallenge.builder()
                    .user(sessionUser)
                    .challenge(reqDTO.challenge)
                    .closingTime(closingTime)
                    .status(null)
                    .build();
        }
    }
}
