package vermeer.sample.ee9.infra.queries.userdata;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class JpaTestExtension implements BeforeAllCallback, AfterAllCallback {

    public static final String PU_NAME = "TEST_PU";

    private static EntityManagerFactory emf;
    public static EntityManager em;

    public static org.h2.tools.Server server;

    @Override
    public void beforeAll(ExtensionContext ec) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            shutdownServer();
        }));

        server = org.h2.tools.Server.createTcpServer().start();
        emf = Persistence.createEntityManagerFactory(PU_NAME);
        em = emf.createEntityManager();
    }

    @Override
    public void afterAll(ExtensionContext ec) throws Exception {
        shutdownServer();
    }

    private static void shutdownServer() {
        if (em != null && em.isOpen()) {
            em.close();
            em = null;
        }

        if (emf != null && emf.isOpen()) {
            emf.close();
            emf = null;
        }
        if (server != null) {
            server.stop();
            server = null;
        }
    }

}
