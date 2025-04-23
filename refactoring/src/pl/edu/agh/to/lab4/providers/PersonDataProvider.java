package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.models.CracovCitizen;
import pl.edu.agh.to.lab4.models.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

// Zgodnie z informajami otrzymanymi podczas loboratorium, zmieniliśmy w danych wiek na numer PESEL.
// Wiek jest teraz wyciągany z numeru PESEL za pomocą metody w utils.

public class PersonDataProvider implements SuspectAggregate {

    private final Collection<CracovCitizen> cracovCitizens = new ArrayList<CracovCitizen>();

    public PersonDataProvider() {
        cracovCitizens.add(new CracovCitizen("Jan", "Kowalski", "95031812347"));
        cracovCitizens.add(new CracovCitizen("Janusz", "Krakowski", "95062445628"));
        cracovCitizens.add(new CracovCitizen("Janusz", "Mlodociany", "15292778906"));
        cracovCitizens.add(new CracovCitizen("Kasia", "Kosinska", "06252465439"));
        cracovCitizens.add(new CracovCitizen("Piotr", "Zgredek", "96010765480"));
        cracovCitizens.add(new CracovCitizen("Tomek", "Gimbus", "11221745638"));
        cracovCitizens.add(new CracovCitizen("Janusz", "Gimbus", "10270278924"));
        cracovCitizens.add(new CracovCitizen("Alicja", "Zaczarowana", "03291178951"));
        cracovCitizens.add(new CracovCitizen("Janusz", "Programista", "48010112306"));
        cracovCitizens.add(new CracovCitizen("Pawel", "Pawlowicz", "93022598761"));
        cracovCitizens.add(new CracovCitizen("Krzysztof", "Mendel", "95110432179"));

    }

    public Collection<CracovCitizen> getCracovCitizens() {
        return cracovCitizens;
    }

    public Iterator<Suspect> iterator() {
        return ((Collection<Suspect>)(Collection<?>) cracovCitizens).iterator();
    }
}
