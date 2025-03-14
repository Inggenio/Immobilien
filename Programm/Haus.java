package Programm;

public class Haus extends Immobilie{
	public Haus(double flaecheG, double flaeche, int zimmerN, int zimmerS, char energieKlasse, double mietPreis, double kaufPreis) {
		super(flaecheG, flaeche, zimmerN, zimmerS, energieKlasse, mietPreis, kaufPreis);
	}

	public Haus(double flaeche, int zimmerN, int zimmerS, char energieKlasse, double mietPreis, double kaufPreis) {
		super(flaeche, zimmerN, zimmerS, energieKlasse, mietPreis, kaufPreis);
	}

	public Haus() {
	}
}
