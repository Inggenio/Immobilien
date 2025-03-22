package Programm;

public class Haus extends Immobilie{
	public Haus() {
	}
	//Konstruktor für Haus/Mieten (Ohne Grundstücksfläche)
	public Haus(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresse, String stadt, int flaeche, int zimmer, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresse, stadt, flaeche, zimmer,energieKlasse);
	}
	//Konstruktor für Haus/Mieten (Mit Grundstücksfläche)
	public Haus(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresse, String adresseStadt, int flaecheG, int flaeche, int zimmer, EnergieKlasse energieKlasse) {
		super(immoTyp, preisMK, preis, adresse, adresseStadt, flaecheG, flaeche, zimmer,energieKlasse);
	}

	@Override
	public String toString() {
		return 	"ID#" + iD + "_" +
				immoTyp.toString() + ":" +
				" " + (this.preisMK == MietKauf.Kauf? "Kauf-": "Miet-") +
				"Preis " + printPreis(preis) + "€" +
				" - Adresse: " +
				adresse + " " +
				stadt +
				" - Fläche= " + flaeche +
				" GrundstückF= " + flaecheG + "m²" +
				" - #Zimmer= " + zimmer +
				" - Energieklasse= " + getEnergieKlasse();
	}
}
