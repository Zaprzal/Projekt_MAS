package AppServices;



import AppClass.Serwisant;
import AppDAO.SerwisantDAO;

import java.util.List;

public class SerwisantService {
    private static SerwisantDAO dao;

    public SerwisantService() {
        dao = new SerwisantDAO();
    }


    public void persist(Serwisant entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Serwisant entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Serwisant findById(Integer id) {
        dao.openCurrentSession();
        Serwisant serwisant = dao.findById(id);
        dao.closeCurrentSession();
        return serwisant;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Serwisant serwisant = dao.findById(id);
        dao.delete(serwisant);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Serwisant> findAll() {
        dao.openCurrentSession();
        List<Serwisant> serwisants = dao.findAll();
        dao.closeCurrentSession();
        return serwisants;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public SerwisantDAO dao() {
        return dao;
    }
}
