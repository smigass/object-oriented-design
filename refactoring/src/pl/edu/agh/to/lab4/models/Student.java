package pl.edu.agh.to.lab4.models;

public class Student extends Suspect {
    private String index;

    public Student(String firstName, String lastName, String pesel, String index) {
        super(firstName, lastName, pesel);
        this.index = index;
    }

    @Override
    public boolean isSuspicious() {
        return this.getAge() >= 18;
    }
}
