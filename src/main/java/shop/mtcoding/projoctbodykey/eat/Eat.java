package shop.mtcoding.projoctbodykey.eat;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Table(name = "eat_tb")
@Entity
public class Eat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer mealId;  // 식단 id
    private Integer foodId; // 음식 id
    private Integer quantity; // 먹은 양

    @Builder
    public Eat(Integer id, Integer mealId, Integer foodId, Integer quantity) {
        this.id = id;
        this.mealId = mealId;
        this.foodId = foodId;
        this.quantity = quantity;
    }
}
