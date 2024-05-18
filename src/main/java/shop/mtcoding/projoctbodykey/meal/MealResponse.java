package shop.mtcoding.projoctbodykey.meal;

import lombok.Data;
import shop.mtcoding.projoctbodykey.eat.Eat;
import shop.mtcoding.projoctbodykey.food.Food;

import java.util.ArrayList;
import java.util.List;

public class MealResponse {

    @Data
    public static class SaveDTO{
        public Integer mealId;
        public String mealImg;
        public List<EatDTO> foods;

        @Data
        public static class EatDTO{
            public Integer foodId;
            public Integer foodQuantity;

            public EatDTO(Eat eat) {
                this.foodId = eat.getFood().getId();
                this.foodQuantity = eat.getQuantity();
            }
        }

        public SaveDTO(Integer mealId, String mealImg, List<EatDTO> foods) {
            this.mealId = mealId;
            this.mealImg = mealImg;
            this.foods = foods;
        }
    }
    @Data
    public static class MaealListAndRecommendCalDTO {
        public Double recommendCal;
        public Double recommendCarbon;
        public Double recommendProtein;
        public Double recommendFat;
        public List<MealDTO> mealList = new ArrayList<>();
        @Data
        public static class MealDTO {
            public String mealImg;
            public String eatTime;
            public List<FoodDTO> foods = new ArrayList<>();

            @Data
            public static class FoodDTO{
                public Integer foodId;
                public String foodName;
                public Double carbo;
                public Double protein;

                public Double fat;
                public Double kcal;
                public Integer gram;

                public FoodDTO(Food food) {
                    this.foodId = food.getId();
                    this.foodName = food.getName();
                    this.carbo = food.getCarbo();
                    this.protein = food.getProtein();
                    this.fat = food.getFat();
                    this.kcal = food.getKcal();
                    this.gram = food.getGram();
                }
            }

            public MealDTO(Meal meal, List<FoodDTO> foods) {
                this.mealImg = meal.getMealImg();
                this.eatTime = meal.getEatTime();
                this.foods = foods;
            }
        }

        public MaealListAndRecommendCalDTO(Double recommendCal, Double recommendCarbon, Double recommendProtein, Double recommendFat, List<MealDTO> mealList) {
            this.recommendCal = recommendCal;
            this.recommendCarbon = recommendCarbon;
            this.recommendProtein = recommendProtein;
            this.recommendFat = recommendFat;
            this.mealList = mealList;
        }
    }

}
