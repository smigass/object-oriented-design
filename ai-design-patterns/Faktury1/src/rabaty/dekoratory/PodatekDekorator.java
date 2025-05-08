package rabaty.dekoratory;

import magazyn.Towar;

public class PodatekDekorator extends TowarDekorator {
    private final double stawkaPodatku;

    public PodatekDekorator(Towar dekorowany, double stawkaPodatku) {
        super(dekorowany);
        this.stawkaPodatku = stawkaPodatku;
    }

    @Override
    public double getCenaPoRabacie() {
        double cenaPoRabacie = dekorowany.getCenaPoRabacie();
        return cenaPoRabacie * (1 + stawkaPodatku/100);
    }

    @Override
    public String getNazwa() {
        return dekorowany.getNazwa() + " + podatek " + stawkaPodatku + "%";
    }
}