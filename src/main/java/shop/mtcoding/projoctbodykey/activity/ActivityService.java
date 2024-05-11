package shop.mtcoding.projoctbodykey.activity;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataJPARepository;
import shop.mtcoding.projoctbodykey.eat.EatJPARepository;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ActivityService {
    private final ActivityJPARepository activityJPARepository;
    private final UserJPARepository userJPARepository;
    private final BodyDataJPARepository bodydataJPARepository;
    private final EatJPARepository eatJPARepository;

    public ActivityResponse.activitiesDateDTO activitiesDate(Timestamp timestamp, SessionUser sessionUser) {
        Activity activity = activityJPARepository
                .findByUserIdAndDate(sessionUser.getId(), timestamp);

        BodyData bodyData = bodydataJPARepository.findByUserIdOrderDesc(sessionUser.getId());

//        List<Integer> eatList = eatJPARepository.findKcalByUserIdAndEatTime(sessionUser.getId(), timestamp);
//
//        Integer totalKcal = eatList.stream().reduce(0, Integer::sum);

        return new ActivityResponse.activitiesDateDTO(activity, bodyData);
    }

    //메인 페이지
//    public void getActivity(int userId) {
//        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception403("권한이 없습니다"));
//        //오늘 날짜를 받아 오늘의 활동을 가져오기
//        LocalDate today = LocalDate.now();
//        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, today).orElseThrow(() -> new Exception404("원하시는 날짜에 활동이 없습니다"));
//        //최신 7개의 바디 결과만 가져오게 하기
//        Pageable pageable = PageRequest.of(0, 7);
//        List<BodyData> bodyList = bodydataJPARepository.findBodySevenByUserId(userId, pageable).orElseThrow(() -> new Exception404("바디값이 없습니다"));
//    }

    //메인페이지 walking 디테일
    public ActivityResponse.WalkingDetail getWalkingDetail(int userId){
        User user=userJPARepository.findById(userId).orElseThrow(() -> new Exception403("권한이 없습니다"));

        LocalDate today = LocalDate.now();

        //당일 걸음 수
        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, today).orElseThrow(() -> new Exception404("원하시는 날짜에 활동이 없습니다"));


        //한달 총 걸음 수, 한달 평균 걸음 수
        ActivityRequest.WalkingToatalAndAVG  WalkingToatalAndAVG= activityJPARepository.findWithToatalAndAVG(userId, today).orElseThrow(() -> new Exception404("원하시는 날짜에 활동이 없습니다"));
        System.out.println("WalkingToatalAndAVG = " + WalkingToatalAndAVG);

        //한달 평균 달성률
        YearMonth yearMonth = YearMonth.from(today);
        int totalDays = yearMonth.lengthOfMonth();
        ActivityRequest.WalkingRateAvG walkingRateAvG = activityJPARepository.findWithWalkingRateAvG(userId, today).orElseThrow(() -> new Exception404("원하시는 날짜에 활동이 없습니다"));
        System.out.println("walkingRateAvG = " + walkingRateAvG);
        double rateAvg= (double) walkingRateAvG.getRateAvgWalking() /totalDays*100;
        System.out.println("rateAvg = " + rateAvg);

        //가장 많이 걸은 날
        ActivityRequest.MaxWalkingDay maxWalking = activityJPARepository.findWithMaxWalkingDay(userId, today);
        System.out.println("maxWalkingDay = " + maxWalking);

        //일주일 걸음 수
        LocalDate startDate = today.minusDays(7);
        List<Activity> weakActivity= activityJPARepository.findWithWeakActivity(Timestamp.valueOf(startDate.atStartOfDay()), Timestamp.valueOf(today.atStartOfDay()), userId);
        List<ActivityRequest.WeakWalking> weakWalking = weakActivity.stream().map(ActivityRequest.WeakWalking::new).toList();
        System.out.println("weakWalking = " + weakWalking);


        return new ActivityResponse.WalkingDetail(activity.getWalking(), WalkingToatalAndAVG, rateAvg, maxWalking, weakWalking);
    }

    public ActivityResponse.WaterDetail getWaterDetail(Integer userId) {
        LocalDate today = LocalDate.now();

        //당일 물
        Activity activity = activityJPARepository.findByUserIdAndCreatedAt(userId, today).orElseThrow(() -> new Exception404("원하시는 날짜에 활동이 없습니다"));

        //일주일간 물
        LocalDate startDate = today.minusDays(7);
        List<Activity> weakActivity= activityJPARepository.findWithWeakActivity
                        (Timestamp.valueOf(startDate.atStartOfDay()), Timestamp.valueOf(today.atStartOfDay()), userId);
        List<ActivityRequest.WeakWater> weakWaters = weakActivity.stream().map(ActivityRequest.WeakWater::new).toList();

        return new ActivityResponse.WaterDetail(activity.getDrinkWater(), weakWaters);

    }
}
