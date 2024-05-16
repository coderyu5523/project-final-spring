package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception400;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.activity.Activity;
import shop.mtcoding.projoctbodykey.activity.ActivityJPARepository;
import shop.mtcoding.projoctbodykey.activity.ActivityRequest;
import shop.mtcoding.projoctbodykey.activity.ActivityService;
import shop.mtcoding.projoctbodykey.challenge.ChallengeQueryRepository;
import shop.mtcoding.projoctbodykey.challenge.ChallengeResponse;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AttendChallengeService {
    private final AttendChallengeJPARepository attendChallengeJPARepository;
    private final UserJPARepository userJPARepository;
    private final ChallengeQueryRepository challengeQueryRepository;

    @Transactional
    public AttendChallengeResponse.SaveDTO save(SessionUser sessionUser, AttendChallengeRequest.SaveDTO reqDTO) {
        User user = userJPARepository.
                findById(sessionUser.getId()).orElseThrow(() -> new Exception404("유저 정보가 없습니다."));
        AttendChallenge findByStatusNull = attendChallengeJPARepository.findByStatusNull(sessionUser.getId());
        List<Object[]> pastChallenges = challengeQueryRepository.partChallenges(sessionUser.getId());

        if(findByStatusNull == null)
        {
            for (Object[] challenge : pastChallenges) {
                if(challenge[0] == reqDTO.getChallenge().getId()) {
                    throw new Exception400("이미 한번 진행한 챌린지 입니다.");
                }
            }
        }

        if (findByStatusNull != null) {
            throw new Exception400("진행중인 챌린지가 존재합니다.");
        }

        // 현재 시간을 가져옴
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        // Calendar 인스턴스를 생성하고 현재 시간을 설정합니다.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(currentTimestamp.getTime());

        // 30일을 더함
        calendar.add(Calendar.DATE, 30);

        // 타임스탬프에 저장해줘야함
        Timestamp closingTime = new Timestamp(calendar.getTime().getTime());

        AttendChallenge attendChallenge = attendChallengeJPARepository.save(reqDTO.toEntity(closingTime, reqDTO, user));

        return new AttendChallengeResponse.SaveDTO(attendChallenge);
    }

    @Transactional
    public ChallengeResponse.UpcomingChallengesDTO statusUpdate(SessionUser sessionUser, AttendChallengeRequest.StatusUpdateDTO reqDTO) {
        Object[] ongoingChallenges = challengeQueryRepository.ongoingChallenge(sessionUser.getId());

        if(ongoingChallenges == null) {
            throw new Exception400("현재 진행중인 챌린지가 없어, 챌린지의 스테이터스 값을 변경할 수 없습니다.");
        }

        ChallengeResponse.UpcomingChallengesDTO ongoingChallenge = new ChallengeResponse.UpcomingChallengesDTO(ongoingChallenges, reqDTO.getStatus());

        AttendChallenge attendChallenge = attendChallengeJPARepository.findByStatusNull(sessionUser.getId());
        attendChallenge.setStatus(reqDTO.getStatus());

        return ongoingChallenge;
    }

//    @Transactional
//    public void walkingUpdate(ActivityRequest.WalkingUpdateDTO reqDTO, SessionUser user) {
//        Activity activity = activityJPARepository.findByUserIdOrderDesc(user.getId());
//
//    }
}

