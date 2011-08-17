package pl.softwaremill.hibernatebug;

import org.hibernate.ejb.Ejb3Configuration;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import java.io.IOException;

public class InheritedEntityPostgresTest {

    private EntityManagerFactory emf;

    @BeforeClass
    public void initDatabase() throws IOException, SystemException, RollbackException, HeuristicRollbackException, HeuristicMixedException, NotSupportedException {
        Ejb3Configuration cfg = new Ejb3Configuration();

        cfg.configure("postgresql.test.cfg.xml");

        cfg.addAnnotatedClass(InheritingEntity.class);

        emf = cfg.buildEntityManagerFactory();
    }

    @AfterClass
    public void cleanupDatabase() {
        emf.close();
    }

    @Test
    public void shouldPersistDebtorAccountWhenParentServiceAgreementPersisted() throws SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException, NotSupportedException {
        InheritingEntity child1 = new InheritingEntity();
        InheritingEntity child2 = new InheritingEntity();

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(child1);

        em.merge(child2);
        em.getTransaction().commit();
    }

}
