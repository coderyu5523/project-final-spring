package shop.mtcoding.projoctbodykey.questionchoice;

import lombok.Data;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;

import java.sql.Time;
import java.sql.Timestamp;

public class QuestionChoiceRequest {
    @Data
    public static class SaveDTO {
        private Survey survey;
        private SurveyQuestion surveyQuestion;
        private Integer choiceNumber;
        private String choiceItem;
        private Timestamp timestamp;

        public QuestionChoice toEntity () {
            return QuestionChoice.builder()
                    .survey(survey)
                    .surveyQuestion(surveyQuestion)
                    .choiceNumber(choiceNumber)
                    .choiceItem(choiceItem)
                    .createdAt(timestamp)
                    .build();
        }

        public SaveDTO(Survey survey, Integer choiceNumber,SurveyQuestion surveyQuestion, String choiceItem, Timestamp timestamp) {
            this.survey = survey;
            this.surveyQuestion = surveyQuestion;
            this.choiceNumber = choiceNumber;
            this.choiceItem = choiceItem;
            this.timestamp = timestamp;
        }
    }
}
