package shop.mtcoding.projoctbodykey._core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import shop.mtcoding.projoctbodykey._core.utils.PasswordUtil;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;
import shop.mtcoding.projoctbodykey.user.UserService;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserJPARepository userJPARepository;

    @Autowired
    private UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 비밀번호 암호화를 위해 더미 사용자의 비밀번호를 가져와서 암호화하여 다시 저장합니다.
        List<User> users = userJPARepository.findAll(); // 모든 사용자 정보를 가져오는 메서드라 가정합니다.

        for (User user : users) {
            String originalPassword = user.getPassword(); // 더미 사용자의 비밀번호 가져오기
            String encPassword = PasswordUtil.encode(originalPassword); // 비밀번호 암호화
            userService.saveUser(user, encPassword); // 사용자 정보 저장
        }
    }
}