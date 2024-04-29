package shop.mtcoding.projoctbodykey.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception400;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception401;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey._core.utils.PasswordUtil;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userJPARepository;

    @Transactional
    public UserResponse.JoinDTO join(UserRequest.JoinDTO reqDTO) {

        // 유저네임 중복체크
        Optional<User> userOP = userJPARepository.findByUsername(reqDTO.getUsername());
        if (userOP.isPresent()) {
            throw new Exception400("유저네임이 중복되었습니다.");
        }

        // 유저패스워드 암호화
        String encPassword = PasswordUtil.encode(reqDTO.getPassword());

        User user = userJPARepository.save(reqDTO.toEntity(encPassword));

        return new UserResponse.JoinDTO(user);
    }

    public UserResponse.LoginDTO login(UserRequest.LoginDTO reqDTO) {
        User userPS = userJPARepository.findByUsername(reqDTO.getUsername()).orElseThrow(
                ()-> new Exception404("유저네임을 찾을 수 없습니다")
        );

        if (!PasswordUtil.verify(reqDTO.getPassword(), userPS.getPassword())) {
            throw new Exception401("패스워드가 일치하지 않습니다");
        }

        String jwt = JwtUtil.create(userPS);

        return new UserResponse.LoginDTO(jwt, userPS);
    }
}