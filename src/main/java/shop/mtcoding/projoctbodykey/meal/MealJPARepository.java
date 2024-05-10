package shop.mtcoding.projoctbodykey.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MealJPARepository extends JpaRepository<Meal, Integer> {

    @Query("select m from Meal m where m.activity.user.id = :userId")
    List<Meal> findByUserId(@Param("userId") Integer userId);
}
