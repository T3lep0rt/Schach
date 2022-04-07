public class Konig extends Figur{

	public Konig(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return '♕';
		}
		return '♛';
	}

	@Override
	public boolean test(int prevX, int prevY, int newX, int newY, boolean isW,Figur[][] brett) {
		// check if king movement is possible
		if(newX==prevX+1 && newY==prevY+1) {
			return true;
		}else if(newX==prevX+1 && newY==prevY-1) {
			return true;
		}else if(newX==prevX-1 && newY==prevY+1) {
			return true;
		}else if(newX==prevX-1 && newY==prevY-1) {
			return true;
		}else if(newX==prevX+1 && newY==prevY) {
			return true;
		}else if(newX==prevX-1 && newY==prevY) {
			return true;
		}else if(newY==prevY+1 && newX==prevX) {
			return true;
		}else if(newY==prevY-1 && newX==prevX) {
			return true;
		}else {
			return false;
		}


	}
	
}
