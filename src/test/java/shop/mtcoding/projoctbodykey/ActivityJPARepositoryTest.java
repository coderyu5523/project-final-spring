package shop.mtcoding.projoctbodykey;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.projoctbodykey.activity.Activity;
import shop.mtcoding.projoctbodykey.activity.ActivityJPARepository;

import java.sql.Timestamp;
import java.time.LocalDate;

@DataJpaTest
public class ActivityJPARepositoryTest {


    @Autowired
    private ActivityJPARepository activityJPARepository;
    @Autowired
    private EntityManager em;

    @Test
    public void findByUserIdAndCreatedAt_test() {
        // given
        int userId = 1;
        LocalDate createdAt = LocalDate.now();
        // when
        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, createdAt).get();
        //eye
        System.out.println("activity = " + activity);
        // then
    }


}
