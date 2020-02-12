package AppDAO;


import AppClass.AnyDAOInterface;
import AppClass.JazdaTestowa;
import AppClass.SessionFac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class JazdaTestowaDAO implements AnyDAOInterface<JazdaTestowa, Integer> {

    private static SessionFactory sessionFactory;

    private static Session currentSession;

    private Transaction currentTransaction;

    /**
     * operacje na sesjach i transakcjach
     * @return
     */

    public Session openCurrentSession() {
        currentSession = SessionFac.openSession();
        return currentSession;
    }

    public Session openCurrentSessionwithTransaction() {
        currentSession = SessionFac.openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }

    public void closeCurrentSession() {
        //currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        //currentSession.close();
    }

    public Session getCurrentSession() {
        return currentSession;
    }

    public void setCurrentSession(Session currentSession) {
        this.currentSession = currentSession;
    }

    public Transaction getCurrentTransaction() {
        return currentTransaction;
    }

    public void setCurrentTransaction(Transaction currentTransaction) {
        this.currentTransaction = currentTransaction;
    }


    @Override
    public void persist(JazdaTestowa entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(JazdaTestowa entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public JazdaTestowa findById(Integer integer) {
        return getCurrentSession().get(JazdaTestowa.class, integer);
    }



    @Override
    public void delete(JazdaTestowa entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<JazdaTestowa> findAll() {
        return getCurrentSession().createQuery("from JazdaTestowa").list();
    }

    @Override
    public void deleteAll() {
        List<JazdaTestowa> entityList = findAll();
        for (JazdaTestowa entity : entityList) {
            delete(entity);
        }
    }
}
