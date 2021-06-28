package vermeer.sample.ee9.domain;

public class UserDataQueryDto {

    private final String userName;
    private final String nickName;

    public UserDataQueryDto(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

}
