package shop.mtcoding.projoctbodykey.Activity;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.projoctbodykey.activity.Activity;
import shop.mtcoding.projoctbodykey.activity.ActivityJPARepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, createdAt).orElseThrow();
        //eye
        System.out.println("activity = " + activity);
        // then
    }

    @Test
    public void findByUserIdAndDate_test() {
        // given
        int userId = 1;
        LocalDateTime dateTime = LocalDateTime.of(2024, 4, 27, 0, 0, 0);

        // LocalDateTime 객체를 Timestamp 객체로 변환합니다.
        Timestamp timestamp = Timestamp.valueOf(dateTime);

        // when
        Activity activity = activityJPARepository.findByUserIdAndDate(userId, timestamp);
        //eye
        System.out.println("activity = " + activity);
        // then
    }

    @Test
    public void TimeStamp_test(){
        // given
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        LocalDateTime dateTime = timestamp.toLocalDateTime();
        // when
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String strDate = dateTime.format(formatter);

        //eye
        System.out.println("strDate = " + strDate);
        // then
    }

    @Test
    public void findByUserIdOrderDesc_test() {
        // given
        int userId = 1;
        // when
        Activity activity = activityJPARepository.findByUserIdOrderDesc(userId);
        //eye
        System.out.println("activity = " + activity.getWalking());
        // then
    }
}
