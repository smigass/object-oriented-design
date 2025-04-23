package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to.lab4.filter.*;
import pl.edu.agh.to.lab4.models.CracovCitizen;
import pl.edu.agh.to.lab4.models.Prisoner;
import pl.edu.agh.to.lab4.providers.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private Collection<CracovCitizen> allPersons = new ArrayList<CracovCitizen>();

    private Map<String, Collection<Prisoner>> allPrisoners = new HashMap<String, Collection<Prisoner>>();

    private final Collection<SearchStrategy> col = Arrays.asList(new NameSearchStrategy("Jan"), new AgeSearchStrategy());

    private final CompositeSearchStrategy strategy = new CompositeSearchStrategy(col);

    private final CompositeAggregate aggregate = new CompositeAggregate(new ArrayList<>(Arrays.asList(new PersonDataProvider(), new PrisonersDataProvider(), new StudentDataProvider())));

    private final Finder suspectFinder = new Finder(aggregate);

    @Test
    public void testDisplayingNotJailedPrisoner() {
        addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski", "802104543357", 2000, 1));
        suspectFinder.displaySuspects(strategy);
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        // 2005-06-14 → PESEL: 05261478903
        allPersons.add(new CracovCitizen("Jan", "Kowalski", "05261478903"));
        suspectFinder.displaySuspects(strategy);
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        // 2010-11-09 → PESEL: 10210932158
        allPersons.add(new CracovCitizen("Marcin", "Gortat", "10210932158"));
        suspectFinder.displaySuspects(strategy);
        assertContentIsNotDisplayed("Marcin Gortat");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        // 2005-02-04 → PESEL: 05020465471
        allPersons.add(new CracovCitizen("Jan", "Kowalski", "05220465471"));

        // Prisoner urodzony 1980-11-04 → PESEL: 80110454335
        addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", "80110454335", 2000, 20));

        suspectFinder.displaySuspects(strategy);
        assertContentIsNotDisplayed("Jan Kowalski2");
    }


    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

    private void addPrisoner(String category, Prisoner news) {
        if (!allPrisoners.containsKey(category))
            allPrisoners.put(category, new ArrayList<Prisoner>());
        allPrisoners.get(category).add(news);
    }
}
