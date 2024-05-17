package shop.mtcoding.projoctbodykey.meal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface MealJPARepository extends JpaRepository<Meal, Integer> {

    @Query("select m from Meal m where m.user.id = :userId and CAST(m.createdAt AS date) = CAST(:createdAt AS date)")
    List<Meal> findByUserIdAndcreatedAt(@Param("userId") Integer userId, @Param("createdAt") Timestamp createdAt);
}