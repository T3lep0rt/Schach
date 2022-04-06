public class Spielbrett {

	Figur[][] brett = new Figur[8][8];
	GUIKonsole guiHandler = new GUIKonsole();

	public void Init() {
		// TODO Auto-generated method stub

		Figur wLTurm = new Turm(false);
		brett[0][0] = wLTurm;
		Figur wLSpringer = new Springer(false);
		brett[1][0] = wLSpringer;
		Figur wLLaufer = new Laufer(false);
		brett[2][0] = wLLaufer;
		Figur wDame = new Dame(false);
		brett[3][0] = wDame;
		Figur wKonig = new Konig(false);
		brett[4][0] = wKonig;
		Figur wRLaufer = new Laufer(false);
		brett[5][0] = wRLaufer;
		Figur wRSpringer = new Springer(false);
		brett[6][0] = wRSpringer;
		Figur wRTurm = new Turm(false);
		brett[7][0] = wRTurm;
		// ab hier fuellen des Bretts mit weissen Bauern
		for (int i = 0; i < brett[1].length; i++) {
			brett[i][1] = new Bauer(false);
		}

		// ab hier fuellen des Bretts mit den schwarzen Figuren
		Figur bLTurm = new Turm(true);
		brett[0][7] = bLTurm;
		Figur bLSpringer = new Springer(true);
		brett[1][7] = bLSpringer;
		Figur bLLaufer = new Laufer(true);
		brett[2][7] = bLLaufer;
		Figur bDame = new Dame(true);
		brett[3][7] = bDame;
		Figur bKonig = new Konig(true);
		brett[4][7] = bKonig;
		Figur bRLaufer = new Laufer(true);
		brett[5][7] = bRLaufer;
		Figur bRSpringer = new Springer(true);
		brett[6][7] = bRSpringer;
		Figur bRTurm = new Turm(true);
		brett[7][7] = bRTurm;
		// ab hier fuellen des Bretts mit den schwarzen Bauern
		for (int i = 0; i < brett[1].length; i++) {
			brett[i][6] = new Bauer(true);
		}

		guiHandler.Draw(brett);

	}
	//return brett
	public Figur[][] getBrett() {
		return brett;
	}
	public void update(Figur[][] ziehen) {
		guiHandler.Draw(brett);
	}
    public boolean isSchach() {
        // search brett for 1 black and 1 white king
		// if both are found return false else return true
		boolean schach = false;
		// do two for loops 
		int kingsLeft = 0;

		for(int i = 0; i < brett.length; i++) {
			for(int j = 0; j < brett[i].length; j++) {
				if(brett[i][j] != null && brett[i][j].getUni() == 'K' ||brett[i][j] != null && brett[i][j].getUni() == 'k') {
					kingsLeft++;
				}
			}
		}
		if(kingsLeft == 2) {
			schach = false;
			return schach;
		}else {
			schach = true;
			System.out.println("Schach");
			return schach;
		}



		
    }

}
