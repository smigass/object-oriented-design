package pl.edu.agh.to.lab4.utils;

public class PESELUtils {
    public static int extractAge(String PESEL) {
        int year = Integer.parseInt(PESEL.substring(0, 2));
        int month = Integer.parseInt(PESEL.substring(2, 4));

        // Adjust year based on century
        if (month > 20 && month <= 32) {
            year += 2000;
            month -= 20;
        } else if (month > 0 && month <= 12) {
            year += 1900;
        } else if (month > 40 && month <= 52) {
            year += 2100;
            month -= 40;
        } else if (month > 60 && month <= 72) {
            year += 2200;
            month -= 60;
        } else if (month > 80 && month <= 92) {
            year += 1800;
            month -= 80;
        }

        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        return currentYear - year;
    }
}
