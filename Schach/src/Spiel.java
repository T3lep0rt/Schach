
public class Spiel  {
	
	Spielbrett spielbrett = new Spielbrett();
	Spieler P1 = new Spieler();
	AI ai = new AI();
	boolean schach = false;
	GUI2D gui = new GUI2D();
	
	public Spiel() {
		
		Figur[][] brett = spielbrett.Init();
		gui.initialize(brett);
		Start();
		
	}
	

	public void Start() {
		// TODO Auto-generated method stub
		//Spiel starten und laufen lassen bis einer gewinnt
		
		
		while(!schach){
			gui.isPlayerTurn = true;
			spielbrett.update(P1.ziehen(spielbrett.getBrett(),gui)); // system.in dann controller.class prüfen ob move true ist
			schach = spielbrett.isSchach();  //überprüfe auf schach
			if(schach) {   //wenn schach true gebe aus wer gewinnt 
				System.out.println("gewonnen hat der spieler");
				break;
			}
			System.out.println("Spieler ist fertig");
			spielbrett.update(ai.ziehen(spielbrett.getBrett(),gui)); //ai macht so unendliche viel random moves bis einer valid ist
			schach = spielbrett.isSchach();
			if(schach) {
				System.out.println("gewonnen hat der computer");
			}
		}

				
		
		
	}

	
	
}
