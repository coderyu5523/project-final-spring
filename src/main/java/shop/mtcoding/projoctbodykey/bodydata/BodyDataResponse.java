package shop.mtcoding.projoctbodykey.bodydata;

import lombok.Builder;
import lombok.Data;

public class BodyDataResponse {

    @Data
    public static class SaveDTO {
        private Integer userId;
        private Double fat;
        private Double muscle;
        private Double weight;

        @Builder
        public SaveDTO(BodyData bodyData) {
            this.userId = bodyData.getUser().getId();
            this.fat = bodyData.getFat();
            this.muscle = bodyData.getMuscle();
            this.weight = bodyData.getWeight();
        }
    }
}
