package vermeer.sample.ee9.infra.queries.userdata;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
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
