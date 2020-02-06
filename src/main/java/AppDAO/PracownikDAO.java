package AppDAO;

import AppClass.AnyDAOInterface;

import AppClass.Pracownik;
import AppClass.SessionFac;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PracownikDAO implements AnyDAOInterface<Pracownik, Integer> {

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
    public void persist(Pracownik entity) {
        getCurrentSession().persist(entity);
    }

    @Override
    public void update(Pracownik entity) {
        getCurrentSession().update(entity);
    }



    @Override
    public Pracownik findById(Integer integer) {
        return getCurrentSession().get(Pracownik.class, integer);
    }



    @Override
    public void delete(Pracownik entity) {
        getCurrentSession().delete(entity);
    }

    @Override
    public List<Pracownik> findAll() {
        return getCurrentSession().createQuery("from Klient").list();
    }

    @Override
    public void deleteAll() {
        List<Pracownik> entityList = findAll();
        for (Pracownik entity : entityList) {
            delete(entity);
        }
    }
}
