public class Konig extends Figur{

	public Konig(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return 'k';
		}
		return 'K';
	}
	
}
