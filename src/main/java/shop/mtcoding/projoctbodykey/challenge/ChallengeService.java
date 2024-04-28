package shop.mtcoding.projoctbodykey.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey._core.utils.MyDateUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeJPARepository challengeJPARepository;

    // 검색 없는 관리자 페이지 챌린지 리스트
    public ChallengeResponse.AdminChallengeListDTO adminChallengeList(Integer page, Pageable pageable) {
        Page<Challenge> challenges = challengeJPARepository.findAll(pageable);

        // 페이지가 0이라면 첫번째 페이지
        Boolean first = page == 0;

        // 페이지의 토탈 페이지 수가 페이지 수에 1을 더한 값과 같다면 마지막 페이지
        Boolean last = challenges.getTotalPages() == page + 1;

        Integer prev = page - 1;
        Integer next = page + 1;

        return new ChallengeResponse.AdminChallengeListDTO(first, last, prev, next, challenges);
    }

    // 검색 있는 관리자 페이지 챌린지 리스트
    public ChallengeResponse.AdminChallengeSearchListDTO adminChallengeSearchList(String keyword, Integer page, Pageable pageable) {
        Page<Challenge> challenges = challengeJPARepository.findAllKeyword(keyword, pageable);
        
        // 페이지가 0이라면 첫번째 페이지
        Boolean first = page == 0;

        // 페이지의 토탈 페이지 수가 페이지 수에 1을 더한 값과 같다면 마지막 페이지
        Boolean last = challenges.getTotalPages() == page + 1;
        Integer prev = page - 1;
        Integer next = page + 1;

        return new ChallengeResponse.AdminChallengeSearchListDTO(first, last, prev, next, keyword, challenges);
    }

    public Challenge adminDetail(Integer id) {
        return challengeJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    public Challenge adminUpdateForm(Integer id) {
        return challengeJPARepository.findById(id).orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    @Transactional
    public void adminSave(ChallengeRequest.AdminSaveDTO reqDTO, String period) throws IOException, ParseException {

        // 백그라운드 이미지
        MultipartFile backgroundImg = reqDTO.getBackgroundImgFile();
        String backgroundImgUUID = UUID.randomUUID() + "_" + backgroundImg.getOriginalFilename();
        Path backgroundImgPaths = Paths.get("./upload/" + backgroundImgUUID);
        Files.write(backgroundImgPaths, backgroundImg.getBytes());

        // 배지 이미지
        MultipartFile badgeImg = reqDTO.getBadgeImgFile();
        String badgeImgUUID = UUID.randomUUID() + "_" + backgroundImg.getOriginalFilename();
        Path badgeImgPath = Paths.get("./upload/" + badgeImgUUID);
        Files.write(badgeImgPath, badgeImg.getBytes());


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp timestamp = new Timestamp(dateFormat.parse(period).getTime());

        // 둘의 UUID를 받아서 인설트 해주는것
        challengeJPARepository.save(reqDTO.toEntity(backgroundImgUUID, badgeImgUUID, timestamp));
    }

    @Transactional
    public void adminUpdate(Integer id, ChallengeRequest.AdminUpdateDTO reqDTO, String period) throws IOException, ParseException {
        Challenge challenge = challengeJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));

        // 백그라운드 이미지
        MultipartFile backgroundImg = reqDTO.getBackgroundImgFile();
        String backgroundImgUUID = UUID.randomUUID() + "_" + backgroundImg.getOriginalFilename();
        Path backgroundImgPaths = Paths.get("./upload/" + backgroundImgUUID);
        Files.write(backgroundImgPaths, backgroundImg.getBytes());

        // 배지 이미지
        MultipartFile badgeImg = reqDTO.getBadgeImgFile();
        String badgeImgUUID = UUID.randomUUID() + "_" + backgroundImg.getOriginalFilename();
        Path badgeImgPath = Paths.get("./upload/" + badgeImgUUID);
        Files.write(badgeImgPath, badgeImg.getBytes());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Timestamp timestamp = new Timestamp(dateFormat.parse(period).getTime());

        challenge.setChallengeName(reqDTO.getChallengeName());
        challenge.setBackgroundImg(backgroundImgUUID);
        challenge.setSubTitle(reqDTO.getSubTitle());
        challenge.setDistance(reqDTO.getDistance());
        challenge.setWalking(reqDTO.getWalking());
        challenge.setBadgeImg(badgeImgUUID);
        challenge.setContent(reqDTO.getContent());
        challenge.setCoin(reqDTO.getCoin());
        challenge.setPeriod(timestamp);
    }

    @Transactional
    public void adminDelete(Integer id) {
        Challenge challenge = challengeJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
        challengeJPARepository.delete(challenge);
    }


}