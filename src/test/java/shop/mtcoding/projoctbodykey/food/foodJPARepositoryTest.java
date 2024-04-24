package shop.mtcoding.projoctbodykey.food;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import shop.mtcoding.projoctbodykey.bodydata.BodydataJPARepository;

@DataJpaTest
public class foodJPARepositoryTest {
    @Autowired
    private FoodJPARepository foodJPARepository;
    @Autowired
    private EntityManager em;

    @Test
    public void _test() {
        // given
        Pageable pageable = PageRequest.of(1, 10);
        // when
        Page<Food> foods = foodJPARepository.findAll(pageable);
        //eye
        System.out.println("foods = " + foods);

        // then

    }

}
