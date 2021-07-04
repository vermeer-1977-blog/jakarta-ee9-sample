package vermeer.sample.ee9.infra.queries.userdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import vermeer.sample.ee9.infra.entities.UserData;

@ExtendWith(JpaTestExtension.class)
public class UserDataQueryImplTest {

    @Test
    public void test01() {
        var userData = new UserData(1L);
        userData.setNickName("NickTest");
        userData.setUserName("UserName1 Test2");

        var tx = JpaTestExtension.em.getTransaction();
        tx.begin();
        JpaTestExtension.em.persist(userData);
        tx.commit();

        var query = new UserDataQueryImpl(JpaTestExtension.em);
        var results = query.getUserData();

        assertEquals(1, results.size());
        assertEquals("NickTest", results.get(0).getNickName());
        assertEquals("UserName1", results.get(0).getUserName().getFirstName());
        assertEquals("Test2", results.get(0).getUserName().getLastName());
    }
}
