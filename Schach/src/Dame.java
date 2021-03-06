
public class Dame extends Figur {
	
	public Dame(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return '♔';
		}
		return '♚';
	}



	@Override
	public boolean test(int prevX, int prevY, int newX, int newY, boolean isW,Figur[][] brett) {
		// check if queen movement is possible
		if(Math.abs(newX-prevX) == Math.abs(newY-prevY)) {
			return true;
		}else if (newX == prevX && newY > prevY) {
			return true;
		} else if (newX == prevX && newY < prevY) {
			return true;
		} else if (newY == prevY && newX > prevX) {
			return true;
		} else if (newY == prevY && newX < prevX) {
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
