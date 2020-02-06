package AppServices;



import AppClass.JazdaTestowa;
import AppDAO.JazdaTestowaDAO;

import java.util.List;

public class JazdaTestowaService {
    private static JazdaTestowaDAO dao;

    public JazdaTestowaService() {
        dao = new JazdaTestowaDAO();
    }


    public void persist(JazdaTestowa entity) {
        dao.openCurrentSessionwithTransaction();
        dao.persist(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public void update(JazdaTestowa entity) {
        dao.openCurrentSessionwithTransaction();
        dao.update(entity);
        dao.closeCurrentSessionwithTransaction();
    }

    public JazdaTestowa findById(Integer id) {
        dao.openCurrentSession();
        JazdaTestowa jazdaTestowa = dao.findById(id);
        dao.closeCurrentSession();
        return jazdaTestowa;
    }

    public void delete(Integer id) {
        dao.openCurrentSessionwithTransaction();
        JazdaTestowa jazdaTestowa = dao.findById(id);
        dao.delete(jazdaTestowa);
        dao.closeCurrentSessionwithTransaction();
    }

    public List<JazdaTestowa> findAll() {
        dao.openCurrentSession();
        List<JazdaTestowa> jazdaTestowas = dao.findAll();
        dao.closeCurrentSession();
        return jazdaTestowas;
    }

    public void deleteAll() {
        dao.openCurrentSessionwithTransaction();
        dao.deleteAll();
        dao.closeCurrentSessionwithTransaction();
    }

    public JazdaTestowaDAO dao() {
        return dao;
    }
}

