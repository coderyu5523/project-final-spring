package shop.mtcoding.projoctbodykey.attendChallenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.challenge.Challenge;

import java.util.List;
import java.util.Optional;

public interface AttendChallengeJPARepository extends JpaRepository<AttendChallenge, Integer> {

    @Query("select a.status from Challenge c left join AttendChallenge a on c.id = a.challenge.id and a.user.id = :userId where c.id = :challengeId")
    Boolean findByChallengeIdAndUserId(@Param("userId") Integer userId, @Param("challengeId") Integer challengeId);

    @Query("select a from AttendChallenge a where a.user.id = :userId and a.status is null")
    Optional<AttendChallenge> closingTime(@Param("userId") Integer userId);

    @Query("select a from AttendChallenge a where a.user.id = :userId and a.status is not null")
    List<AttendChallenge> status(@Param("userId") Integer userId);

    @Query("SELECT a " +
            "FROM AttendChallenge a " +
            "join fetch Challenge c ON a.challenge.id = c.id AND a.user.id = :userId " +
            "WHERE a.status is Not null")
    List<AttendChallenge> partChallenges(@Param("userId") Integer userId);
}
