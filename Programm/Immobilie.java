package Programm;

/*
Immobilie Objekte Eltern-Klass
Deklarierte enums für Kauf/Miete, EnergieKlassen und Immobilien Typ.

Objekt Grundstück, Wohnung, Grundstück + Haus, Haus
Attribute: Mietpreis, Kaufpreis, Wärmeklasse, qm

 */


import java.util.Random;

enum MietKauf{
	Miete, Kauf,Unbknt;

	@Override
	public String toString() {
		return this == Miete? "Miete": "Kauf";
	}
}
enum EnergieKlasse{
	A,B,C,D,Unbknt
}
enum ImmoTyp{
	Grundstuck,
	Haus,
	Wohnung,
	Unbknt;
	@Override
	public String toString() {
		return switch (this) {
			case Haus -> "HAUS";
			case Wohnung -> "WOHNUNG";
			case Grundstuck -> "GRUNDSTÜCK";
			default -> "Unbekannt";
		};


	}
}

public class Immobilie {
	protected int iD;
	protected ImmoTyp immoTyp;
	protected MietKauf preisMK;
	protected int preis;

	protected String adresse;
	protected String stadt;

	protected int flaecheG;
	protected int flaeche;

	protected int zimmer;
	protected EnergieKlasse energieKlasse;
	protected double preisqm;


	//Leer Konstruktor
	public Immobilie() {
	}
	//Konstruktor: Grundstück: GrundstückFäche, Preis,
		public Immobilie(ImmoTyp immoTyp,int preis, String adresse, String stadt, int flaecheG) {
		this.iD = idGen.nextInt(100,999);
		this.immoTyp = immoTyp;
		this.preisMK = MietKauf.Kauf;
		this.preis = preis;
		this.adresse = adresse;
		this.stadt = stadt;
		this.flaecheG = flaecheG;
	}
	//Konstruktor: MietKauf Haus + Grundstück: Kaufpreis, Zimmer, Energieklasse
	public Immobilie(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresse, String stadt, int flaecheG, int flaeche, int zimmer, EnergieKlasse energieKlasse) {
		this.iD = idGen.nextInt(100,999);
		this.immoTyp = immoTyp;
		this.preisMK = preisMK;
		this.preis = preis;
		this.adresse = adresse;
		this.stadt = stadt;
		this.flaecheG = flaecheG;
		this.flaeche = flaeche;
		this.zimmer = zimmer;
		this.energieKlasse = energieKlasse;
	}

	//Konstruktor Miete/Kauf: Wohnung | Haus(ohne Grundstück)
		public Immobilie(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresse, String stadt, int flaeche, int zimmer, EnergieKlasse energieKlasse) {
		this.iD = idGen.nextInt(100,999);
		this.immoTyp = immoTyp;
		this.preisMK = preisMK;
		this.preis = preis;
		this.adresse = adresse;
		this.stadt = stadt;
		this.flaeche = flaeche;
		this.zimmer = zimmer;
		this.energieKlasse = energieKlasse;
	}

	//Getters und Setters
	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public ImmoTyp getImmoTyp() {
		return immoTyp;
	}
	public void setImmoTyp(ImmoTyp immoTyp) {
		this.immoTyp = immoTyp;
	}
	public MietKauf getPreisMK() {
		return preisMK;
	}
	public void setPreisMK(MietKauf preisMK) {
		this.preisMK = preisMK;
	}
	public int getPreis() {
		return preis;
	}
	public void setPreis(int preis) {
		this.preis = preis;
	}
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getStadt() {
		return stadt;
	}
	public void setStadt(String stadt) {
		this.stadt = stadt;
	}
	public double getFlaecheG() {
		return flaecheG;
	}
	public void setFlaecheG(int flaecheG) {
		this.flaecheG = flaecheG;
	}
	public double getFlaeche() {
		return flaeche;
	}
	public void setFlaeche(int flaeche) {
		this.flaeche = flaeche;
	}
	public int getZimmer() {
		return zimmer;
	}
	public void setZimmer(int zimmer) {
		if(zimmer >=0 ){
			this.zimmer = zimmer;	
		}
		System.out.println("Es gab ein Fehler");
		
	}

	//Methoden
	Random idGen = new Random();

	public EnergieKlasse getEnergieKlasse() {
		return energieKlasse;
	}

	public void setEnergieKlasse(EnergieKlasse energieKlasse) {
		this.energieKlasse = energieKlasse;
	}

	public double getPreisqm() {
		return preisqm;
	}

	public void setPreisqm(double preisqm) {
		if (immoTyp == ImmoTyp.Grundstuck){
			this.preisqm = (double) preis/flaecheG;
		}
		this.preisqm = (double) preis /flaeche;
	}

	public static EnergieKlasse charToEnergieKlasse(char energieKlasse) {
		return switch (energieKlasse) {
			case 'A','a' -> EnergieKlasse.A;
			case 'B','b' -> EnergieKlasse.B;
			case 'C','c' -> EnergieKlasse.C;
			case 'D','d' -> EnergieKlasse.D;

			default -> EnergieKlasse.Unbknt;
		};
	}
	public static MietKauf charToMietKauf(String mietkauf) {
		if(mietkauf.equalsIgnoreCase("M")){
			return MietKauf.Miete;
		} else if (mietkauf.equalsIgnoreCase("K")) {
			return MietKauf.Kauf;
		}
		return MietKauf.Unbknt;
	}


	public String printPreis(int precio) {
		if (precio < 1000) {
			return String.valueOf(precio);
		} else if (precio <= 99_999) {
			return String.valueOf(precio/1000) + "." + precio % 1000;
		} else {
			return String.valueOf(precio/1000) + "." + precio % 1000;
		}
	}


	//To String
	@Override
	public String toString() {
		return "Adresse: " +
				adresse + " " +
				stadt +
				" <| Typ=" + (this.preisMK == MietKauf.Kauf? "Kauf": "Miete") +
				" Preis " + printPreis(preis) + "€" +
				"|> Fläche= " + flaeche +
				" #Zimmer= " + zimmer +
				" Energieklasse= " + getEnergieKlasse();
	}
}
