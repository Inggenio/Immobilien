package Programm;

public class Wohnung extends Immobilie{
	public Wohnung() {
	}

	public Wohnung(double flaeche, int zimmerN, int zimmerS, char energieKlasse, double mietPreis, double kaufPreis) {
		super(flaeche, zimmerN, zimmerS, energieKlasse, mietPreis, kaufPreis);
	}
}
