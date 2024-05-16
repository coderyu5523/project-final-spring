package shop.mtcoding.projoctbodykey.activity;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.attendChallenge.AttendChallenge;
import shop.mtcoding.projoctbodykey.attendChallenge.AttendChallengeJPARepository;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataJPARepository;
import shop.mtcoding.projoctbodykey.eat.EatJPARepository;
import shop.mtcoding.projoctbodykey.user.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneOffset;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ActivityService {
    private final ActivityJPARepository activityJPARepository;
    private final AttendChallengeJPARepository attendChallengeJPARepository;
    private final UserJPARepository userJPARepository;
    private final BodyDataJPARepository bodydataJPARepository;

    public ActivityResponse.activitiesDateDTO activitiesDate(LocalDate createdAt, SessionUser sessionUser) {

        // LocalDate를 Timestamp로 변환
        Timestamp timestamp = Timestamp.valueOf(createdAt.atStartOfDay());

        Activity activity = activityJPARepository
                .findByUserIdAndDate(sessionUser.getId(), timestamp);

        BodyData bodyData = bodydataJPARepository.findByUserIdAndCreatedAt(sessionUser.getId(), timestamp);

        // 칼로리 더해주는 코드
//        List<Integer> eatList = eatJPARepository.findKcalByUserIdAndEatTime(sessionUser.getId(), timestamp);
//
//        Integer totalKcal = eatList.stream().reduce(0, Integer::sum);

        if(bodyData != null) {
            return new ActivityResponse.activitiesDateDTO(activity, bodyData);
        } else {
            BodyData bodyDataLimit = bodydataJPARepository.findByUserIdOrderDesc(sessionUser.getId());
            return new ActivityResponse.activitiesDateDTO(activity, bodyDataLimit);
        }
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


        return new ActivityResponse.WalkingDetail(activity, WalkingToatalAndAVG, rateAvg, maxWalking, weakWalking);
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

        return new ActivityResponse.WaterDetail(activity, weakWaters);

    }

    @Transactional
    public void save(Integer userId) {
        if(userId != null) {
            User user = userJPARepository.findById(userId).orElseThrow();

            // 현재 날짜와 시간을 가져옵니다.
            LocalDateTime now = LocalDateTime.now();

            // 시분초를 0으로 초기화합니다.
            LocalDateTime startOfDay = now.withHour(0).withMinute(0).withSecond(0).withNano(0);

            // 로컬 날짜와 시간을 타임스탬프로 변환합니다.
            Timestamp timestamp = Timestamp.valueOf(startOfDay);

            Activity activity = activityJPARepository.findByUserIdAndDate(userId, timestamp);

            if(activity == null) {
                Activity newActivity = new Activity();
                Timestamp time = Timestamp.valueOf(startOfDay);
                newActivity.setCreatedAt(time);
                newActivity.setUser(user);
                newActivity.setWalking(0);
                newActivity.setDrinkWater(0);

                activityJPARepository.save(newActivity);
            }
        }
    }

    @Transactional
    public ActivityResponse.UpdateDTO update(SessionUser user, ActivityRequest.UpdateDTO reqDTO) {
        Activity activity = activityJPARepository.findByUserIdOrderDesc(user.getId());

        activity.setWalking(reqDTO.getWalking());
        activity.setDrinkWater(reqDTO.getWater());

        return new ActivityResponse.UpdateDTO(user.getId(), activity);
    }

    // 아래는 걷기, 물 따로 업데이트 하는거
    @Transactional
    public ActivityResponse.WalkingUpdateDTO walkingUpdate(SessionUser user, ActivityRequest.WalkingUpdateDTO reqDTO) {
        Activity activity = activityJPARepository.findByUserIdOrderDesc(user.getId());


        // 업데이트 전 activity의 걸음수를 dto의 걸음 수로 빼준다.
        int walkingM = reqDTO.getWalking() - activity.getWalking();

        // 현재 진행중인 챌린지 (스테이터스가 null인 챌린지)를 찾아옴
        AttendChallenge attendChallenge = attendChallengeJPARepository.findByStatusNull(user.getId());

        if(attendChallenge != null) {
            // 찾아온 현재 진행중인 챌린지의 걸음 수에 빼준 값을 더함
            int walkingSum = attendChallenge.getTotalWalking() + walkingM;

            // 진행중인 챌린지의 걸음 수를 walkingSum으로 업데이트
            attendChallenge.setTotalWalking(walkingSum);

            // 오늘의 activity 걸음수를 업데이트
            activity.setWalking(reqDTO.getWalking());

        }
        return new ActivityResponse.WalkingUpdateDTO(user.getId(), reqDTO.getWalking());
    }
//
//    @Transactional
//    public ActivityResponse.WaterUpdateDTO waterUpdate(SessionUser user, ActivityRequest.WaterUpdateDTO reqDTO) {
//        Activity activity = activityJPARepository.findByUserIdOrderDesc(user.getId());
//
//        activity.setDrinkWater(reqDTO.getWater());
//
//        return new ActivityResponse.WaterUpdateDTO(user.getId(), reqDTO.getWater());
//    }
}