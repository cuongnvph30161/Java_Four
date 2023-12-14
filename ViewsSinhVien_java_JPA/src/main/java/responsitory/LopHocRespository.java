package responsitory;

import entity.LopHoc;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.ArrayList;

public class LopHocRespository {

    public ArrayList<LopHoc> getList() {
        ArrayList<LopHoc> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<LopHoc>) session.createQuery("from LopHoc").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }
}
