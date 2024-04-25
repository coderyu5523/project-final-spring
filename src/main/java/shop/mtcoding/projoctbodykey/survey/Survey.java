package shop.mtcoding.projoctbodykey.survey;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "survey_tb")
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Timestamp createdAt;
    private Timestamp openingTime;
    private Timestamp closingTime;

}
