package shop.mtcoding.projoctbodykey.bodydata;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

@RequiredArgsConstructor
@Service
public class BodyDataService {
    private final BodyDataJPARepository bodydataJPARepository;
    private final UserJPARepository userJPARepository;

    @Transactional
    public BodyDataResponse.SaveDTO save(SessionUser sessionUser, BodyDataRequest.SaveDTO reqDTO) {
        User user = userJPARepository.
                findById(sessionUser.getId()).orElseThrow(() -> new Exception404("유저 정보가 없습니다."));

        BodyData bodyData = bodydataJPARepository.save(reqDTO.toEntity(user));

        return new BodyDataResponse.SaveDTO(bodyData);
    }
}
