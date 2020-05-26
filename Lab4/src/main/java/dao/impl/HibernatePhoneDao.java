package dao.impl;

import config.HibernateUtil;
import dao.PhoneDao;
import model.Job;
import model.Phone;
import org.hibernate.Session;

import java.util.List;

public class HibernatePhoneDao implements PhoneDao {
    @Override
    public Phone findById(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Phone phone = session.get(Phone.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return phone;
    }

    @Override
    public List<Phone> getAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Phone> phones = session.createQuery("FROM Phone").list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return phones;
    }

    @Override
    public Integer insert(Phone phone) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(phone);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return id;
    }

    @Override
    public void remove(Phone phone) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(phone);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }
}
