package shop.mtcoding.projoctbodykey.meal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MealService {
    private final MealJPARepository mealJPARepository ;

    public void createdAtUpdate() {
        List<Meal> mealList = mealJPARepository.findAll();

        for (Meal meal : mealList) {
            LocalDateTime currentCreatedAt = meal.getCreatedAt().toLocalDateTime(); // 현재 createdAt 값을 LocalDateTime으로 변환
            LocalDateTime updatedCreatedAt = currentCreatedAt.withHour(0).withMinute(0).withSecond(0).withNano(0); // 시분초를 0으로 초기화
            meal.setCreatedAt(Timestamp.valueOf(updatedCreatedAt)); // 초기화된 값으로 설정
        }

        mealJPARepository.saveAll(mealList);
    }
}
