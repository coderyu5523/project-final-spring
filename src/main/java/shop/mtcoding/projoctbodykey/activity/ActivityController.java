package shop.mtcoding.projoctbodykey.activity;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;

@RequiredArgsConstructor
@RestController
public class ActivityController {
    private final ActivityService activityService;
    private final HttpSession session;

    @GetMapping("/mainpage")
    public ResponseEntity<?> mainpage() {
       //ActivityResponse.MainResumesDTO> respDTO = mainService.mainResumes();

        return ResponseEntity.ok(new ApiUtil<>(null));
    }
}
