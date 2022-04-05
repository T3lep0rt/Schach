
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
		//Spiel starten also Weiss eingabe prüfen ausführen dann schwarz
		while(!schach){
			spielbrett.update(P1.ziehen(spielbrett.getBrett())); // system.in dann controller.class prüfen ob move boolean
			schach = spielbrett.isSchach();
			if(schach) {
				System.out.println("gewonnen hat der spieler");
			}
			spielbrett.update(ai.ziehen(spielbrett.getBrett()));
			schach = spielbrett.isSchach();
			if(schach) {
				System.out.println("gewonnen hat der computer");
			}
		}

				
		
		
	}

	
	
}
