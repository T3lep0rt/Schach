public class GUIHandler implements GUI{

	public void Draw(Figur[][] brett) {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 7; i++) {
			System.out.println();
			System.out.print(i + 1 + "   ");
			for (int j = 0; j < 8; j++) {
				if (brett[j][i] == null) {
					System.out.print("\u25a1\u2009 ");
				} else {
					System.out.print(brett[j][i].getUni()+"  ");
				}
			}
		}

		System.out.println("");
		System.out.println("");
		System.out.println("    a  b  c  d  e  f  g  h");
	}


	
}
