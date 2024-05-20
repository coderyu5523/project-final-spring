package shop.mtcoding.projoctbodykey.meal;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey.user.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc // MockMvc IoC 로드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 모든 빈 IoC 로드
public class mealControllerTest {

    private ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

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
    public void walkList_test() throws Exception {
        // given
        
        
        // when
        ResultActions actions = mvc.perform(
                get("/api/survey")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.[0].id").value(1));
        actions.andExpect(jsonPath("$.body.[0].title").value("설문조사1"));
        actions.andExpect(jsonPath("$.body.[0].isAttend").value("참여가능"));
        actions.andExpect(jsonPath("$.body.[0].progress").value("진행중"));
        actions.andExpect(jsonPath("$.body.[0].questionCount").value(19));

    }


    @Test
    public void surveyDetail_test() throws Exception {
        // given


        // when
        ResultActions actions = mvc.perform(
                get("/api/survey/1")
                        .header("Authorization", "Bearer " + jwt)
        );
        //eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.surveyId").value(1));
        actions.andExpect(jsonPath("$.body.surveyTitle").value("설문조사1"));
        actions.andExpect(jsonPath("$.body.questions[0].questionId").value("1"));
        actions.andExpect(jsonPath("$.body.questions[0].questionTitle").value("하루 평균 수면 시간은 얼마나 되십니까?"));
        actions.andExpect(jsonPath("$.body.questions[0].choices[0].choiceId").value("1"));
        actions.andExpect(jsonPath("$.body.questions[0].choices[0].choiceTitle").value("6시간 미만"));
        actions.andExpect(jsonPath("$.body.questions[0].choices[0].choiceNumber").value("1"));

    }

    @Test
    public void surveyDetail_fail_test() throws Exception {
        // given


        // when
        ResultActions actions = mvc.perform(
                get("/api/survey/9")
                        .header("Authorization", "Bearer " + jwt)
        );
        //eye
        String respBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(404));
        actions.andExpect(jsonPath("$.msg").value("해당 설문조사를 찾을 수 없습니다"));
        actions.andExpect(jsonPath("$.body").isEmpty());
    }
}

