package shop.mtcoding.projoctbodykey.choiceanswer;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey.user.User;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc // MockMvc IoC 로드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 모든 빈 IoC 로드
public class ChoiceAnswerControllerTest {

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
    public void save_test() throws Exception {
        // given
        List<ChoiceAnswerRequest.AnswerDTO> reqDTO =new ArrayList<>();
        ChoiceAnswerRequest.AnswerDTO answer = new ChoiceAnswerRequest.AnswerDTO(1, 2);
        reqDTO.add(answer);

        String reqBody = om.writeValueAsString(reqDTO);


        // when
        ResultActions actions = mvc.perform(
                post("/api/survey/8")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.userId").value(1));
        actions.andExpect(jsonPath("$.body.surveyId").value(1));
        actions.andExpect(jsonPath("$.body.questionAndAnswers[0].questionId").value(1));
        actions.andExpect(jsonPath("$.body.questionAndAnswers[0].choiceId").value(2));
    }

    @Test
    public void save_not_exist_survey_fail_test() throws Exception {
        // given
        List<ChoiceAnswerRequest.AnswerDTO> reqDTO =new ArrayList<>();
        ChoiceAnswerRequest.AnswerDTO answer = new ChoiceAnswerRequest.AnswerDTO(1, 2);
        reqDTO.add(answer);

        String reqBody = om.writeValueAsString(reqDTO);


        // when
        ResultActions actions = mvc.perform(
                post("/api/survey/9")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        //eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(404));
        actions.andExpect(jsonPath("$.msg").value("설문조사가 없습니다"));
        actions.andExpect(jsonPath("$.body").isEmpty());

    }
}

