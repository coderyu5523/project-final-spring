package shop.mtcoding.projoctbodykey.admin.survey;

import lombok.Data;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdminSurveyResponse {

    @Data
    public static class SaveDTO {
        private String surveyName;
        private List<QuestionDTO> questionElements;
        @Data
        public class QuestionDTO {
            private String question;
            private List<String> choices;
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
            public static class ChoiceDTO{
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
                this.questionId=question.getId();
                this.question = question.getQuestionItem();
                this.choices = IntStream.range(0, choices.size())
                        .mapToObj(i -> new ChoiceDTO(choiceId.get(i),choices.get(i), choiceNumbers.get(i)))
                        .collect(Collectors.toList());
            }

        }

        public DetailDTO(Integer surveyId, String title, List<DetailDTO.QuestionDTO> questionElements) {
            this.surveyId=surveyId;
            this.title = title;
            this.questionElements = questionElements;
        }
    }

    @Data
    public static class ChartDTO {
        private Integer surveyId;
        private String title;
        private List<QuestionDTO> questionElements;

        @Data
        public static class QuestionDTO {
            private Integer questionId;
            private String question;
            private List<ChoiceDTO> choices;

            @Data
            public static class ChoiceDTO{
                private Integer choiceId;
                String choiceItem;
                Integer choiceNumber;
                Integer choiceCount;

                public ChoiceDTO(Integer choiceId, String choiceItem, Integer choiceNumber, Integer choiceCount) {
                    this.choiceId = choiceId;
                    this.choiceItem = choiceItem;
                    this.choiceNumber = choiceNumber;
                    this.choiceCount = choiceCount;
                }
            }

            public QuestionDTO(SurveyQuestion question, List<Integer> choiceId,List<String> choices, List<Integer> choiceNumbers, List<Integer> choiceCount) {
                this.questionId=question.getId();
                this.question = question.getQuestionItem();
                this.choices = IntStream.range(0, choices.size())
                        .mapToObj(i -> new ChoiceDTO(choiceId.get(i),choices.get(i), choiceNumbers.get(i), choiceCount.get(i)))
                        .collect(Collectors.toList());
            }

        }

        public ChartDTO(Integer surveyId, String title, List<QuestionDTO> questionElements) {
            this.surveyId=surveyId;
            this.title = title;
            this.questionElements = questionElements;
        }
    }
}
