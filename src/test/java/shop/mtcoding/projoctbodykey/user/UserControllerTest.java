package shop.mtcoding.projoctbodykey.user;

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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import shop.mtcoding.projoctbodykey.MyRestDoc;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc // MockMvc IoC 로드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 모든 빈 IoC 로드
public class UserControllerTest extends MyRestDoc {

    private ObjectMapper om = new ObjectMapper();

    private static String jwt;

    @BeforeAll
    public static void setUp() {
        jwt = JwtUtil.create(
                User.builder()
                        .id(1)
                        .username("ssar")
                        .password("1234")
                        .build());
    }

    @Test
    public void goalWeightUpdate_success_test() throws Exception {
        // given
        UserRequest.GoalWeightUpdateDTO reqDTO = new UserRequest.GoalWeightUpdateDTO();
        reqDTO.setGoalWeight(70.0d);
        String reqBody = om.writeValueAsString(reqDTO);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/goalWeight-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.goalWeight").value(70.0d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void goalWeightUpdate_fail_test() throws Exception {
        // given
        UserRequest.GoalWeightUpdateDTO reqDTO = new UserRequest.GoalWeightUpdateDTO();
        reqDTO.setGoalWeight(7000000.0d);
        String reqBody = om.writeValueAsString(reqDTO);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/goalWeight-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("200 이하의 값을 입력하여 주세요. : goalWeight"));
    }

    @Test
    public void goalMuscleUpdate_success_test() throws Exception {
        // given
        UserRequest.GoalMuscleUpdateDTO reqDTO = new UserRequest.GoalMuscleUpdateDTO();
        reqDTO.setGoalMuscle(23.0d);
        String reqBody = om.writeValueAsString(reqDTO);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/goalMuscle-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.goalMuscle").value(23.0d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void goalMuscleUpdate_fail_test() throws Exception {
        // given
        UserRequest.GoalMuscleUpdateDTO reqDTO = new UserRequest.GoalMuscleUpdateDTO();
        reqDTO.setGoalMuscle(23197198189.0d);
        String reqBody = om.writeValueAsString(reqDTO);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/goalMuscle-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("100 이하의 값을 입력하여 주세요. : goalMuscle"));
    }

    @Test
    public void goalFatUpdate_success_test() throws Exception {
        // given
        UserRequest.GoalFatUpdateDTO reqDTO = new UserRequest.GoalFatUpdateDTO();
        reqDTO.setGoalFat(22.0d);
        String reqBody = om.writeValueAsString(reqDTO);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/goalFat-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.goalFat").value(22.0d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void goalFatUpdate_fail_test() throws Exception {
        // given
        UserRequest.GoalFatUpdateDTO reqDTO = new UserRequest.GoalFatUpdateDTO();
        reqDTO.setGoalFat(22000.0d);
        String reqBody = om.writeValueAsString(reqDTO);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/goalFat-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("100 이하의 값을 입력하여 주세요. : goalFat"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void imgUpdate_test() throws Exception {
        // given
        UserRequest.ImgUpdateDTO reqDTO = new UserRequest.ImgUpdateDTO();
        reqDTO.setUserImg(ImageUtil.encode("86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png"));


        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/img-update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("respBody : "+respBody);
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void update_success_test() throws Exception {
        // given
        UserRequest.UpdateDTO reqDTO = new UserRequest.UpdateDTO();
        reqDTO.setName("하승진");
        reqDTO.setPassword("4587");
        reqDTO.setPhone("010-7551-5747");
        reqDTO.setHeight(169.8d);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.name").value("하승진"));
        actions.andExpect(jsonPath("$.body.phone").value("010-7551-5747"));
        actions.andExpect(jsonPath("$.body.height").value(169.8d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void update_fail_test() throws Exception {
        // given
        UserRequest.UpdateDTO reqDTO = new UserRequest.UpdateDTO();
        reqDTO.setName("하승진");
        reqDTO.setPassword("4587");
        reqDTO.setPhone("010-75515747");
        reqDTO.setHeight(169.8d);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                put("/api/users/update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("respBody : "+respBody);
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("010-0000-0000 형식으로 작성해주세요 : phone"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void updateForm_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/users/update-form")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.id").value(1));
        actions.andExpect(jsonPath("$.body.name").value("류재성"));
        actions.andExpect(jsonPath("$.body.phone").value("010-0100-0100"));
        actions.andExpect(jsonPath("$.body.height").value(178.5));
        actions.andExpect(jsonPath("$.body.userImg").value("/upload/86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void mainPage_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/users")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.id").value(1));
        actions.andExpect(jsonPath("$.body.name").value("류재성"));
        actions.andExpect(jsonPath("$.body.goalFat").value(12.0));
        actions.andExpect(jsonPath("$.body.goalMuscle").value(35.0));
        actions.andExpect(jsonPath("$.body.goalWeight").value(70.0));
        actions.andExpect(jsonPath("$.body.fat").value(21.3));
        actions.andExpect(jsonPath("$.body.muscle").value(21.5));
        actions.andExpect(jsonPath("$.body.weight").value(76.3));
        actions.andExpect(jsonPath("$.body.bodyData[0].id").value(1));
        actions.andExpect(jsonPath("$.body.bodyData[0].fat").value(21.3));
        actions.andExpect(jsonPath("$.body.bodyData[0].muscle").value(21.5));
        actions.andExpect(jsonPath("$.body.bodyData[0].weight").value(76.3));
        actions.andExpect(jsonPath("$.body.bodyData[0].date").value("2024-05-16T09:12:00.000+00:00"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void myPage_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/users/myPage")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.id").value(1));
        actions.andExpect(jsonPath("$.body.name").value("류재성"));
        actions.andExpect(jsonPath("$.body.fat").value(21.3d));
        actions.andExpect(jsonPath("$.body.muscle").value(21.5d));
        actions.andExpect(jsonPath("$.body.weight").value(76.3));
        actions.andExpect(jsonPath("$.body.userImg").value("/upload/86d1375a-9cc3-47bc-a1a0-6561c01fa2e4_saram1.png"));
        actions.andExpect(jsonPath("$.body.conqueredChallenge[0].id").value(3));
        actions.andExpect(jsonPath("$.body.conqueredChallenge[0].challengeName").value("칠쿠트 트레일"));
        actions.andExpect(jsonPath("$.body.conqueredChallenge[0].distance").value("53K"));
        actions.andExpect(jsonPath("$.body.conqueredChallenge[0].status").value(true));
        actions.andExpect(jsonPath("$.body.conqueredChallenge[0].badgeImg").value("/upload/270f40f2-683f-4a9a-be40-764e377847c6_chilkoot.png"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void myChangeFat_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/users/my-change-fat")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.fatDataList[0].fat").value(21.3d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void myChangeMuscle_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/users/my-change-muscle")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.muscleDataList[0].muscle").value(21.5d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void myChangeWeight_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/users/my-change-weight")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.weightDataList[0].weight").value(76.3d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void login_success_test() throws Exception {
        // given
        String username = "ssar";
        String password = "1234";
        UserRequest.LoginDTO reqDTO = new UserRequest.LoginDTO(username, password);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/login")
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("respBody : "+respBody);
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.username").value("ssar"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void login_fail_test() throws Exception {
        // given
        String username = "ssar";
        String password = "비밀번호";
        UserRequest.LoginDTO reqDTO = new UserRequest.LoginDTO(username, password);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/login")
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("respBody : "+respBody);
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("영문/숫자 2~14자 이내로 작성해주세요 : password"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void join_success_test() throws Exception {
        // given
        UserRequest.JoinDTO reqDTO = new UserRequest.JoinDTO();
        reqDTO.setUsername("egdg4587");
        reqDTO.setName("하낙복");
        reqDTO.setPassword("1234");
        reqDTO.setBirth(Timestamp.valueOf("1994-12-26 00:00:00"));
        reqDTO.setGender("M");
        reqDTO.setPhone("010-7551-5747");
        reqDTO.setHeight(169.8d);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/join")
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("respBody : "+respBody);
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.username").value("egdg4587"));
        actions.andExpect(jsonPath("$.body.name").value("하낙복"));
        actions.andExpect(jsonPath("$.body.birth").value("1994-12-26"));
        actions.andExpect(jsonPath("$.body.gender").value("M"));
        actions.andExpect(jsonPath("$.body.phone").value("010-7551-5747"));
        actions.andExpect(jsonPath("$.body.height").value(169.8d));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void join_fall_test() throws Exception {
        // given
        UserRequest.JoinDTO reqDTO = new UserRequest.JoinDTO();
        reqDTO.setUsername("egdg4587");
        reqDTO.setName("하낙복");
        reqDTO.setPassword("1234");
        reqDTO.setBirth(Timestamp.valueOf("1994-12-26 00:00:00"));
        reqDTO.setGender("M");
        reqDTO.setPhone("010-75515747");
        reqDTO.setHeight(169.8d);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                post("/join")
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("respBody : "+respBody);
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("010-0000-0000 형식으로 작성해주세요 : phone"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
//        actions.andExpect(jsonPath("$.body.username").value("egdg"));
//        actions.andExpect(jsonPath("$.body.name").value("하승진"));
//        actions.andExpect(jsonPath("$.body.gender").value("M"));
//        actions.andExpect(jsonPath("$.body.height").value(169.8d));
    }
}