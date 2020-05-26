package dao.impl;

import config.HibernateUtil;
import dao.PersonDao;
import model.Job;
import model.Person;
import model.Phone;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HibernatePersonDao implements PersonDao {
    @Override
    public Person findById(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Person person = session.get(Person.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return person;
    }

    @Override
    public Person findByPhone(Phone phone) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        String sql = "SELECT DISTINCT * FROM Person p INNER JOIN Phone ph ON ph.person = p.id AND ph.id = " + phone.getId()+ ";";
        List<Person> personList = session.createSQLQuery(sql).addEntity(Person.class).list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return personList.get(0);
    }

    @Override
    public List<Person> findByJob(Job job) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("SELECT * FROM Person p INNER JOIN p.jobs j where j.id = :id");
        query.setParameter("id", job.getId());
        List<Person> personList = query.list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return personList;
    }

    @Override
    public List<Person> getAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Person> personList = session.createQuery("FROM Person").list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return personList;
    }

    @Override
    public Integer insert(Person person) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(person);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return id;
    }

    @Override
    public Integer updateName(Person person, String name) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Query query = session.createQuery("UPDATE Person p SET p.name = :name where p.id = :id");
        query.setParameter("name", name);
        query.setParameter("id", person.getId());
        Integer result = query.executeUpdate();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return result;
    }

    @Override
    public void remove(Person person) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        for(Job job: person.getJobs()) {
            job.getPersons().remove(person);
        }
        session.delete(person);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }
}
