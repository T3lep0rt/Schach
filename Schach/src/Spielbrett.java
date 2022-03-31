public class Spielbrett {

	Figur[][] brett = new Figur[8][8];
	GUIHandler guiHandler = new GUIHandler();

	public void Init() {
		// TODO Auto-generated method stub

		Figur wLTurm = new Turm(false);
		brett[0][0] = wLTurm;
		Figur wLSpringer = new Springer(false);
		brett[0][1] = wLSpringer;
		Figur wLLaufer = new Laufer(false);
		brett[0][2] = wLLaufer;
		Figur wDame = new Dame(false);
		brett[0][3] = wDame;
		Figur wKonig = new Konig(false);
		brett[0][4] = wKonig;
		Figur wRLaufer = new Laufer(false);
		brett[0][5] = wRLaufer;
		Figur wRSpringer = new Springer(false);
		brett[0][6] = wRSpringer;
		Figur wRTurm = new Turm(false);
		brett[0][7] = wRTurm;
		// ab hier fuellen des Bretts mit weissen Bauern
		for (int i = 0; i < brett[1].length; i++) {
			brett[1][i] = new Bauer(false);
		}

		// ab hier fuellen des Bretts mit den schwarzen Figuren
		Figur bLTurm = new Turm(true);
		brett[7][0] = bLTurm;
		Figur bLSpringer = new Springer(true);
		brett[7][1] = bLSpringer;
		Figur bLLaufer = new Laufer(true);
		brett[7][2] = bLLaufer;
		Figur bDame = new Dame(true);
		brett[7][3] = bDame;
		Figur bKonig = new Konig(true);
		brett[7][4] = bKonig;
		Figur bRLaufer = new Laufer(true);
		brett[7][5] = bRLaufer;
		Figur bRSpringer = new Springer(true);
		brett[7][6] = bRSpringer;
		Figur bRTurm = new Turm(true);
		brett[7][7] = bRTurm;
		// ab hier fuellen des Bretts mit den schwarzen Bauern
		for (int i = 0; i < brett[1].length; i++) {
			brett[6][i] = new Bauer(true);
		}

		guiHandler.Draw(brett);

	}

}
