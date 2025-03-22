package Programm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Menus
 */
public class BenutzerOberflaeche {

	public static void programm(){
		Scanner console = new Scanner(System.in);
		boolean programm = true;
		while(programm){
			hallo();
			System.out.println("Option wählen: ");


			if (!console.hasNextInt()) {
				System.out.println("Ungültige Eingabe! Bitte eine Nummer eingeben.");
				console.nextLine();
				continue;
			}

			int option = console.nextInt();
			console.nextLine();
			/*
			 		0. Immo-Liste ausdrucken
				    1. Immo-Liste nach Kriterien Sortieren
				    2. Immo-Objekte Filtern
				    3. Immo-Objekt hinzufügen
				    4. Immo-Objekt löschen
				    5. EXIT
			 */
			switch (option){
				case 0:
					System.out.println("Immo Objekte Ausdrucken");
					Dateien.printList();
					break;
				case 1:
					header();
					sortieren();
					break;
				case 2:
					header();
					filtern();
				case 3:
					header();
					immoAdd();
					break;
				case 4:
					immoLosch();
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
	public static void filtern(){
		boolean filtern = true;
		Scanner filterLoopConsole = new Scanner(System.in);
		ArrayList<Immobilie> filterteList = new ArrayList<>(Dateien.immobilieList);


		while (filtern){
			System.out.println("""
					Wählen Sie ein Option aus:
					0- Gefilterte Liste Ausdrucken
					1-Filter nach ImmoTyp
					2-Filter nach Preis Bereich
					3-Filter nach Fläche
					4-Filtern nach EnergieKlasse
					5-Exit option und zurück zum Hauptmenü"""
			);

			int option = filterLoopConsole.nextInt();
			filterLoopConsole.nextLine();

			switch (option) {
				case 0:
					filterteList.forEach(System.out::println);
					break;
				case 1:
					filternImmoTyp();
					break;
				case 2:
					filternPreis();
					break;
				case 3:
					filternFlaeche();
					break;
				case 4:
					filterEnergieKlasse();
					break;
				case 5:
					filtern = false;
					break;
				default:
					System.out.println("Ungültige Option. Bitte erneut versuchen.");
					break;
			}
			filterLoopConsole.nextLine();
		}
		filterLoopConsole.nextLine();
	}


	//Filter Methoden
	public static void filternImmoTyp(){
		boolean filterLoop = true;
		Scanner filterTypConsole = new Scanner(System.in);
		ArrayList<Immobilie> filterteList = new ArrayList<>(Dateien.immobilieList);


		while (filterLoop){
			System.out.println("""
					Wählen Sie ein Option aus:
					0-Gefilterte Liste Ausdrucken
					1-Filter nach ImmoTyp Haus
					2-Filter nach ImmoTyp Wohnung
					3-Filter nach ImmoTyp Grundstück
					4-Exit option und zurück zum Hauptmenü"""
			);

			int option = filterTypConsole.nextInt();
			filterTypConsole.nextLine();

			switch (option) {
				case 0:
					filterteList.forEach(System.out::println);
					break;
				case 1:
					filterteList = new ArrayList<>(Dateien.immobilieList);
					ImmoTyp immoTypFilterH = ImmoTyp.Haus;
					filterteList = filterteList.stream()
							.filter(immo ->immo.getImmoTyp().equals(immoTypFilterH))
							.collect(Collectors.toCollection(ArrayList::new));
					break;
				case 2:
					filterteList = new ArrayList<>(Dateien.immobilieList);
					ImmoTyp immoTypFilterW = ImmoTyp.Wohnung;
					filterteList = filterteList.stream()
							.filter(immo ->immo.getImmoTyp().equals(immoTypFilterW))
							.collect(Collectors.toCollection(ArrayList::new));
					break;
				case 3:
					filterteList = new ArrayList<>(Dateien.immobilieList);
					ImmoTyp immoTypFilterG = ImmoTyp.Grundstuck;
					filterteList = filterteList.stream()
							.filter(immo ->immo.getImmoTyp().equals(immoTypFilterG))
							.collect(Collectors.toCollection(ArrayList::new));
					break;
				case 4:
					filterLoop = false;
					break;
				default:
					System.out.println("Ungültige Option. Bitte erneut versuchen.");
					break;
			}
			filterTypConsole.nextLine();
		}

	}

	public static void filternPreis(){
		boolean filterLoop = true;
		Scanner filterLoopConsole = new Scanner(System.in);
		ArrayList<Immobilie> filterteList = new ArrayList<>(Dateien.immobilieList);
		int untergrenze = 0;
		int obergrenze = 1000;

		System.out.println("Untergrenze:" + untergrenze );
		System.out.println("Obergrenze:" + obergrenze );

		System.out.println("Geben Sie eine neue Untergrenze ein:");
		untergrenze = filterLoopConsole.nextInt();
		filterLoopConsole.nextLine();

		System.out.println("Geben Sie eine neue Obergrenze ein:");
		obergrenze = filterLoopConsole.nextInt();
		filterLoopConsole.nextLine();


		int finalUntergrenze = untergrenze;
		int finalObergrenze = obergrenze;

					filterteList = filterteList.stream()
							.filter(immo -> immo.getPreis() >= finalUntergrenze && immo.getPreis() <= finalObergrenze)
							.collect(Collectors.toCollection(ArrayList::new));
					System.out.println("Filter Erfolgreich");

		filterLoopConsole.nextLine();

		while (filterLoop){

			System.out.println("""
					Filter nach Preis
					0 - Gefilterte Liste ausdrucken
					1-Exit option und zurück zum Hauptmenü"""
			);
			int option = filterLoopConsole.nextInt();
			filterLoopConsole.nextLine();
			switch (option) {
				case 0:
					filterteList.forEach(System.out::println);
					break;
				case 1:
					filterLoop = false;
					break;
				default:
					System.out.println("Ungültige Option. Bitte erneut versuchen.");
					break;
			}
			filterLoopConsole.nextLine();
		}
	}

	public static void filternFlaeche(){
		boolean filterLoop = true;
		Scanner filterLoopConsole = new Scanner(System.in);
		ArrayList<Immobilie> filterteList = new ArrayList<>(Dateien.immobilieList);
		int untergrenze = 0;
		int obergrenze = 100;

		System.out.println("Fläche Untergrenze:" + untergrenze );
		System.out.println("Fläche Obergrenze:" + obergrenze );

		System.out.println("Geben Sie eine neue Untergrenze ein:");
		untergrenze = filterLoopConsole.nextInt();
		filterLoopConsole.nextLine();

		System.out.println("Geben Sie eine neue Obergrenze ein:");
		obergrenze = filterLoopConsole.nextInt();
		filterLoopConsole.nextLine();


		int finalUntergrenze = untergrenze;
		int finalObergrenze = obergrenze;

		filterteList = filterteList.stream()
				.filter(immo -> immo.getPreis() >= finalUntergrenze && immo.getFlaeche() <= finalObergrenze)
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Filter Erfolgreich");

		filterLoopConsole.nextLine();

		while (filterLoop){

			System.out.println("""
					Filter nach Preis
					0- Gefilterte Liste ausdrucken
					1- Exit option und zurück zum Hauptmenü"""
			);
			int option = filterLoopConsole.nextInt();
			filterLoopConsole.nextLine();
			switch (option) {
				case 0:
					filterteList.forEach(System.out::println);
					break;
				case 1:
					filterLoop = false;
					break;
				default:
					System.out.println("Ungültige Option. Bitte erneut versuchen.");
					break;
			}
		}
		filterLoopConsole.nextLine();
	}

	public static void filterEnergieKlasse(){
		boolean filterLoop = true;
		Scanner filterLoopConsole = new Scanner(System.in);
		ArrayList<Immobilie> filterteList = new ArrayList<>(Dateien.immobilieList);
		char energie;

		System.out.println("Geben Sie eine Filter Kriterie ein:");
		energie = filterLoopConsole.nextLine().charAt(0);
		EnergieKlasse energieKlasse = Immobilie.charToEnergieKlasse(energie);



		filterteList = filterteList.stream()
				.filter(immo -> immo.getEnergieKlasse().equals(energieKlasse))
				.collect(Collectors.toCollection(ArrayList::new));
		System.out.println("Filter Erfolgreich");

		filterLoopConsole.nextLine();
		filterteList.forEach(System.out::println);

		while (filterLoop){

			System.out.println("""
					Filter nach Preis
					0- Gefilterte Liste ausdrucken
					1- Exit option und zurück zum Hauptmenü"""
			);
			int option = filterLoopConsole.nextInt();
			filterLoopConsole.nextLine();
			switch (option) {
				case 0:
					filterteList.forEach(System.out::println);
					break;
				case 1:
					filterLoop = false;
					break;
				default:
					System.out.println("Ungültige Option. Bitte erneut versuchen.");
					break;
			}
		}
		filterLoopConsole.nextLine();
	}
	public static void immoAdd(){
		Scanner immoAdd = new Scanner(System.in);

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
		String adresse = immoAdd.nextLine();

		System.out.print("Adresse: Stadt - ");
		String stadt = immoAdd.nextLine();

		System.out.print("Fläche [m²]-");
		int flaeche = immoAdd.nextInt();
		immoAdd.nextLine();

		System.out.print("Grundtücksfläche [m²]-");
		int flaecheG = immoAdd.nextInt();
		immoAdd.nextLine();

		System.out.print("Anzahl der Zimmer -");
		int zimmer = immoAdd.nextInt();
		immoAdd.nextLine();

		System.out.print("EnergieKlasse -");
		char energie = immoAdd.nextLine().charAt(0);

		EnergieKlasse energieK = Immobilie.charToEnergieKlasse(energie);

		System.out.println("Wollen Sie mit diesen Werten das Immo-Objekt hinzufügen?");
		System.out.println("ImmoTyp: " + immoTyp);
		System.out.println("Miete/Kauf?: " + (mietKauf.equals("m") ? "Mieten" : "Kaufen"));
		System.out.println("Preis: " + preis);
		System.out.println("Straße: " + adresse);
		System.out.println("Stadt: " + stadt);
		System.out.println("Fläche: " + flaeche);
		if (immoTyp.equals("H") && constMietKauf.equals(MietKauf.Kauf)) {
			System.out.println("Grundstücksfläche: " + flaecheG);
		}
		System.out.println("#Zimmer: " + zimmer);
		System.out.println("Energieklasse: " + energieK);
		System.out.println("Fortsetzen? [J]a , [N]ein");
		String option2 = immoAdd.nextLine().toLowerCase();

		int vorherSize = Dateien.immobilieList.size();

		try{
			if (option2.equalsIgnoreCase("j")){
				if(immoTyp.equalsIgnoreCase("W")){
					Dateien.immobilieList.add(new Wohnung(ImmoTyp.Wohnung,constMietKauf, preis, adresse,  stadt, flaeche, zimmer, energieK));
				} else if (immoTyp.equalsIgnoreCase("G")){
					Dateien.immobilieList.add(new Grundstuck(ImmoTyp.Grundstuck,preis,adresse, stadt,flaeche));
				} else if (immoTyp.equalsIgnoreCase("H") && constMietKauf == MietKauf.Miete) {
					Dateien.immobilieList.add(new Haus(ImmoTyp.Haus,constMietKauf, preis, adresse,stadt,flaeche,zimmer,energieK));
				}  else if (immoTyp.equalsIgnoreCase("H") && constMietKauf == MietKauf.Kauf) {
					Dateien.immobilieList.add(new Haus(ImmoTyp.Haus, constMietKauf, preis, adresse, stadt, flaeche, flaecheG, zimmer, energieK));
				} else {
					System.out.println("Es gab ein Fehler");
				}
			}
		} catch (Exception e) {
			System.out.println("Es gab ein Fehler");
		}

		if (Dateien.immobilieList.size() > vorherSize){
			System.out.println("Immobilie Objekt wurde erfolgreich hinzugefügt");
		} else{
			System.out.println("Fehler beim Hinzufügen der Immobilie - Versuchen bitte Sie nochmals");
		}

	}

	//Methode für Elemente Löschen
	public static  void immoLosch(){
		BenutzerOberflaeche.header();

		Scanner immoLoschConsole = new Scanner(System.in);
		int elementeVorher = Dateien.immobilieList.size();

		boolean run = true;
		while (run){
			header();
			System.out.println("Immo Losch ausgewählt:");
			System.out.println("");
			System.out.println(""" 
					Wählen Sie eine Option aus:
					0- Immo Liste ausdrucken
					1- ID eintragen um Immo_objekt zu löschen
					2- Zurück zum letzten menü 
					""");
			int option = immoLoschConsole.nextInt();
			immoLoschConsole.nextLine();
			int id = 0;
			immoLoschConsole.nextLine();
			switch (option){
				case 0:
					Dateien.printList();
					break;
				case 1:
					boolean loschen = true;
					while (loschen){
						System.out.println("Bitte geben Sie ein ID:");
						id = immoLoschConsole.nextInt();
						immoLoschConsole.nextLine();
						final int idfinal = id;
						Dateien.immobilieList.removeIf(immo -> immo.getiD() == idfinal);
						loschen = false;
					}
					if(Dateien.immobilieList.size() < elementeVorher){
						System.out.println("Element erfolgreich gelöscht");
					} else {
						System.out.println("Beim löschen es gab ein Fehler");
					}
					break;
				case 2:

					break;
				default:
					System.out.println("Wählen Sie eine gültige Option aus");
			}
		}
	}

	//Methode Liste Sortierung
	public static void sortieren(){
		boolean sort = true;
		Scanner sortConsole = new Scanner(System.in);


		while (sort){
			System.out.println("""
					Wählen Sie ein Option aus:
					0- Gesamte Liste Ausdrucken
					1-Sort bei ImmoTyp
					2-Sortierung nach Preis (Günstige Zuerst)
					3-Sortierung nach Preis (Teuerste Zuerst)
					4-Sort bei Preis pro Quadrat-Meter(Günstige Zuerst)
					5-Sort bei Preis pro Quadrat-Meter(Teuerste Zuerst)
					6-Sort bei Energieklasse
					7-Exit option und zurück zum Hauptmenü"""
			);

			int optionSort = sortConsole.nextInt();
			sortConsole.nextLine();

			switch (optionSort) {
				case 0:
					Dateien.printList();
					break;
				case 1:
					Dateien.immobilieList.sort(Comparator.comparing(Immobilie::getImmoTyp));
					break;
				case 2:
					Dateien.immobilieList.sort(Comparator.comparingInt(Immobilie::getPreis));
					break;
				case 3:
					Dateien.immobilieList.sort(Comparator.comparingInt(Immobilie::getPreis).reversed());
					break;
				case 4:
					Dateien.immobilieList.sort(Comparator.comparingDouble(Immobilie::getPreisqm));
					break;
				case 5:
					Dateien.immobilieList.sort(Comparator.comparingDouble(Immobilie::getPreisqm).reversed());
					break;
				case 6:
					Dateien.immobilieList.sort(Comparator.comparing(
							Immobilie::getEnergieKlasse,Comparator.nullsLast(Comparator.naturalOrder())));
					break;
				case 7:
					sort = false;
					break;
				default:
					System.out.println("Ungültige Option. Bitte erneut versuchen.");
					break;
			}
		}

	}

	public static void header(){
		System.out.println("********** IMMO Commander 22.5 **********");
	}

	public static void hallo(){
		System.out.println("""
				********** IMMO Commander 22.5 **********
				Wählen Sie eine Option aus:
				    0. Immo-Liste ausdrucken
				    1. Immo-Liste Nach Kriterien Sortieren
				    2. Immo-Objekte Filtern
				    3. Immo-Objekt hinzufügen
				    4. Immo-Objekt löschen
				    5. EXIT
				""");
	}
}
