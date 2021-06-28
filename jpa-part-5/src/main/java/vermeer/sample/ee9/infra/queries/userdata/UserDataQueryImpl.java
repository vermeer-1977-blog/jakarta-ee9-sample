package vermeer.sample.ee9.infra.queries.userdata;

import vermeer.sample.ee9.domain.UserDataQueryDto;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.SqlResultSetMapping;
import java.io.Serializable;
import java.util.List;
import vermeer.sample.ee9.domain.UserDataQuery;

@RequestScoped
public class UserDataQueryImpl implements UserDataQuery {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<UserDataQueryDto> getUserData() {
        var results = em.createNamedQuery("UserDataQueryDto", UserDataQueryDto.class).getResultList();
        return results;
    }

    /**
     * Dummy Class for ResultSet Mapping.
     *
     * <code>@Entity</code> class must set <code>@Id</code> to property. <br>
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
