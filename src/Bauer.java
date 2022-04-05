
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
	//y+1 y+1/x+1 if enemy y+2 if y<4
	@Override
	public boolean test(int prevX, int prevY,int newX,int newY,boolean isW) {
		System.out.println("bauer test :"+prevX+" "+prevY+" "+newX+" "+newY);
		if((isW && newY==prevY-1 && newX==prevX || isW && newY==4 && prevY==6 && newX==prevX) || (!isW && newY==prevY+1 && newX==prevX || !isW && newY==3 && prevY==1 && newX==prevX)) {
			return true;
		}else {
			return false;
		}
	}
}
