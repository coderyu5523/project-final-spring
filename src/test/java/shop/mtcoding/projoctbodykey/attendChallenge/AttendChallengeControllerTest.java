package shop.mtcoding.projoctbodykey.attendChallenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import shop.mtcoding.projoctbodykey.MyRestDoc;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey.activity.ActivityRequest;
import shop.mtcoding.projoctbodykey.challenge.Challenge;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc // MockMvc IoC 로드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 모든 빈 IoC 로드
public class AttendChallengeControllerTest extends MyRestDoc {

    private ObjectMapper om = new ObjectMapper();

    private static String jwt;
    private static String jwt5;

    @BeforeAll
    public static void setUp() {
        jwt = JwtUtil.create(
                User.builder()
                        .id(1)
                        .username("ssar")
                        .password("1234")
                        .build());

        jwt5 = JwtUtil.create(
                User.builder()
                        .id(5)
                        .username("hsj")
                        .password("1234")
                        .build());
    }

    @Test
    public void statusUpdate_success_test() throws Exception {
        // given
        AttendChallengeRequest.StatusUpdateDTO reqDTO = new AttendChallengeRequest.StatusUpdateDTO();
        Boolean st = false;
        reqDTO.setStatus(st);
        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                put("/api/attend-challenges/status-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("성공"))
                .andExpect(jsonPath("$.body.id").value(28))
                .andExpect(jsonPath("$.body.status").value(st))
                .andExpect(jsonPath("$.body.challengeName").value("그로스글로크너"))
                .andExpect(jsonPath("$.body.distance").value("3798m"))
                .andExpect(jsonPath("$.body.badgeImg").value("/upload/c6d37c1b-a37b-45a6-a170-5254a68970de_grossglock.png"))
                .andDo(MockMvcResultHandlers.print()).andDo(document);

    }

    @Test
    public void statusUpdate_fail_test() throws Exception {
        // given
        AttendChallengeRequest.StatusUpdateDTO reqDTO = new AttendChallengeRequest.StatusUpdateDTO();
        Boolean st = false;
        reqDTO.setStatus(st);
        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                put("/api/attend-challenges/status-update")
                        .header("Authorization", "Bearer " + jwt5)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.msg").value("현재 진행중인 챌린지가 없어, 챌린지의 스테이터스 값을 변경할 수 없습니다."))
                .andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void save_success_test() throws Exception {
        // given
        AttendChallengeRequest.SaveDTO reqDTO = new AttendChallengeRequest.SaveDTO();
        Challenge challenge = new Challenge();
        challenge.setId(1);
        reqDTO.setChallenge(challenge);
        Boolean st = null;
        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/api/attend-challenge-save")
                        .header("Authorization", "Bearer " + jwt5)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200))
                .andExpect(jsonPath("$.msg").value("성공"))
                .andExpect(jsonPath("$.body.userId").value(5))
                .andExpect(jsonPath("$.body.challengeId").value(1))
                .andExpect(jsonPath("$.body.status").value(st))
                .andDo(MockMvcResultHandlers.print()).andDo(document);

    }

    @Test
    public void save_fail_test() throws Exception {
        // given
        AttendChallengeRequest.SaveDTO reqDTO = new AttendChallengeRequest.SaveDTO();
        Challenge challenge = new Challenge();
        challenge.setId(1);
        reqDTO.setChallenge(challenge);
        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/api/attend-challenge-save")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.msg").value("진행중인 챌린지가 존재합니다."))
                .andDo(MockMvcResultHandlers.print()).andDo(document);
//                .andExpect(jsonPath("$.body.userId").value(5))
//                .andExpect(jsonPath("$.body.challengeId").value(1))
//                .andExpect(jsonPath("$.body.status").value(st));

    }
}