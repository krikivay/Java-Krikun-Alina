package main;

import config.HibernateUtil;
import model.Job;
import model.Passport;
import model.Person;
import model.Phone;
import service.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Main {


    public static void main(String[] args) {
        Service service = new Service();

        List<Phone> phones = new ArrayList<>();
        phones.add(service.insertPhone("0662260958", "A51", "Samsung", 2020));
        phones.add(service.insertPhone("0677525128", "4X", "Xiaomi", 2017));
        phones.add(service.insertPhone("0936418032", "R54", "Huawei", 2019));

        List<Job> jobs = new ArrayList<>();
        jobs.add(service.insertJob("Mac", "cleaner"));
        jobs.add(service.insertJob("KFC", "cleaner"));
        jobs.add(service.insertJob("Mafia", "cleaner"));
        jobs.add(service.insertJob("Yakitoria", "cleaner"));


        List<Person> people = new ArrayList<>();
        people.add(service.insertPerson("Krikun Alina", 20,
                new Passport("EL013106", 2015, "F", "Lugansk"), asList(phones.get(0), phones.get(1)), asList(jobs.get(0), jobs.get(1))));
        people.add(service.insertPerson("Novikov Roma", 20,
                new Passport("MS867403", 2015, "M", "Kharkiv"), asList(phones.get(2)), asList(jobs.get(2), jobs.get(3))));


        people = service.getAllPeople();
        for(Person person : people)
            System.out.println(person);

        System.out.println("***********");

        Person person = service.findByPhone(new Phone("0662260958", "A51", "Samsung", 2020));
        System.out.println(person);
        System.out.println("***********");

        people = service.findByJob(new Job("Mafia", "cleaner"));
        for(Person p : people)
            System.out.println(p);

        System.out.println("***********");

        person = service.findPersonById(2);
        System.out.println(person);

        System.out.println("***********");

        service.updateName(person, "Vasya Pupkin");
        System.out.println(person);

        System.out.println("***********");

        service.removePerson(people.get(0));

        for(Person p : people)
            System.out.println(p);

        HibernateUtil.getSessionFactory().close();

    }
}
