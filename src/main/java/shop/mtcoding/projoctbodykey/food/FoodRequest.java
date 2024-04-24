package shop.mtcoding.projoctbodykey.food;

import lombok.Data;

public class FoodRequest {
    @Data
    public static class SaveDTO {
        private String name;
        private Double carbo;
        private Double protein;
        private Double fat;
        private Integer kcal;
        private Integer gram;

        public Food toEntity() {
            return Food.builder()
                    .name(name)
                    .carbo(carbo)
                    .protein(protein)
                    .fat(fat)
                    .kcal(kcal)
                    .gram(gram)
                    .build();
        }
    }

    @Data
    public static class UpdateDTO {
        private String name;
        private Double carbo;
        private Double protein;
        private Double fat;
        private Integer kcal;
        private Integer gram;

    }
}
