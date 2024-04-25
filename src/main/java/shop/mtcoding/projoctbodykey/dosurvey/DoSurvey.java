package shop.mtcoding.projoctbodykey.dosurvey;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.survey.Survey;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "do_survey_tb")
@Entity
public class DoSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;  //유저 id
    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;
    private Timestamp createdAt;


}
