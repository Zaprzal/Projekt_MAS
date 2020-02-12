package AppDAO;

import AppClass.AnyDAOInterface;
import AppClass.SessionFac;

import AppClass.Usterka;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UsterkaDAO implements AnyDAOInterface<Usterka, Integer> {

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
    public void persist(Usterka entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Usterka entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public Usterka findById(Integer integer) {
        return getCurrentSession().get(Usterka.class, integer);
    }



    @Override
    public void delete(Usterka entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Usterka> findAll() {
        return getCurrentSession().createQuery("from Usterka").list();
    }

    @Override
    public void deleteAll() {
        List<Usterka> entityList = findAll();
        for (Usterka entity : entityList) {
            delete(entity);
        }
    }
}
