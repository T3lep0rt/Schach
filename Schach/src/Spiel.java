
public class Spiel  {
	
	Spielbrett spielbrett = new Spielbrett();
	Spieler P1 = new Spieler();
	AI ai = new AI();
	boolean schach = false;
	
	public Spiel() {
		
		spielbrett.Init();
		Start();
		
	}
	

	public void Start() {
		// TODO Auto-generated method stub
		//Spiel starten und laufen lassen bis einer gewinnt
		while(!schach){
			spielbrett.update(P1.ziehen(spielbrett.getBrett())); // system.in dann controller.class prüfen ob move true ist
			schach = spielbrett.isSchach();  //überprüfe auf schach
			if(schach) {   //wenn schach true gebe aus wer gewinnt 
				System.out.println("gewonnen hat der spieler");
			}
			spielbrett.update(ai.ziehen(spielbrett.getBrett())); //ai macht so unendliche viel random moves bis einer valid ist
			schach = spielbrett.isSchach();
			if(schach) {
				System.out.println("gewonnen hat der computer");
			}
		}

				
		
		
	}

	
	
}
