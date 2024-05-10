package shop.mtcoding.projoctbodykey.meal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class MealJPARepositoryTest {

    @Autowired
    private MealJPARepository mealJPARepository;

    @Test
    public void findByUserId_test() {
        List<Meal> mealList = mealJPARepository.findByUserId(1);

        System.out.println(mealList.size());
    }
}
