package Programm;

/*
Class Main:
Aufrufe Menu un Programm
Erzeugung Immobilien Objekte
 */

public class Main {

	public static void main(String[] args) {

		//Wohnung Objekt
		Wohnung prueba = new Wohnung(ImmoTyp.Wohnung,MietKauf.Miete,300,"Esperanza 123","Santa Cruz",120,6, Immobilie.charToEnergieKlasse('A'));
		Dateien.immobilieList.add(prueba);

		//Generation Immo Objekte zu Prüfung
		//Objekte wird durch Dateien.immoRandomObjekte generiert. Attribute der Methode #Grundstücke, #Wohnungen #Häuser
		Dateien.immoRandomObjekte(2,2,2); // Generiert Random Immo-Objekte,

		//Ausführung des Programms
		BenutzerOberflaeche.programm();

	}
}
