public class AI {

    ZugHandler zugHandler = new ZugHandler();

    public AI() {
    }

    public Figur[][] ziehen(Figur[][] brett){

        //create a random move Like 0 2 0 3 until zugHandler.istZugMöglich(prevX,prevY,newX,newY,brett) is true

        while(true) {
            int prevX = (int)(Math.random()*7);
            int prevY = (int)(Math.random()*7);
            int newX = (int)(Math.random()*7);
            int newY = (int)(Math.random()*7);
    
            if(zugHandler.istZugMöglich(prevX,prevY,newX,newY,brett,false)) {
                brett = zugHandler.ziehen(prevX,prevY,newX,newY,brett);
                break;
            }
        }


        return brett;
    }

}
