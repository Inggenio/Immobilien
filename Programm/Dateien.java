package Programm;

import java.util.ArrayList;
import java.util.Random;

/*
Implementation Database für Immobilie Objekte Erzeugung
ImmobilieGenerator für Random Werte
 */
public class Dateien {
	public static ArrayList<Immobilie> immobilieList = new ArrayList<>();


	}
class ImmoGenerator {
	Random random = new Random();
	private String[] strassen = {"Schulstrasse", "Hauptstraße", "Goethestraße", "Peronstraße", "Nestorstraße", "Hauptbahnhofstraße","Hopfenstraße","Paradisestraße"};
	private String[] staedte = {"Augsburg","Göggingen","Friedberg","Rehling", "München", "Memmingen", "Stuttgart", "Ulm", "Regensburg", "Ingolstadt", "Bremen"};
	private char[] energieKlasse = {'A','B','C','D'};

	public void wohnungMieteGenerator() {
		MietKauf mietKauf = MietKauf.Miete; // Typ Miete
		double preis = random.nextDouble(300.00, 2400.00);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];

		double flaeche = 40 + random.nextInt(120); // Fläche zwischen 40 y 160 m²
		int zimmerN = 1 + random.nextInt(5); // Anzahl der Zimmer zwischen 1 y 5
		int zimmerS = 1 + random.nextInt(3); // Anzahl der Zimmer zwischen 1 y 3

		char energie = energieKlasse[ random.nextInt(energieKlasse.length)];


		Wohnung wohnung = new Wohnung(mietKauf, preis, strasse, nummer, stadt, flaeche, zimmerN, zimmerS, energie);
		Dateien.immobilieList.add(wohnung);
	}

	public void wohnungKaufGenerator(){

	}


}
