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
}
