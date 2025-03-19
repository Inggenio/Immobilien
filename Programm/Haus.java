package Programm;

public class Haus extends Immobilie{
	public Haus() {
	}

	public Haus(MietKauf preisMK, double preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG, double flaeche, int zimmerN, int zimmerS, char energieKlasse) {
		super(preisMK, preis, adresseStrasse, adresseNummer, adresseStadt, flaecheG, flaeche, zimmerN, zimmerS, energieKlasse);
	}
}
