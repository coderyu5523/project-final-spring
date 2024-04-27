package shop.mtcoding.projoctbodykey.food;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.challenge.Challenge;

import java.util.List;

public interface FoodJPARepository extends JpaRepository<Food,Integer> {

    @Query("select f from Food f where f.name like %:keyword%")
    Page<Food> findAllKeyword(@Param("keyword") String keyword, Pageable pageable);

    Page<Food> findAll(Pageable pageable);
}
