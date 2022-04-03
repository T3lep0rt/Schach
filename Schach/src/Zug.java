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
        return "current x:"+currX+"\n current y:"+currY+"\n new x:"+newX+"\n new y:"+newY;
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