package vermeer.sample.ee9.presentaion;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
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
    @Path("data1")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserDatas1() {
        return query.getUserData("data1");

    }

    @GET
    @Path("data2")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserDatas2() {
        return query.getUserData("data2");

    }
}
