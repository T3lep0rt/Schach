
public class Bauer extends Figur{
	public Bauer(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return 'b';
		}
		return 'B';
	}
}
