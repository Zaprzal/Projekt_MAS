package AppServices;

import AppClass.Klient;
import AppDAO.KlientDAO;

import java.util.List;

public class KlientService {
    private static KlientDAO dao;

    public KlientService() {
        dao = new KlientDAO();
    }


    public void persist(Klient entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Klient entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Klient findById(Integer id) {
        dao.openCurrentSession();
        Klient Klient = dao.findById(id);
        dao.closeCurrentSession();
        return Klient;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Klient Klient = dao.findById(id);
        dao.delete(Klient);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Klient> findAll() {
        dao.openCurrentSession();
        List<Klient> Klient = dao.findAll();
        dao.closeCurrentSession();
        return Klient;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public KlientDAO dao() {
        return dao;
    }
}
