package shop.mtcoding.projoctbodykey.survey;

import lombok.Data;
import shop.mtcoding.projoctbodykey.admin.survey.AdminSurveyRequest;
import shop.mtcoding.projoctbodykey.dosurvey.DoSurvey;
import shop.mtcoding.projoctbodykey.food.Food;

import java.sql.Timestamp;

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


}
