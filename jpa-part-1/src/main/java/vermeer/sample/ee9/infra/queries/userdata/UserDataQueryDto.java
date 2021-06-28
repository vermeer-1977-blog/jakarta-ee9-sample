package vermeer.sample.ee9.infra.queries.userdata;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import java.io.Serializable;
import vermeer.sample.ee9.domain.User;
import vermeer.sample.ee9.domain.UserName;

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

    /**
     * Dummy Class for ResultSet Mapping
     *
     * <code>@Entity</code> class must set <code>@Id</code> property. <br>
     * (Id field is not needed for DTOs.)
     */
    @SqlResultSetMapping(name = "UserDataQueryDto",
            classes = {
                @ConstructorResult(
                        targetClass = UserDataQueryDto.class,
                        columns = {
                            @ColumnResult(name = "userName", type = String.class),
                            @ColumnResult(name = "nickName", type = String.class),}
                )

            })
    @Entity
    static class MappingConfig implements Serializable {

        @Id
        String id;
    }

}
