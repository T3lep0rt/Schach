public class Laufer extends Figur{

	public Laufer(boolean isW) {
		super(isW);
	}
	
	public char getUni() {
		if(isW) {
			return 'l';
		}
		return 'L';
	}
	
}
