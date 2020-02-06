package AppDAO;

import AppClass.AnyDAOInterface;

import AppClass.Osoba;
import AppClass.SessionFac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OsobaDAO implements AnyDAOInterface<Osoba, Integer> {

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
    public void persist(Osoba entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Osoba entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public Osoba findById(Integer integer) {
        return getCurrentSession().get(Osoba.class, integer);
    }



    @Override
    public void delete(Osoba entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Osoba> findAll() {
        return getCurrentSession().createQuery("from Klient").list();
    }

    @Override
    public void deleteAll() {
        List<Osoba> entityList = findAll();
        for (Osoba entity : entityList) {
            delete(entity);
        }
    }
}
