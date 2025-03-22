package Programm;

public class Grundstuck extends Immobilie {
	public Grundstuck() {
		super();
	}

	public Grundstuck(ImmoTyp immoTyp, int preis, String adresse, String stadt, int flaecheG) {
		super(immoTyp, preis, adresse, stadt, flaecheG);
	}

	@Override
	public String toString() {
		return 	"ID#" + iD + "_" +
				ImmoTyp.Grundstuck.toString() + ":" +
				" Kauf-Preis " + printPreis(preis) + "€" +
				" - Adresse: " +
				adresse + " " +
				stadt +
				" - Gründstücksfläche = " + flaecheG + "m²";
	}

}
