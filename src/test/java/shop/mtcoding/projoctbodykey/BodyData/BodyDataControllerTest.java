package shop.mtcoding.projoctbodykey.BodyData;

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
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey.activity.ActivityRequest;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataRequest;
import shop.mtcoding.projoctbodykey.user.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc // MockMvc IoC 로드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 모든 빈 IoC 로드
public class BodyDataControllerTest extends MyRestDoc {

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
    public void update_success_test() throws Exception {
        // given
        BodyDataRequest.UpdateDTO reqDTO = new BodyDataRequest.UpdateDTO();
        reqDTO.setFat(23.3d);
        reqDTO.setMuscle(29.5d);
        reqDTO.setWeight(62.3d);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                put("/api/body-date/update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.userId").value(1));
        actions.andExpect(jsonPath("$.body.fat").value(23.3));
        actions.andExpect(jsonPath("$.body.muscle").value(29.5));
        actions.andExpect(jsonPath("$.body.weight").value(62.3));
        actions.andExpect(jsonPath("$.body.date").value("2024-05-20T09:12:00.000+00:00"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void update_fail_test() throws Exception {
        // given
        BodyDataRequest.UpdateDTO reqDTO = new BodyDataRequest.UpdateDTO();
        reqDTO.setFat(500000000d);
        reqDTO.setMuscle(29.5d);
        reqDTO.setWeight(62.3d);

        String reqBody = om.writeValueAsString(reqDTO);
        //System.out.println("reqBody : "+reqBody);

        // when
        ResultActions actions = mvc.perform(
                put("/api/body-date/update")
                        .header("Authorization", "Bearer " + jwt)
                        .content(reqBody)
                        .contentType(MediaType.APPLICATION_JSON)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : "+respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("100 이하의 값을 입력하여 주세요. : fat"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }
}