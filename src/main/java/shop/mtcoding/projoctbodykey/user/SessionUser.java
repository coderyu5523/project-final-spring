package shop.mtcoding.projoctbodykey.user;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class SessionUser {

    private Integer id;
    private String username; //유저네임
    private String password; //비밀번호
    private String phone; // 전화번호
    private String name; // 이름
    private Timestamp birth; //생년월일
    private Character gender; //성별 M,F
    private double height; // 키
//    private double weight; //몸무게
    private String userImg; // 사진파일경로
    private Integer totalCoin; // 보상 받은 코인 합산
    private Timestamp createdAt;
    private double goalMuscle;
    private double goalFat;

    @Builder
    public SessionUser(Integer id, String username, String password, String phone, String name, Timestamp birth, Character gender, double height, String userImg, Integer totalCoin, Timestamp createdAt, double goalMuscle, double goalFat) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
//        this.weight = weight;
        this.height = height;
        this.userImg = userImg;
        this.totalCoin = totalCoin;
        this.goalMuscle = goalMuscle;
        this.goalFat = goalFat;
        this.createdAt = createdAt;

    }

    public SessionUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.name = user.getName();
        this.birth = user.getBirth();
        this.gender = user.getGender();
//        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.userImg = user.getUserImg();
        this.goalMuscle = user.getGoalMuscle();
        this.goalFat = user.getGoalFat();
        this.createdAt = user.getCreatedAt();
    }
}
