package wydruk;

import dokumenty.Faktura;

public abstract class DrukujFakture {

    public final void drukuj(Faktura faktura) {
        drukujNaglowek(faktura);
        drukujPozycje(faktura);
        drukujStopke(faktura);
    }

    abstract void drukujNaglowek(Faktura faktura);

    abstract void drukujPozycje(Faktura faktura);

    abstract void drukujStopke(Faktura faktura);
}
