package shop.mtcoding.projoctbodykey.bodydata;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BodyDataController {
    private final BodyDataService bodydataService;
    private final HttpSession session;

}
