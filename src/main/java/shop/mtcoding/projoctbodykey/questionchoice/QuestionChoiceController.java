package shop.mtcoding.projoctbodykey.questionchoice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class QuestionChoiceController {
    private final QuestionChoiceService questionChoiceService;
}
