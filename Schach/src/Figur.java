public class Figur {

	
	int posX;
	int posY;
	int pId;
	boolean isW;
	char unicode;
	
	public Figur(boolean isW) {
		this.isW = isW;
	}
	
	public int getPiece() {		
		return pId;		
	}
	public char getUni() {
		return unicode;
	}
	
}
