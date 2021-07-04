package ee.base.provider;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * リソースをCDIでつなぐためのProvider.
 *
 * @Produces が付いているメソッドで返されているクラスは@Injectでインジェクション出来るようになります. 例えば
 * @PersistenceContext でリソース取得していた場合、
 * コンストラクタインジェクションが出来ませんが、本Providerを使用することでインジェクションが出来るようになります.
 *
 */
@Dependent
public class ResourceProvider {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    @Dependent
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
