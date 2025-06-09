package konfiguracja;

import rabaty.ObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieProcentowym;
import wydruk.DrukarkaPodstawowa;
import wydruk.DrukujFakture;

public class Konfiguracja {
    private static Konfiguracja instance;
    private ObliczCenePoRabacie obliczanieRabatu;
    private DrukujFakture drukarka;

    private Konfiguracja() {
        this.obliczanieRabatu = new ObliczCenePoRabacieProcentowym();
        this.drukarka = new DrukarkaPodstawowa();
    }

    public static Konfiguracja getInstance() {
        if (instance == null) {
            instance = new Konfiguracja();
        }
        return instance;
    }

    public ObliczCenePoRabacie getObliczanieRabatu() {
        return obliczanieRabatu;
    }

    public void setObliczanieRabatu(ObliczCenePoRabacie obliczanieRabatu) {
        this.obliczanieRabatu = obliczanieRabatu;
    }

    public DrukujFakture getDrukarka() {
        return drukarka;
    }

    public void setDrukarka(DrukujFakture drukarka) {
        this.drukarka = drukarka;
    }
}
