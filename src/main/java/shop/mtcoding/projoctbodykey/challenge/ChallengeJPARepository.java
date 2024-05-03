package shop.mtcoding.projoctbodykey.challenge;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChallengeJPARepository extends JpaRepository<Challenge, Integer> {

    @Query("SELECT c FROM Challenge c WHERE " +
            "c.challengeName LIKE %:keyword% " +
            "OR c.subTitle LIKE %:keyword% " +
            "OR c.distance LIKE %:keyword% " +
            "OR CAST(c.walking AS string) = :keyword " +
            "OR CAST(c.coin AS string) = :keyword")

    Page<Challenge> findAllKeyword(@Param("keyword") String keyword, Pageable pageable);

    Page<Challenge> findAll(Pageable pageable);

    @Query("SELECT c " +
            "FROM Challenge c " +
            "LEFT JOIN AttendChallenge a ON c.id = a.challenge.id AND a.user.id = :userId " +
            "WHERE a.user.id IS NULL")
    List<Challenge> findAllChallengeIdNull(@Param("userId") Integer userId);

    @Query("select a.challenge from AttendChallenge a where a.user.id = :userId and a.status is null")
    Optional<Challenge> findByUserChallenge(@Param("userId") Integer userId);

    @Query("SELECT c " +
            "FROM Challenge c " +
            "LEFT JOIN AttendChallenge a ON c.id = a.challenge.id AND a.user.id = :userId " +
            "WHERE a.status is Not null")
    List<Challenge> partChallenges(@Param("userId") Integer userId);
}
