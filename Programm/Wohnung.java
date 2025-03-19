package Programm;

public class Wohnung extends Immobilie{
	public Wohnung() {
	}

	public Wohnung(MietKauf preisMK, double preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaeche, int zimmerN, int zimmerS, char energieKlasse) {
		super(preisMK, preis, adresseStrasse, adresseNummer, adresseStadt, flaeche, zimmerN, zimmerS, energieKlasse);
	}
}
