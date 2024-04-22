package shop.mtcoding.projoctbodykey.body;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.activity.Activity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BodyJPARepository extends JpaRepository<Body, Integer> {

    @Query("""
            select a
            from Activity a
            join fetch a.user
            where a.user.id = :userId 
            order by a.createdAt desc
            """)
    Optional<List<Body>> findBodySevenByUserId(@Param("userId") Integer userId, Pageable pageable);


}
