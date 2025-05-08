package rabaty;

import rabatlosowy.LosowyRabat;

public class AdapterLosowegoRabatu implements ObliczCenePoRabacie {
    private final LosowyRabat losowyRabat;

    public AdapterLosowegoRabatu(LosowyRabat losowyRabat) {
        this.losowyRabat = losowyRabat;
    }

    @Override
    public double obliczCenePoRabacie(double cena) {
        // Assuming LosowyRabat has a method that returns discount percentage
        double rabatProcent = losowyRabat.losujRabat();
        return cena * (1 - rabatProcent/100);
    }
}