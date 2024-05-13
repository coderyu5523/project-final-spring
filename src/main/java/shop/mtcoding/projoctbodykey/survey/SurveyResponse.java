package shop.mtcoding.projoctbodykey.survey;

import lombok.Data;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyResponse;
import shop.mtcoding.projoctbodykey.dosurvey.DoSurvey;
import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SurveyResponse {

    @Data
    public static class SurveyDTO {
        private Integer id;
        private String title;
        private String isAttend;
        private String progress;
        private Long questionCount;


        public SurveyDTO(AdminSurveyRequest.SurveyAndQuestionCount reqDTO, DoSurvey doSurvey) {
            this.id = reqDTO.getSurvey().getId();
            this.title = reqDTO.getSurvey().getTitle();
            this.isAttend= (doSurvey != null) ? "참여완료":"참여가능";
            this.progress= reqDTO.getSurvey().getStatus();
            this.questionCount = reqDTO.getQuestionCount();

        }
    }
    @Data
    public static class DetailDTO {
        private Integer surveyId;
        private String title;
        private List<QuestionDTO> questionElements;


        @Data
        public static class QuestionDTO {
            private Integer questionId;
            private String question;
            private List<ChoiceDTO> choices;

            @Data
            public static class ChoiceDTO {
                private Integer choiceId;
                String choiceItem;
                Integer choiceNumber;

                public ChoiceDTO(Integer choiceId, String choiceItem, Integer choiceNumber) {
                    this.choiceId = choiceId;
                    this.choiceItem = choiceItem;
                    this.choiceNumber = choiceNumber;
                }
            }

            public QuestionDTO(SurveyQuestion question, List<Integer> choiceId, List<String> choices, List<Integer> choiceNumbers) {
                this.questionId = question.getId();
                this.question = question.getQuestionItem();
                this.choices = IntStream.range(0, choices.size())
                        .mapToObj(i -> new ChoiceDTO(choiceId.get(i), choices.get(i), choiceNumbers.get(i)))
                        .collect(Collectors.toList());
            }

        }

        public DetailDTO(Survey survey, List<QuestionDTO> questionElements) {
            this.surveyId = survey.getId();
            this.title = survey.getTitle();
            this.questionElements = questionElements;
        }
    }

}
