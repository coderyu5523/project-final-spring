package shop.mtcoding.projoctbodykey.challenge;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import shop.mtcoding.projoctbodykey.MyRestDoc;
import shop.mtcoding.projoctbodykey._core.utils.ImageUtil;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;
import shop.mtcoding.projoctbodykey.user.User;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc // MockMvc IoC 로드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 모든 빈 IoC 로드
public class ChallengeControllerTest extends MyRestDoc {

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
    public void ongoingChallenge_success_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/challenges/ongoingChallenge")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.id").value(28));
        actions.andExpect(jsonPath("$.body.challengeName").value("그로스글로크너"));
        actions.andExpect(jsonPath("$.body.subtitle").value("알프스-오스트리아 3,798.0m(약 1.2천층 올라감)"));
        actions.andExpect(jsonPath("$.body.total_walking").value(8303));
        actions.andExpect(jsonPath("$.body.walking").value(100000));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void ongoingChallenge_fail_test() throws Exception {
        // given

        // when
        ResultActions actions = mvc.perform(
                get("/api/challenges/ongoingChallenge")
                        .header("Authorization", "Bearer " + jwt5)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(400));
        actions.andExpect(jsonPath("$.msg").value("hsj" + " 님은 현재 진행중인 챌린지가 없어요"));
    }

    @Test
    public void challenges_test() throws Exception {
        // given
        Boolean st = null;
        // when
        ResultActions actions = mvc.perform(
                get("/api/challenges")
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//       System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.id").value(28));
        actions.andExpect(jsonPath("$.body.challengeName").value("그로스글로크너"));
        actions.andExpect(jsonPath("$.body.subtitle").value("알프스-오스트리아 3,798.0m(약 1.2천층 올라감)"));
//        actions.andExpect(jsonPath("$.body.closingTime").value("2024-06-21T15:00:00.000+00:00"));
        actions.andExpect(jsonPath("$.body.coin").value(2));
        actions.andExpect(jsonPath("$.body.walking").value(100000));
        actions.andExpect(jsonPath("$.body.totalWalking").value(8303));
        actions.andExpect(jsonPath("$.body.backImg").value("/upload/a79e04fc-31b8-4c5b-9729-fa1192dc7c76_grossglock.png"));
        actions.andExpect(jsonPath("$.body.upcomingChallenges[0].id").value(1));
        actions.andExpect(jsonPath("$.body.upcomingChallenges[0].challengeName").value("에베레스트"));
        actions.andExpect(jsonPath("$.body.upcomingChallenges[0].distance").value("8848m"));
        actions.andExpect(jsonPath("$.body.upcomingChallenges[0].status").value(st));
        actions.andExpect(jsonPath("$.body.upcomingChallenges[0].badgeImg").value("/upload/abf1c607-62c7-429d-9601-6edb1a3e4965_everest.png"));
        actions.andExpect(jsonPath("$.body.pastChallenges[0].id").value(3));
        actions.andExpect(jsonPath("$.body.pastChallenges[0].challengeName").value("칠쿠트 트레일"));
        actions.andExpect(jsonPath("$.body.pastChallenges[0].distance").value("53K"));
        actions.andExpect(jsonPath("$.body.pastChallenges[0].status").value(true));
        actions.andExpect(jsonPath("$.body.pastChallenges[0].badgeImg").value("/upload/270f40f2-683f-4a9a-be40-764e377847c6_chilkoot.png"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void challengeDetail_success_test() throws Exception {
        // given
        Integer id = 2;

        // when
        ResultActions actions = mvc.perform(
                get("/api/challenges/" + id)
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.id").value(2));
        actions.andExpect(jsonPath("$.body.challengeName").value("에베레스트 베이스캠프 트레킹"));
        actions.andExpect(jsonPath("$.body.subTitle").value("히말라야-네팔 62.0km(약 8.7만개의 계단)"));
        actions.andExpect(jsonPath("$.body.walking").value(300000));
        actions.andExpect(jsonPath("$.body.content").value("세계에서 가장 상징적인 트레킹 중 하나인 에베레스트 베이스캠프 루트를 정복하세요. 네팔의 히말라야를 거쳐 세계에서 가장 높은 산인 에베레스트산의 베이스캠프로 이동합니다. 이 탐험은 작은 마을인 루클라(Lukla)에서 시작하여 셰르파 마을인 남체 바자(Namche Bazaar), 텅보체(Tengboche), 딩보체(Dingboche), 고락셉(Gorakshep)을 통과합니다. 하이커들은 강과 고지대 통행로를 지나는 것과 더불어 풍부한 문화, 종교, 환대로 유명한 솔루쿰부(Solukhumbu) 지구의 중심부를 거쳐 이동합니다."));
        actions.andExpect(jsonPath("$.body.state").value(false));
        actions.andExpect(jsonPath("$.body.coin").value(2));
        actions.andExpect(jsonPath("$.body.backgroundImg").value("/upload/ab9dde60-6ce4-41f9-a848-aced82c5d38c_basecampEV.png"));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }

    @Test
    public void challengeDetail_fail_test() throws Exception {
        // given
        Integer id = 500;

        // when
        ResultActions actions = mvc.perform(
                get("/api/challenges/" + id)
                        .header("Authorization", "Bearer " + jwt)
        );

        // eye
//        String respBody = actions.andReturn().getResponse().getContentAsString();
//        System.out.println("respBody : " + respBody);

        // then
        actions.andExpect(jsonPath("$.status").value(404));
        actions.andExpect(jsonPath("$.msg").value("해당 챌린지를 찾을 수 없습니다."));
        actions.andDo(MockMvcResultHandlers.print()).andDo(document);
    }
}