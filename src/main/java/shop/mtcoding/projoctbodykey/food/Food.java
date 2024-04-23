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
    private String foodName; // 음식이름
    private Double carbo; //탄수화물
    private Double protein; // 단백질
    private Double fat;// 지방
    private Integer kcal; // 칼로리
    private Integer gram; // 먹은 그램양
    private Timestamp createdAt;

    @Builder
    public Food(Integer id, String foodName, Double carbo, Double protein, Double fat, Integer kcal, Integer gram, Timestamp createdAt) {
        this.id = id;
        this.foodName = foodName;
        this.carbo = carbo;
        this.protein = protein;
        this.fat = fat;
        this.kcal = kcal;
        this.gram = gram;
        this.createdAt = createdAt;
    }
}
