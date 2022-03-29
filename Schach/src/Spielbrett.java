public class Spielbrett {


	Figur[][] brett = new Figur[8][8];
	GUIHandler guiHandler = new GUIHandler();
	
	public void Init() {
		// TODO Auto-generated method stub
		
		
		guiHandler.Draw(brett);
		
	}
	
}
