package pl.edu.agh.to.lab4.providers;

import pl.edu.agh.to.lab4.models.Suspect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CompositeAggregate{

    private ArrayList<SuspectAggregate> aggregates;

    public CompositeAggregate(ArrayList<SuspectAggregate> aggregates) {
        this.aggregates = aggregates;
    }

    public Collection<Suspect> getSuspects(){
        Collection<Suspect> suspects = new ArrayList<>();
        for (SuspectAggregate aggregate : aggregates) {
            Iterator<Suspect> iterator = aggregate.iterator();
            while (iterator.hasNext()) {
                suspects.add(iterator.next());
            }
        }
        return suspects;
    }
}