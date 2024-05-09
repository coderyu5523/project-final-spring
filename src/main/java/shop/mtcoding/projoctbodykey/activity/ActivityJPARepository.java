package shop.mtcoding.projoctbodykey.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Optional;

public interface ActivityJPARepository extends JpaRepository<Activity, Integer> {

    @Query("""
            select a
            from Activity a
            join fetch a.user
            where CAST(a.createdAt AS date) = CAST(:createdAt AS date) and a.user.id = :userId
            """)
    Optional<Activity> findByUserIdAndCreatedAt(@Param("userId") Integer userId, @Param("createdAt") LocalDate createdAt);

    @Query("select a from Activity a where a.user.id = :userId and a.createdAt = :createdAt")
    Activity findByUserIdAndDate(@Param("userId") Integer userId, @Param("createdAt") Timestamp createdAt);
}
