package wiki.laona.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: Blog
 * @description: 用户
 * @author: HuaiAnGG
 * @create: 2020-11-25 10:46
 **/
@Setter
@Getter
public class User {
    private Integer id;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
