package shop.mtcoding.projoctbodykey.choiceanswer;

import lombok.Data;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoice;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;
import shop.mtcoding.projoctbodykey.user.User;

import java.awt.*;
import java.sql.Timestamp;
public class ChoiceAnswerRequest {

    @Data
    public static class AnswerDTO {
        private Integer questionId;
        private Integer choiceId;
    }

    @Data
    public static class SaveDTO {
        private User user;
        private Survey survey;
        private SurveyQuestion surveyQuestion;
        private QuestionChoice questionChoice;

        public SaveDTO(User user, Survey survey, SurveyQuestion surveyQuestion, QuestionChoice questionChoice) {
            this.user = user;
            this.survey = survey;
            this.surveyQuestion = surveyQuestion;
            this.questionChoice = questionChoice;
        }

        public ChoiceAnswer toEntity() {
            return ChoiceAnswer.builder()
                    .user(user)
                    .survey(survey)
                    .surveyQuestion(surveyQuestion)
                    .questionChoice(questionChoice)
                    .createdAt(new Timestamp(System.currentTimeMillis()))
                    .build();
        }

    }
}
