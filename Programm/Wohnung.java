package Programm;

public class Wohnung extends Immobilie{
	public Wohnung() {
	}

	public Wohnung(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresse,  String stadt, int flaeche, int zimmer, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresse, stadt, flaeche, zimmer, energieKlasse);
	}


	@Override
	public String toString() {
		return 	"ID#" + iD + "_" +
				immoTyp.toString() + ": " +
				(this.preisMK == MietKauf.Kauf? "Kauf-": "Miet-") +
				"Preis " + printPreis(preis) + "€" +
				" - Adresse: " +
				adresse + " " +
				stadt +
				" - Fläche= " + flaeche + "m²" +
				" - #Zimmer= " + zimmer +
				" - Energieklasse= " + getEnergieKlasse();

	}
}
