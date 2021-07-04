package vermeer.sample.ee9.infra.queries.userdata;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import vermeer.sample.ee9.domain.UserDataQuery;
import vermeer.sample.ee9.domain.User;

@RequestScoped
public class UserDataQueryImpl implements UserDataQuery {

    private final EntityManager em;

    @Inject
    public UserDataQueryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<User> getUserData() {
        var results = em.createNamedQuery("UserDataQuery", UserDataQueryDto.class).getResultList();
        var users = results.stream().map((result) -> {
            var user = result.toUser();
            return user;
        }).collect(Collectors.toList());

        return users;
    }

}
