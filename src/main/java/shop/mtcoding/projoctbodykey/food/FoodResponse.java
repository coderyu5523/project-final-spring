package shop.mtcoding.projoctbodykey.food;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Page;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.challenge.ChallengeResponse;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class FoodResponse {

    @Data
    public static class FoodListDTO {
        private List<FoodNameListDTO> FoodNameList;
        private List<FoodContentListDTO> FoodContentList;

        public FoodListDTO(List<Food> foods) {
            FoodNameList = foods.stream().map(FoodNameListDTO::new).toList();
            FoodContentList = foods.stream().map(FoodContentListDTO::new).toList();
        }

        @Data
        public static class FoodNameListDTO {
            private Integer id;
            private String name;

            public FoodNameListDTO(Food food) {
                this.id = food.getId();
                this.name = food.getName();
            }
        }

        @Data
        public static class FoodContentListDTO {
            private Integer id;
            private String name;
            private Double carbo; //탄수화물
            private Double protein; // 단백질
            private Double fat;// 지방
            private Integer kcal; // 칼로리
            private Integer gram; // 먹은 그램양

            public FoodContentListDTO(Food food) {
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

    @Data
    public static class AdminFoodListDTO {
        private Boolean first;
        private Boolean last;
        private Integer prev;
        private Integer next;
        private List<AdminFoodList> foodList;

        public AdminFoodListDTO(Boolean first, Boolean last, Integer prev, Integer next, Page<Food> foods) {
            this.first = first;
            this.last = last;
            this.prev = prev;
            this.next = next;

            // 받아온 Page<Food>를 리스트로 변환
            this.foodList = foods.getContent().stream()
                    .map(AdminFoodList::new)
                    .collect(Collectors.toList());
        }

        @Data
        public static class AdminFoodList {
            private Integer id;
            private String name;
            private Double carbo;
            private Double protein;
            private Double fat;
            private Integer kcal;
            private Integer gram;

            @Builder

            public AdminFoodList(Food food) {
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

    @Data
    public static class AdminFoodSearchListDTO {
        private Boolean first;
        private Boolean last;
        private Integer prev;
        private Integer next;
        private String keyword;
        private List<AdminFoodSearchList> foodList;

        public AdminFoodSearchListDTO(Boolean first, Boolean last,  Integer prev, Integer next, String keyword, Page<Food> foods) {
            this.first = first;
            this.last = last;
            this.prev = prev;
            this.next = next;
            this.keyword = keyword;

            // 받아온 Page<Food>를 리스트로 변환
            this.foodList = foods.getContent().stream()
                    .map(AdminFoodSearchList::new)
                    .collect(Collectors.toList());
        }

        @Data
        public static class AdminFoodSearchList {
            private Integer id;
            private String name;
            private Double carbo;
            private Double protein;
            private Double fat;
            private Integer kcal;
            private Integer gram;

            @Builder

            public AdminFoodSearchList(Food food) {
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
