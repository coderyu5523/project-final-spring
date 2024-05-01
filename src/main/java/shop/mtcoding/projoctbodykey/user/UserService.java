package shop.mtcoding.projoctbodykey.user;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception400;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception401;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception403;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey._core.utils.PasswordUtil;
import shop.mtcoding.projoctbodykey.bodydata.Bodydata;
import shop.mtcoding.projoctbodykey.bodydata.BodydataJPARepository;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.challenge.ChallengeJPARepository;
import shop.mtcoding.projoctbodykey.challenge.ChallengeQueryRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserJPARepository userJPARepository;
    private final BodydataJPARepository bodydataJPARepository;
    private final ChallengeQueryRepository challengeQueryRepository;

    @Transactional
    public UserResponse.UpdateDTO update(UserRequest.UpdateDTO reqDTO, SessionUser user) throws IOException {
        if(user == null) {
            throw new Exception403("로그인 하셔야 해요.");
        }

        User my = userJPARepository.findById(user.getId()).orElseThrow(() ->
                new Exception404("유저 정보를 찾을 수 없어요"));

        // 유저패스워드 암호화
        String encPassword = PasswordUtil.encode(reqDTO.getPassword());

        // 이미지를 디코딩하여 저장하고 파일명 생성
        byte[] imageData = Base64.getDecoder().decode(reqDTO.getUserImg());
        String imgUUID = UUID.randomUUID().toString() + ".jpg";
        String imagePath = "./upload/" + imgUUID;

        // 이미지 파일로 저장
        File file = new File(imagePath);
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write(imageData);
        outputStream.close();

        my.setName(reqDTO.getName());
        my.setPassword(encPassword);
        my.setPhone(reqDTO.getPhone());
        my.setHeight(reqDTO.getHeight());
        my.setUserImg(imgUUID);

        return new UserResponse.UpdateDTO(my, reqDTO.getUserImg());
    }

    @Transactional
    public UserResponse.JoinDTO join(UserRequest.JoinDTO reqDTO) {

        // 유저네임 중복체크
        Optional<User> userOP = userJPARepository.findByUsername(reqDTO.getUsername());
        if (userOP.isPresent()) {
            throw new Exception400("유저네임이 중복되었습니다.");
        }

        // 유저패스워드 암호화
        String encPassword = PasswordUtil.encode(reqDTO.getPassword());

        User user = userJPARepository.save(reqDTO.toEntity(encPassword));

        return new UserResponse.JoinDTO(user);
    }

    // DataLoader을 써서 처음 시작할 때 실행됨, 실행해서 더미에 있는 유저 패스워드를 암호화해서 업데이트 해줌
    @Transactional
    public void updateUserPassword(User user, String encPassword) {
        User users = userJPARepository.findByUsername(user.getUsername()).orElseThrow();

        users.setPassword(encPassword);
    }

    public UserResponse.LoginDTO login(UserRequest.LoginDTO reqDTO) {
        User userPS = userJPARepository.findByUsername(reqDTO.getUsername()).orElseThrow(
                ()-> new Exception404("유저네임을 찾을 수 없습니다")
        );

        if (!PasswordUtil.verify(reqDTO.getPassword(), userPS.getPassword())) {
            throw new Exception401("패스워드가 일치하지 않습니다");
        }

        String jwt = JwtUtil.create(userPS);

        return new UserResponse.LoginDTO(jwt, userPS);
    }

    public UserResponse.MyPageDTO myPage(SessionUser user) {
        if(user == null) {
            throw new Exception403("로그인 하셔야 해요.");
        }

        User my = userJPARepository.findById(user.getId()).orElseThrow(() ->
                new Exception404("유저 정보를 찾을 수 없어요"));

        Bodydata bodydata = bodydataJPARepository.findByUserOrderDesc(user.getId()).orElseThrow(() ->
                new Exception404("유저 정보를 찾을 수 없어요."));

        List<Object[]> conqueredChallenge = challengeQueryRepository.conqueredChallenge(user.getId());

        return new UserResponse.MyPageDTO(my, bodydata, conqueredChallenge);
    }

    public UserResponse.UpdateFormDTO updateForm(SessionUser user) {
        if(user == null) {
            throw new Exception403("로그인 하셔야 해요.");
        }

        User my = userJPARepository.findById(user.getId()).orElseThrow(() ->
                new Exception404("유저 정보를 찾을 수 없어요"));

        return new UserResponse.UpdateFormDTO(my);
    }


}