package shop.mtcoding.projoctbodykey.meal;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey._core.utils.ApiUtil;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerRequest;
import shop.mtcoding.projoctbodykey.choiceanswer.ChoiceAnswerResponse;
import shop.mtcoding.projoctbodykey.user.SessionUser;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MealController {
    private final MealService mealService;
    private final HttpSession session;

    @GetMapping("/api/meal/{date}")
    public ResponseEntity<?> mealList(@PathVariable("date") LocalDate date) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        MealResponse.MaealListAndRecommendCalDTO respDTO = mealService.mealList(sessionUser.getId(), date);
        return  ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @PostMapping("/api/meal/{date}")
    public ResponseEntity<?> save(@PathVariable("date") LocalDate date, @RequestBody MealRequest.SaveDTO request) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        MealResponse.SaveDTO respDTO = mealService.save(sessionUser.getId(), date, request);
        return  ResponseEntity.ok(new ApiUtil<>(respDTO));
    }

    @DeleteMapping("/api/meal/{date}/{mealId}")
    public ResponseEntity<?> delete(@PathVariable("date") LocalDate date, @PathVariable("mealId") Integer mealId){
        mealService.delete(date,mealId);
        return  ResponseEntity.ok(new ApiUtil<>(null));
    }
}
