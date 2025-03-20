package Programm;

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
enum EnergieKlasse{
	A,B,C,D
}
enum ImmoTyp{
	Grundstück,
	Haus,
	Wohnung;
	@Override
	public String toString() {
		switch (this){
			case Haus:
				return "HAUS";
			case Wohnung:
				return "WOHNUNG";
			case Grundstück:
				return "GRUNDSTÜCK";
			default:
				return "Unbekannt";
		}


	}
}

public class Immobilie {
	protected ImmoTyp immoTyp;
	protected MietKauf preisMK;
	protected int preis;

	protected String adresse;
	protected String adresseStrasse;
	protected String adresseNummer;
	protected String adresseStadt;

	protected double flaecheG;
	protected double flaeche;

	protected int zimmerN;
	protected int zimmerS;
	protected EnergieKlasse energieKlasse;


	//Leer Konstruktor
	public Immobilie() {
	}
	//Konstruktor: Grundstück: GrundstückFäche, Preis,
		public Immobilie(ImmoTyp immoTyp,int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG) {
		this.immoTyp = immoTyp;
		this.preisMK = MietKauf.Kauf;
		this.preis = preis;
		this.adresseStrasse = adresseStrasse;
		this.adresseNummer = adresseNummer;
		this.adresseStadt = adresseStadt;
		this.flaecheG = flaecheG;
	}
	//Konstruktor: MietKauf Haus + Grundstück: Kaufpreis, Zimmer, Energieklasse
	public Immobilie(ImmoTyp immoTyp,MietKauf preisMK, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaecheG, double flaeche, int zimmerN, int zimmerS, EnergieKlasse energieKlasse) {
		this.immoTyp = immoTyp;
		this.preisMK = preisMK;
		this.preis = preis;
		this.adresseStrasse = adresseStrasse;
		this.adresseNummer = adresseNummer;
		this.adresseStadt = adresseStadt;
		this.flaecheG = flaecheG;
		this.flaeche = flaeche;
		this.zimmerN = zimmerN;
		this.zimmerS = zimmerS;
		this.energieKlasse = energieKlasse;
	}

	//Konstruktor Miete/Kauf: Wohnung | Haus(ohne Grundstück)
		public Immobilie(ImmoTyp immoTyp, MietKauf preisMK, int preis, String adresseStrasse, String adresseNummer, String adresseStadt, double flaeche, int zimmerN, int zimmerS, EnergieKlasse energieKlasse) {
		this.immoTyp = immoTyp;
		this.preisMK = preisMK;
		this.preis = preis;
		this.adresseStrasse = adresseStrasse;
		this.adresseNummer = adresseNummer;
		this.adresseStadt = adresseStadt;
		this.flaeche = flaeche;
		this.zimmerN = zimmerN;
		this.zimmerS = zimmerS;
		this.energieKlasse = energieKlasse;
	}

	//Getters und Setters
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

	public EnergieKlasse getEnergieKlasse() {
		return energieKlasse;
	}

	public void setEnergieKlasse(EnergieKlasse energieKlasse) {
		this.energieKlasse = energieKlasse;
	}

	public String printPreis(int precio) {
		if (precio < 1000) {
			return String.valueOf(precio);
		} else if (precio <= 99_999) {
			return String.valueOf(precio/1000) + "." + java.lang.String.valueOf(precio%1000);
		} else {
			return String.valueOf(precio/1000) + "." + java.lang.String.valueOf(precio%1000);
		}
	}


	//To String
	@Override
	public String toString() {
		return "Adresse: " +
				adresseStrasse + " " +
				adresseNummer + ", "+
				adresseStadt +
				" <| Typ=" + (this.preisMK == MietKauf.Kauf? "Kauf": "Miete") +
				" Preis " + printPreis(preis) + "€" +
				"|> Fläche= " + flaeche +
				" #Zimmer= " + zimmerN +
				" #Schlafzimmer= " + zimmerS +
				" Energieklasse= " + getEnergieKlasse();
	}
}
