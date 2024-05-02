package shop.mtcoding.projoctbodykey.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserJPARepositoryTest {

    @Autowired
    private UserJPARepository userJPARepository;

    @Test
    public void join_test() {
        String username = "ssar";
        String password = "1234";

        User user = userJPARepository.findByUsernameAndPassword(username, password).orElseThrow();
        System.out.println(user.getUsername());
    }

    @Test
    public void findByGoalFat_test() {
        int userId = 1;
        User user = userJPARepository.findById(userId).orElseThrow();
        System.out.println(user.getGoalFat());
    }
}
