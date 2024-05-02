package shop.mtcoding.projoctbodykey.surveyquestion;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "survey_question_tb")
@Entity
public class SurveyQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;
    private String questionItem;
    private Timestamp createdAt;

    @Builder
    public SurveyQuestion(Integer id, Survey survey, String questionItem, Timestamp createdAt) {
        this.id = id;
        this.survey = survey;
        this.questionItem = questionItem;
        this.createdAt = createdAt;
    }
}
