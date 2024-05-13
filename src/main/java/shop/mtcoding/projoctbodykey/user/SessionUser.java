package shop.mtcoding.projoctbodykey.user;

import lombok.Builder;
import lombok.Data;

@Data
public class SessionUser {

    private Integer id;
    private String username; //유저네임
    private String password; //비밀번호

    @Builder
    public SessionUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Builder
    public SessionUser(String username) {
        this.username = username;
    }

    @Builder
    public SessionUser(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
}
