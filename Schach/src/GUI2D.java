
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GUI2D extends JFrame implements ActionListener, GUI {

	// volatile wegen refreshrate bei Spieler und Spiel
	public volatile boolean isPlayerTurn = true;
	JFrame frame = new JFrame();
	static JButton[][] chessBoardSquares = new JButton[8][8];

	int count = 1;
	int X;
	int Y;
	int newX;
	int newY;
	Color c = Color.WHITE;
	int[] bttnCoords = new int[4];
	ImageIcon img = new ImageIcon("chess_piece_king.png");
	ImageIcon bg = new ImageIcon("Holz-Background.jpg");
	static ArrayList<Zug> zuege = new ArrayList<Zug>();
	static JTextArea zugHistory;
	static Figur[][] spielBrett;

	@Override
	public void initialize(Figur[][] brett) {
		// init Frame
		spielBrett = brett;
		frame.setTitle("Schach von Sandro!");
		frame.setIconImage(img.getImage());
		frame.setSize(605, 488);
		frame.setVisible(true);
		frame.setResizable(false);

		// init background image
		frame.setLayout(new BorderLayout());
		frame.setContentPane(new JLabel(bg));
		// sonst layout weird und verbuggt
		frame.setLayout(null);
		// init label
		JLabel lblNewLabel = new JLabel("    A        B       C        D        E        F        G        H");
		lblNewLabel.setFont(new Font("Meiryo", Font.PLAIN, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(50, 25, 449, 14);
		frame.add(lblNewLabel);

		// init label vertical
		for (int i = 0; i < 8; i++) {
			JLabel lblNewLabel_1 = new JLabel(Integer.toString(i + 1));
			lblNewLabel_1.setFont(new Font("Meiryo", Font.PLAIN, 16));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(25, 70 + i * 50, 50, 14);
			frame.add(lblNewLabel_1);
		}

		// init ZugVerlauf
		JLabel lblNewLabel_2 = new JLabel("Zug Verlauf");
		lblNewLabel_2.setFont(new Font("Meiryo", Font.BOLD, 16));
		lblNewLabel_2.setBounds(480, 30, 110, 25);
		frame.add(lblNewLabel_2);
		zugHistory = new JTextArea();
		// zugHistory.setBounds(480, 50, 100, 400);
		zugHistory.setEditable(false);
		frame.add(zugHistory);
		JScrollPane scroll = new JScrollPane(zugHistory, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setBounds(480, 50, 100, 400);
		frame.add(scroll);

		// init chessboard
		for (int i = 0; i < brett.length; i++) {
			for (int j = 0; j < brett.length; j++) {
				// add a button.
				JButton b = new JButton();
				int coordsX = (i * 50);
				int coordsY = (j * 50);
				b.setBounds(50 + coordsX, coordsY + 50, 50, 50);

				if ((i + j) % 2 == 0) {
					b.setBackground(Color.BLACK);
				} else {
					b.setBackground(Color.WHITE);
				}

				if (brett[i][j] == null) {
					b.setText("");
				} else {
					b.setText(brett[i][j].getUni() + "");
				}

				b.setFont(new Font("Meiryo", Font.PLAIN, 16));

				b.addActionListener(this);
				b.setOpaque(true);
				// add button to the frame.
				chessBoardSquares[i][j] = b;
				System.out.println("button added at");
				frame.add(b);
			}
		}

		frame.validate();
		frame.repaint();

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().getClass() == JButton.class && isPlayerTurn) {
			JButton clickedButton = (JButton) e.getSource();
			if (count == 2) {
				count = 1;
				newX = (clickedButton.getX() - 50) / 50;
				newY = (clickedButton.getY() - 50) / 50;
				System.out.println("newX: " + newX + " newY: " + newY);
				isPlayerTurn = false;

				// hide possible moves
				// ist ineffizient aber trotzdem cool also bleibt das so
				for (int i = 0; i < chessBoardSquares.length; i++) {
					for (int j = 0; j < chessBoardSquares.length; j++) {
						if ((i + j) % 2 == 0) {
							chessBoardSquares[i][j].setBackground(Color.BLACK);
						} else {
							chessBoardSquares[i][j].setBackground(Color.WHITE);
						}
					}
				}
			} else if (count == 1) {
				clickedButton.setBackground(Color.GREEN);
				count = 2;
				X = (clickedButton.getX() - 50) / 50;
				Y = (clickedButton.getY() - 50) / 50;

				// show all possible moves i pawnatpos is white
				Figur pawnatPos = spielBrett[X][Y];
				if (pawnatPos.isW) {
					for (int i = 0; i < spielBrett.length; i++) {
						for (int j = 0; j < spielBrett.length; j++) {
							if (pawnatPos.test(X, Y, i, j, pawnatPos.isW, spielBrett)) {
								chessBoardSquares[i][j].setBackground(Color.GREEN);
							}
						}
					}
				}else{
					chessBoardSquares[X][Y].setBackground(Color.RED);
				}

			} else {

				count = 1;
			}
		}
	}

	// Übergebe Werte des ActionListeners
	public int[] getClicked() {

		int[] coords = new int[] { X, Y, newX, newY };
		return coords;
	}

	public void setBrett(Figur[][] brett) {
		spielBrett = brett;
	}

	public void appendZug(Zug zug) {
		zuege.add(zug);
	}

	@Override
	public void ziehe(int[] fields) {

		int x = fields[0];
		int y = fields[1];
		int newX = fields[2];
		int newY = fields[3];

		chessBoardSquares[newX][newY].setText(chessBoardSquares[x][y].getText());
		// validate unicode
		chessBoardSquares[newX][newY].setText((spielBrett[newX][newY].getUni() + ""));
		chessBoardSquares[x][y].setText("");

		System.out.println("Set new");
		updateHistory();
		frame.repaint();

	}

	public void updateHistory() {
		// do zugHistory.append("\n" + zuege.get(zuege.size() - 1).toString()); ausser
		// beim ersten Zug
		if (zuege.size() > 1) {
			zugHistory.append("\n" + zuege.get(zuege.size() - 1).toString());
		} else {
			zugHistory.append(zuege.get(zuege.size() - 1).toString());
		}

	}

}
