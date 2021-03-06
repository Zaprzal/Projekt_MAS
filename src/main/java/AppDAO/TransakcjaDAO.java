package AppDAO;

import AppClass.AnyDAOInterface;

import AppClass.SessionFac;
import AppClass.Transakcja;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TransakcjaDAO implements AnyDAOInterface<Transakcja, Integer> {

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
    public void persist(Transakcja entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Transakcja entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public Transakcja findById(Integer integer) {
        return getCurrentSession().get(Transakcja.class, integer);
    }



    @Override
    public void delete(Transakcja entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Transakcja> findAll() {
        return getCurrentSession().createQuery("from Transakcja").list();
    }

    @Override
    public void deleteAll() {
        List<Transakcja> entityList = findAll();
        for (Transakcja entity : entityList) {
            delete(entity);
        }
    }
}
