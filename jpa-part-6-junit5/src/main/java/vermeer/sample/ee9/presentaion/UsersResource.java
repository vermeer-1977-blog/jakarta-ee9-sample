package vermeer.sample.ee9.presentaion;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import vermeer.sample.ee9.domain.User;
import vermeer.sample.ee9.domain.UserDataQuery;

@Path("/users")
public class UsersResource {

    private UserDataQuery query;

    @Inject
    public UsersResource(UserDataQuery query) {
        this.query = query;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserDatas() {
        return query.getUserData();

    }
}
