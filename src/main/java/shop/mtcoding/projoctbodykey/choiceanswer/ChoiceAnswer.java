package shop.mtcoding.projoctbodykey.choiceanswer;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.questionchoice.QuestionChoice;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.surveyquestion.SurveyQuestion;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "choice_answer_tb")
@Entity
public class ChoiceAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;  //유저 id
    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;
    @ManyToOne(fetch = FetchType.LAZY)
    private SurveyQuestion surveyQuestion;
    @ManyToOne(fetch = FetchType.LAZY)
    private QuestionChoice questionChoice;
    private Timestamp createdAt;

}
