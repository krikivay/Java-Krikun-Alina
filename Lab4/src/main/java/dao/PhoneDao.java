package dao;

import model.Job;
import model.Phone;

import java.util.List;

public interface PhoneDao {
    public Phone findById(Integer id);

    public List<Phone> getAll();

    public Integer insert(Phone phone);

    public void remove(Phone phone);
}
