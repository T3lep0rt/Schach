public class ZugHandler {

	
	
	public ZugHandler() {
		
		
	}

	public Figur[][] ziehen(int prevX, int prevY,int newX,int newY,Figur[][] brett){
		//swap array value of brett at prevY with newY and prevX with newX
		if(brett[newX][newY] != null) {
			brett[newX][newY] = null;
		}
		Figur temp = brett[prevX][prevY];
		brett[prevX][prevY] = brett[newX][newY];
		brett[newX][newY] = temp;


		return brett;

	}
	
	public boolean istZugMöglich(int prevX, int prevY,int newX,int newY,Figur[][] brett,boolean isWhitePlayer) {
		if(brett[prevX][prevY]==null) {
			return false;
		}
		Figur pawn = brett[prevX][prevY]; 
		boolean canDoTurn = pawn.test(prevX,prevY,newX,newY,pawn.getisW());
		if(!canDoTurn) return false;
		if(isWhitePlayer == pawn.getisW()){
			if(brett[newX][newY] != null) {
				Figur pawn2 = brett[newX][newY];
				if(pawn.getisW()==pawn2.getisW()) {
					return false;
				}
			}
			return true;
		}else return false;

	}
	
}
