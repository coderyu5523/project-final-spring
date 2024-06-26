package shop.mtcoding.projoctbodykey.admin.survey;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import shop.mtcoding.projoctbodykey.food.FoodRequest;
import shop.mtcoding.projoctbodykey.food.FoodResponse;
import shop.mtcoding.projoctbodykey.food.FoodService;
import shop.mtcoding.projoctbodykey.survey.SurveyResponse;
import shop.mtcoding.projoctbodykey.survey.SurveyService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class AdminSurveyController {

    private final SurveyService surveyService;
    //설문조사 차트 리스트
    @GetMapping("/admin/surveyscharts")
    public String surveycharts(HttpServletRequest request) {
        AdminSurveyResponse.statsDTO respDTO = surveyService.chartList();
        request.setAttribute("stats", respDTO);
        return "survey/chart-list";
    }

    //설문조사 차트 디테일 보기
    @GetMapping("/admin/surveyscharts/{id}")
    public String surveyChart(@PathVariable int id, HttpServletRequest request) {
        AdminSurveyResponse.ChartDTO respDTO = surveyService.chart(id);
        request.setAttribute("survey", respDTO);
        return "survey/chart";
    }

    //설문조사 저장 폼
    @GetMapping("/admin/surveys/save-form")
    public String surveySaveForm() {
        return "survey/save-form";
    }

    //설문조사 저장
    @PostMapping("/admin/surveys/save")
    public String surveySave(@RequestBody AdminSurveyRequest.SaveDTO reqDTOs) {
        surveyService.save(reqDTOs);
        return "redirect:/admin/surveys";
    }

    @GetMapping("/admin/surveys/{id}/update-form")
    public String surveyUpdateForm(@PathVariable int id, HttpServletRequest request) {
        AdminSurveyResponse.DetailStatusDTO respDTO=surveyService.findByIdWithStatus(id);
        return "survey/update-form";
    }

    //설문조사 업데이트
    @PostMapping("/admin/surveys/{id}/update")
    public String surveyUpdate(@PathVariable int id, @RequestBody AdminSurveyRequest.UpdateDTO reqDTOs) {
        surveyService.update(id, reqDTOs);
        return "redirect:/admin/surveys";
    }

    //설문조사 디테일
    @GetMapping("/admin/surveys/{id}")
    public String surveyDetail(@PathVariable int id, HttpServletRequest request) {
        AdminSurveyResponse.DetailDTO respDTO=surveyService.findById(id);
        request.setAttribute("survey",respDTO);
        return "survey/detail-form";
    }



    //설문조사 리스트
    @GetMapping("/admin/surveys")
    public String surveys(HttpServletRequest request) {
        List<AdminSurveyResponse.SurveysDTO> respDTO = surveyService.findWithQuestionCount();
        request.setAttribute("surveys", respDTO);
        return "survey/survey";
    }

    @PostMapping("/admin/surveys/{id}/status/update")
    public String statusUpdate(@PathVariable int id, AdminSurveyRequest.UpdateStatusDTO statusDTO) {
        surveyService.statusUpdate(id, statusDTO.getStatus());
        return "redirect:/admin/surveys";
    }

    //설문조사 삭제
    @PostMapping("/admin/surveys/{id}/delete")
    public String surveyDelete(@PathVariable int id) {
        surveyService.delete(id);
        return "redirect:/admin/surveys";
    }
}
