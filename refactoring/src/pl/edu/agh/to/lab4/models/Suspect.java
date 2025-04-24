package pl.edu.agh.to.lab4.models;

import pl.edu.agh.to.lab4.utils.PESELUtils;

/**
 * Uzasadnienie użycia klasy abstrakcyjnej
 * 1. Definiuje wspólny interfejs dla osoby
 * 2. Zawiera współdzieloną implementację podstawowych atrybutów
 * 3. Pozwala na rozszerzanie systemu
 * 4. Wymusza spójną strukturę danych
 * 5. Umożliwia polimorficzne traktowanie różnych typów podejrzanych w systemie
 */

public abstract class Suspect {
    private String firstName;
    private String lastName;
    private String PESEL;
    private boolean suspicious;

    public Suspect(String firstName, String lastName, String pesel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PESEL = pesel;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return PESELUtils.extractAge(PESEL);
    }

    public abstract boolean isSuspicious();

}
