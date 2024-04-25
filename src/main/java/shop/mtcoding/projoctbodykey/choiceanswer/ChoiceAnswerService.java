package shop.mtcoding.projoctbodykey.choiceanswer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ChoiceAnswerService {
    private final ChoiceAnswerJPARepository choiceAnswerJPARepository ;
}
