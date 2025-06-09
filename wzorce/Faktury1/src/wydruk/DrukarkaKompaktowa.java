package wydruk;

import java.util.Iterator;

import dokumenty.Faktura;
import dokumenty.Pozycja;

public class DrukarkaKompaktowa extends DrukujFakture {

    @Override
    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("FAKTURA: " + faktura.getKontrahent());
    }

    @Override
    protected void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji = faktura.getIteratorPozycji();
        int licznik = 1;
        while (iteratorPozycji.hasNext()) {
            Pozycja pozycja = iteratorPozycji.next();
            System.out.println(licznik++ + ". " + pozycja.getNazwa() +
                    " - " + pozycja.getWartosc() + " zl");
        }
    }

    @Override
    protected void drukujStopke(Faktura faktura) {
        System.out.println("SUMA: " + faktura.getSuma() + " zl");
    }
}
