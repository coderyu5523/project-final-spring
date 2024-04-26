package shop.mtcoding.projoctbodykey.challenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeJPARepository extends JpaRepository<Challenge,Integer> {

    @Query("""
            select c from Challenge c where c.challengeName like %:keyword%
            """)
    List<Challenge> findAllKeyword(@Param("keyword") String keyword);
}
