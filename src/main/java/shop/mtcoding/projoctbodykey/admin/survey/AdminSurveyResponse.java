package shop.mtcoding.projoctbodykey.admin.survey;

import lombok.Data;

import java.util.List;

public class AdminSurveyResponse {

    @Data
    public static class SaveDTO {
        private String surveyName;
        private List<AdminSurveyRequest.SaveDTO.questionElements> questionElements;
        @Data
        public static class questionElements {
            private String question;
            private List<String> choices;
        }
    }
}
