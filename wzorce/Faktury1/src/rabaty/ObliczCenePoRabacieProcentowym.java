package rabaty;

import rabatlosowy.LosowyRabat;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {

    @Override
    public double obliczCenePoRabacie(double cena, double rabat) {
        return cena * (1 - rabat);
    }
}
