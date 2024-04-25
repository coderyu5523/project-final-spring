package shop.mtcoding.projoctbodykey.dosurvey;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DoSurveyService {
    private final DoSurveyJPARepository doSurveyJPARepository ;
}
