package vermeer.sample.ee9.infra.queries.userdata;

import java.util.List;
import java.util.stream.Collectors;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import vermeer.sample.ee9.domain.UserDataQuery;
import vermeer.sample.ee9.domain.User;

@RequestScoped
public class UserDataQueryImpl implements UserDataQuery {

    @PersistenceContext
    EntityManager em;

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
