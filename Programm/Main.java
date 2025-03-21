package Programm;

import java.util.ArrayList;
import java.util.Random;

/*
Class Main:
Aufrufe Menu un Programm
Erzeugung Immobilien Objekte
 */

public class Main {

	public static void main(String[] args) {

		Wohnung prueba = new Wohnung(ImmoTyp.Wohnung,MietKauf.Miete,300,"Nestor Kirchner","123","Santa Cruz",120.00,6,3, Immobilie.charToEnergieKlasse('A'));
		//Generation Immo Objekte zu Prüfung
		Dateien.immoRandomObjekte(2,2,10); // Generiert Random Immo-Objekte

		//Ausführung des Programms
		BenutzerOberflaeche.programm();


	}
}
