package rabaty;

import rabatlosowy.LosowyRabat;

public class AdapterLosowegoRabatu implements ObliczCenePoRabacie {
    private LosowyRabat losowyRabat;

    public AdapterLosowegoRabatu() {
        this.losowyRabat = new LosowyRabat();
    }

    @Override
    public double obliczCenePoRabacie(double cena) {
        double rabatProcentowy = losowyRabat.losujRabat();
        return cena * (1 - rabatProcentowy);
    }
}
