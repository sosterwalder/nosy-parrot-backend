package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(SurveyJpaEntity.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());

        HibernateUtil.sessionFactory = configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return HibernateUtil.sessionFactory;
    }

}
