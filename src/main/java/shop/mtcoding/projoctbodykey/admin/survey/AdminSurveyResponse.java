package shop.mtcoding.projoctbodykey.admin.survey;

import lombok.Data;

import java.util.List;

public class AdminSurveyResponse {

    @Data
    public static class SaveDTO {
        private String surveyName;
        private List<questionElements> questionElements;
        @Data
        public class questionElements {
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
            public static class ChoiceDTO
            public QuestionDTO(String question, List<String> choices) {
                this.question = question;
                this.choices = choices;
            }

        }

        public DetailDTO(Integer id, String title, List<DetailDTO.QuestionDTO> questionElements) {
            this.id=id;
            this.title = title;
            this.questionElements = questionElements;
        }
    }
}
