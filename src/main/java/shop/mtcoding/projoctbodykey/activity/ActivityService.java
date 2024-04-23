package shop.mtcoding.projoctbodykey.activity;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.bodydata.Bodydata;
import shop.mtcoding.projoctbodykey.bodydata.BodydataJPARepository;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ActivityService {
    private final ActivityJPARepository activityJPARepository;
    private final UserJPARepository userJPARepository;
    private final BodydataJPARepository bodydataJPARepository;
    //메인 페이지
    public void getActivity(int userId) {
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception403("권한이 없습니다"));
        //오늘 날짜를 받아 오늘의 활동을 가져오기
        LocalDate today = LocalDate.now();
        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, today).orElseThrow(() -> new Exception404("원하시는 날짜에 활동이 없습니다"));
        //최신 7개의 바디 결과만 가져오게 하기
        Pageable pageable = PageRequest.of(0, 7);
        List<Bodydata> bodyList = bodydataJPARepository.findBodySevenByUserId(userId, pageable).orElseThrow(() -> new Exception404("바디값이 없습니다"));

    }
}
