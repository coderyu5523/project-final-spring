package shop.mtcoding.projoctbodykey.survey;

import lombok.Data;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

public class SurveyRequest {

    @Data
    public static class SaveDTO {
        private String title;
        private Timestamp createdAt;

        public Survey toEntity () {
            return Survey.builder()
                    .title(title)
                    .status("진행전")
                    .createdAt(createdAt)
                    .build();
        }

        public SaveDTO(String title, Timestamp createdAt) {
            this.title = title;
            this.createdAt = createdAt;
        }
    }
}
