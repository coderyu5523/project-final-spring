package shop.mtcoding.projoctbodykey.food;

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
public class FoodControllerTest {

    private ObjectMapper om = new ObjectMapper();

    @Autowired
    private MockMvc mvc;

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
    }

    @Test
    public void foods_page_success_test() throws Exception {
        // given
        Integer page = 1;

        // when
        ResultActions actions = mvc.perform(
                get("/api/foods?&page=" + page)
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.foodNameList[0].id").value(11));
        actions.andExpect(jsonPath("$.body.foodNameList[0].name").value("삶은 닭가슴살"));
        actions.andExpect(jsonPath("$.body.foodContentList[0].id").value(11));
        actions.andExpect(jsonPath("$.body.foodContentList[0].name").value("삶은 닭가슴살"));
        actions.andExpect(jsonPath("$.body.foodContentList[0].carbo").value(0.0));
        actions.andExpect(jsonPath("$.body.foodContentList[0].protein").value(29.0));
        actions.andExpect(jsonPath("$.body.foodContentList[0].fat").value(1.4));
        actions.andExpect(jsonPath("$.body.foodContentList[0].kcal").value(135.0));
        actions.andExpect(jsonPath("$.body.foodContentList[0].gram").value(100));
    }

    @Test
    public void foods_success_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/foods" )
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
        String respBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.foodNameList[0].id").value(1));
        actions.andExpect(jsonPath("$.body.foodNameList[0].name").value("바나나"));
        actions.andExpect(jsonPath("$.body.foodContentList[0].id").value(1));
        actions.andExpect(jsonPath("$.body.foodContentList[0].name").value("바나나"));
        actions.andExpect(jsonPath("$.body.foodContentList[0].carbo").value(22.84));
        actions.andExpect(jsonPath("$.body.foodContentList[0].protein").value(1.09));
        actions.andExpect(jsonPath("$.body.foodContentList[0].fat").value(0.33));
        actions.andExpect(jsonPath("$.body.foodContentList[0].kcal").value(88.0));
        actions.andExpect(jsonPath("$.body.foodContentList[0].gram").value(100));
    }

    @Test
    public void foods_keyword_success_test() throws Exception {
        // given
        String keyword = "그";

        // when
        ResultActions actions = mvc.perform(
                get("/api/foods?keyword=" + keyword)
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.foodNameList[0].id").value(65));
        actions.andExpect(jsonPath("$.body.foodNameList[0].name").value("그린 스무디"));
        actions.andExpect(jsonPath("$.body.foodContentList[0].id").value(65));
        actions.andExpect(jsonPath("$.body.foodContentList[0].name").value("그린 스무디"));
        actions.andExpect(jsonPath("$.body.foodContentList[0].carbo").value(25.6));
        actions.andExpect(jsonPath("$.body.foodContentList[0].protein").value(5.2));
        actions.andExpect(jsonPath("$.body.foodContentList[0].fat").value(2.4));
        actions.andExpect(jsonPath("$.body.foodContentList[0].kcal").value(120.0));
        actions.andExpect(jsonPath("$.body.foodContentList[0].gram").value(100));
    }

    @Test
    public void foods_fail_success_test() throws Exception {
        // given
        String keyword = "123456789";

        // when
        ResultActions actions = mvc.perform(
                get("/api/foods?keyword=" + keyword)
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(404));
        actions.andExpect(jsonPath("$.msg").value("음식을 찾을 수 없어요."));
    }
}