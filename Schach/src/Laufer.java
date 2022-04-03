public class Laufer extends Figur{

	public Laufer(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return 'l';
		}
		return 'L';
	}
	@Override
	public boolean test(int prevX, int prevY, int newX, int newY, boolean isW) {
		// check if bishop movement is possible 
		if(newX-prevX == newY-prevY) {
			return true;
		}else{
			return false;
		}
	}
	
}
