package vermeer.sample.ee9.infra.queries.userdata;

import vermeer.sample.ee9.domain.UserDataQueryDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import vermeer.sample.ee9.domain.UserDataQuery;

@RequestScoped
public class UserDataQueryImpl implements UserDataQuery {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserDataQueryDto> getUserData() {
        var results = em.createNamedQuery("UserDataQuery", UserDataQueryDto.class).getResultList();
        return results;
    }

}
