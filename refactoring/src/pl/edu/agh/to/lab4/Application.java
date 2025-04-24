package pl.edu.agh.to.lab4;

import pl.edu.agh.to.lab4.filter.*;
import pl.edu.agh.to.lab4.providers.*;

import java.util.ArrayList;
import java.util.Collection;

public class Application {

    public static void main(String[] args) {
        ArrayList<SuspectAggregate> aggregates = new ArrayList<>();
        aggregates.add(new PersonDataProvider());
        aggregates.add(new PrisonersDataProvider());
        aggregates.add(new StudentDataProvider());
        CompositeAggregate aggregate = new CompositeAggregate(aggregates);
        Finder suspects = new Finder(aggregate);

        Collection<SearchStrategy> strategies = new ArrayList<>();
        strategies.add(new NameSearchStrategy("Janusz"));
        strategies.add(new AgeSearchStrategy());
        CompositeSearchStrategy strategy = new CompositeSearchStrategy(strategies);
        suspects.displaySuspects(strategy);
    }
}
