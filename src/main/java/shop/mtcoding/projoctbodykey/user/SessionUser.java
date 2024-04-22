package shop.mtcoding.projoctbodykey.user;

import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;


@Data
public class SessionUser {

    private Integer id;
    private String username; //유저네임
    private String phone; // 전화번호
    private String name; // 이름
    private Timestamp birth; //생년월일
    private Character gender; //성별 M,F
    private double height; // 키
    private double weight; // 몸무게
    private double muscle; // 근육량
    private double fat; // 지방량
    private String userImg; // 사진파일경로
    private Timestamp createdAt;

    @Builder
    public SessionUser(Integer id, String username, String phone, String name, Timestamp birth, Character gender, double height, double weight, double muscle, double fat, String userImg, Timestamp createdAt) {
        this.id = id;
        this.username = username;
        this.phone = phone;
        this.name = name;
        this.birth = birth;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.muscle = muscle;
        this.fat = fat;
        this.userImg = userImg;
        this.createdAt = createdAt;
    }

    public SessionUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.name = user.getName();
        this.birth = user.getBirth();
        this.gender = user.getGender();
        this.height = user.getHeight();
        this.weight = user.getWeight();
        this.muscle = user.getMuscle();
        this.fat = user.getFat();
        this.userImg = user.getUserImg();
        this.createdAt = user.getCreatedAt();
    }
}
