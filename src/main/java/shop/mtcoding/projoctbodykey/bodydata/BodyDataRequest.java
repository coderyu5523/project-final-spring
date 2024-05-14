package shop.mtcoding.projoctbodykey.bodydata;

import lombok.Data;

import shop.mtcoding.projoctbodykey.user.User;

public class BodyDataRequest {

    @Data
    public static class UpdateDTO {
        private Double fat;
        private Double muscle;
        private Double weight;

        public BodyData toEntity(User user) {
            return BodyData.builder()
                    .user(user)
                    .fat(fat)
                    .muscle(muscle)
                    .weight(weight)
                    .build();
        }
    }
}
