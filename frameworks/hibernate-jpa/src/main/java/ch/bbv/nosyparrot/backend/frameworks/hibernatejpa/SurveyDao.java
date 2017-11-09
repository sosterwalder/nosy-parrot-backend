package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.SessionImpl;

import java.util.List;


public class SurveyDao implements SurveyDaoInterface<SurveyJpaEntity, Long> {
    private Session currentSession;
    private Transaction currentTransaction;

    private static SessionFactory sessionFactory;

    static {
        Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(SurveyJpaEntity.class);

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());

        SurveyDao.sessionFactory = configuration.buildSessionFactory(builder.build());

    }

    public Session openCurrentSession() {
        this.currentSession = this.getSessionFactory().openSession();

        return this.currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        this.currentSession = this.getSessionFactory().openSession();
        this.currentTransaction = this.currentSession.beginTransaction();

        return this.currentSession;
    }

    public void closeCurrentSession() {
        this.currentSession.close();
    }

    public void closeCurrentSessionWithTransaction() {
        this.currentTransaction.commit();
        this.closeCurrentSession();
    }

    public Session getCurrentSession() {
        return this.currentSession;
    }

    public void setCurrentSession(Session session) {
        this.currentSession = session;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }

    @Override
    public void persist(SurveyJpaEntity entity) {
        this.currentSession.save(entity);
    }

    @Override
    public void update(SurveyJpaEntity entity) {
        this.currentSession.update(entity);
    }

    @Override
    public SurveyJpaEntity findById(Long id) {
        SurveyJpaEntity survey = (SurveyJpaEntity) this.currentSession.get(SurveyJpaEntity.class, id);

        return survey;
    }

    @Override
    public void delete(SurveyJpaEntity entity) {
        this.currentSession.delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<SurveyJpaEntity> findAll() {
        String queryString = String.format("from %s", SurveyJpaEntity.class.getSimpleName());
        List<SurveyJpaEntity> surveyList = (List<SurveyJpaEntity>) this.currentSession
                .createQuery(queryString)
                .list();

        return surveyList;
    }

    @Override
    public void deleteAll() {
        List<SurveyJpaEntity> surveyList = this.findAll();
        for (SurveyJpaEntity survey : surveyList) {
            this.delete(survey);
        }
    }

    private static SessionFactory getSessionFactory() {
        return SurveyDao.sessionFactory;
    }
}
