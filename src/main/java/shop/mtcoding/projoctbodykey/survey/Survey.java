package shop.mtcoding.projoctbodykey.survey;

import jakarta.persistence.*;
import lombok.Builder;
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
    private Boolean status;
    private Timestamp createdAt;

    @Builder
    public Survey(Integer id, String title, Boolean status, Timestamp createdAt) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.createdAt = createdAt;
    }

    public void update(String title, Timestamp createdAt){
        this.title = title;
        this.createdAt = createdAt;
    }
}
