package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.providers.PrisonersDataProvider;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private PrisonersDataProvider prisonersDatabase = new PrisonersDataProvider();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonersDatabase.getAllPrisons().size());
    }
}
