package shop.mtcoding.projoctbodykey.admin.survey;

import lombok.Data;

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
        private Integer id;
        private String title;
        private List<QuestionDTO> questionElements;

        @Data
        public static class QuestionDTO {
            private String question;
            private List<ChoiceDTO> choices;

            @Data
            public static class ChoiceDTO{
                String choiceItem;
                Integer choiceNumber;

                public ChoiceDTO(String choiceItem, Integer choiceNumber) {
                    this.choiceItem = choiceItem;
                    this.choiceNumber = choiceNumber;
                }
            }

            public QuestionDTO(String question, List<String> choices, List<Integer> choiceNumbers) {
                this.question = question;
                this.choices = IntStream.range(0, choices.size())
                        .mapToObj(i -> new ChoiceDTO(choices.get(i), choiceNumbers.get(i)))
                        .collect(Collectors.toList());
            }

        }

        public DetailDTO(Integer id, String title, List<DetailDTO.QuestionDTO> questionElements) {
            this.id=id;
            this.title = title;
            this.questionElements = questionElements;
        }
    }
}
