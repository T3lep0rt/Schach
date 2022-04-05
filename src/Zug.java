public class Zug {
    int currX;
    int currY;
    int newX;
    int newY;

    public Zug (int pCurrX, int pCurrY, int pNewX, int pNewY) {
        currX = pCurrX;
        currY = pCurrY;
        newX = pNewX;
        newY = pNewY;
    }

    @Override
    public String toString() {
        // BSP: A 8 --> B 7
    	//Make String
    	return  ""+String.valueOf((char)(currX + 65))+""+(currY+1)+" --> "+String.valueOf((char)(newX + 65))+""+(newY+1);
    }

    public int getCurrX() {
        return currX;
    }

    public int getCurrY() {
        return currY;
    }

    public int getNewX() {
        return newX;
    }

    public int getNewY() {
        return newY;
    }
}