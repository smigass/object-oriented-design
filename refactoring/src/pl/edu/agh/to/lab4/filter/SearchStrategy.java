package pl.edu.agh.to.lab4.filter;

import pl.edu.agh.to.lab4.models.Suspect;

public interface SearchStrategy {
    boolean filter(Suspect suspect);
}
