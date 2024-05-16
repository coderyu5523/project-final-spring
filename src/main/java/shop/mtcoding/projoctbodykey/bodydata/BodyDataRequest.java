package shop.mtcoding.projoctbodykey.bodydata;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import shop.mtcoding.projoctbodykey.user.User;

public class BodyDataRequest {

    @Data
    public static class UpdateDTO {

        @NotNull(message = "값을 입력해주세요.")
        @Min(value = 0, message = "0 이상의 값을 입력하여 주세요.")
        @Max(value = 100, message = "100 이하의 값을 입력하여 주세요.")
        private Double fat;

        @NotNull(message = "값을 입력해주세요.")
        @Min(value = 0, message = "0 이상의 값을 입력하여 주세요.")
        @Max(value = 100, message = "100 이하의 값을 입력하여 주세요.")
        private Double muscle;

        @NotNull(message = "값을 입력해주세요.")
        @Min(value = 0, message = "0 이상의 값을 입력하여 주세요.")
        @Max(value = 200, message = "200 이하의 값을 입력하여 주세요.")
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
