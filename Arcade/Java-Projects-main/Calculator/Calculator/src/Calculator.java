import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel outputPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JLabel textField = new JLabel();
	JButton[] buttons = new JButton[20];

	boolean adding = false;
	boolean divide;
	boolean multiply;
	boolean adition;
	boolean percent;
	boolean coma = false;
	float result = 0;

	String ganzeZahl2;
	String ganzeZahl1;
	String vorkomma = null;
	String nachkomma = null;

	Calculator() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.getContentPane().setBackground(new Color(50, 50, 50));
		frame.setVisible(true);

		textField.setBackground(new Color(25, 25, 25));
		textField.setForeground(new Color(25, 255, 0));
		textField.setFont(new Font("Calibri", Font.BOLD, 75));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Calculator");
		textField.setOpaque(true);

		outputPanel.setLayout(new BorderLayout());
		outputPanel.setBounds(0, 0, 800, 150);

		buttonPanel.setLayout(new GridLayout(5, 4));
		buttonPanel.setBackground(new Color(150, 150, 150));

		// Button Grid
		for (int i = 0; i < 20; i++) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font("Calibri", Font.BOLD, 120));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		buttons[1].setEnabled(false);
		buttons[16].setEnabled(false);

		buttons[0].setText("C");
		buttons[2].setText("%");
		buttons[3].setText("/");
		buttons[7].setText("x");
		buttons[11].setText("-");
		buttons[15].setText("+");
		buttons[19].setText("=");
		buttons[18].setText(".");

		buttons[4].setText("7");
		buttons[5].setText("8");
		buttons[6].setText("9");
		buttons[8].setText("4");
		buttons[9].setText("5");
		buttons[10].setText("6");
		buttons[12].setText("1");
		buttons[13].setText("2");
		buttons[14].setText("3");
		buttons[17].setText("0");

		// Add Stuff to frame
		outputPanel.add(textField);
		frame.add(outputPanel, BorderLayout.NORTH);
		frame.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buttons[0]) {
			clear();
		}
		if (e.getSource() == buttons[2]) {
			if (ganzeZahl1 != null) {
				percent();
				adding = true;
				vorkomma = null;
				nachkomma = null;
				coma = false;

			}
		}
		if (e.getSource() == buttons[3]) {
			if (ganzeZahl1 != null) {
				division();
				adding = true;
				vorkomma = null;
				nachkomma = null;
				coma = false;
			}
		}
		if (e.getSource() == buttons[7]) {
			if (ganzeZahl1 != null) {
				multiplication();
				adding = true;
				vorkomma = null;
				nachkomma = null;
				coma = false;
			}
		}
		if (e.getSource() == buttons[11]) {
			if (ganzeZahl1 != null) {
				minus();
				adding = true;
				vorkomma = null;
				nachkomma = null;
				coma = false;
			}
		}
		if (e.getSource() == buttons[15]) {
			if (ganzeZahl1 != null) {
				addition();
				adding = true;
				vorkomma = null;
				nachkomma = null;
				coma = false;
			}
		}
		if (e.getSource() == buttons[19]) {
			equal();
		}

		// comma button
		if (e.getSource() == buttons[18]) {
			coma = true;
			vorkomma += ".";
		}
		if (e.getSource() == buttons[17]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "0";
				else {
					vorkomma += 0;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "0";
				else {
					nachkomma += 0;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[14]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "3";
				else {
					vorkomma += 3;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "3";
				else {
					nachkomma += 3;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[13]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "2";
				else {
					vorkomma += 2;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "2";
				else {
					nachkomma += 2;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[12]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "1";
				else {
					vorkomma += 1;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "1";
				else {
					nachkomma += 1;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[10]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "6";
				else {
					vorkomma += 6;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "6";
				else {
					nachkomma += 6;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[9]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "5";
				else {
					vorkomma += 5;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "5";
				else {
					nachkomma += 5;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[8]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "4";
				else {
					vorkomma += 4;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "4";
				else {
					nachkomma += 4;
				}
			}
			if (nachkomma == null) {
				ganzeZahl1 = vorkomma;
			} else {
				ganzeZahl1 = vorkomma + nachkomma;
			}
			textField.setText(ganzeZahl1);
		}
		if (e.getSource() == buttons[6]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "9";
				else {
					vorkomma += 9;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "9";
				else {
					nachkomma += 9;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[5]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "8";
				else {
					vorkomma += 8;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "8";
				else {
					nachkomma += 8;
				}
			}
			showNumber();
		}
		if (e.getSource() == buttons[4]) {
			if (!coma) {
				if (vorkomma == null)
					vorkomma = "7";
				else {
					vorkomma += 7;
				}
			}
			if (coma) {
				if (nachkomma == null)
					nachkomma = "7";
				else {
					nachkomma += 7;
				}
			}
			showNumber();
		}
	}

	public float number1() {
		float x = Float.parseFloat(ganzeZahl1);
		return x;
	}

	public float number2() {
		float x = Float.parseFloat(ganzeZahl2);

		return x;
	}

	public void showNumber() {
		if (!adding) {
			if (nachkomma == null) {
				ganzeZahl1 = vorkomma;
			} else {
				ganzeZahl1 = vorkomma + nachkomma;
			}
			textField.setText(ganzeZahl1);
		} else if (adding) {
			if (nachkomma == null) {
				ganzeZahl2 = vorkomma;
			} else {
				ganzeZahl2 = vorkomma + nachkomma;
			}
			textField.setText(ganzeZahl2);
		}
	}

	public void clear() {
		textField.setText("cleared");
		result = 0;
		coma = false;
		vorkomma = null;
		nachkomma = null;
		adding = false;
		ganzeZahl1 = null;
		ganzeZahl2 = null;
	}

	public void percent() {
		percent = true;
		adition = false;
		divide = false;
		multiply = false;
	}

	public void multiplication() {
		adition = false;
		divide = false;
		multiply = true;
		percent = false;

	}

	public void division() {
		adition = false;
		divide = true;
		multiply = false;
		percent = false;
	}

	public void minus() {
		adition = false;
		divide = false;
		multiply = false;
		percent = false;
	}

	public void addition() {
		adition = true;
		divide = false;
		multiply = false;
		percent = false;
	}

	public void equal() {

		if (adition && !multiply && !divide && !percent) {
			result = number1() + number2();
		} else if (!adition && !multiply && !divide && !percent) {
			result = number1() - number2();
		} else if (!adition && !multiply && divide && !percent) {
			result = number1() / number2();
		} else if (!adition && multiply && !divide && !percent) {
			result = number1() * number2();
		} else if (!adition && !multiply && !divide && percent) {
			result = number1() % number2();
		}

		textField.setText((String.valueOf(result)));
		vorkomma = null;
		nachkomma = null;
		coma = false;
		adding = false;
	}
}
