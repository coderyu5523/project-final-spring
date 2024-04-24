package shop.mtcoding.projoctbodykey.food;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplicationRunListener;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "food_tb")
@Entity
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name; // 음식이름
    private Double carbo; //탄수화물
    private Double protein; // 단백질
    private Double fat;// 지방
    private Integer kcal; // 칼로리
    private Integer gram; // 먹은 그램양
    private Timestamp createdAt;

    @Builder
    public Food(Integer id, String name, Double carbo, Double protein, Double fat, Integer kcal, Integer gram, Timestamp createdAt) {
        this.id = id;
        this.name = name;
        this.carbo = carbo;
        this.protein = protein;
        this.fat = fat;
        this.kcal = kcal;
        this.gram = gram;
        this.createdAt = createdAt;
    }

    public void update(FoodRequest.UpdateDTO reqDTO){
        this.name = reqDTO.getName();
        this.carbo = reqDTO.getCarbo();
        this.protein = reqDTO.getProtein();
        this.fat = reqDTO.getFat();
        this.kcal = reqDTO.getKcal();
        this.gram = reqDTO.getGram();
    }
}
