package shop.mtcoding.projoctbodykey.choiceanswer;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey.eat.EatService;

@RequiredArgsConstructor
@RestController
public class ChoiceAnswerController {
    private final ChoiceAnswerService choiceAnswerService;
}
