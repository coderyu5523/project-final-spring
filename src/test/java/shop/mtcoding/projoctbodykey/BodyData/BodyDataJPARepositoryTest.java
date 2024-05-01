package shop.mtcoding.projoctbodykey.BodyData;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import shop.mtcoding.projoctbodykey.bodydata.Bodydata;
import shop.mtcoding.projoctbodykey.bodydata.BodydataJPARepository;

import java.util.List;

@DataJpaTest
public class BodyDataJPARepositoryTest {
    @Autowired
    private BodydataJPARepository bodydataJPARepository;
    @Autowired
    private EntityManager em;

    @Test
    public void findBodySevenByUserId_test(){
        // given
        int userId = 1;
        Pageable pageable = PageRequest.of(0, 7);

        // when
        List<Bodydata> bodydata = bodydataJPARepository.findBodySevenByUserId(userId, pageable).get();

        // eye
        System.out.println("bodys = " + bodydata);
        // then
    }

    @Test
    public void findByUserOrderDesc_test() {
        int userId = 1;
        Bodydata bodydata = bodydataJPARepository.findByUserOrderDesc(userId).orElseThrow();
        System.out.println(bodydata);
    }
}
