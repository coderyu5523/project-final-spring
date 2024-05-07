package shop.mtcoding.projoctbodykey.BodyData;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataJPARepository;

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
        BodyData bodydata = bodydataJPARepository.findByUserIdOrderDesc(userId).orElseThrow();
        System.out.println(bodydata);
    }

    @Test
    public void findByUserAndBodyData_test() {
        int userId = 1;
        List<BodyData> bodyData = bodydataJPARepository.findByUserAndBodyData(userId);
        System.out.println(bodyData.get(1).getUser().getUsername());
    }
}
