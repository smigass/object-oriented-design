package pl.edu.agh.to.lab4.filter;

import pl.edu.agh.to.lab4.models.Suspect;

public class AgeSearchStrategy implements SearchStrategy {
    private int minAge;
    private int maxAge;

    public AgeSearchStrategy(int minAge, int maxAge) throws IllegalArgumentException {
        this.minAge = minAge;
        this.maxAge = maxAge;

        if (minAge > maxAge) {
            throw new IllegalArgumentException("Min age cannot be greater than max age");
        }
    }

    public AgeSearchStrategy() {
        this.minAge = 18;
        this.maxAge = Integer.MAX_VALUE;
    }

    @Override
    public boolean filter(Suspect suspect) {
        return suspect.getAge() <= maxAge && suspect.getAge() >= minAge;
    }
}
