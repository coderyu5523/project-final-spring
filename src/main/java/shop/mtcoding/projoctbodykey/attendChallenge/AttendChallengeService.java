package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception400;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.sql.Timestamp;
import java.util.Calendar;

@RequiredArgsConstructor
@Service
public class AttendChallengeService {
    private final AttendChallengeJPARepository attendChallengeJPARepository;
    private final UserJPARepository userJPARepository;

    @Transactional
    public AttendChallengeResponse.SaveDTO save(SessionUser sessionUser, AttendChallengeRequest.SaveDTO reqDTO) {
        User user = userJPARepository.
                findById(sessionUser.getId()).orElseThrow(() -> new Exception404("유저 정보가 없습니다."));

        AttendChallenge findByStatusNull = attendChallengeJPARepository.findByStatusNull(sessionUser.getId());

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
}
