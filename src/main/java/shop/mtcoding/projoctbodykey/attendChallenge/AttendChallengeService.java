package shop.mtcoding.projoctbodykey.attendChallenge;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey.user.SessionUser;

@RequiredArgsConstructor
@Service
public class AttendChallengeService {
    private final AttendChallengeJPARepository attendChallengeJPARepository;

//    @Transactional
//    public AttendChallengeResponse.SaveDTO save(SessionUser sessionUser, AttendChallengeRequest.SaveDTO reqDTO) {
//
//        AttendChallenge attendChallenge = attendChallengeJPARepository.save(reqDTO.toEntity(sessionUser.getId()));
//
//        return new AttendChallengeResponse.SaveDTO(attendChallenge);
//    }
}
