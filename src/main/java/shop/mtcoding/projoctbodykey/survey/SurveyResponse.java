package shop.mtcoding.projoctbodykey.survey;

import lombok.Data;
import shop.mtcoding.projoctbodykey.food.Food;

import java.sql.Timestamp;

public class SurveyResponse {

    @Data
    public static class SurveysDTO {
        private Integer id;
        private String title;
        private Timestamp createdAt;
        private Timestamp openingTime;
        private Timestamp closingTime;

        public SurveysDTO(Survey survey) {
            this.id = survey.getId();
            this.title = survey.getTitle();
            this.createdAt = survey.getCreatedAt();
            this.openingTime = survey.getOpeningTime();
            this.closingTime = survey.getClosingTime();
        }
    }

}
