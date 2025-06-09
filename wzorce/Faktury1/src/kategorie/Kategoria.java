package kategorie;

import java.util.ArrayList;

import magazyn.Towar;

public class Kategoria implements KomponentKategorii {
    private String nazwa;
    private ArrayList<Towar> towary;

    public Kategoria(String nazwa) {
        this.nazwa = nazwa;
        this.towary = new ArrayList<>();
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
        System.out.println(wciecie + "Kategoria: " + nazwa);
        for (Towar towar : towary) {
            System.out.println(wciecie + "  - " + towar.getNazwa() + " (" + towar.getCena() + " zl)");
        }
    }

    @Override
    public void dodajTowar(Towar towar) {
        towary.add(towar);
    }
}
