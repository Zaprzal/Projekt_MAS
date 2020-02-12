package AppDAO;

import AppClass.AnyDAOInterface;

import AppClass.Serwisant;
import AppClass.SessionFac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SerwisantDAO  implements AnyDAOInterface<Serwisant, Integer> {

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
    public void persist(Serwisant entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Serwisant entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public Serwisant findById(Integer integer) {
        return getCurrentSession().get(Serwisant.class, integer);
    }



    @Override
    public void delete(Serwisant entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Serwisant> findAll() {
        return getCurrentSession().createQuery("from Serwisant").list();
    }

    @Override
    public void deleteAll() {
        List<Serwisant> entityList = findAll();
        for (Serwisant entity : entityList) {
            delete(entity);
        }
    }
}