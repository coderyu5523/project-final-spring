package shop.mtcoding.projoctbodykey.challenge;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChallengeJPARepository extends JpaRepository<Challenge, Integer> {

    @Query("select c from Challenge c where " +
            "c.challengeName like %:keyword% " +
            "or c.subTitle like %:keyword% " +
            "or c.distance like %:keyword% " +
            "or c.walking = :keyword " +
            "or c.coin = :keyword ")
    Page<Challenge> findAllKeyword(@Param("keyword") String keyword, Pageable pageable);

    Page<Challenge> findAll(Pageable pageable);

    @Query("SELECT c " +
            "FROM Challenge c " +
            "LEFT JOIN AttendChallenge a ON c.id = a.challenge.id AND a.user.id = :userId " +
            "WHERE a.user.id IS NULL")
    List<Challenge> findAllChallengeIdNull(@Param("userId") Integer userId);

    @Query("select a.challenge from AttendChallenge a where a.user.id = :userId and a.status is null")
    Optional<Challenge> findByUserChallenge(@Param("userId") Integer userId);

    @Query("SELECT c, a.status " +
            "FROM Challenge c " +
            "LEFT JOIN AttendChallenge a ON c.id = a.challenge.id AND a.user.id = :userId " +
            "WHERE a.status is Not null")
    List<Challenge> partChallenges(@Param("userId") Integer userId);
}
