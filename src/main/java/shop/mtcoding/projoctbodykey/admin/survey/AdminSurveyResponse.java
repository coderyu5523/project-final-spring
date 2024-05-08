package shop.mtcoding.projoctbodykey.admin.survey;

import lombok.Data;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AdminSurveyResponse {
    @Data
    public static class SurveysDTO {
        private Integer id;
        private String title;
        private String status;
        private Timestamp createdAt;


        public SurveysDTO(Survey survey) {
            this.id = survey.getId();
            this.title = survey.getTitle();
            if(survey.getStatus()==null) {
                this.status = "진행전";
            } else if (survey.getStatus()==true) {
                this.status = "진행중";
            } else if (survey.getStatus()==false) {
                this.status = "진행종료";
            }
            this.createdAt = survey.getCreatedAt();

        }
    }

    @Data
    public static class SurveyListDTO {
        private Integer id;
        private String title;
        private Integer totalQuestion;
        private Boolean status;
        private Timestamp createdAt;


        public SurveyListDTO(int totalQuestion,Survey survey) {
            this.id = survey.getId();
            this.title = survey.getTitle();
            this.totalQuestion = totalQuestion;
            this.status= survey.getStatus();
            this.createdAt = survey.getCreatedAt();

        }
    }
    @Data
    public static class statsDTO {
        private List<ChartDTO> charts;
        private List<SurveysDTO> surveys;
        @Data
        public static class SurveysDTO {
            private Integer surveyId;
            private String surveyTitle;
            private Timestamp createdAt;


            public SurveysDTO(Survey survey) {
                this.surveyId = survey.getId();
                this.surveyTitle = survey.getTitle();
                this.createdAt = survey.getCreatedAt();

            }
        }

        @Data
        public static class ChartDTO {
            private Integer surveyId;
            private String surveyTitle;
            private Long count;

            public ChartDTO(AdminSurveyRequest.UserStatsDTO userStatsDTO) {
                this.surveyId = userStatsDTO.getSurveyId();
                this.surveyTitle = userStatsDTO.getSurveyTitle();
                this.count = userStatsDTO.getCount();
            }
        }

        public statsDTO(List<SurveysDTO> surveys, List<ChartDTO> charts) {
            this.charts = charts;
            this.surveys = surveys;
        }
    }

    @Data
    public static class SaveDTO {
        private String surveyName;
        private List<QuestionDTO> questionElements;
        @Data
        public class QuestionDTO {
            private String question;
            private List<String> choices;
        }
    }

    @Data
    public static class UpdateDTO {
        private Integer surveyId;
        private String title;
        private boolean status;
        private List<QuestionDTO> questionElements;

        @Data
        public static class QuestionDTO {
            private Integer questionId;
            private String question;
            private List<ChoiceDTO> choices;

            @Data
            public static class ChoiceDTO{
                private Integer choiceId;
                String choiceItem;
                Integer choiceNumber;

                public ChoiceDTO(Integer choiceId, String choiceItem, Integer choiceNumber) {
                    this.choiceId = choiceId;
                    this.choiceItem = choiceItem;
                    this.choiceNumber = choiceNumber;
                }
            }

            public QuestionDTO(SurveyQuestion question, List<Integer> choiceId, List<String> choices, List<Integer> choiceNumbers) {
                this.questionId=question.getId();
                this.question = question.getQuestionItem();
                this.choices = IntStream.range(0, choices.size())
                        .mapToObj(i -> new ChoiceDTO(choiceId.get(i),choices.get(i), choiceNumbers.get(i)))
                        .collect(Collectors.toList());
            }

        }

        public UpdateDTO(Integer surveyId, String title, Boolean status, List<QuestionDTO> questionElements) {
            this.surveyId=surveyId;
            this.title = title;
            this.status = status;
            this.questionElements = questionElements;
        }
    }

    @Data
    public static class DetailDTO {
        private Integer surveyId;
        private String title;
        private List<QuestionDTO> questionElements;

        @Data
        public static class QuestionDTO {
            private Integer questionId;
            private String question;
            private List<ChoiceDTO> choices;

            @Data
            public static class ChoiceDTO{
                private Integer choiceId;
                String choiceItem;
                Integer choiceNumber;

                public ChoiceDTO(Integer choiceId, String choiceItem, Integer choiceNumber) {
                    this.choiceId = choiceId;
                    this.choiceItem = choiceItem;
                    this.choiceNumber = choiceNumber;
                }
            }

            public QuestionDTO(SurveyQuestion question, List<Integer> choiceId, List<String> choices, List<Integer> choiceNumbers) {
                this.questionId=question.getId();
                this.question = question.getQuestionItem();
                this.choices = IntStream.range(0, choices.size())
                        .mapToObj(i -> new ChoiceDTO(choiceId.get(i),choices.get(i), choiceNumbers.get(i)))
                        .collect(Collectors.toList());
            }

        }

        public DetailDTO(Integer surveyId, String title, List<DetailDTO.QuestionDTO> questionElements) {
            this.surveyId=surveyId;
            this.title = title;
            this.questionElements = questionElements;
        }
    }

    @Data
    public static class ChartDTO {
        private Integer surveyId;
        private String title;
        private List<QuestionDTO> questionElements;

        @Data
        public static class QuestionDTO {
            private Integer questionId;
            private String question;
            private List<ChoiceDTO> choices;

            @Data
            public static class ChoiceDTO{
                private String choiceItem;
                private Integer choiceNumber;
                private Long choiceCount;

                public ChoiceDTO( String choiceItem, Integer choiceNumber, Long choiceCount) {
                    this.choiceItem = choiceItem;
                    this.choiceNumber = choiceNumber;
                    this.choiceCount = choiceCount;
                }
            }

            public QuestionDTO(SurveyQuestion question, List<String> choices, List<Integer> choiceNumbers, List<Long> choiceCount) {
                this.questionId=question.getId();
                this.question = question.getQuestionItem();
                this.choices = IntStream.range(0, choiceCount.size())
                        .mapToObj(i -> new ChoiceDTO(choices.get(i), choiceNumbers.get(i), choiceCount.get(i)))
                        .collect(Collectors.toList());
            }

        }

        public ChartDTO(Integer surveyId, String title, List<QuestionDTO> questionElements) {
            this.surveyId=surveyId;
            this.title = title;
            this.questionElements = questionElements;
        }
    }


}
