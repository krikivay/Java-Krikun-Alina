package dao;

import model.Job;
import model.Person;
import model.Phone;

import java.util.List;

public interface JobDao {
    public Job findById(Integer id);

    public List<Job> getAll();

    public Integer insert(Job job);

    public void remove(Job job);
}
