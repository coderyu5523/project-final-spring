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
        private String surveyName;
        private List<questionElements> questionElements;

        @Data
        public static class questionElements {
            private String question;
            private List<String> choices;

            public questionElements(String question, List<String> choices) {
                this.question = question;
                this.choices = choices;
            }

        }

        public DetailDTO(String surveyName, List<DetailDTO.questionElements> questionElements) {
            this.surveyName = surveyName;
            this.questionElements = questionElements;
        }
    }
}
