
public class Spiel  {
	
	Spielbrett Spielbrett = new Spielbrett();
	Spieler P1 = new Spieler();
	
	public Spiel() {
		
		Spielbrett.Init();
		Start();
		
	}
	

	public void Start() {
		// TODO Auto-generated method stub
		//Spiel starten also Weiss eingabe prüfen ausführen dann schwarz
		
		P1.Zug(); // system.in dann controller.class prüfen ob move boolean
		//Schach?
				
		
		
	}

	
	
}
