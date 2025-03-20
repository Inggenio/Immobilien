package Programm;

import java.util.Scanner;

/*
Menus
 */
public class BenutzerOberflaeche {

	public static void programm(){
		Scanner console = new Scanner(System.in);
		boolean programm = true;
		while(programm){
			hallo();
			int option = console.nextInt();
			console.nextLine();
			switch (option){
				case 1:
					Dateien.immoAdd();
					break;
				case 2:
					Dateien.immoLosch();
					break;
				case 3:
					System.out.println("Immo Objekte Ausdrucken");
					Dateien.printList();
					break;
				case 4:
					Dateien.filtern();
					break;
				case 5:
					programm = false;
					System.out.println("Programm beendet.");
					break;
				default:
					System.out.println("Falsche Option");

			}
		}
		console.close();
	}
	public static void header(){
		System.out.println("********** IMMO Commander 25 **********");
	}



	public static void hallo(){
		System.out.println("""
				********** IMMO Commander 25 **********
				Wählen Sie eine Option aus:
				    1. Immo-Objekt hinzufügen
				    2. Immo-Objekt löschen
				    3. Immo-Liste ausdrucken
				    4. Immo-Liste filtern
				    5. EXIT
				""");
	}
}
