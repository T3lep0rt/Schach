public class Springer extends Figur{

	public Springer(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return 's';
		}
		return 'S';
	}
	
}
