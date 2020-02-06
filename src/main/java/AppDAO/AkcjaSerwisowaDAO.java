package AppDAO;

import AppClass.AkcjaSerwisowa;
import AppClass.AnyDAOInterface;
import AppClass.SessionFac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AkcjaSerwisowaDAO implements AnyDAOInterface<AkcjaSerwisowa, Integer> {

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
    public void persist(AkcjaSerwisowa entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(AkcjaSerwisowa entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public AkcjaSerwisowa findById(Integer integer) {
        return getCurrentSession().get(AkcjaSerwisowa.class, integer);
    }



    @Override
    public void delete(AkcjaSerwisowa entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<AkcjaSerwisowa> findAll() {
        return getCurrentSession().createQuery("from Klient").list();
    }

    @Override
    public void deleteAll() {
        List<AkcjaSerwisowa> entityList = findAll();
        for (AkcjaSerwisowa entity : entityList) {
            delete(entity);
        }
    }
}
