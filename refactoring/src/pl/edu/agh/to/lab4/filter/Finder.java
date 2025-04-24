package pl.edu.agh.to.lab4.filter;

import pl.edu.agh.to.lab4.models.Suspect;
import pl.edu.agh.to.lab4.providers.CompositeAggregate;

import java.util.ArrayList;
import java.util.Collection;

public class Finder {
    private final Collection<Suspect> suspects;

    public Finder(CompositeAggregate aggregate) {
        this.suspects = aggregate.getSuspects();
    }


    public void displaySuspects(SearchStrategy strategy) {
        ArrayList<Suspect> suspected = new ArrayList<Suspect>();
        for (Suspect suspect : suspects) {
            if (strategy.filter(suspect)) {
                suspected.add(suspect);
            }
        }

        int total = suspected.size();
        System.out.println("Znalazlem " + total + " pasujacych podejrzanych!");

        for (Suspect n : suspected) {
            System.out.println(n.toString());
        }
    }
}
