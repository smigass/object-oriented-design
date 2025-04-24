package pl.edu.agh.to.lab4.filter;

import pl.edu.agh.to.lab4.models.Suspect;

public class NameSearchStrategy implements SearchStrategy {
    private String name;

    public NameSearchStrategy(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Suspect suspect) {
        if (suspect.getFirstName() == null && suspect.getLastName() == null) {
            return false;
        }
        return suspect.getFirstName().equalsIgnoreCase(name) || suspect.getLastName().equalsIgnoreCase(name);
    }
}
