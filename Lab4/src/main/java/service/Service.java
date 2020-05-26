package service;

import dao.JobDao;
import dao.PersonDao;
import dao.PhoneDao;
import dao.impl.HibernateJobDao;
import dao.impl.HibernatePersonDao;
import dao.impl.HibernatePhoneDao;
import model.Job;
import model.Passport;
import model.Person;
import model.Phone;

import java.util.List;

public class Service {
    private final PersonDao personDao = new HibernatePersonDao();
    private final PhoneDao phoneDao = new HibernatePhoneDao();
    private final JobDao jobDao = new HibernateJobDao();


    public Job findJobById(Integer id) {
        return jobDao.findById(id);
    }

    public List<Job> getAllJobs() {
        return jobDao.getAll();
    }

    public Job insertJob(String place, String position) {
        Job job = new Job(place, position);
        Integer id = jobDao.insert(job);
        job.setId(id);
        return job;
    }

    public void removeJob(Job job) {
        jobDao.remove(job);
    }

    public Phone findPhoneById(Integer id) {
        return phoneDao.findById(id);
    }

    public List<Phone> getAllPhones() {
        return phoneDao.getAll();
    }

    public Phone insertPhone(String number, String model, String producer, int year) {
        Phone phone = new Phone(number, model, producer, year);
        Integer id = phoneDao.insert(phone);
        phone.setId(id);
        return phone;
    }

    public void removePhone(Phone phone) {
        phoneDao.remove(phone);
    }

    public Person findPersonById(Integer id) {
        return personDao.findById(id);
    }

    public Person findByPhone(Phone phone) {
        return personDao.findByPhone(phone);
    }

    public List<Person> findByJob(Job job) {
        return personDao.findByJob(job);
    }

    public List<Person> getAllPeople() {
        return personDao.getAll();
    }

    public Person insertPerson(String name, int age, Passport passport, List<Phone> phones, List<Job> jobs) {
        Person person = new Person(name, age, passport, phones, jobs);
        Integer id = personDao.insert(person);
        person.setId(id);
        return person;
    }

    public Integer updateName(Person person, String name) {
        return personDao.updateName(person, name);
    }

    public void removePerson(Person person) {
        personDao.remove(person);
    }
}
