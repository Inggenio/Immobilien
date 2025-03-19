package Programm;

import java.util.ArrayList;
import java.util.Random;

/*
Class Main:
Aufrufe Menu un Programm
Erzeugung Immobilien Objekte
 */

/*
public Wohnung(MietKauf preisMK, double preis, String adresseStrasse, String adresseNummer, String adresseStadt, int adressePLZ, double flaeche, int zimmerN, int zimmerS, char energieKlasse) {

	}
 */
public class Main {

	public static void main(String[] args) {

		System.out.println(Dateien.immobilieList);
		for(int i = 0; i < 10; i++){
			ImmoGenerator generator = new ImmoGenerator();
			generator.wohnungMieteGenerator();
		}

		for (Immobilie immobilie : Dateien.immobilieList) {
			System.out.println(immobilie);
		}

	}
}
