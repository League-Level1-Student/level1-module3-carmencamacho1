package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ButtonQuiz implements ActionListener{
 int counter = 0;	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	
	public static void main(String[] args) {
ButtonQuiz quiz = new ButtonQuiz();


	}
ButtonQuiz(){
			frame.add(panel);
		frame.setVisible(true);
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		button.setText("Increment");
		button2.setText("Display");
		button3.setText("Decrement");
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		frame.pack();
}
@Override
public void actionPerformed(ActionEvent e) {
if (e.getSource()== button) {
	counter++;
}
if (e.getSource()== button2) {
	JOptionPane.showMessageDialog(null, counter);
}
if (e.getSource()== button3) {
	counter--;
}
	
}
}
