package dao.impl;

import config.HibernateUtil;
import dao.JobDao;
import model.Job;
import model.Person;
import org.hibernate.Session;

import java.util.List;

public class HibernateJobDao implements JobDao {
    @Override
    public Job findById(Integer id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Job job = session.get(Job.class, id);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return job;
    }

    @Override
    public List<Job> getAll() {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        List<Job> jobs = session.createQuery("FROM Job").list();
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return jobs;
    }

    @Override
    public Integer insert(Job job) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Integer id = (Integer) session.save(job);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
        return id;
    }

    @Override
    public void remove(Job job) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.delete(job);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }
}
