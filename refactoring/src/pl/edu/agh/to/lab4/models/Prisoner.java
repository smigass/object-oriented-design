package pl.edu.agh.to.lab4.models;

import java.util.Calendar;

public class Prisoner extends Suspect {
    private final int judgementYear;
    private final int sentenceDuration;

    public Prisoner(String firstname, String lastname, String pesel, int judgementYear, int sentenceDuration) {
        super(firstname, lastname, pesel);
        this.judgementYear = judgementYear;
        this.sentenceDuration = sentenceDuration;
    }

    @Override
    public boolean isSuspicious() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return judgementYear + sentenceDuration >= currentYear;
    }

    public boolean isJailedNow() {
        return judgementYear + sentenceDuration < Calendar.getInstance().get(Calendar.YEAR);
    }
}
