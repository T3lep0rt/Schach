
public class Spieler {

	
	public void Zug() {
		
		turnInput();
		
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
