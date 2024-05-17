package shop.mtcoding.projoctbodykey.eat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface EatJPARepository extends JpaRepository<Eat, Integer> {

    @Query("SELECT f.kcal FROM Eat e JOIN e.food f JOIN e.meal m JOIN m.user u WHERE u.id = :userId AND m.createdAt = :createdAt")
    List<Integer> findKcalByUserIdAndEatTime(@Param("userId") Integer userId, @Param("createdAt") Timestamp createdAt);

    @Query("SELECT e FROM Eat e JOIN fetch e.food ef WHERE e.meal.id = :mealId")
    List<Eat> findByMealId(@Param("mealId") Integer mealId);
}
