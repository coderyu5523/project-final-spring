package shop.mtcoding.projoctbodykey.Activity;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import shop.mtcoding.projoctbodykey.activity.Activity;
import shop.mtcoding.projoctbodykey.activity.ActivityJPARepository;
import shop.mtcoding.projoctbodykey.activity.ActivityRequest;

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
        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, createdAt).orElse(null);
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


}
