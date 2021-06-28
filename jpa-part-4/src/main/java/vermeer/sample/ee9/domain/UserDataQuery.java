package vermeer.sample.ee9.domain;

import java.util.List;
import vermeer.sample.ee9.domain.User;

public interface UserDataQuery {

    List<User> getUserData(String condition);

}
