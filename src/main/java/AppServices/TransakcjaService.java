package AppServices;


import AppClass.Transakcja;
import AppDAO.TransakcjaDAO;

import java.util.List;

public class TransakcjaService {
    private static TransakcjaDAO dao;

    public TransakcjaService() {
        dao = new TransakcjaDAO();
    }


    public void persist(Transakcja entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Transakcja entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Transakcja findById(Integer id) {
        dao.openCurrentSession();
        Transakcja transakcja = dao.findById(id);
        dao.closeCurrentSession();
        return transakcja;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Transakcja transakcja = dao.findById(id);
        dao.delete(transakcja);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Transakcja> findAll() {
        dao.openCurrentSession();
        List<Transakcja> transakcjas = dao.findAll();
        dao.closeCurrentSession();
        return transakcjas;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public TransakcjaDAO dao() {
        return dao;
    }
}
