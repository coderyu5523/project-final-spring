package shop.mtcoding.projoctbodykey.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception401;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userJPARepository;

    @Transactional
    public User join(UserRequest.JoinDTO reqDTO) {
        User user = userJPARepository.save(reqDTO.toEntity());

        return user;
    }

    public User login(UserRequest.LoginDTO reqDTO) {
        try {
            return userJPARepository.findByUsernameAndPassword(reqDTO.getUsername(), reqDTO.getPassword())
                    .orElseThrow(() -> new Exception404("회원 정보가 없습니다."));
        } catch (EmptyResultDataAccessException e) {
            throw new Exception401("아이디,비밀번호가 틀렸어요");
        }
    }
}
