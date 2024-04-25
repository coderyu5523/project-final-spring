package shop.mtcoding.projoctbodykey.questionchoice;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "question_choice_tb")
@Entity
public class QuestionChoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;
    @ManyToOne(fetch = FetchType.LAZY)
    private SurveyQuestion surveyQuestion;
    private String choiceItem;
    private Timestamp createdAt;

}
