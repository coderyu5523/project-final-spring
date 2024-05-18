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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import shop.mtcoding.projoctbodykey._core.utils.JwtUtil;

import java.sql.Timestamp;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@Transactional
@AutoConfigureMockMvc // MockMvc IoC 로드
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) // 모든 빈 IoC 로드
public class UserControllerTest {

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
    public void goalWeightUpdate_suc_test() throws Exception {
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
    public void goalMuscleUpdate_suc_test() throws Exception {
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
    public void goalFatUpdate_suc_test() throws Exception {
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
    }

    @Test
    public void imgUpdate_test() throws Exception {
        // given
        UserRequest.ImgUpdateDTO reqDTO = new UserRequest.ImgUpdateDTO();
        reqDTO.setUserImg("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAJYAyADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD5/ooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopyozEBVJJ6ACtO18Na3ejNvpd04PcRkfzoAyqK6P8A4QHxXt3f2Hd4/wB0f41RufDWt2f+v0q7T/tmT/KgDKoqeSyuohmS2mQDu0ZFQUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFTW9pcXcnl20Ekz+kalj+lAENFW30vUIz89jcr9Ym/wqqysjbWUqfQjFACUUUUAFFFFABRRRQAUUVLBa3F1IscEMkjtwAikk0ARUVbutLv7GcQXVpNFKwyEZDk0z7BeZx9knz6eWaAK9FWTp18OtncD6xN/hUMkUkRxJG6H/aUigBlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFGM9KKACiiigAooooAKKKKACiiigAooooAKkhgluZlhgieWVjhURSSfoBUdfSnwY+H8Wk6QNb1O1Bv7gkxBxzGnHb1yD+dAHnWl/AnxdqNoJ5vsliTyI55Mt/47mn/wDChPF+/GbLH97zq+nJozLEyLI0ZI+8vUV5b8YPiBN4Xtbaz0i88vU3cOygZAjww598gUAfOmuaHfeHdWm03UYhHcRHDAEEfgRWdVzU9UvdZv5L3ULhp7mQ5Z26mqdABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFS21u91cpBH95zgVFW14Ri87xXp0Z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AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAFVipBUkEdxXrnhv4+avpFklrqmnR6kE4EvneU+Pf5Wz+leRUUAe4337Rt3IhWx8PRQt2aW6Lj8gg/nXofhv4k6fqfgmLVb++tIL4JmePOArZ7Dr0xXyXRQB0fiHx34h8TXHm6hqEgAGBHESij8M+9c4SSck5NFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABWjpmv6to0ok07UJ7Zh/cbj8ulZ1FAHqOmfHjxZZBUuVtLxB1MiEMfxB/pXa6R+0Rp03y6vo09v/t28okz+BC/zr55ooA+s7f4y+Cp1DHUzFntImD+maS5+M3gq3QsNRebHaKPJ/XFfJtFAH0Nq/7RGnRxkaRo9xO56NcSCMD8ADmvK/E3xP8AE/ikGO6uxBb/APPG3BVf55rjaKAAnJyaKKKACiiigAooooAKKKKAPp/wn8V/BMulx2QlfS9gx5c/I/Bh1/KuhtvEXhSC4+2jxIJCRjDy5X8sV8f0UAfWHiDx98O7mONNTvrW98tt6IELEHkZ7eprlNQ+PXh/TIjFoGhyTEcZcrCv6Bs189UUAeh658aPFusho47iKxhP8NuuD+JNcDPcz3UhkuJpJXP8TsSaiooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKk+0T+X5fnSbP7u44/Ko6KACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiius8GfD/VvHEso06S3jjh++8zEenQAe4oA5OiveLL9nI43XviPB/uRWn9S/9Ktz/s6aeUxD4hmjc9C9sGH5bhQB8+UV1/jj4d6r4Gnj+2PHPaynEc8YIBPPBHY8GuQoAKKKKACiiigAooooAKKKciNI4RFLMegAyTQA2ivafAvwMn1GNL/xLI9tCfu2sY+c/U9u/Y13nib4K+HdW0yK20qGPS50bPnqhckc8EZGevrQB8tUV9Dyfs66Z9lKx65cC4xw7Qjb+Wf614Be2j2N5LbSFS8ZwSvSgCvR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CiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP//Z");

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
        actions.andExpect(jsonPath("$.body.userImg").value("/9j/4AAQSkZJRgABAgAAAQABAAD/2wBDAAgGBgcGBQgHBwcJCQgKDBQNDAsLDBkSEw8UHRofHh0aHBwgJC4nICIsIxwcKDcpLDAxNDQ0Hyc5PTgyPC4zNDL/2wBDAQkJCQwLDBgNDRgyIRwhMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjIyMjL/wAARCAJYAyADASIAAhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQAAAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWmp6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEAAwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSExBhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD5/ooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAopyozEBVJJ6ACtO18Na3ejNvpd04PcRkfzoAyqK6P8A4QHxXt3f2Hd4/wB0f41RufDWt2f+v0q7T/tmT/KgDKoqeSyuohmS2mQDu0ZFQUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFTW9pcXcnl20Ekz+kalj+lAENFW30vUIz89jcr9Ym/wqqysjbWUqfQjFACUUUUAFFFFABRRRQAUUVLBa3F1IscEMkjtwAikk0ARUVbutLv7GcQXVpNFKwyEZDk0z7BeZx9knz6eWaAK9FWTp18OtncD6xN/hUMkUkRxJG6H/aUigBlFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFGM9KKACiiigAooooAKKKKACiiigAooooAKkhgluZlhgieWVjhURSSfoBUdfSnwY+H8Wk6QNb1O1Bv7gkxBxzGnHb1yD+dAHnWl/AnxdqNoJ5vsliTyI55Mt/47mn/wDChPF+/GbLH97zq+nJozLEyLI0ZI+8vUV5b8YPiBN4Xtbaz0i88vU3cOygZAjww598gUAfOmuaHfeHdWm03UYhHcRHDAEEfgRWdVzU9UvdZv5L3ULhp7mQ5Z26mqdABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABRRRQAUUUUAFS21u91cpBH95zgVFW14Ri87xXp0Z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AKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAFVipBUkEdxXrnhv4+avpFklrqmnR6kE4EvneU+Pf5Wz+leRUUAe4337Rt3IhWx8PRQt2aW6Lj8gg/nXofhv4k6fqfgmLVb++tIL4JmePOArZ7Dr0xXyXRQB0fiHx34h8TXHm6hqEgAGBHESij8M+9c4SSck5NFFABRRRQAUUUUAFFFFABRRRQAUUUUAFFFFABWjpmv6to0ok07UJ7Zh/cbj8ulZ1FAHqOmfHjxZZBUuVtLxB1MiEMfxB/pXa6R+0Rp03y6vo09v/t28okz+BC/zr55ooA+s7f4y+Cp1DHUzFntImD+maS5+M3gq3QsNRebHaKPJ/XFfJtFAH0Nq/7RGnRxkaRo9xO56NcSCMD8ADmvK/E3xP8AE/ikGO6uxBb/APPG3BVf55rjaKAAnJyaKKKACiiigAooooAKKKKAPp/wn8V/BMulx2QlfS9gx5c/I/Bh1/KuhtvEXhSC4+2jxIJCRjDy5X8sV8f0UAfWHiDx98O7mONNTvrW98tt6IELEHkZ7eprlNQ+PXh/TIjFoGhyTEcZcrCv6Bs189UUAeh658aPFusho47iKxhP8NuuD+JNcDPcz3UhkuJpJXP8TsSaiooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKk+0T+X5fnSbP7u44/Ko6KACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiius8GfD/VvHEso06S3jjh++8zEenQAe4oA5OiveLL9nI43XviPB/uRWn9S/9Ktz/s6aeUxD4hmjc9C9sGH5bhQB8+UV1/jj4d6r4Gnj+2PHPaynEc8YIBPPBHY8GuQoAKKKKACiiigAooooAKKKciNI4RFLMegAyTQA2ivafAvwMn1GNL/xLI9tCfu2sY+c/U9u/Y13nib4K+HdW0yK20qGPS50bPnqhckc8EZGevrQB8tUV9Dyfs66Z9lKx65cC4xw7Qjb+Wf614Be2j2N5LbSFS8ZwSvSgCvR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CiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKACiiigAooooAKKKKAP//Z"));
    }

    @Test
    public void update_suc_test() throws Exception {
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
        String respBody = actions.andReturn().getResponse().getContentAsString();
        System.out.println("respBody : " + respBody);
//        int statusCode = actions.andReturn().getResponse().getStatus();
//        System.out.println("statusCode : "+statusCode);

        // then
        actions.andExpect(jsonPath("$.status").value(200));
        actions.andExpect(jsonPath("$.msg").value("성공"));
        actions.andExpect(jsonPath("$.body.fat").value(21.3d));
        actions.andExpect(jsonPath("$.body.muscle").value(21.5d));
        actions.andExpect(jsonPath("$.body.weight").value(75.8d));
        actions.andExpect(jsonPath("$.body.bodyData[0].id").value(1));
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
        actions.andExpect(jsonPath("$.body.fat").value(21.3d));
        actions.andExpect(jsonPath("$.body.muscle").value(21.5d));
        actions.andExpect(jsonPath("$.body.weight").value(75.8));
        actions.andExpect(jsonPath("$.body.name").value("류재성"));
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
    }

    @Test
    public void login_suc_test() throws Exception {
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
    }

    @Test
    public void join_suc_test() throws Exception {
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
        actions.andExpect(jsonPath("$.body.gender").value("M"));
        actions.andExpect(jsonPath("$.body.height").value(169.8d));
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
//        actions.andExpect(jsonPath("$.body.username").value("egdg"));
//        actions.andExpect(jsonPath("$.body.name").value("하승진"));
//        actions.andExpect(jsonPath("$.body.gender").value("M"));
//        actions.andExpect(jsonPath("$.body.height").value(169.8d));
    }
}