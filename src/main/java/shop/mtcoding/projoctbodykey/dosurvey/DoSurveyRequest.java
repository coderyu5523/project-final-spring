package shop.mtcoding.projoctbodykey.dosurvey;

import lombok.Data;

import shop.mtcoding.projoctbodykey.survey.Survey;

import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;



public class DoSurveyRequest {
    @Data
    public static class SaveDTO {
        private User user;
        private Survey survey;

        public DoSurvey toEntity() {
            return DoSurvey.builder()
                    .user(user)
                    .survey(survey)
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .build();
        }

        public SaveDTO(User user, Survey survey) {
            this.user = user;
            this.survey = survey;
        }
    }
}
