public class Turm extends Figur {

	public Turm(boolean isW) {
		super(isW);
	}

	public char getUni() {
		if (isW) {
			return '♖';
		}
		return '♜';
	}

	@Override
	public boolean test(int prevX, int prevY, int newX, int newY, boolean isW,Figur[][] brett) {
		// check if turm movement is possible
		if (newX == prevX && newY > prevY) {
			return true;
		} else if (newX == prevX && newY < prevY) {
			return true;
		} else if (newY == prevY && newX > prevX) {
			return true;
		} else if (newY == prevY && newX < prevX) {
			return true;
		} else {
			return false;
		}

	}

}
