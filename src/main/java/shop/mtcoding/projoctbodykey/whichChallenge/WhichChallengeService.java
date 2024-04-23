package shop.mtcoding.projoctbodykey.whichChallenge;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception401;
import shop.mtcoding.projoctbodykey.user.SessionUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class WhichChallengeService {
    private final WhichChallengeJPARepository whichChallengeJPARepository;

    public List<WhichChallenge> whichChallengeList() {

        return whichChallengeJPARepository.findAll();
    }

    public void adminChallengeSave(WhichChallengeRequest.AdminChallengeSaveDTO reqDTO) {

        whichChallengeJPARepository.save(reqDTO.toEntity());
    }
}
