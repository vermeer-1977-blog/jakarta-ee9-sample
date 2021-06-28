package vermeer.sample.ee9.infra.queries.userdata;

import vermeer.sample.ee9.domain.User;
import vermeer.sample.ee9.domain.UserName;

/**
 * !! Not use in this project !!
 */
public class UserDataQueryDto {

    private final String userName;
    private final String nickName;

    public UserDataQueryDto(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

    public User toUser() {
        var names = this.userName.split(" ");
        var _userName = new UserName(names[0], 2 <= names.length ? names[1] : "");
        var user = new User(_userName, this.nickName);
        return user;
    }

}
