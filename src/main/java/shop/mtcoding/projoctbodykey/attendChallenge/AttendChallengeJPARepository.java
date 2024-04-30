package shop.mtcoding.projoctbodykey.attendChallenge;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import shop.mtcoding.projoctbodykey.challenge.Challenge;

public interface AttendChallengeJPARepository extends JpaRepository<AttendChallenge, Integer> {

}
