package main;

import java.util.Iterator;
import java.util.Calendar;
import magazyn.Towar;

import dokumenty.Faktura;
import dokumenty.Pozycja;

//ZEWNETRZNY RABAT
import rabatlosowy.LosowyRabat;

// Import strategy classes
import rabaty.RabatProcentowy;
import rabaty.RabatKwotowy;
import rabaty.AdapterLosowegoRabatu;

// Import decorator classes
import rabaty.dekoratory.RabatProcentowyDekorator;
import rabaty.dekoratory.RabatKwotowyDekorator;
import rabaty.dekoratory.DarmoweDostarczeniaDekorator;
import rabaty.dekoratory.PodatekDekorator;

public class Ui {

	public static void main(String[] args) {
		Calendar teraz = Calendar.getInstance();

		// Część 1: Demonstracja wzorca Strategii
		System.out.println("=== DEMONSTRACJA WZORCA STRATEGII ===");

		// Tworzymy towary
		Towar t1 = new Towar(10, "buty");
		Towar t2 = new Towar(2, "skarpety");

		// Tworzymy strategie rabatowe
		RabatProcentowy rabat20procent = new RabatProcentowy(20);
		RabatKwotowy rabat1zl = new RabatKwotowy(1);

		// Stosujemy strategie do towarów
		t1.ustawStrategieRabatu(rabat20procent);
		t2.ustawStrategieRabatu(rabat1zl);

		System.out.println("Buty - cena bez rabatu: " + t1.getCena() + " zł");
		System.out.println("Buty - cena po rabacie 20%: " + t1.getCenaPoRabacie() + " zł");

		System.out.println("Skarpety - cena bez rabatu: " + t2.getCena() + " zł");
		System.out.println("Skarpety - cena po rabacie 1 zł: " + t2.getCenaPoRabacie() + " zł");

		// Adapter do losowego rabatu
		LosowyRabat lr = new LosowyRabat();
		AdapterLosowegoRabatu adapterLosowy = new AdapterLosowegoRabatu(lr);

		// Zmiana strategii rabatowej
		t1.ustawStrategieRabatu(adapterLosowy);
		System.out.println("Buty - cena po losowym rabacie: " + t1.getCenaPoRabacie() + " zł");

		// Przykladowa faktura z podstawowymi rabatami
		Faktura f = new Faktura(teraz.getTime(), "Fido");
		f.dodajPozycje(t1, 3);
		f.dodajPozycje(t2, 5);

		wypiszFakture(f);

		// Część 2: Demonstracja wzorca Dekoratora
		System.out.println("\n=== DEMONSTRACJA WZORCA DEKORATORA ===");

		// Podstawowy towar
		Towar laptopPodstawowy = new Towar(3000, "Laptop");
		System.out.println("Podstawowy produkt: " + laptopPodstawowy.getNazwa());
		System.out.println("Cena podstawowa: " + laptopPodstawowy.getCena() + " zł");

		// Dekorator 1: Rabat procentowy 10%
		Towar laptopRabat10 = new RabatProcentowyDekorator(laptopPodstawowy, 10);
		System.out.println("\nPo dodaniu rabatu procentowego: " + laptopRabat10.getNazwa());
		System.out.println("Cena po rabacie: " + laptopRabat10.getCenaPoRabacie() + " zł");

		// Dekorator 2: Dodanie podatku 23%
		Towar laptopRabat10Podatek = new PodatekDekorator(laptopRabat10, 23);
		System.out.println("\nPo dodaniu podatku: " + laptopRabat10Podatek.getNazwa());
		System.out.println("Cena końcowa: " + laptopRabat10Podatek.getCenaPoRabacie() + " zł");

		// Dekorator 3: Darmowa dostawa
		Towar laptopRabat10PodatekDostawa = new DarmoweDostarczeniaDekorator(laptopRabat10Podatek, 20);
		System.out.println("\nZ darmową dostawą: " + laptopRabat10PodatekDostawa.getNazwa());
		System.out.println("Cena końcowa: " + laptopRabat10PodatekDostawa.getCenaPoRabacie() + " zł");

		// Przykład niezależnego łączenia dekoratorów
		Towar telefon = new Towar(1500, "Telefon");
		telefon = new RabatKwotowyDekorator(telefon, 200);
		telefon = new PodatekDekorator(telefon, 23);

		System.out.println("\nInny przykład: " + telefon.getNazwa());
		System.out.println("Cena końcowa: " + telefon.getCenaPoRabacie() + " zł");

		// Dodanie do faktury elementu z dekoratorem
		Faktura f2 = new Faktura(teraz.getTime(), "Dekoracja Sp. z o.o.");
		f2.dodajPozycje(laptopRabat10PodatekDostawa, 1);
		f2.dodajPozycje(telefon, 2);

		wypiszFakture(f2);
	}

	private static void wypiszFakture(Faktura faktura) {
		System.out.println("=====================================================");
		System.out.println("FA z dnia: " + faktura.getDataSprzedazy().toString());
		System.out.println("Wystawiona dla: " + faktura.getKontrahent());
		System.out.println("Na kwote: " + faktura.getSuma());
		Iterator<Pozycja> iteratorPozycji = faktura.getIteratorPozycji();
		while(iteratorPozycji.hasNext()) {
			Pozycja pozycja = iteratorPozycji.next();
			System.out.println("Towar: " + pozycja.getNazwa() + " Ilosc: " + pozycja.getIlosc() + " Wartosc:" + pozycja.getWartosc());
		}
		System.out.println("=====================================================");
	}
}