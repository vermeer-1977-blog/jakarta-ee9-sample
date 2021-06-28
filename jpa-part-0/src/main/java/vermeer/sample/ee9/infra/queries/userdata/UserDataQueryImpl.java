package vermeer.sample.ee9.infra.queries.userdata;

import vermeer.sample.ee9.domain.UserDataQuery;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;
import vermeer.sample.ee9.domain.User;
import vermeer.sample.ee9.domain.UserName;
import vermeer.sample.ee9.infra.entities.UserData;

@Named
@RequestScoped
public class UserDataQueryImpl implements UserDataQuery {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<User> getUserData() {
        var results = em.createNamedQuery("UserData.findAll", UserData.class).getResultList();
        var users = results.stream().map(userData -> {
            var _names = userData.getUserName().split(" ");
            var _userName = new UserName(_names[0], 2 <= _names.length ? _names[1] : "");
            return new User(_userName, userData.getNickName());
        }).collect(Collectors.toList());

        return users;
    }
}
