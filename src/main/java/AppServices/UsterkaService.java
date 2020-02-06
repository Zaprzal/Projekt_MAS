package AppServices;


import AppClass.Usterka;
import AppDAO.UsterkaDAO;

import java.util.List;

public class UsterkaService {
    private static UsterkaDAO dao;

    public UsterkaService() {
        dao = new UsterkaDAO();
    }


    public void persist(Usterka entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Usterka entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Usterka findById(Integer id) {
        dao.openCurrentSession();
        Usterka usterka = dao.findById(id);
        dao.closeCurrentSession();
        return usterka;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Usterka usterka = dao.findById(id);
        dao.delete(usterka);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Usterka> findAll() {
        dao.openCurrentSession();
        List<Usterka> usterkas = dao.findAll();
        dao.closeCurrentSession();
        return usterkas;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public UsterkaDAO dao() {
        return dao;
    }
}
