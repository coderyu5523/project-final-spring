package shop.mtcoding.projoctbodykey.admin.survey;
import lombok.Data;
import java.util.List;
public class AdminSurveyRequest {
    @Data
    public static class SaveDTO {
        private String title;
        private List<questionElements> questionElements;
        @Data
        public static class questionElements {
            private String question;
            private List<String> choices;
        }
    }
}