public class AI {

    ZugHandler zugHandler = new ZugHandler();
    int[] moves = new int[4];

    public AI() {
    }

    public int[] ziehen(Figur[][] brett, GUI2D gui) {

        //create a random move Like 0 2 0 3 until zugHandler.istZugMöglich(prevX,prevY,newX,newY,brett) is true

        while(true) {
            int prevX = (int)(Math.random()*7);
            int prevY = (int)(Math.random()*7);
            int newX = (int)(Math.random()*7);
            int newY = (int)(Math.random()*7);

            System.out.println("prevX: " + prevX + " prevY: " + prevY + " newX: " + newX + " newY: " + newY);
    
            if(zugHandler.istZugMöglich(prevX,prevY,newX,newY,brett,false,gui)) {
                brett = zugHandler.ziehen(prevX,prevY,newX,newY,brett);
                moves[0] = prevX;
                moves[1] = prevY;
                moves[2] = newX;
                moves[3] = newY;
                break;
            }
        }


        return moves;
    }

}
