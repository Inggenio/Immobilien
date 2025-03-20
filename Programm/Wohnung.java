package Programm;

public class Wohnung extends Immobilie{
	public Wohnung() {
	}

	public Wohnung(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaeche, int zimmerN, int zimmerS, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresseStrasse, adresseNummer, adresseStadt, flaeche, zimmerN, zimmerS, energieKlasse);
	}

	@Override
	public String toString() {
		return immoTyp.toString() +
				(this.preisMK == MietKauf.Kauf? "Kauf-": "Miet-") +
				" Preis " + printPreis(preis) + "€" +
				" - Adresse: " +
				adresseStrasse + " " +
				adresseNummer + ", "+
				adresseStadt +
				" Fläche= " + flaeche + "m²" +
				" #Zimmer= " + zimmerN +
				" #Schlafzimmer= " + zimmerS +
				" Energieklasse= " + getEnergieKlasse();

	}
}
