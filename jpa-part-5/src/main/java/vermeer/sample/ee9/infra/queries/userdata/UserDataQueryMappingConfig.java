/*
 *  Copyright(C) 2021 Sanyu Academy All rights reserved.
 */
package vermeer.sample.ee9.infra.queries.userdata;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SqlResultSetMapping;
import java.io.Serializable;
import vermeer.sample.ee9.domain.UserDataQueryDto;

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
public class UserDataQueryMappingConfig implements Serializable {

    @Id
    String id;
}
