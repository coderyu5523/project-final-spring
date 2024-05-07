package shop.mtcoding.projoctbodykey.challenge;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.AbstractList;
import java.util.List;

@RequiredArgsConstructor
@Repository
@Component
public class ChallengeQueryRepository {
    private final EntityManager em;

    public Object[] ongoingChallenges(Integer userId) {
        String q = """
            SELECT c.id, c.challenge_name, c.sub_title, a.closing_time, c.coin, c.background_img
            FROM challenge_tb c
            LEFT JOIN attend_challenge_tb a ON c.id = a.challenge_id
            WHERE a.user_id = ? AND a.status IS NULL;
            """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, userId);

        try {
            return (Object[]) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Object[] ongoingChallengesWalking(Integer userId) {
        String q = """
            SELECT c.id, c.challenge_name, c.sub_title, a.total_walking, c.walking
            FROM challenge_tb c
            LEFT JOIN attend_challenge_tb a ON c.id = a.challenge_id
            WHERE a.user_id = ? AND a.status IS NULL;
            """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, userId);

        try {
            return (Object[]) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Object[]> partChallenges(Integer userId) {
        String q = """
                SELECT c.id, c.challenge_name, c.distance, c.badge_img, a.status
                FROM challenge_tb c
                LEFT JOIN attend_challenge_tb a ON c.id = a.challenge_id AND a.user_id = ?
                WHERE a.status IS NOT NULL
                ORDER BY CASE WHEN a.status = true THEN 0 ELSE 1 END, a.status DESC;
            """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, userId);

        return query.getResultList();
    }

    public List<Object[]> conqueredChallenge(Integer userId) {
        String q = """
            SELECT c.id, c.challenge_name, c.distance, a.status, c.badge_img
            FROM challenge_tb c
            LEFT JOIN attend_challenge_tb a ON c.id = a.challenge_id AND a.user_id = ?
            WHERE a.status IS true;
            """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, userId);

        return query.getResultList();
    }


    public List<Object[]> upcomingChallenges(Integer userId) {
        String q = """
            SELECT c.id, c.challenge_name, c.distance, c.badge_img, a.status
            FROM challenge_tb c
            LEFT JOIN attend_challenge_tb a ON c.id = a.challenge_id AND a.user_id = ?
            WHERE a.user_id IS NULL;
            """;
        Query query = em.createNativeQuery(q);
        query.setParameter(1, userId);

        return query.getResultList();
    }
}
