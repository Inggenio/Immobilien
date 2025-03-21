package Programm;

public class Haus extends Immobilie{
	public Haus() {
	}
	//Konstruktor für Haus/Mieten (Ohne Grundstücksfläche)
	public Haus(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaeche, int zimmerN, int zimmerS, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresseStrasse, adresseNummer, adresseStadt, flaeche, zimmerN, zimmerS, energieKlasse);
	}
	//Konstruktor für Haus/Mieten (Mit Grundstücksfläche)
	public Haus(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG, double flaeche, int zimmerN, int zimmerS, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresseStrasse, adresseNummer, adresseStadt, flaecheG, flaeche, zimmerN, zimmerS, energieKlasse);
	}

	@Override
	public String toString() {
		return immoTyp.toString() +
				" " + (this.preisMK == MietKauf.Kauf? "Kauf-": "Miet-") +
				"\tPreis " + printPreis(preis) + "€" +
				" - Adresse: " +
				adresseStrasse + " " +
				adresseNummer + ", "+
				adresseStadt +
				" - Fläche= " + flaeche + flaecheG + "m²" +
				" - #Zimmer= " + zimmerN +
				" #Schlafzimmer= " + zimmerS +
				" - Energieklasse= " + getEnergieKlasse();
	}
}
