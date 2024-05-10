package shop.mtcoding.projoctbodykey.eat;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.meal.Meal;


@Data
@Table(name = "eat_tb")
@Entity
@NoArgsConstructor
public class Eat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Meal meal;  // 식단 id

    @ManyToOne(fetch = FetchType.LAZY)
    private Food food; // 음식 id

    private Integer quantity; // 먹은 양

    @Builder
    public Eat(Integer id, Meal meal, Food food, Integer quantity) {
        this.id = id;
        this.meal = meal;
        this.food = food;
        this.quantity = quantity;
    }
}
