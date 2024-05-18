package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.validation.constraints.*;
import lombok.Data;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

public class AttendChallengeRequest {

    @Data
    public static class SaveDTO {

        @NotNull(message = "Challenge는 필수 입력 항목입니다.")
        private Challenge challenge;

        public AttendChallenge toEntity(Timestamp closingTime, SaveDTO reqDTO, User sessionUser) {
            return AttendChallenge.builder()
                    .user(sessionUser)
                    .challenge(reqDTO.challenge)
                    .closingTime(closingTime)
                    .status(null)
                    .build();
        }
    }

    @Data
    public static class StatusUpdateDTO {

        @NotNull(message = "null값을 넣을 수 없어요")
        private Boolean status;
    }
}
