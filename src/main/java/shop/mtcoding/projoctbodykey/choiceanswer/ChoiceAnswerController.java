package shop.mtcoding.projoctbodykey.choiceanswer;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataRequest;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataResponse;
import shop.mtcoding.projoctbodykey.eat.EatService;
import shop.mtcoding.projoctbodykey.user.SessionUser;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ChoiceAnswerController {
    private final ChoiceAnswerService choiceAnswerService;
    private final HttpSession session;

    @PostMapping("/api/survey/{id}")
    public ResponseEntity<?> save(@PathVariable Integer id, @RequestBody List<ChoiceAnswerRequest.AnswerDTO> reqDTO) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("git sessionUser");
        ChoiceAnswerResponse.GetChoiceAnswer respDTO = choiceAnswerService.save(sessionUser.getId(), id, reqDTO);

        return  ResponseEntity.ok(new ApiUtil<>(respDTO));
    }
}
