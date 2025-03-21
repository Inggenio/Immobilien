package Programm;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
Implementation Database für Immobilie Objekte Erzeugung
ImmobilieGenerator für Random Werte
 */
public class Dateien {

	//Definition Immobilie-Objekte Liste
	public static ArrayList<Immobilie> immobilieList = new ArrayList<>();

	//Methode
	public static void immoAdd(){
		Scanner immoAdd = new Scanner(System.in);
		boolean run = true;
		System.out.println("Immo-Add ausgewählt");
		System.out.print("Was wollen Sie hinzufügen: [G]rundstück, [H]aus, [W]ohnung ?");
		String immoTyp = immoAdd.nextLine().toUpperCase();
		System.out.print("Für [M]ieten oder Ver[K]aufen ?");
		String mietKauf = String.valueOf(immoAdd.nextLine().toLowerCase().charAt(0));
		MietKauf constMietKauf = Immobilie.charToMietKauf(mietKauf);

		System.out.print("Fügen Sie einen Preis hinzu: (€)");
		int preis = immoAdd.nextInt();
		immoAdd.nextLine();

		System.out.print("Adresse: Straße - ");
		String strasse = immoAdd.nextLine();

		System.out.print("Adresse: Hausnummer - ");
		String nummer = immoAdd.nextLine();

		System.out.print("Adresse: Stadt - ");
		String stadt = immoAdd.nextLine();

		System.out.print("Fläche [m²]-");
		int flaeche = immoAdd.nextInt();

		System.out.print("Grundtücksfläche [m²]-");
		int flaecheG = immoAdd.nextInt();

		System.out.print("Anzahl der Zimmer -");
		int zimmerN = immoAdd.nextInt();

		System.out.print("Anzahl der Schlaf-Zimmer -");
		int zimmerS = immoAdd.nextInt();
		immoAdd.nextLine();

		System.out.print("EnergieKlasse -");
		char energie = immoAdd.nextLine().charAt(0);

		EnergieKlasse energieK = Immobilie.charToEnergieKlasse(energie);

		System.out.println("Wollen Sie mit diesen Werten das Immo-Objekt hinzufügen?");
		System.out.println("ImmoTyp: " + immoTyp);
		System.out.println("Miete/Kauf?: " + (mietKauf.equals("m") ? "Mieten" : "Kaufen"));
		System.out.println("Preis: " + preis);
		System.out.println("Straße: " + strasse);
		System.out.println("Nummer: " + nummer);
		System.out.println("Stadt: " + stadt);
		System.out.println("Fläche: " + flaeche);
		if (immoTyp.equals("H") && constMietKauf.equals(MietKauf.Kauf)) {
			System.out.println("Grundstücksfläche: " + flaecheG);
		}
		System.out.println("#Zimmer: " + zimmerN);
		System.out.println("#Schlafzimmer: " + zimmerS);
		System.out.println("Energieklasse: " + energieK);
		System.out.println("Fortsetzen? [J]a , [N]ein");
		String option2 = immoAdd.nextLine().toLowerCase();

		int vorherSize = immobilieList.size();

		if (option2.equalsIgnoreCase("j")){
			if(immoTyp.equalsIgnoreCase("W")){
				immobilieList.add(new Wohnung(ImmoTyp.Wohnung,constMietKauf, preis, strasse, nummer, stadt, flaeche, zimmerN, zimmerS, energieK));
			} else if (immoTyp.equalsIgnoreCase("G")){
				immobilieList.add(new Grundstück(ImmoTyp.Grundstück,preis,strasse, nummer, stadt,flaeche));
			} else if (immoTyp.equalsIgnoreCase("H") || constMietKauf.equals("m")) {
				immobilieList.add(new Haus(ImmoTyp.Haus,constMietKauf, preis, strasse,nummer,stadt,flaeche,zimmerN,zimmerS,energieK));
			}  else if (immoTyp.equalsIgnoreCase("H") && constMietKauf.equals("k")) {
				immobilieList.add(new Haus(ImmoTyp.Haus, constMietKauf, preis, strasse, nummer, stadt, flaeche, flaecheG, zimmerN, zimmerS, energieK));
			} else{
				System.out.println("Es gab ein Fehler");
			}
		}

		if (immobilieList.size() > vorherSize){
			System.out.println("Immobilie Objekt wurde erfolgreich hinzugefügt");
		} else{
			System.out.println("Fehler beim Hinzufügen der Immobilie - Versuchen bitte Sie nochmals");
		}

	}

	private static void addWhohnung() {
		//Wohnung wohnung = new Wohnung(ImmoTyp.Wohnung,mietKauf, preis, strasse, nummer, stadt, flaeche, zimmerN, zimmerS, energie);
	}

	public static  void immoLosch(){
		System.out.println("Immo Losch ausgewählt\nFiltern Kriteria:");

		//immobilieList.remove();
	}
	public static void printList(){
		 //Immo Liste Ausdrücken
		for (Immobilie immobilie : Dateien.immobilieList) {
			System.out.println(immobilie);
		}

	}
	public static void filtern(){
		System.out.println("Filtern Implementieren");


	}


	public static void immoRandomObjekte(int grundstücke, int wohnungen, int häuser){
		for(int i = 0; i < grundstücke; i++){
			ImmoGenerator generator = new ImmoGenerator();
			generator.grundstückKaufGenerator();
		}
		for(int i = 0; i < wohnungen; i++){
			ImmoGenerator generator = new ImmoGenerator();
			generator.wohnungGenerator();
		}
		for(int i = 0; i < häuser; i++){
			ImmoGenerator generator = new ImmoGenerator();
			generator.hausGenerator();
		}


	}


	}
class ImmoGenerator {
	Random random = new Random();

	//Data Feed Random
	private final String[] strassen = {"Schulstrasse", "Hauptstraße", "Goethestraße", "Peronstraße", "Nestorstraße", "Hauptbahnhofstraße","Hopfenstraße","Paradisestraße"};
	private final String[] staedte = {"Augsburg","Göggingen","Friedberg","Rehling", "München", "Memmingen", "Stuttgart", "Ulm", "Regensburg", "Ingolstadt", "Bremen"};
	private final EnergieKlasse[] energieKlasse = {EnergieKlasse.A,EnergieKlasse.B,EnergieKlasse.C,EnergieKlasse.D};
	private final MietKauf[] mietkauf = {MietKauf.Miete, MietKauf.Kauf};

	//Random Variabel
	MietKauf mietKauf = mietkauf[random.nextInt(2)];
	EnergieKlasse energie = energieKlasse[random.nextInt(energieKlasse.length)];

	public void wohnungGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];


		double flaeche = 40 + random.nextInt(120); // Fläche zwischen 40 und 160 m²
		int zimmerN = 1 + random.nextInt(5); // Anzahl der Zimmer zwischen 1 und 5
		int zimmerS = 1 + random.nextInt(3); // Anzahl der Zimmer zwischen 1 und 3

		Wohnung wohnung = new Wohnung(ImmoTyp.Wohnung,mietKauf, preis, strasse, nummer, stadt, flaeche, zimmerN, zimmerS, energie);
		Dateien.immobilieList.add(wohnung);
	}

	public void hausGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];

		double flaeche = 40 + random.nextInt(120); // Fläche zwischen 40 y 160 m²
		double flaecheG = flaeche + random.nextInt(250); // Gründstücks Fläche zwischen HausFläche und 250 m²
		int zimmerN = 1 + random.nextInt(5); // Anzahl der Zimmer zwischen 1 y 5
		int zimmerS = 1 + random.nextInt(3); // Anzahl der Zimmer zwischen 1 y 3

		Haus haus = new Haus(ImmoTyp.Haus, mietKauf, preis, strasse, nummer, stadt, flaecheG, flaeche, zimmerN, zimmerS, energie);
		Dateien.immobilieList.add(haus);
	}

	public void grundstückKaufGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];

		double flaecheG = Math.round(random.nextDouble(1000.00)); // Gründstücks Fläche zwischen HausFläche und 250 m²

		Grundstück grundstück = new Grundstück(ImmoTyp.Grundstück,preis, strasse, nummer, stadt, flaecheG);
		Dateien.immobilieList.add(grundstück);
	}





}
