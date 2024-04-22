package shop.mtcoding.projoctbodykey.activity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ActivityService {
    private final ActivityJPARepository activityJPARepository;
    private final UserJPARepository userJPARepository;
    //메인 페이지
    public void getActivity(int userId) {
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception403("권한이 없습니다"));
        LocalDate today = LocalDate.now();
        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, today).orElseThrow(() -> new Exception404("원하시는 날짜에 활동이 없습니다"));


    }
}
