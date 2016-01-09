import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MainFrame extends JFrame {

	private JTextField tf_Number = new JTextField();
	private JButton[][] btn_Number = new JButton[4][4];
	private String[][] btn_String = { { "7", "8", "9", "+" }, { "4", "5", "6", "-" }, 
										{ "1", "2", "3", "*" }, { "0", ".", "C", "/" } };
	private float tmpFloat = 0;
	private String tmpString = "";
	private String tmpFunc = "";
	private Boolean jujge = true;

	public MainFrame() {

		this.setTitle("簡易小算盤 v0.1 by Kovich");
		this.setSize(300, 250);
		this.setLocationRelativeTo(null); // 畫面放置螢幕正中
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);

		tf_Number.setBounds(15, 10, 256, 30);
		tf_Number.setOpaque(true);
		tf_Number.setHorizontalAlignment(JTextField.RIGHT);
		tf_Number.setFont(new Font("Consola", Font.BOLD, 20));
		this.add(tf_Number);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				btn_Number[i][j] = new JButton(btn_String[i][j]);
				btn_Number[i][j].setBounds(15 + (66 * j), 50 + (40 * i), 56, 30);
				btn_Number[i][j].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						setTfText(arg0);
					}

				});
				this.add(btn_Number[i][j]);
			}
		}

	}

	public void setTfText(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case "0":
		case "1":
		case "2":
		case "3":
		case "4":
		case "5":
		case "6":
		case "7":
		case "8":
		case "9":
		case ".":
			NumberSet(arg0);
			break;
		case "+":
		case "-":
		case "*":
		case "/":
			CountSet(arg0);
			break;
		case "C":
			tmpFloat = 0;
			tmpFunc = "";
			tf_Number.setText("");
		}
	}

	public void Count() {
		jujge = false;
		switch (tmpFunc) {
		case "+":
			tmpFloat = (float) (tmpFloat + Float.valueOf(tmpString));
			tf_Number.setText("" + (float) (tmpFloat));
			break;
		case "-":
			tmpFloat = (float) (tmpFloat - Float.valueOf(tmpString));
			tf_Number.setText("" + (float) (tmpFloat));
			break;
		case "*":
			tmpFloat = (float) (tmpFloat * Float.valueOf(tmpString));
			tf_Number.setText("" + (float) (tmpFloat));
			break;
		case "/":
			tmpFloat = (float) (tmpFloat / Float.valueOf(tmpString));
			tf_Number.setText("" + (float) (tmpFloat));
			break;
		}
	}

	public void NumberSet(ActionEvent arg0) {
		if (!jujge) {
			jujge = true;
			tf_Number.setText("");
		}
		tf_Number.setText(tf_Number.getText() + arg0.getActionCommand());
	}

	public void CountSet(ActionEvent arg0) {
		tmpString = tf_Number.getText();
		tf_Number.setText("");
		if (tmpFloat == 0) {
			tmpFloat = Float.valueOf(tmpString);
			tmpFunc = arg0.getActionCommand();
		} else {
			Count();
		}
		tmpFunc = arg0.getActionCommand();
	}
}
