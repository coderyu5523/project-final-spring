package shop.mtcoding.projoctbodykey.eat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class EatJPARepositoryTest {

    @Autowired
    private EatJPARepository eatJPARepository;

    @Test
    public void findByUserIdAnbEatTime_test() {

        int userId = 1;
        LocalDateTime dateTime = LocalDateTime.of(2024, 5, 5, 0, 0, 0);

        // LocalDateTime 객체를 Timestamp 객체로 변환합니다.
        Timestamp timestamp = Timestamp.valueOf(dateTime);

        List<Integer> eatList = eatJPARepository.findKcalByUserIdAndEatTime(userId, timestamp);

        System.out.println(eatList);

        int totalKcal = eatList.stream().reduce(0, Integer::sum);
        System.out.println("총 칼로리: " + totalKcal);
    }
}
