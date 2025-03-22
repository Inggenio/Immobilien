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

	//Sorters:


	//Methode
	//Immo Objekte durch Benutzer Oberfläche hinzufügen


	public static void printList(){
		 //Immo Liste Ausdrücken
		for (Immobilie immobilie : Dateien.immobilieList) {
			System.out.println(immobilie);
		}

	}

	public static void immoRandomObjekte(int grundstucke, int wohnungen, int hauser){
		for(int i = 0; i < grundstucke; i++){
			ImmoGenerator generator = new ImmoGenerator();
			generator.grundstückKaufGenerator();
		}
		for(int i = 0; i < wohnungen; i++){
			ImmoGenerator generator = new ImmoGenerator();
			generator.wohnungGenerator();
		}
		for(int i = 0; i < hauser; i++){
			ImmoGenerator generator = new ImmoGenerator();
			generator.hausGenerator();
		}


	}

	}
class ImmoGenerator {
	Random random = new Random();

	//Data Feed Random
	private final String[] strassen = {"Schulstrasse", "Hauptstraße", "Goethestraße", "Hoffnungstraße", "Kavalierstraße","Romanische Straße", "Hauptbahnhofstraße","Hopfenstraße","Paradisestraße","Rathausplatzstraße","Willy-Bradt"};
	private final String[] staedte = {"Augsburg","Göggingen","Friedberg","Rehling", "München", "Memmingen", "Stuttgart", "Ulm", "Regensburg", "Ingolstadt", "Bremen"};
	private final EnergieKlasse[] energieKlasse = {EnergieKlasse.A,EnergieKlasse.B,EnergieKlasse.C,EnergieKlasse.D};
	private final MietKauf[] mietkauf = {MietKauf.Miete, MietKauf.Kauf};

	//Random Variabel
	MietKauf mietKauf = mietkauf[random.nextInt(2)];
	EnergieKlasse energie = energieKlasse[random.nextInt(energieKlasse.length)];

	//Generator Random-Immo-Objekte
	public void wohnungGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String adresse = strasse + " " + nummer;
		String stadt = staedte[ random.nextInt(staedte.length)];


		int flaeche = 40 + random.nextInt(25,160); // Fläche zwischen 25 und 160 m²
		int zimmer = 1 + random.nextInt(7); // Anzahl der Zimmer zwischen 1 und 7


		Wohnung wohnung = new Wohnung(ImmoTyp.Wohnung,mietKauf, preis, adresse, stadt, flaeche, zimmer,energie);
		Dateien.immobilieList.add(wohnung);
	}
	public void hausGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(75));
		String adresse = strasse + " " + nummer;
		String stadt = staedte[ random.nextInt(staedte.length)];

		int flaeche = random.nextInt(35,120); // Fläche zwischen 40 y 160 m²
		int flaecheG = flaeche + random.nextInt(250); // Gründstücks Fläche zwischen HausFläche und 250 m²
		int zimmer = random.nextInt(1,7); // Anzahl der Zimmer zwischen 1 y 5

		Haus haus = new Haus(ImmoTyp.Haus, mietKauf, preis, adresse, stadt, flaecheG, flaeche, zimmer, energie);
		Dateien.immobilieList.add(haus);
	}
	public void grundstückKaufGenerator() {
		int preis = random.nextInt(300, 2400);
		String strasse = strassen[ random.nextInt(strassen.length)];
		String nummer = String.valueOf(random.nextInt(50));
		String stadt = staedte[ random.nextInt(staedte.length)];
		String adresse = strasse + " " + nummer;

		int flaecheG = random.nextInt(100,1000); // Gründstücks Fläche zwischen HausFläche und 250 m²

		Grundstuck grundstuck = new Grundstuck(ImmoTyp.Grundstuck,preis, adresse, stadt, flaecheG);
		Dateien.immobilieList.add(grundstuck);
	}



}
