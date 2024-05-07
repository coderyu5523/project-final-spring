package shop.mtcoding.projoctbodykey.bodydata;

import lombok.Data;

public class BodyDataRequest {

    @Data
    public static class SaveDTO {
        private Double fat;
        private Double muscle;
        private Double weight;
    }
}
