package shop.mtcoding.projoctbodykey.eat;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EatController {
    private final EatService eatService;
}
