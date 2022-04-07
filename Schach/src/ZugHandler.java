import java.util.ArrayList;

public class ZugHandler {

	ArrayList<Zug> zugListe = new ArrayList<Zug>(); // Zugregister

	public ZugHandler() {

	}

	public Figur[][] ziehen(int prevX, int prevY, int newX, int newY, Figur[][] brett) {
		// swap array value of brett at prevY with newY and prevX with newX

		// führt zug aus

		

		if (brett[newX][newY] != null) { // wenn an der neuen stelle eine andere figur steht überschreibe sie
			brett[newX][newY] = null;
		}
		if (newY == 0 && brett[prevX][prevY].isW && brett[prevX][prevY] instanceof Bauer) { //Bauer zu Dame wenn am ende
			brett[prevX][prevY] = null;
			Popup gui = new Popup();
			brett[newX][newY] = gui.makeDecision();
		} else if (newY == 7 && !brett[prevX][prevY].isW && brett[prevX][prevY] instanceof Bauer) {
			brett[prevX][prevY] = null;
			//pc wählt zufällig was er möchte
			brett[newX][newY] = new Dame(false);
		} 
		//else if(brett[newX-1][newY+1] != null){
		//	brett[newX][newY] = brett[prevX][prevY];
		//	brett[newX-1][newY+1] = null;
		//}
		else {
			Figur temp = brett[prevX][prevY];
			brett[prevX][prevY] = brett[newX][newY];
			brett[newX][newY] = temp;
		}

		return brett;

	}

	public boolean istZugMöglich(int prevX, int prevY, int newX, int newY, Figur[][] brett, boolean isWhitePlayer,
			GUI2D gui) {
		if (brett[prevX][prevY] == null) { // eingabe darf nicht NULL sein
			System.out.println("Eingabe darf nicht NULL sein");
			return false;
		} else
		// Wenn eine übergebener zug nich im Spielfeld ist
		if ((prevX > 7 || prevX < 0) || (prevY > 7 || prevY < 0) || (newX > 7 || newX < 0) || (newY > 7 || newY < 0)) {
			System.out.println("Bitte nur Felder im spielfeld auswählen ");
			return false;
		}
		Figur pawn = brett[prevX][prevY];
		boolean canDoTurn = pawn.test(prevX, prevY, newX, newY, pawn.getisW(), brett);

		// überprüfen das der spieler nur seine Figur ziehen Darf und das er seine figur
		// nicht auf seine andere figur setzt

		if (!canDoTurn)
			return false;
		if (isWhitePlayer == pawn.getisW()) {
			if (brett[newX][newY] != null) {
				Figur pawn2 = brett[newX][newY];
				if (pawn.getisW() == pawn2.getisW()) {
					return false;
				}
			}

			// wenn der zug valide ist füge ihn zum zugregister hinzu
			gui.appendZug(new Zug(prevX, prevY, newX, newY));
			// debug shit: System.out.println(zugListe.get(0).toString());
			return true;
		} else
			return false;

	}

	public ArrayList<Zug> getZug() {
		return zugListe;
	}

}
