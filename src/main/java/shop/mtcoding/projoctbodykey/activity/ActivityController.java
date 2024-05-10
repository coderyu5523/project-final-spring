package shop.mtcoding.projoctbodykey.activity;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataResponse;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataService;
import shop.mtcoding.projoctbodykey.user.SessionUser;

@RequiredArgsConstructor
@RestController
public class ActivityController {
    private final ActivityService activityService;
    private final BodyDataService bodyDataService;
    private final HttpSession session;

    @GetMapping("/api/activities/body-date")
    public ResponseEntity<?> activitiesBodyDate() {
        SessionUser user = (SessionUser) session.getAttribute("sessionUser");
        BodyDataResponse.BodyDateDTO respDTO = bodyDataService.activitiesBodyDate(user);

        return ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @GetMapping("/mainpage")
    public ResponseEntity<?> mainpage() {
       //ActivityResponse.MainResumesDTO> respDTO = mainService.mainResumes();

        return ResponseEntity.ok(new ApiUtil<>(null));
    }

    @GetMapping("/api/activities/")
    public ResponseEntity<?> page() {
        //ActivityResponse.MainResumesDTO> respDTO = mainService.mainResumes();
        return ResponseEntity.ok(new ApiUtil<>(null));
    }
}
