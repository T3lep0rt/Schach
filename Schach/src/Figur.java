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
	public boolean getisW() {
		return isW;
	}
	public boolean test(int prevX, int prevY,int newX,int newY,boolean isW,Figur[][] brett) {
		return false;
	}
	
}