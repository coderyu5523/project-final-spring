package shop.mtcoding.projoctbodykey.food;

import lombok.Data;

public class FoodResponse {

    @Data
    public static class SaveDTO {
        private Integer id;
        private String name;
        private Double carbo;
        private Double protein;
        private Double fat;
        private Integer kcal;
        private Integer gram;

        public SaveDTO(Food food) {
            this.id = food.getId();
            this.name = food.getName();
            this.carbo = food.getCarbo();
            this.protein = food.getProtein();
            this.fat = food.getFat();
            this.kcal = food.getKcal();
            this.gram = food.getGram();
        }
    }

    @Data
    public static class FoodDTO {
        private Integer id;
        private String name;
        private Double carbo;
        private Double protein;
        private Double fat;
        private Integer kcal;
        private Integer gram;

        public FoodDTO(Food food) {
            this.id = food.getId();
            this.name = food.getName();
            this.carbo = food.getCarbo();
            this.protein = food.getProtein();
            this.fat = food.getFat();
            this.kcal = food.getKcal();
            this.gram = food.getGram();
        }
    }

    @Data
    public static class FoodsDTO {
        private Integer id;
        private String name;
        private Double carbo;
        private Double protein;
        private Double fat;
        private Integer kcal;
        private Integer gram;

        public FoodsDTO(Food food) {
            this.id = food.getId();
            this.name = food.getName();
            this.carbo = food.getCarbo();
            this.protein = food.getProtein();
            this.fat = food.getFat();
            this.kcal = food.getKcal();
            this.gram = food.getGram();
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer id;
        private String name;
        private Double carbo;
        private Double protein;
        private Double fat;
        private Integer kcal;
        private Integer gram;

        public UpdateDTO(Food food) {
            this.id = food.getId();
            this.name = food.getName();
            this.carbo = food.getCarbo();
            this.protein = food.getProtein();
            this.fat = food.getFat();
            this.kcal = food.getKcal();
            this.gram = food.getGram();
        }
    }
}
