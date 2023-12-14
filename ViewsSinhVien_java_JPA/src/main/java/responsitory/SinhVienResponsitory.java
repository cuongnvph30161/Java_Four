package responsitory;

import entity.SinhVien;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;

public class SinhVienResponsitory {
   public ArrayList<SinhVien> getList(){
        ArrayList<SinhVien> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            list = (ArrayList<SinhVien>) session.createQuery("from SinhVien ").list();

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
