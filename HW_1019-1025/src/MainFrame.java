import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MainFrame extends JFrame {

	private JLabel lb_word = new JLabel("顯示字:", JLabel.RIGHT);
	private JLabel lb_height = new JLabel("高度:", JLabel.RIGHT);
	private JTextField tf_word = new JTextField();
	private JTextField tf_height = new JTextField();
	private JButton btn_run = new JButton("RUN");
	private JTextArea ta = new JTextArea();
	private String[] cb_data = { "◣", "◤", "◢", "◥", "▲", "△" };
	private JComboBox<String> cb_type = new JComboBox<String>(cb_data);
	private String spece = "";

	public MainFrame() {

		this.setTitle("文字排圖器 v0.1 by Kovich");
		this.setSize(330, 330);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);

		lb_word.setBounds(0, 0, 100, 20);
		this.add(lb_word);

		tf_word.setBounds(100, 0, 100, 20);
		this.add(tf_word);

		cb_type.setBounds(200, 0, 100, 20);
		this.add(cb_type);

		lb_height.setBounds(0, 30, 100, 20);
		this.add(lb_height);

		tf_height.setBounds(100, 30, 100, 20);
		this.add(tf_height);

		btn_run.setBounds(200, 30, 100, 20);
		btn_run.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				runWord();
			}
		});
		this.add(btn_run);

		ta.setBounds(5, 60, 305, 225);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		ta.setBorder(border);
		this.add(ta);
	}

	public void runWord() {
		String word = tf_word.getText();
		int height = Integer.valueOf(tf_height.getText());
		char c = word.charAt(0);
		spece = ((c <= 90 && c >= 65) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)) ? "  " : "    ";
		ta.setText("");
		switch (cb_type.getSelectedIndex()) {
		case 0:
			print0(word, height);
			break;
		case 1:
			print1(word, height);
			break;
		case 2:
			print2(word, height);
			break;
		case 3:
			print3(word, height);
			break;
		case 4:
			print4(word, height);
			break;
		case 5:
			print5(word, height);
			break;
		}
	}

	private void print0(String word, int height) {
		// TODO Auto-generated method stub
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < (i + 1); j++) {
				ta.append(word);
			}
			ta.append("\r\n");
		}
	}

	private void print1(String word, int height) {
		// TODO Auto-generated method stub
		for (int i = 0; i < height; i++) {
			for (int j = height - i; j > 0; j--) {
				ta.append(word);
			}
			ta.append("\r\n");
		}
	}

	private void print2(String word, int height) {
		// TODO Auto-generated method stub
		for (int i = 0; i < height; i++) {
			for (int j = height - i; j > 0; j--) {
				ta.append(spece);
			}
			for (int j = 0; j < (i + 1); j++) {
				ta.append(word);
			}
			ta.append("\r\n");
		}
	}

	private void print3(String word, int height) {
		// TODO Auto-generated method stub
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < i; j++) {
				ta.append(spece);
			}
			for (int j = height - i; j > 0; j--) {
				ta.append(word);
			}
			ta.append("\r\n");
		}
	}

	private void print4(String word, int height) {
		// TODO Auto-generated method stub
		for (int i = 0; i < height; i++) {
			for (int j = height - i; j > 0; j--) {
				ta.append(spece);
			}
			for (int j = 0; j < (i + 1) * 2 - 1; j++) {
				ta.append(word);
			}
			ta.append("\r\n");
		}
	}

	private void print5(String word, int height) {
		char c = word.charAt(0);
		for (int i = 0; i < height; i++) {
			for (int j = (height - i) - 1; j > 0; j--) {
				ta.append(spece);
			}
			ta.append(word);
			for (int j = 0; j < ((i * 2) - 1); j++) {
				if (i == (height - 1)) {
					ta.append(word);
				} else {
					ta.append(spece);
				}
			}
			if (i != 0) {
				ta.append(word);
			}
			ta.append("\r\n");
		}
	}
}
