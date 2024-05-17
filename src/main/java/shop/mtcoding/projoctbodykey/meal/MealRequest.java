package shop.mtcoding.projoctbodykey.meal;

import lombok.Data;
import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

public class MealRequest {

    @Data
    public static class SaveDTO {
        private String eatTime;
        private String mealImg;
        private List<Food> foods;

        @Data
        public static class Food{
            private Integer foodId;
            private Integer qty;
        }
    }

    public static class MealSaveDTO {
        private User user;
        private String mealImg;
        private String eatTime;
        private Timestamp createdAt;

        public Meal toEntity() {
            return Meal.builder()
                    .user(user)
                    .mealImg(mealImg)
                    .eatTime(eatTime)
                    .createdAt(createdAt)
                    .build();
        }

        public MealSaveDTO(User user, LocalDate date, MealRequest.SaveDTO reqDTO) {
            this.user = user;
            this.mealImg = reqDTO.getMealImg();
            this.eatTime = reqDTO.getEatTime();
            this.createdAt = new Timestamp(System.currentTimeMillis());
        }
    }
}
