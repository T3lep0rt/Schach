
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;
import java.net.URL;
import javax.imageio.ImageIO;

public class GUI2D implements GUI {

	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] chessBoardSquares = new JButton[8][8];
    private Image[][] chessPieceImages = new Image[2][6];
    private JPanel chessBoard;
	
	@Override
	public void initialize() {
		JFrame frame = new JFrame();
		frame.setTitle("Welecome to JFames!");
		frame.setSize(900, 800);
		frame.setVisible(true);
		
		for(int i = 0;i<8;i++) {
			for(int j = 0;j<8;j++) {
				//add a button.
				JButton b = new JButton("");
				int coordsX = (i*50);
				int coordsY = (j*50);
				b.setBounds(50+coordsX, coordsY+100, 50, 50);
				if((i+j)%2 == 0) {
					b.setBackground(Color.BLACK);
				}else{
					b.setBackground(Color.WHITE);
				}
				
				b.setOpaque(true);
				//add button to the frame.
				frame.add(b);
			}
		}
		frame.repaint();

	}

	@Override
	public void ziehe() {
		// TODO Auto-generated method stub

	}
	
	

}
