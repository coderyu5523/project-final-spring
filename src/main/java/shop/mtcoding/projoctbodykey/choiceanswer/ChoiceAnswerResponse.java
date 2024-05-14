package shop.mtcoding.projoctbodykey.choiceanswer;

import lombok.Data;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoice;
import java.util.List;


public class ChoiceAnswerResponse {
    @Data
    public static class GetChoiceAnswer {
        private Integer userId;
        private Integer surveyId;
        private List<QuestionAndAnswerDTO> QuestionAndAnswers;


        @Data
        public static class QuestionAndAnswerDTO{
            private Integer surveyQuestion;
            private Integer questionChoice;

            public QuestionAndAnswerDTO(Integer surveyQuestion, Integer questionChoice) {
                this.surveyQuestion = surveyQuestion;
                this.questionChoice = questionChoice;
            }
        }

        public GetChoiceAnswer(Integer userId, Integer surveyId, List<QuestionAndAnswerDTO> questionAndAnswers) {
            this.userId = userId;
            this.surveyId = surveyId;
            this.QuestionAndAnswers = questionAndAnswers;
        }
    }
}
