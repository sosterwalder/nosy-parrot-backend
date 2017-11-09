package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class SurveyDao implements SurveyDaoInterface<SurveyJpaEntity, Long> {
    private Session currentSession;
    private Transaction currentTransaction;

    public Session openCurrentSession() {
        this.currentSession = HibernateUtil.getSessionFactory().openSession();

        return this.currentSession;
    }

    public Session openCurrentSessionWithTransaction() {
        this.currentSession = HibernateUtil.getSessionFactory().openSession();
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
}
