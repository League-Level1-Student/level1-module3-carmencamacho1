import java.applet.AudioClip;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.io.File;

/* This recipe is to be used with the Jeopardy Handout: http://bit.ly/1bvnvd4 */

public class Jeopardy implements ActionListener {
	private JButton firstButton;
	private JButton secondButton;
	private JButton thirdButton, fourthButton, fifthButton;

	private JPanel quizPanel;
	int score = 0;
	JLabel scoreBox = new JLabel("0");
	int buttonCount = 0;

	public static void main(String[] args) {
		new Jeopardy().start();
	}

	private void start() {
		JFrame frame = new JFrame();
		quizPanel = new JPanel();
		frame.setLayout(new BorderLayout());

		// 1. Make the frame show up
		frame.setVisible(true);
		// 2. Give your frame a title
		frame.setTitle("Jeopardy");

		// 3. Create a JPanel variable to hold the header using the createHeader
		// method
		JPanel panel = createHeader("Animal Facts");
		// 4. Add the header component to the quizPanel
		quizPanel.add(panel);
		// 5. Add the quizPanel to the frame
		frame.add(quizPanel);

		// 6. Use the createButton method to set the value of firstButton
		firstButton = createButton("$200");
		// 7. Add the firstButton to the quizPanel
		quizPanel.add(firstButton);
		// 8. Write the code inside the createButton() method below. Check that
		// your
		// game looks like Figure 1 in the Jeopardy Handout -
		// http://bit.ly/1bvnvd4.

		// 9. Use the secondButton variable to hold a button using the
		// createButton
		// method
		secondButton = createButton("$400");
		// 10. Add the secondButton to the quizPanel
		quizPanel.add(secondButton);
		// 11. Add action listeners to the buttons (2 lines of code)
		firstButton.addActionListener(this);
		secondButton.addActionListener(this);
		// 12. Fill in the actionPerformed() method below
		thirdButton = createButton("$600");
		quizPanel.add(thirdButton);
		thirdButton.addActionListener(this);
		fourthButton = createButton("$800");
		quizPanel.add(fourthButton);
		fourthButton.addActionListener(this);
		fifthButton = createButton("$1000");
		quizPanel.add(fifthButton);
		fifthButton.addActionListener(this);
		frame.pack();
		quizPanel.setLayout(new GridLayout(buttonCount + 1, 3));
		frame.add(makeScorePanel(), BorderLayout.NORTH);
		frame.setSize(Toolkit.getDefaultToolkit().getScreenSize().height,
				Toolkit.getDefaultToolkit().getScreenSize().width);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/*
	 * 13. Use the method provided to play the Jeopardy theme music
	 * 
	 * 14. Add buttons so that you have $200, $400, $600, $800 and $1000
	 * questions
	 *
	 * [optional] Use the showImage or playSound methods when the user answers a
	 * question
	 */

	private JButton createButton(String dollarAmount) {
		// Create a new JButton
		JButton button = new JButton();
		// Set the text of the button to the dollarAmount
		button.setText(dollarAmount);
		// Increment the buttonCount (this should make the layout vertical)
		buttonCount = buttonCount + 1;
		// Return your new button instead of the temporary button

		return button;
	}

	public void actionPerformed(ActionEvent arg0) {
		// Remove this temporary message:

		// Use the method that plays the jeopardy theme music.

		JButton buttonPressed = (JButton) arg0.getSource();
		// If the buttonPressed was the firstButton

		// Call the askQuestion() methodJPanel panel = new JPanel();
		if (buttonPressed == firstButton) {
			askQuestion("How many hearts does an octopus have?", "3", 200);
			firstButton.setText("0");
		}
		// Fill in the askQuestion() method. When you play the game, the score
		// should
		// change.

		// Or if the buttonPressed was the secondButton
		else if (buttonPressed == secondButton) {
			askQuestion("Are mice primates or rodents? \n A) Rodents \n B) Primates", "a", 400);
			secondButton.setText("0");
		}
		else if (buttonPressed == thirdButton){
			askQuestion("There is only one mammal that has the ability to fly. What is it? \n A) Peacock \n B) Squirrel \n C) Bat", "c", 600);
			thirdButton.setText("0");
		}
		else if (buttonPressed == fourthButton){
			askQuestion("How long can Tarantulas go without eating? \n A) 2 years \n B) 3 weeks \n C) 4 years \n D) 5 months ", "a", 800);
			fourthButton.setText("0");
		}
		else if (buttonPressed == fifthButton){
			askQuestion("How much does an average fox weigh? \n A) 20 lbs \n B) 14 lbs \n C) 30 lbs  \n D) 50 lbs \n E) 5 lbs ", "b", 1000);
			fifthButton.setText("0");
		}


		// Call the askQuestion() method with a harder question

		// Clear the button text (set the button text to nothing)

	}

	private void askQuestion(String question, String correctAnswer, int prizeMoney) {
		// Remove this temporary message

		// Use a pop up to ask the user the question
		String answer = JOptionPane.showInputDialog(question);
		// If the answer is correct
		if (answer.equals(correctAnswer)) {
			score = score + prizeMoney;
			updateScore();
			JOptionPane.showMessageDialog(null, "Correct");
		}
		// Increase the score by the prizeMoney

		// Call the updateScore() method

		// Pop up a message to tell the user they were correct

		// Otherwise
		else {
			score = score - prizeMoney;
			JOptionPane.showMessageDialog(null, "The Correct answer is " + correctAnswer);
			updateScore();
		}
		// Decrement the score by the prizeMoney

		// Pop up a message to tell the user the correct answer

		// Call the updateScore() method

	}

	public void playJeopardyTheme() {
		try {
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(new File("/Users/League/Google Drive/league-sounds/jeopardy.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private void playSound(String fileName) {
		AudioClip scream = JApplet.newAudioClip(getClass().getResource(fileName));
		scream.play();
	}

	private Component makeScorePanel() {
		JPanel panel = new JPanel();
		panel.add(new JLabel("score:"));
		panel.add(scoreBox);
		panel.setBackground(Color.CYAN);
		return panel;
	}

	private void updateScore() {
		scoreBox.setText("" + score);
	}

	private JPanel createHeader(String topicName) {
		JPanel panelj = new JPanel();
		panelj.setLayout(new BoxLayout(panelj, BoxLayout.PAGE_AXIS));
		JLabel l1 = new JLabel(topicName);
		l1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panelj.add(l1);
		return panelj;
	}

	void showCorrectImage() {
		showImage("correct.jpg");
	}

	void showIncorrectImage() {
		showImage("incorrect.jpg");
	}

	private void showImage(String fileName) {
		JFrame frame = new JFrame();
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		JLabel image = new JLabel(icon);
		frame.add(image);
		frame.setVisible(true);
		frame.pack();
	}
}