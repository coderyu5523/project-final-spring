package shop.mtcoding.projoctbodykey.body;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BodyController {
    private final BodyService bodyService;
    private final HttpSession session;

}
