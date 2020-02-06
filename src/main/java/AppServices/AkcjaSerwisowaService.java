package AppServices;



import AppClass.AkcjaSerwisowa;
import AppDAO.AkcjaSerwisowaDAO;

import java.util.List;

public class AkcjaSerwisowaService {
    private static AkcjaSerwisowaDAO dao;

    public AkcjaSerwisowaService() {
        dao = new AkcjaSerwisowaDAO();
    }


    public void persist(AkcjaSerwisowa entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(AkcjaSerwisowa entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public AkcjaSerwisowa findById(Integer id) {
        dao.openCurrentSession();
        AkcjaSerwisowa akcja = dao.findById(id);
        dao.closeCurrentSession();
        return akcja;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        AkcjaSerwisowa akcja = dao.findById(id);
        dao.delete(akcja);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<AkcjaSerwisowa> findAll() {
        dao.openCurrentSession();
        List<AkcjaSerwisowa> akcja = dao.findAll();
        dao.closeCurrentSession();
        return akcja;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public AkcjaSerwisowaDAO dao() {
        return dao;
    }
}
