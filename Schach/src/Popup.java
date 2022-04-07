import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class Popup extends JFrame implements ActionListener{
   
    JFrame frame = new JFrame();
    static Figur gewählteFigur;
    static volatile boolean actionListened = false;
   
    public Figur makeDecision(){
        
        frame.setTitle("Bitte Figur wählen!");
        frame.setLayout(null);
		frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);

        JButton button = new JButton();
        button.setText("Dame");
        button.setBounds(10, 10, 80, 40);
        frame.add(button);
        button.addActionListener(this);
        JButton button2 = new JButton();
        button2.setText("Turm");
        button2.setBounds(90, 10, 80, 40);
        frame.add(button2);
        button2.addActionListener(this);
        JButton button3 = new JButton();
        button3.setText("Läufer");
        button3.setBounds(170, 10, 80, 40);
        frame.add(button3);
        button3.addActionListener(this);
        JButton button4 = new JButton();
        button4.setText("Springer");
        button4.setBounds(250, 10, 80, 40);
        frame.add(button4);
        button4.addActionListener(this);

        while(!actionListened){

        }
        return gewählteFigur;
    }

    public void  gewonnen(String s){
        frame.setTitle("Gewonnen!");
        frame.setLayout(null);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        JLabel label = new JLabel("Gewonnen hat: " + s);
        label.setBounds(0, 10, 300, 40);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        frame.add(label);

    }

    public void actionPerformed(ActionEvent e) {
        switch(((JButton) e.getSource()).getText()){
            case "Dame":
                gewählteFigur = new Dame(true);
                actionListened = true;
                break;
            case "Turm":
                gewählteFigur = new Turm(true);
                actionListened = true;
                break;
            case "Läufer":
                gewählteFigur = new Laufer(true);
                actionListened = true;
                break;
            case "Springer":
                gewählteFigur = new Springer(true);
                actionListened = true;
                break;
        }
        frame.dispose();
    }
}
