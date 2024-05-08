package shop.mtcoding.projoctbodykey.challenge;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception400;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception401;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey.attendChallenge.AttendChallenge;
import shop.mtcoding.projoctbodykey.attendChallenge.AttendChallengeJPARepository;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.io.*;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ChallengeService {
    private final ChallengeJPARepository challengeJPARepository;
    private final AttendChallengeJPARepository attendChallengeJPARepository;
    private final UserJPARepository userJPARepository;
    private final ChallengeQueryRepository challengeResponse;

    // 챌린지 페이지
    public ChallengeResponse.ChallengesDTO challenges(SessionUser sessionUser) {

        // 내가 지금까지 진행한 챌린지
        List<Object[]> pastChallenges = challengeResponse.partChallenges(sessionUser.getId());


        // 현재 진행중인 챌린지
        Object[] ongoingChallenges = challengeResponse.ongoingChallenges(sessionUser.getId());

        // 진행을 하지 않은 챌린지
        List<Object[]> upcomingChallenges = challengeResponse.upcomingChallenges(sessionUser.getId());

        // 현재 진행중인 챌린지가 없는 경우 ongoingChallenges를 null을 넘기는 처리
        try {
            return new ChallengeResponse.ChallengesDTO(ongoingChallenges, upcomingChallenges, pastChallenges);
        } catch (NullPointerException e) {
            return new ChallengeResponse.ChallengesDTO(upcomingChallenges, pastChallenges);
        }
    }

    // 챌린지
    public ChallengeResponse.OngoingChallengeDTO ongoingChallenge(SessionUser sessionUser) {
        Object[] ongoingChallenges = challengeResponse.ongoingChallengesWalking(sessionUser.getId());
        try {
            return new ChallengeResponse.OngoingChallengeDTO(ongoingChallenges);
        } catch (NullPointerException e) {
           throw new Exception400(sessionUser.getUsername() + " 님은 현재 진행중인 챌린지가 없어요");
        }
    }

    public ChallengeResponse.DetailDTO detail(SessionUser sessionUser, Integer id) throws IOException {
        Challenge challenge = challengeJPARepository.findById(id).orElseThrow(() ->
                new Exception404("해당 챌린지를 찾을 수 없습니다."));

        Boolean attendChallenge = attendChallengeJPARepository.findByChallengeIdAndUserId(sessionUser.getId(), id);

        String backgroundImg = ImageUtil.encode(challenge.getBackgroundImg());

        return new ChallengeResponse.DetailDTO(attendChallenge, backgroundImg, challenge);
    }

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
        return challengeJPARepository.findById(id).orElseThrow(() ->
                new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    public Challenge adminUpdateForm(Integer id) {
        return challengeJPARepository.findById(id).orElseThrow(() ->
                new Exception404("해당 챌린지를 찾을 수 없습니다."));
    }

    public void adminSave(ChallengeRequest.AdminSaveDTO reqDTO, String period) {
        try {
            int targetWidth = 800;
            int targetHeight = 600;

            // 배경 이미지
            String backgroundImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("배경 이미지", reqDTO.getBackgroundImgFile().getOriginalFilename(), reqDTO.getBackgroundImgFile(), targetWidth, targetHeight);

            // 배지 이미지
            String badgeImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("배지 이미지", reqDTO.getBadgeImgFile().getOriginalFilename(), reqDTO.getBadgeImgFile(), targetWidth, targetHeight);

//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Timestamp timestamp = new Timestamp(dateFormat.parse(period).getTime());

            // 둘의 UUID를 받아서 인설트 해주는것
            challengeJPARepository.save(reqDTO.toEntity(backgroundImgUUID, badgeImgUUID));
        } catch (IOException e) {
            // 오류 처리
            e.printStackTrace();
        }
    }

    @Transactional
    public void adminUpdate(Integer id, ChallengeRequest.AdminUpdateDTO reqDTO) {
        try {
            Challenge challenge = challengeJPARepository.findById(id)
                    .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));

            int targetWidth = 800;
            int targetHeight = 600;

            String backgroundImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("배경 이미지", reqDTO.getBackgroundImgFile().getOriginalFilename(), reqDTO.getBackgroundImgFile(), targetWidth, targetHeight);

            String badgeImgUUID = ImageUtil.imgResizedAndDownloadAndUUID("배지 이미지", reqDTO.getBadgeImgFile().getOriginalFilename(), reqDTO.getBadgeImgFile(), targetWidth, targetHeight);

//            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//            Timestamp timestamp = new Timestamp(dateFormat.parse(period).getTime());

            challenge.setChallengeName(reqDTO.getChallengeName());
            challenge.setBackgroundImg(backgroundImgUUID);
            challenge.setSubTitle(reqDTO.getSubTitle());
            challenge.setDistance(reqDTO.getDistance());
            challenge.setWalking(reqDTO.getWalking());
            challenge.setBadgeImg(badgeImgUUID);
            challenge.setContent(reqDTO.getContent());
            challenge.setCoin(reqDTO.getCoin());
            challenge.setPeriod(reqDTO.getPeriod());
        } catch (IOException e) {
            // 오류 처리
            e.printStackTrace();
        }
    }

    @Transactional
    public void adminDelete(Integer id) {
        Challenge challenge = challengeJPARepository.findById(id)
                .orElseThrow(() -> new Exception404("해당 챌린지를 찾을 수 없습니다."));
        challengeJPARepository.delete(challenge);
    }
}