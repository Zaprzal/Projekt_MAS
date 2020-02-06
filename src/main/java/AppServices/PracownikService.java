package AppServices;


import AppClass.Pracownik;
import AppDAO.PracownikDAO;

import java.util.List;

public class PracownikService {
    private static PracownikDAO dao;

    public PracownikService() {
        dao = new PracownikDAO();
    }


    public void persist(Pracownik entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Pracownik entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Pracownik findById(Integer id) {
        dao.openCurrentSession();
        Pracownik pracownik = dao.findById(id);
        dao.closeCurrentSession();
        return pracownik;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Pracownik pracownik = dao.findById(id);
        dao.delete(pracownik);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Pracownik> findAll() {
        dao.openCurrentSession();
        List<Pracownik> pracownik = dao.findAll();
        dao.closeCurrentSession();
        return pracownik;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public PracownikDAO dao() {
        return dao;
    }
}
