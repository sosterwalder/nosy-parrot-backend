package ch.bbv.nosyparrot.backend.frameworks.hibernatejpa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public abstract class AbstractGenericDao<E> implements GenericDao<E> {

    private final Class<E> entityClass;

    public AbstractGenericDao() {
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    private Session getSession() {
        Session currentSession = HibernateUtil.getSessionFactory().getCurrentSession();
        if (currentSession == null || !currentSession.isOpen()) {
            currentSession = HibernateUtil.getSessionFactory().openSession();
        }

        return currentSession;
    }

    @Override
    public E findById(final Serializable id) {
        return (E) getSession().get(this.entityClass, id);
    }

    @Override
    public Serializable save(E entity) {
        return getSession().save(entity);
    }

    @Override
    public void saveOrUpdate(E entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(E entity) {
        getSession().delete(entity);
    }

    @Override
    public void deleteAll() {
        List<E> entities = findAll();
        for (E entity : entities) {
            getSession().delete(entity);
        }
    }

    @Override
    public List<E> findAll() {
        Session currentSession = this.getSession();
        Transaction currentTransaction = currentSession.getTransaction();
        List<E> resultList;

        try {
            currentTransaction.begin();
            resultList = currentSession.createCriteria(this.entityClass).list();
            currentTransaction.commit();
        }
        catch(RuntimeException runtimeException) {
            currentTransaction.rollback();
            throw runtimeException;
        }

        return resultList;
    }

    @Override
    public void clear() {
        getSession().clear();

    }

    @Override
    public void flush() {
        getSession().flush();

    }

}