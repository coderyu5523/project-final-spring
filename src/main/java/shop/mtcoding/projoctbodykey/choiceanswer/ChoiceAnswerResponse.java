package shop.mtcoding.projoctbodykey.choiceanswer;

import lombok.Data;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoice;
import java.util.List;


public class ChoiceAnswerResponse {
    @Data
    public static class ChoiceAnswerList {
        private Integer userId;
        private Integer surveyId;
        private List<QuestionAndAnswerDTO> questionAndAnswers;


        @Data
        public static class QuestionAndAnswerDTO{
            private Integer questionId;
            private Integer choiceId;

            public QuestionAndAnswerDTO(Integer questionId, Integer choiceId) {
                this.questionId = questionId;
                this.choiceId = choiceId;
            }
        }

        public ChoiceAnswerList(Integer userId, Integer surveyId, List<QuestionAndAnswerDTO> questionAndAnswers) {
            this.userId = userId;
            this.surveyId = surveyId;
            this.questionAndAnswers = questionAndAnswers;
        }
    }
}
