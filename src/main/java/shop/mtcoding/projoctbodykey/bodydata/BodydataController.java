package shop.mtcoding.projoctbodykey.bodydata;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BodydataController {
    private final BodydataService bodydataService;
    private final HttpSession session;

}
