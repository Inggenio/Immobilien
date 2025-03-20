package Programm;

public class Haus extends Immobilie{
	public Haus() {
	}

	public Haus(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaeche, int zimmerN, int zimmerS, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresseStrasse, adresseNummer, adresseStadt, flaeche, zimmerN, zimmerS, energieKlasse);
	}

	public Haus(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG, double flaeche, int zimmerN, int zimmerS, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresseStrasse, adresseNummer, adresseStadt, flaecheG, flaeche, zimmerN, zimmerS, energieKlasse);
	}

	@Override
	public String toString() {
		return immoTyp.toString() +
				" " + (this.preisMK == MietKauf.Kauf? "Kauf-": "Miet-") +
				"Preis " + printPreis(preis) + "€" +
				" - Adresse: " +
				adresseStrasse + " " +
				adresseNummer + ", "+
				adresseStadt +
				" Fläche= " + flaeche + "m²" +
				" Grundstücksfläche" + flaecheG + "m²" +
				" #Zimmer= " + zimmerN +
				" #Schlafzimmer= " + zimmerS +
				" Energieklasse= " + getEnergieKlasse();
	}
}
