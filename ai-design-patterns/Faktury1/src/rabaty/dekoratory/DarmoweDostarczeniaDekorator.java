package rabaty.dekoratory;

import magazyn.Towar;

public class DarmoweDostarczeniaDekorator extends TowarDekorator {
    private final double wartoscGratisu;

    public DarmoweDostarczeniaDekorator(Towar dekorowany, double wartoscGratisu) {
        super(dekorowany);
        this.wartoscGratisu = wartoscGratisu;
    }

    @Override
    public String getNazwa() {
        return dekorowany.getNazwa() + " + darmowa dostawa (wartość " + wartoscGratisu + " zł)";
    }
}