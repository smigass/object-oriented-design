package rabaty.dekoratory;

import magazyn.Towar;

public abstract class TowarDekorator extends Towar {
    protected Towar dekorowany;

    public TowarDekorator(Towar dekorowany) {
        super(dekorowany.getCena(), dekorowany.getNazwa());
        this.dekorowany = dekorowany;
    }

    @Override
    public double getCena() {
        return dekorowany.getCena();
    }

    @Override
    public double getCenaPoRabacie() {
        return dekorowany.getCenaPoRabacie();
    }

    @Override
    public String getNazwa() {
        return dekorowany.getNazwa();
    }
}