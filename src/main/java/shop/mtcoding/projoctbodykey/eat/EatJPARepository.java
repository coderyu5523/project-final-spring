package shop.mtcoding.projoctbodykey.eat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface EatJPARepository extends JpaRepository<Eat, Integer> {

    @Query("select e from Eat e where e.meal.activity.user.id = :userId and e.meal.eatTime = :eatTime")
    List<Eat> findByUserIdAnbEatTime(@Param("userId") Integer userId, @Param("eatTime") Timestamp eatTime);
}
