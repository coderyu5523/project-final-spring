package shop.mtcoding.projoctbodykey.surveyquestion;

import lombok.Data;
import shop.mtcoding.projoctbodykey.survey.Survey;

import java.sql.Timestamp;

public class SurveyQuestionRequest {
    @Data
    public static class SaveDTO {
        private Survey survey;
        private String questionItem;
        private Timestamp createdAt;

        public SurveyQuestion toEntity () {
            return SurveyQuestion.builder()
                    .survey(survey)
                    .questionItem(questionItem)
                    .createdAt(createdAt)
                    .build();
        }

        public SaveDTO(Survey survey, String questionItem, Timestamp createdAt) {
            this.survey = survey;
            this.questionItem = questionItem;
            this.createdAt = createdAt;
        }
    }
}
