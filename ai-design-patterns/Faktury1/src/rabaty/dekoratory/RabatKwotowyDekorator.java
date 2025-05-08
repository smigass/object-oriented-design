package rabaty.dekoratory;

import magazyn.Towar;

public class RabatKwotowyDekorator extends TowarDekorator {
    private final double kwotaRabatu;

    public RabatKwotowyDekorator(Towar dekorowany, double kwotaRabatu) {
        super(dekorowany);
        this.kwotaRabatu = kwotaRabatu;
    }

    @Override
    public double getCenaPoRabacie() {
        double cenaPoRabacie = dekorowany.getCenaPoRabacie();
        return Math.max(0, cenaPoRabacie - kwotaRabatu);
    }

    @Override
    public String getNazwa() {
        return dekorowany.getNazwa() + " (rabat " + kwotaRabatu + " zł)";
    }
}