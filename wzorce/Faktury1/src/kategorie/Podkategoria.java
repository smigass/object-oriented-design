package kategorie;

import java.util.ArrayList;

import magazyn.Towar;

public class Podkategoria implements KomponentKategorii {
    private String nazwa;
    private ArrayList<KomponentKategorii> dzieci;

    public Podkategoria(String nazwa) {
        this.nazwa = nazwa;
        this.dzieci = new ArrayList<>();
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public void wyswietl(int poziom) {
        String wciecie = "";
        for (int i = 0; i < poziom; i++) {
            wciecie += "  ";
        }
        System.out.println(wciecie + "Podkategoria: " + nazwa);
        for (KomponentKategorii dziecko : dzieci) {
            dziecko.wyswietl(poziom + 1);
        }
    }

    @Override
    public void dodajTowar(Towar towar) {
        for (KomponentKategorii dziecko : dzieci) {
            if (dziecko instanceof Kategoria) {
                dziecko.dodajTowar(towar);
                return;
            }
        }
    }

    public void dodajKomponent(KomponentKategorii komponent) {
        dzieci.add(komponent);
    }
}
