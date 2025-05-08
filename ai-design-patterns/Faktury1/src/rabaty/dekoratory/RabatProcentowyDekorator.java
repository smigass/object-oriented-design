package rabaty.dekoratory;

import magazyn.Towar;

public class RabatProcentowyDekorator extends TowarDekorator {
    private final double procentRabatu;

    public RabatProcentowyDekorator(Towar dekorowany, double procentRabatu) {
        super(dekorowany);
        this.procentRabatu = procentRabatu;
    }

    @Override
    public double getCenaPoRabacie() {
        double cenaPoRabacie = dekorowany.getCenaPoRabacie();
        return cenaPoRabacie * (1 - procentRabatu/100);
    }

    @Override
    public String getNazwa() {
        return dekorowany.getNazwa() + " (rabat " + procentRabatu + "%)";
    }
}