
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainFrame extends JFrame{
	
	private JLabel lb_Specialty = new JLabel( "�ڪ��M���G��������ܡA�������I" );
	
	public MainFrame(){
		this.setBounds(320, 240, 300, 200); // .setBounds(x, y, width, high);
		this.setTitle("103021045 �����"); // .setTitle(String str);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(255, 0, 246));
		
		lb_Specialty.setFont(new Font("�з���", Font.BOLD, 16));
		this.add(lb_Specialty);
	}
}