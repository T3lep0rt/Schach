public class Laufer extends Figur{

	public Laufer(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return '♗';
		}
		return '♝';
	}
	@Override
	public boolean test(int prevX, int prevY, int newX, int newY, boolean isW,Figur[][] brett) {
		// check if bishop movement is possible 
		if(Math.abs(newX-prevX) == Math.abs(newY-prevY)) {
			return true;
		}else{
			return false;
		}
	}
	
}
