package Programm;

import java.util.Arrays;

/*
TODO
Objekt Grundstück,Wohnung, Grundstück + Haus, Haus
Attribute: Mietpreis, Kaufpreis, Wärmeklasse, qm
Attribute? Stöcke? Zimmern?
 */
enum MietKauf{
	Miete, Kauf;

	@Override
	public String toString() {
		return this == Miete? "Miete": "Kauf";
	}
}
public class Immobilie {
	private MietKauf preisMK;
	private double preis;

	private String adresse;
	private String adresseStrasse;
	private String adresseNummer;
	private String adresseStadt;

	private double flaecheG;
	private double flaeche;

	private int zimmerN;
	private int zimmerS;
	private char EnergieKlasse;


	//Leer Konstruktor
	public Immobilie() {
	}
	//Konstruktor: Grundstück: GrundstückFäche, Preis,
		public Immobilie(double preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG) {
		this.preisMK = MietKauf.Kauf;
		this.preis = preis;
		this.adresseStrasse = adresseStrasse;
		this.adresseNummer = adresseNummer;
		this.adresseStadt = adresseStadt;
		this.flaecheG = flaecheG;
	}
	//Konstruktor: MietKauf Haus + Grundstück: Kaufpreis, Zimmer, Energieklasse
	//Konstruktor für Adresse Getrennt
	public Immobilie(MietKauf preisMK, double preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG, double flaeche, int zimmerN, int zimmerS, char energieKlasse) {
		this.preisMK = preisMK;
		this.preis = preis;
		this.adresseStrasse = adresseStrasse;
		this.adresseNummer = adresseNummer;
		this.adresseStadt = adresseStadt;
		this.flaecheG = flaecheG;
		this.flaeche = flaeche;
		this.zimmerN = zimmerN;
		this.zimmerS = zimmerS;
		EnergieKlasse = energieKlasse;
	}

	//Konstruktor Miete/Kauf: Wohnung | Haus(ohne Grundstück)
		public Immobilie(MietKauf preisMK, double preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaeche, int zimmerN, int zimmerS, char energieKlasse) {
		this.preisMK = preisMK;
		this.preis = preis;
		this.adresseStrasse = adresseStrasse;
		this.adresseNummer = adresseNummer;
		this.adresseStadt = adresseStadt;
		this.flaeche = flaeche;
		this.zimmerN = zimmerN;
		this.zimmerS = zimmerS;
		EnergieKlasse = energieKlasse;
	}

	//Getters und Setters

	public MietKauf getPreisMK() {
		return preisMK;
	}
	public void setPreisMK(MietKauf preisMK) {
		this.preisMK = preisMK;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getAdresse() {
		return this.adresseStrasse + " " + adresseNummer.toString();
	}
	public String getAdresseStrasse() {
		return adresseStrasse;
	}
	public void setAdresseStrasse(String adresseStrasse) {
		this.adresseStrasse = adresseStrasse;
	}
	public String getAdresseNummer() {
		return adresseNummer;
	}
	public void setAdresseNummer(String adresseNummer) {
		this.adresseNummer = adresseNummer;
	}
	public String getAdresseStadt() {
		return adresseStadt;
	}
	public void setAdresseStadt(String adresseStadt) {
		this.adresseStadt = adresseStadt;
	}
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
		if(zimmerS < zimmerN - 1){
			this.zimmerS = zimmerS;
		} else {
			zimmerS = zimmerN -1;
		}

	}
	public char getEnergieKlasse() {
		return EnergieKlasse;
	}
	public void setEnergieKlasse(char energieKlasse) {
		EnergieKlasse = energieKlasse;
	}

	//To String
	@Override
	public String toString() {
		return "Adresse: " +
				adresseStrasse + " " +
				adresseNummer + ", "+
				adresseStadt +
				" || Typ=" + (this.preisMK == MietKauf.Kauf? "Kauf": "Miete")+
				" Fläche= " + flaeche +
				" #Zimmer= " + zimmerN +
				" #Schlafzimmer= " + zimmerS +
				" Energieklasse= " + getEnergieKlasse();
	}
}
