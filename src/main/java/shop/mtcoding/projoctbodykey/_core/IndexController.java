package shop.mtcoding.projoctbodykey._core;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//aws CI/CD 헬스체크를 위해 필요
@RestController
public class IndexController {

    @GetMapping("/health")
    public String health(){
        return "ok";
    }
}
