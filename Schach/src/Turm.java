public class Turm extends Figur{

	public Turm(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return 't';
		}
		return 'T';
	}
	
}
