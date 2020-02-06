package AppServices;



import AppClass.Samochod;
import AppDAO.SamochodDAO;

import java.util.List;

public class SamochodService {
    private static SamochodDAO dao;

    public SamochodService() {
        dao = new SamochodDAO();
    }


    public void persist(Samochod entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(Samochod entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public Samochod findById(Integer id) {
        dao.openCurrentSession();
        Samochod samochod = dao.findById(id);
        dao.closeCurrentSession();
        return samochod;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        Samochod samochod = dao.findById(id);
        dao.delete(samochod);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<Samochod> findAll() {
        dao.openCurrentSession();
        List<Samochod> samochods = dao.findAll();
        dao.closeCurrentSession();
        return samochods;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public SamochodDAO dao() {
        return dao;
    }
}