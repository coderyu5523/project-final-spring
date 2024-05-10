package shop.mtcoding.projoctbodykey.date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import shop.mtcoding.projoctbodykey.BodyData.BodyDataJPARepositoryTest;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataJPARepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Import(BodyDataJPARepositoryTest.class)
@DataJpaTest
public class DateFormatTest {

    @Autowired
    private BodyDataJPARepository bodydataJPARepository;

    @Test
    public void DateFormat_test() {
        int userId = 1;
        List<BodyData> bodyData = bodydataJPARepository.findByUserId(userId);

        // 정렬된 bodyData 출력
        for (BodyData data : bodyData) {
            Timestamp timestamp = data.getCreatedAt();
            String myData = MyDateUtil.timestampFormat(timestamp);
            System.out.println(myData);
        }
    }

    @Test
    public void zero_test() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        // Timestamp를 LocalDateTime으로 변환합니다.
        LocalDateTime localDateTime = timestamp.toLocalDateTime();

        // 시간과 분을 0으로 설정합니다.
        LocalDateTime resultDateTime = localDateTime.withHour(0).withMinute(0).withSecond(0).withNano(0);

        // 변경된 LocalDateTime을 Timestamp로 다시 변환합니다.
        Timestamp resultTimestamp = Timestamp.valueOf(resultDateTime);
        System.out.println("Modified Timestamp: " + resultTimestamp);
    }
}
