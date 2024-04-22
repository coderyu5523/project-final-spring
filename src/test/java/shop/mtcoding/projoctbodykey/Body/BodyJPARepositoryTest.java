package shop.mtcoding.projoctbodykey.Body;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import shop.mtcoding.projoctbodykey.body.Body;
import shop.mtcoding.projoctbodykey.body.BodyJPARepository;

import java.util.List;

@DataJpaTest
public class BodyJPARepositoryTest {
    @Autowired
    private BodyJPARepository bodyJPARepository;
    @Autowired
    private EntityManager em;

    @Test
    public void findBodySevenByUserId_test(){
        // given
        int userId = 1;
        Pageable pageable = PageRequest.of(0, 7);

        // when
        List<Body> bodys=bodyJPARepository.findBodySevenByUserId(userId, pageable).get();

        // eye
        System.out.println("bodys = " + bodys);
        // then
    }
}
