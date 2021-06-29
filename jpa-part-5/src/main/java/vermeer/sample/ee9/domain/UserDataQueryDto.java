package vermeer.sample.ee9.domain;

public class UserDataQueryDto {

    private final String userName;
    private final String nickName;

    public UserDataQueryDto(String userName, String nickName) {
        this.userName = userName;
        this.nickName = nickName;
    }

    public String getFirstName() {
        return this.userName.split(" ")[0];
    }

    public String getLastName() {
        var _names = this.userName.split(" ");
        return 2 <= _names.length ? _names[1] : "";
    }

    public String getNickName() {
        return nickName;
    }

}
