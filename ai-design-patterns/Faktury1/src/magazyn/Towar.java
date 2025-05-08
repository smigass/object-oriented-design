package magazyn;

import rabaty.ObliczCenePoRabacie;

public class Towar {
	private double cena;
	private String nazwa;
	private ObliczCenePoRabacie strategiaRabatu;

	public Towar(double cena, String nazwa)
	{
		this.cena=cena;
		this.nazwa=nazwa;
	}

	//operacje na cenie
	public void setCena(double cena)
	{
		this.cena=cena;
	}

	public double getCena()
	{
		return cena;
	}
	//operacje na nazwie towaru
	public String getNazwa()
	{
		return nazwa;
	}
	public void setNazwa(String nazwa)
	{
		this.nazwa=nazwa;
	}

	// operacje związane ze strategią rabatu
	public void ustawStrategieRabatu(ObliczCenePoRabacie strategiaRabatu) {
		this.strategiaRabatu = strategiaRabatu;
	}

	public double getCenaPoRabacie() {
		if (strategiaRabatu == null) {
			return cena;
		}
		return strategiaRabatu.obliczCenePoRabacie(cena);
	}
}