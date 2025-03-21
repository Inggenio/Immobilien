package Programm;

public class Grundstück extends Immobilie {
	public Grundstück() {
		super();
	}

	public Grundstück(ImmoTyp immoTyp, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG) {
		super(immoTyp, preis, adresseStrasse, adresseNummer, adresseStadt, flaecheG);
	}

	@Override
	public String toString() {
		return ImmoTyp.Grundstück.toString() +
				" Kauf-Preis " + printPreis(preis) + "€" +
				"\t - Adresse: " +
				adresseStrasse + " " +
				adresseNummer + ", "+
				adresseStadt +
				" - Gründstücksfläche = " + flaecheG + "m²";

	}
}
