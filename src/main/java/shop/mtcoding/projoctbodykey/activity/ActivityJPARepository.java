package shop.mtcoding.projoctbodykey.activity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ActivityJPARepository extends JpaRepository<Activity, Integer> {

    @Query("""
            select a
            from Activity a
            join fetch a.user
            where CAST(a.createdAt AS date) = CAST(:createdAt AS date) and a.user.id = :userId
            """)
    Optional<Activity> findByUserIdAndCreatedAt(@Param("userId") Integer userId, @Param("createdAt") LocalDate createdAt);

    @Query("""
            select a
            from Activity a
            join fetch a.user
            where CAST(a.createdAt AS date) = CAST(:createdAt AS date) and a.user.id = :userId
            """)
    Activity findByUserIdAndToDay(@Param("userId") Integer userId, @Param("createdAt") LocalDate createdAt);

    @Query("select a from Activity a where a.user.id = :userId and a.createdAt = :createdAt")
    Activity findByUserIdAndDate(@Param("userId") Integer userId, @Param("createdAt") Timestamp createdAt);

    @Query("""
            select new shop.mtcoding.projoctbodykey.activity.ActivityRequest$WalkingToatalAndAVG(sum(a.walking) as totalMonthWalking, avg(a.walking) as avgMonthWalking)
            from Activity a
            where YEAR(a.createdAt) = YEAR(:createdAt) and MONTH(a.createdAt) = MONTH(:createdAt) and a.user.id = :userId
            """)
    Optional<ActivityRequest.WalkingToatalAndAVG> findWithToatalAndAVG(@Param("userId") Integer userId, @Param("createdAt") LocalDate createdAt);

    @Query("""
            select new shop.mtcoding.projoctbodykey.activity.ActivityRequest$WalkingRateAvG(count(a) as rateAvgWalking)
            from Activity a
            where YEAR(a.createdAt) = YEAR(:createdAt) and MONTH(a.createdAt) = MONTH(:createdAt) and a.user.id = :userId and a.walking>=10000
            """)
    Optional<ActivityRequest.WalkingRateAvG> findWithWalkingRateAvG(@Param("userId") Integer userId, @Param("createdAt") LocalDate createdAt);

    @Query("""
            select new shop.mtcoding.projoctbodykey.activity.ActivityRequest$MaxWalkingDay(a.walking as maxWalking, a.createdAt as maxWalkingDay)
            from Activity a
            where a.walking = (SELECT MAX(a.walking) FROM Activity a where YEAR(a.createdAt) = YEAR(:createdAt) and MONTH(a.createdAt) = MONTH(:createdAt) and a.user.id = :userId) 
            and YEAR(a.createdAt) = YEAR(:createdAt) and MONTH(a.createdAt) = MONTH(:createdAt) and a.user.id = :userId 
            order by a.createdAt desc limit 1
            """)
    ActivityRequest.MaxWalkingDay findWithMaxWalkingDay(@Param("userId") Integer userId, @Param("createdAt") LocalDate createdAt);

    @Query("""
            select a
            from Activity a
            where a.user.id = :userId and a.createdAt Between :startDate and :endDate
            """)
    List<Activity> findWithWeakActivity(@Param("startDate") Timestamp startDate, @Param("endDate") Timestamp endDate, @Param("userId") Integer userId);

    @Query("select a from Activity a where a.user.id = :userId order by a.createdAt desc limit 1")
    Activity findByUserIdOrderDesc(@Param("userId") Integer userId);
}
