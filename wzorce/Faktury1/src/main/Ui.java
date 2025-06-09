package main;

import java.util.Calendar;
import java.util.List;

import magazyn.Towar;
import dokumenty.Faktura;
import konfiguracja.Konfiguracja;
import rabaty.AdapterLosowegoRabatu;
import wydruk.DrukarkaKompaktowa;
import kategorie.*;

public class Ui {

    public static void main(String[] args) {
        Calendar teraz = Calendar.getInstance();

        Konfiguracja.getInstance().setObliczanieRabatu(new AdapterLosowegoRabatu());

        Towar t1 = new Towar(10, "Adasie");
        Towar t2 = new Towar(2, "skarpety");
        Towar t3 = new Towar(15, "kurtka");
        Towar t4 = new Towar(5, "złoty wisior");
        Towar t5 = new Towar(6, "Rolex z TEMU");
        Towar t6 = new Towar(20, "sandały");
        Towar t7 = new Towar(8, "Flip-flopy");


        Faktura f = new Faktura(teraz.getTime(), "Fido");
        f.dodajPozycje(t1, 3);
        f.dodajPozycje(t2, 5);

        System.out.println();

        Konfiguracja.getInstance().getDrukarka().drukuj(f);

        System.out.println();

        Konfiguracja.getInstance().setDrukarka(new DrukarkaKompaktowa());
        Konfiguracja.getInstance().getDrukarka().drukuj(f);

        System.out.println();

        List<Towar> towary = List.of(t1, t2, t3, t4, t5, t6, t7);

        pokazKategorie(towary);
    }

    private static void pokazKategorie(List<Towar> towary) {
        Podkategoria odziez = new Podkategoria("Odzież");

        Kategoria obuwie = new Kategoria("Obuwie");
        Kategoria bielizna = new Kategoria("Bielizna");
        Kategoria wierzchnia = new Kategoria("Odzież wierzchnia");
        Kategoria dodatki = new Kategoria("Dodatki");

        Podkategoria tekstylia = new Podkategoria("Tekstylia");
        tekstylia.dodajKomponent(bielizna);
        tekstylia.dodajKomponent(dodatki);

        odziez.dodajKomponent(obuwie);
        odziez.dodajKomponent(tekstylia);
        odziez.dodajKomponent(wierzchnia);

        obuwie.dodajTowar(towary.getFirst());
        bielizna.dodajTowar(towary.get(1));
        wierzchnia.dodajTowar(towary.get(2));
        dodatki.dodajTowar(towary.get(3));
        dodatki.dodajTowar(towary.get(4));
        obuwie.dodajTowar(towary.get(5));
        obuwie.dodajTowar(towary.get(6));

        odziez.wyswietl(0);
    }
}
