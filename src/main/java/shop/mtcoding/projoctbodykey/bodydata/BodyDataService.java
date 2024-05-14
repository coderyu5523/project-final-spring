package shop.mtcoding.projoctbodykey.bodydata;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.activity.Activity;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class BodyDataService {
    private final BodyDataJPARepository bodydataJPARepository;
    private final UserJPARepository userJPARepository;

    @Transactional
    public BodyDataResponse.UpdateDTO update(SessionUser sessionUser, BodyDataRequest.UpdateDTO reqDTO) {
        BodyData bodyData = bodydataJPARepository.findByUserIdOrderDesc(sessionUser.getId());

        bodyData.setFat(reqDTO.getFat());
        bodyData.setMuscle(reqDTO.getMuscle());
        bodyData.setWeight(reqDTO.getWeight());

        return new BodyDataResponse.UpdateDTO(bodyData);
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

            BodyData bodyData = bodydataJPARepository.findByUserIdAndCreatedAt(user.getId(), timestamp);

            if(bodyData == null) {
                BodyData bodyDataDesc = bodydataJPARepository.findByUserIdOrderDesc(user.getId());
                if(bodyDataDesc == null) {
                    BodyData newBodyData = new BodyData();
                    newBodyData.setUser(user);
                    newBodyData.setFat(0.0d);
                    newBodyData.setMuscle(0.0d);
                    newBodyData.setWeight(0.0d);

                    bodydataJPARepository.save(newBodyData);
                } else {
                    BodyData newBodyData = new BodyData();
                    newBodyData.setUser(user);
                    newBodyData.setFat(bodyDataDesc.getFat());
                    newBodyData.setMuscle(bodyDataDesc.getMuscle());
                    newBodyData.setWeight(bodyDataDesc.getWeight());

                    bodydataJPARepository.save(newBodyData);
                }
            }
        }
    }

    public BodyDataResponse.BodyDateDTO activitiesBodyDate(SessionUser sessionUser) {
        User user = userJPARepository.findById(sessionUser.getId()).orElseThrow(() -> new Exception404("유저 정보가 없습니다."));
        BodyData bodyData = bodydataJPARepository.findByUserIdOrderDesc(sessionUser.getId());
        List<BodyData> bodyDataList = bodydataJPARepository.findByUserIdDesc(sessionUser.getId());

        return new BodyDataResponse.BodyDateDTO(user ,bodyData, bodyDataList);
    }
}
