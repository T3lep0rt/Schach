public class Springer extends Figur{

	public Springer(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return '♘';
		}
		return '♞';
	}
	@Override
	public boolean test(int prevX, int prevY, int newX, int newY, boolean isW,Figur[][] brett) {
		// check if knight movement is possible
		if(newX==prevX+2 && newY==prevY+1) {
			return true;
		}else if(newX==prevX+2 && newY==prevY-1) {
			return true;
		}else if(newX==prevX-2 && newY==prevY+1) {
			return true;
		}else if(newX==prevX-2 && newY==prevY-1) {
			return true;
		}else if(newX==prevX+1 && newY==prevY+2) {
			return true;
		}else if(newX==prevX+1 && newY==prevY-2) {
			return true;
		}else if(newX==prevX-1 && newY==prevY+2) {
			return true;
		}else if(newX==prevX-1 && newY==prevY-2) {
			return true;
		}else {
			return false;
		}
	}
	
}
