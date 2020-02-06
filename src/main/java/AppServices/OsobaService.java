package AppServices;


import AppClass.Osoba;
import AppDAO.OsobaDAO;

import java.util.List;

public class OsobaService {
    private static OsobaDAO dao;

    public OsobaService() {
        dao = new OsobaDAO();
    }


    public void persist(Osoba entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Osoba entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Osoba findById(Integer id) {
        dao.openCurrentSession();
        Osoba osoba = dao.findById(id);
        dao.closeCurrentSession();
        return osoba;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Osoba osoba = dao.findById(id);
        dao.delete(osoba);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Osoba> findAll() {
        dao.openCurrentSession();
        List<Osoba> osoba = dao.findAll();
        dao.closeCurrentSession();
        return osoba;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public OsobaDAO dao() {
        return dao;
    }
}
