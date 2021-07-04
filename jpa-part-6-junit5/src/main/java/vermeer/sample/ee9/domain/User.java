package vermeer.sample.ee9.domain;

public class User {

    private final UserName userName;
    private final String nickName;

    public User(UserName userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

    public UserName getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

}
