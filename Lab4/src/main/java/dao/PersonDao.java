package dao;

import model.*;

import java.util.List;

public interface PersonDao {

    public Person findById(Integer id);

    public List<Person> findByJob(Job job);

    public Person findByPhone(Phone phone);

    public List<Person> getAll();

    public Integer insert(Person person);

    public Integer updateName(Person person, String name);

    public void remove(Person person);

}