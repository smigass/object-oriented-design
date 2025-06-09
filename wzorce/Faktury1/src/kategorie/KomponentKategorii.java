package kategorie;

import magazyn.Towar;

public interface KomponentKategorii {
    String getNazwa();

    void wyswietl(int poziom);

    void dodajTowar(Towar towar);
}
