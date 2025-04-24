package pl.edu.agh.to.lab4;

import org.junit.Test;
import pl.edu.agh.to.lab4.models.Prisoner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrisonerTest {
    @Test
    public void testPrisonerIsInJail() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", currentYear - 2, 3);
        assertTrue(news.isSuspicious());
    }

    @Test
    public void testPrisonerHasBeenReleasedFromJail() {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        Prisoner news = new Prisoner("Jan", "Kowalski", "802104543357", currentYear - 10, 5);
        assertFalse(news.isSuspicious());
    }
}
