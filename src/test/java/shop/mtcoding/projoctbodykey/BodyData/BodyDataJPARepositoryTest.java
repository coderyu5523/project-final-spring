package shop.mtcoding.projoctbodykey.BodyData;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataJPARepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@DataJpaTest
public class BodyDataJPARepositoryTest {
    @Autowired
    private BodyDataJPARepository bodydataJPARepository;
    @Autowired
    private EntityManager em;

    @Test
    public void findBodySevenByUserId_test(){
        // given
        int userId = 1;
        Pageable pageable = PageRequest.of(0, 7);

        // when
        List<BodyData> bodydata = bodydataJPARepository.findBodySevenByUserId(userId, pageable).get();

        // eye
        System.out.println("bodys = " + bodydata);
        // then
    }

    @Test
    public void findByUserOrderDesc_test() {
        int userId = 1;
        BodyData bodydata = bodydataJPARepository.findByUserIdOrderDesc(userId);
        System.out.println(bodydata);
    }

    @Test
    public void findByUserIdDesc_test() {
        int userId = 1;
        List<BodyData> bodyData = bodydataJPARepository.findByUserIdDesc(userId);

        // 정렬된 bodyData 출력
        for (BodyData data : bodyData) {
            System.out.println(data);
        }
    }

    @Test
    public void findByUserId_test() {
        int userId = 1;
        List<BodyData> bodyData = bodydataJPARepository.findByUserId(userId);

        // 정렬된 bodyData 출력
        for (BodyData data : bodyData) {
            System.out.println(data);
        }
    }

    @Test
    public void findByUserIdAndCreatedAt_test() {
        int userId = 1;

        LocalDateTime dateTime = LocalDateTime.of(2024, 4, 27, 0, 0, 0);

        // LocalDateTime 객체를 Timestamp 객체로 변환합니다.
        Timestamp timestamp = Timestamp.valueOf(dateTime);


        BodyData bodyData = bodydataJPARepository.findByUserIdAndCreatedAt(userId, timestamp);

        System.out.println(bodyData);
    }
}
