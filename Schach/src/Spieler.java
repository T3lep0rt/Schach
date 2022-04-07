import java.util.Scanner;

public class Spieler {

	Scanner s = new Scanner(System.in);
	Zug zug;
	ZugHandler zugHandler = new ZugHandler();		
	int[] input;

	public int[] ziehen(Figur[][] brett, GUI2D gui) {

		// wiederholen bis möglich

		while (true) {
			while(gui.isPlayerTurn) {
			}
			input = gui.getClicked();
			if (zugHandler.istZugMöglich(input[0], input[1], input[2], input[3], brett, true,gui)) {
				brett = zugHandler.ziehen(input[0], input[1], input[2], input[3], brett);
				System.out.println("CanDoturn");
				break;
			} else {
				gui.isPlayerTurn = true;
				System.out.println("Zug nicht möglich");
			}
		}
		return input;

	}

	public int[] turnInput() {
		boolean zulaessigeEingabe = false;
		int[] arr = new int[4];

		// Schleife zur Wiederholung der Eingabeaufforderung bei falschem Format.
		while (!zulaessigeEingabe) {
			String speicher;
			char[] c;
			do {
				System.out.println("Bitte Zug eingeben. (Format:a1a2)");
				speicher = s.nextLine();
				// Umwandlung des Eingabestrings in ein Array vom Typ char.
				c = speicher.toCharArray();
				// Falls die Eingabe nicht genau 4 Zeichen hatte, wird eine erneute Eingabe
				// angefordert.
			} while (c.length != 4);
			c = speicher.toCharArray();
			// Umwandlung des chars in eine Zahl und Modifikation für das Koordinatensystem.
			arr[0] = Character.getNumericValue(c[0]) - 10;
			arr[1] = Character.getNumericValue(c[1]) - 1;
			arr[2] = Character.getNumericValue(c[2]) - 10;
			arr[3] = Character.getNumericValue(c[3]) - 1;
			// Überprüfung, ob die Werte im Bereich 0-8 liegen.
			if ((arr[0] >= 0 && arr[0] <= 8) && (arr[1] >= 0 && arr[1] <= 8) && (arr[2] >= 0 && arr[2] <= 8)
					&& (arr[3] >= 0 && arr[3] <= 8)) {
				zulaessigeEingabe = true;
			}
		}
		return arr;
	}

}
