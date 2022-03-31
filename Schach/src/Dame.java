
public class Dame extends Figur {
	
	public Dame(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return 'd';
		}
		return 'D';
	}
	
}
