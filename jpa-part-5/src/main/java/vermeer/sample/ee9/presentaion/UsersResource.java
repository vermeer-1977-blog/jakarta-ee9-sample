package vermeer.sample.ee9.presentaion;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import vermeer.sample.ee9.domain.UserDataQuery;
import vermeer.sample.ee9.domain.UserDataQueryDto;

@Path("/users")
public class UsersResource {

    private UserDataQuery query;

    @Inject
    public UsersResource(UserDataQuery query) {
        this.query = query;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserDataQueryDto> getUserDatas() {
        return query.getUserData();

    }
}
