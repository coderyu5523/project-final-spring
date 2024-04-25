package shop.mtcoding.projoctbodykey.choiceanswer;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import shop.mtcoding.projoctbodykey.user.User;

import java.sql.Timestamp;

@NoArgsConstructor
@Data
@Table(name = "choiceanswer_tb")
@Entity
public class ChoiceAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;  //유저 id

    private Timestamp createdAt;

}
