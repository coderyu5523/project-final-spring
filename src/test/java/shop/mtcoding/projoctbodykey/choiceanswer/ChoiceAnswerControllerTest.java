package shop.mtcoding.projoctbodykey.choiceanswer;

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
    public void _test(){
        // given
        
        
        // when
        
        
        // then
    }
}

