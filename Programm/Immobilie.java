package Programm;
/*
TODO
Objekt Grundstück,Wohnung, Grundstück + Haus, Haus
Attribute: Mietpreis, Kaufpreis, Wärmeklasse, qm
Attribute? Stöcke? Zimmern?
 */
public class Immobilie {
	private double flaecheG;
	private double flaeche;

	private int zimmerN;
	private int zimmerS;
	private char EnergieKlasse;
	private double mietPreis;
	private double kaufPreis;

	//Leer Konstruktor
	public Immobilie() {
	}
	//Komplett Konstruktor (Haus + Grundstück)
	public Immobilie(double flaecheG, double flaeche, int zimmerN, int zimmerS, char energieKlasse, double mietPreis, double kaufPreis) {
		this.flaecheG = flaecheG;
		this.flaeche = flaeche;
		this.zimmerN = zimmerN;
		this.zimmerS = zimmerS;
		EnergieKlasse = energieKlasse;
		this.mietPreis = mietPreis;
		this.kaufPreis = kaufPreis;
	}
	//Konstruktor für Grundstück
	public Immobilie(double flaecheG, double kaufPreis) {
		this.flaecheG = flaecheG;
		this.kaufPreis = kaufPreis;
	}

	//Konstruktor Wohnung oder Haus
	public Immobilie(double flaeche, int zimmerN, int zimmerS, char energieKlasse, double mietPreis, double kaufPreis) {
		this.flaeche = flaeche;
		this.zimmerN = zimmerN;
		this.zimmerS = zimmerS;
		EnergieKlasse = energieKlasse;
		this.mietPreis = mietPreis;
		this.kaufPreis = kaufPreis;
	}

	//Getters und Setters
	public double getFlaecheG() {
		return flaecheG;
	}

	public void setFlaecheG(double flaecheG) {
		this.flaecheG = flaecheG;
	}

	public double getFlaeche() {
		return flaeche;
	}

	public void setFlaeche(double flaeche) {
		this.flaeche = flaeche;
	}

	public int getZimmerN() {
		return zimmerN;
	}

	public void setZimmerN(int zimmerN) {
		this.zimmerN = zimmerN;
	}

	public int getZimmerS() {
		return zimmerS;
	}

	public void setZimmerS(int zimmerS) {
		this.zimmerS = zimmerS;
	}

	public char getEnergieKlasse() {
		return EnergieKlasse;
	}

	public void setEnergieKlasse(char energieKlasse) {
		EnergieKlasse = energieKlasse;
	}

	public double getMietPreis() {
		return mietPreis;
	}

	public void setMietPreis(double mietPreis) {
		this.mietPreis = mietPreis;
	}

	public double getKaufPreis() {
		return kaufPreis;
	}

	public void setKaufPreis(double kaufPreis) {
		this.kaufPreis = kaufPreis;
	}
}
