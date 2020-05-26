package model;

import javax.persistence.*;

@Entity
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String series;
    @Column
    private int year;
    @Column
    private String sex;
    @Column
    private String registration;

    public Passport() {
    }

    public Passport(String series, int year, String sex, String registration) {
        this.series = series;
        this.year = year;
        this.sex = sex;
        this.registration = registration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }


    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", series='" + series + '\'' +
                ", year=" + year +
                ", sex='" + sex + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }
}
