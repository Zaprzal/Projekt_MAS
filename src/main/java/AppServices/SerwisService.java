package AppServices;

import AppClass.Serwis;
import AppDAO.SerwisDAO;

import java.util.List;

public class SerwisService {
    private static SerwisDAO dao;

    public SerwisService() {
        dao = new SerwisDAO();
    }


    public void persist(Serwis entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Serwis entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Serwis findById(Integer id) {
        dao.openCurrentSession();
        Serwis serwis = dao.findById(id);
        dao.closeCurrentSession();
        return serwis;
    }


    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Serwis serwis = dao.findById(id);
        dao.delete(serwis);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Serwis> findAll() {
        dao.openCurrentSession();
        List<Serwis> serwis = dao.findAll();
        dao.closeCurrentSession();
        return serwis;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public SerwisDAO dao() {
        return dao;
    }


}
