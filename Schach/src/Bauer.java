
public class Bauer extends Figur {
	public Bauer(boolean isW) {
		super(isW);
	}

	public char getUni() {
		if (isW) {
			return '♙';
		}
		return '♟';
	}

	// y+1 y+1/x+1 if enemy y+2 if y<4
	@Override
	public boolean test(int prevX, int prevY, int newX, int newY, boolean isW, Figur[][] brett) {
		if ((isW && newY == prevY - 1 && newX == prevX || isW && newY == 4 && prevY == 6 && newX == prevX)
				|| (!isW && newY == prevY + 1 && newX == prevX || !isW && newY == 3 && prevY == 1 && newX == prevX)) {
			return true;
		} else if ((newY == prevY - 1 && newX == prevX + 1 && isW || newY == prevY - 1 && newX == prevX - 1 && isW)
				|| (newY == prevY + 1 && newX == prevX - 1 && !isW || newY == prevY + 1 && newX == prevX + 1 && !isW)) {
			if (brett[newX][newY] == null) {
				return false;
			}// else if ((brett[newX + 1][newY + 1].isW != isW || brett[newX - 1][newY + 1].isW != isW && isW)
			//		|| (brett[newX + 1][newY - 1].isW != isW && brett[newX - 1][newY - 1].isW != isW && !isW)) { //check for rochade
			//	return true;
			//}
		} else {
			return false;
		}
		return false; //
	}
}
 //