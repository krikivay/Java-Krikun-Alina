package model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String place;
    @Column
    private String position;

    @ManyToMany(mappedBy = "jobs", fetch = FetchType.EAGER)
    private List<Person> persons;

    public Job() {
    }

    public Job(String place, String position) {
        this.place = place;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", place='" + place + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
