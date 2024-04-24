package shop.mtcoding.projoctbodykey.Challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeJPARepository challengeJPARepository;

    public List<Challenge> adminChallengeList() {

        return challengeJPARepository.findAll();
    }

    public void adminChallengeSave(ChallengeRequest.AdminChallengeSaveDTO reqDTO) {

        challengeJPARepository.save(reqDTO.toEntity());
    }
}
