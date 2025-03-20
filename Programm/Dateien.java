package Programm;

import java.util.ArrayList;
import java.util.Random;

/*
Implementation Database für Immobilie Objekte Erzeugung
ImmobilieGenerator für Random Werte
 */
public class Dateien {
	public static ArrayList<Immobilie> immobilieList = new ArrayList<>();

	public static void immoAdd(){
		System.out.println("Immo Add ausgewählt");
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



	}
class ImmoGenerator {
	Random random = new Random();
	private final String[] strassen = {"Schulstrasse", "Hauptstraße", "Goethestraße", "Peronstraße", "Nestorstraße", "Hauptbahnhofstraße","Hopfenstraße","Paradisestraße"};
	private final String[] staedte = {"Augsburg","Göggingen","Friedberg","Rehling", "München", "Memmingen", "Stuttgart", "Ulm", "Regensburg", "Ingolstadt", "Bremen"};
	private final EnergieKlasse[] energieKlasse = {EnergieKlasse.A,EnergieKlasse.B,EnergieKlasse.C,EnergieKlasse.D};



	public void wohnungMieteGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];
		EnergieKlasse energie = energieKlasse[random.nextInt(energieKlasse.length)];

		MietKauf mietKauf = MietKauf.Miete; // Typ Miete
		double flaeche = 40 + random.nextInt(120); // Fläche zwischen 40 und 160 m²
		int zimmerN = 1 + random.nextInt(5); // Anzahl der Zimmer zwischen 1 und 5
		int zimmerS = 1 + random.nextInt(3); // Anzahl der Zimmer zwischen 1 und 3

		Wohnung wohnung = new Wohnung(ImmoTyp.Wohnung,mietKauf, preis, strasse, nummer, stadt, flaeche, zimmerN, zimmerS, energie);
		Dateien.immobilieList.add(wohnung);
	}

	public void wohnungKaufGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];
		EnergieKlasse energie = energieKlasse[random.nextInt(energieKlasse.length)];
		MietKauf mietKauf = MietKauf.Kauf; // Typ Miete

		double flaeche = 40 + random.nextInt(120); // Fläche zwischen 40 und 160 m²
		int zimmerN = 1 + random.nextInt(5); // Anzahl der Zimmer zwischen 1 und 5
		int zimmerS = 1 + random.nextInt(3); // Anzahl der Zimmer zwischen 1 und 3

		Wohnung wohnung = new Wohnung(ImmoTyp.Wohnung, mietKauf, preis, strasse, nummer, stadt, flaeche, zimmerN, zimmerS, energie);
		Dateien.immobilieList.add(wohnung);
	}

	public void hausKaufGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];
		EnergieKlasse energie = energieKlasse[random.nextInt(energieKlasse.length)];
		MietKauf mietKauf = MietKauf.Kauf; // Typ Miete

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
