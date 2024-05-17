package shop.mtcoding.projoctbodykey.meal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import shop.mtcoding.projoctbodykey._core.errors.exception.Exception404;
import shop.mtcoding.projoctbodykey.activity.Activity;
import shop.mtcoding.projoctbodykey.bodydata.BodyData;
import shop.mtcoding.projoctbodykey.bodydata.BodyDataJPARepository;
import shop.mtcoding.projoctbodykey.eat.Eat;
import shop.mtcoding.projoctbodykey.eat.EatJPARepository;
import shop.mtcoding.projoctbodykey.eat.EatRequest;
import shop.mtcoding.projoctbodykey.food.Food;
import shop.mtcoding.projoctbodykey.food.FoodJPARepository;
import shop.mtcoding.projoctbodykey.user.SessionUser;
import shop.mtcoding.projoctbodykey.user.User;
import shop.mtcoding.projoctbodykey.user.UserJPARepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MealService {
    private final MealJPARepository mealJPARepository ;
    private final UserJPARepository userJPARepository;
    private final FoodJPARepository foodJPARepository;
    private final EatJPARepository eatJPARepository;
    private final BodyDataJPARepository bodyDataJPARepository;

    @Transactional
    public MealResponse.SaveDTO save(Integer userId, LocalDate date, MealRequest.SaveDTO request) {
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception404("사용자가 없습니다"));

        //meal 저장
        MealRequest.MealSaveDTO saveMeal = new MealRequest.MealSaveDTO(user, date,request);
        Meal meal=mealJPARepository.save(saveMeal.toEntity());

        List<Eat> eatList=new ArrayList<>();
        //eat 저장
        for(MealRequest.SaveDTO.Food food : request.getFoods()){
            Food saveFood = foodJPARepository.findById(food.getFoodId()).orElseThrow(() -> new Exception404("찾으시는 음식이 없습니다"));
            EatRequest.SaveDTO saveEat = new EatRequest.SaveDTO(meal, saveFood,food.getQty());
            eatList.add(saveEat.toEntity());
        }
        List<Eat> eats = eatJPARepository.saveAll(eatList);

        return new MealResponse.SaveDTO(meal.getId(), meal.getMealImg(),
                eats.stream().map(eat -> new MealResponse.SaveDTO.EatDTO(eat)).toList());
    }

    public MealResponse.MaealListAndRecommendCalDTO mealList(Integer userId, LocalDate createdAt) {
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception404("사용자가 없습니다"));

        //권장 칼로리 계산
        Double reconmandCal=null;
        BodyData bodyData =bodyDataJPARepository.findByUserIdAndRecent(user.getId()).orElse(null);
        if (bodyData != null){
            if (user.getGender().equals("M")) {
                reconmandCal = (6.25 * user.getHeight()) + (10 * bodyData.getWeight()) - (6.75 * user.getBirth().getYear())+5;
            }else if (user.getGender().equals("F")) {
                reconmandCal = (6.25 * user.getHeight()) + (10 * bodyData.getWeight()) - (6.75 * user.getBirth().getYear())-161;
            }
        }

        //식단리스트
        List<Meal> mealList = mealJPARepository.findByUserIdAndcreatedAt(user.getId(), Timestamp.valueOf(createdAt.atStartOfDay()));

        List<MealResponse.MaealListAndRecommendCalDTO.MealDTO> meals = new ArrayList<>();
        //음식리스트
        for (Meal meal : mealList) {
            List<Eat> eatList = eatJPARepository.findByMealId(meal.getId());
            List<Food> foodList = eatList.stream().map(Eat::getFood).toList();
            MealResponse.MaealListAndRecommendCalDTO.MealDTO mealDTO = new MealResponse.MaealListAndRecommendCalDTO
                    .MealDTO(meal, foodList.stream().map(MealResponse.MaealListAndRecommendCalDTO.MealDTO.FoodDTO::new).toList());
            meals.add(mealDTO);
        }
        return new MealResponse.MaealListAndRecommendCalDTO(reconmandCal, meals);
    }
}
