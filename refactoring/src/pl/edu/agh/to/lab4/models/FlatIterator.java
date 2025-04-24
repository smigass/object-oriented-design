package pl.edu.agh.to.lab4.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class FlatIterator implements Iterator<Suspect> {
    private Map<String, Collection<Prisoner>> collection;
    private Iterator<String> keyIterator;
    private Iterator<Prisoner> valueIterator;

    public FlatIterator(Map<String, Collection<Prisoner>> collection) {
        this.collection = collection;
        this.keyIterator = collection.keySet().iterator();
        this.valueIterator = collection.get(keyIterator.next()).iterator();
    }

    @Override
    public boolean hasNext() {
       if (valueIterator.hasNext()) {
           return true;
       }
       if (!keyIterator.hasNext()) {
           return false;
       }
       valueIterator = collection.get(keyIterator.next()).iterator();
       return hasNext();
    }

    @Override
    public Suspect next() {
        if (valueIterator.hasNext()) {
            return (Suspect) valueIterator.next();
        }
        valueIterator = collection.get(keyIterator.next()).iterator();
        return next();
    }
}
