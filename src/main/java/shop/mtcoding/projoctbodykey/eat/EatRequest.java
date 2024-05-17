package shop.mtcoding.projoctbodykey.eat;

import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.meal.Meal;

public class EatRequest {

    public static class SaveDTO{
        private Meal meal;
        private Food food;

        private Integer quantity;

        public Eat toEntity(){
            return Eat.builder()
                   .meal(meal)
                   .food(food)
                   .quantity(quantity)
                   .build();
        }
        public SaveDTO(Meal meal, Food food, Integer quantity) {
            this.meal = meal;
            this.food = food;
            this.quantity = quantity;
        }
    }
}
