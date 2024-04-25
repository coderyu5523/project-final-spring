package shop.mtcoding.projoctbodykey.attendChallenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AttendChallengeService {
    private final AttendChallengeJPARepository attendChallengeJPARepository;
}
