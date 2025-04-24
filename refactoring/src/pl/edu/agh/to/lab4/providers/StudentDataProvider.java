package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.models.Student;
import pl.edu.agh.to.lab4.models.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StudentDataProvider implements SuspectAggregate {
    private Collection<Student> students = new ArrayList<Student>();

    public StudentDataProvider() {
        students.add(new Student("Janusz", "Student", "01220312345", "s12345"));
        students.add(new Student("Kinga", "Kowalska", "01210167890", "s12346"));
        students.add(new Student("Pawel", "Maly", "15210287654", "s12347"));
        students.add(new Student("Janusz", "Zawodowiec", "93101054321", "s12348"));
        students.add(new Student("Anna", "Nowak", "00210111111", "s12349"));
        students.add(new Student("Marek", "Mazur", "98010122222", "s12350"));
        students.add(new Student("Katarzyna", "Wielka", "95030333333", "s12351"));
        students.add(new Student("Janusz", "Politechniczny", "99050544444", "s12352"));
        students.add(new Student("Agnieszka", "Lis", "02220255555", "s12353"));
        students.add(new Student("Piotr", "Wieczorek", "91040466666", "s12354"));
        students.add(new Student("Janusz", "Ambitny", "94060677777", "s12355"));
    }

    public Collection<Student> getAllStudentCitizens(){
        return students;
    }

    @Override
    public Iterator<Suspect> iterator() {
        return ((Collection<Suspect>)(Collection<?>) students).iterator();
    }
}
