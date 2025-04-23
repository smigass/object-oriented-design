package pl.edu.agh.to.lab4.models;

public class CracovCitizen extends Suspect {
    public CracovCitizen(String firstname, String lastname, String PESEL) {
        super(firstname, lastname, PESEL);
    }

    @Override
    public boolean isSuspicious() {
        return this.getAge() >= 18;
    }
}
