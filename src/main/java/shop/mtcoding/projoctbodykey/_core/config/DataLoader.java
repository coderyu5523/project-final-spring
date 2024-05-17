//package shop.mtcoding.projoctbodykey._core.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//import shop.mtcoding.projoctbodykey.meal.MealService;
//
//// 처음 시작할 때 실행됨, 실행해서 더미에 있는 유저 패스워드를 암호화해서 업데이트 해줌
//@Component
//public class DataLoader implements ApplicationRunner {
//
//    @Autowired
//    private MealService mealService;
//
//    @Override
//    public void run(ApplicationArguments args) {
//
//        mealService.createdAtUpdate();
//    }
//}