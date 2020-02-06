package AppDAO;

import AppClass.AnyDAOInterface;

import AppClass.Samochod;
import AppClass.SessionFac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SamochodDAO implements AnyDAOInterface<Samochod, Integer> {

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
    public void persist(Samochod entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Samochod entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public Samochod findById(Integer integer) {
        return getCurrentSession().get(Samochod.class, integer);
    }



    @Override
    public void delete(Samochod entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Samochod> findAll() {
        return getCurrentSession().createQuery("from Klient").list();
    }

    @Override
    public void deleteAll() {
        List<Samochod> entityList = findAll();
        for (Samochod entity : entityList) {
            delete(entity);
        }
    }
}
