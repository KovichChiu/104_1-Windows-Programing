
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class MainFrame extends JFrame{
	
	private JLabel lb_Font = new JLabel( "�r��" );
	private JLabel lb_Style = new JLabel( "����" );
	private JLabel lb_Size = new JLabel( "����" );
	private JLabel lb_Front = new JLabel( "�e����" );
	private JLabel lb_Rear = new JLabel( "�ᴺ��" );
	
	private Choice ch_Font = new Choice();
	private Choice ch_Style = new Choice();
	private Choice ch_Size = new Choice();
	private Choice ch_Front = new Choice();
	private Choice ch_Rear = new Choice();
	
	private JButton btn_Exit = new JButton( "����" );
	private JButton[][] btn_Group = new JButton[4][3];
	
	private JTextArea ta = new JTextArea();
	
	private Checkbox cb = new Checkbox("�i�s��", true);
	
	public MainFrame(){
		this.setTitle( "²����r�s�边 v0.1 by Kovich" );
		this.setLayout(null);
		this.setSize(505, 465);
		this.getContentPane().setBackground(Color.GRAY);
		this.setLocationRelativeTo(null); // �e����m�ù�����
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lb_Font.setBounds(0, 0, 40, 20);
		this.add(lb_Font);
		
		ch_Font.add("�s������");
		ch_Font.add("�з���");
		ch_Font.setBounds(0, 20, 150, 20);
		ch_Font.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				setWord();
			}
			
		});
		this.add(ch_Font);
		
		lb_Style.setBounds(170, 0, 40, 20);
		this.add(lb_Style);
		
		ch_Style.add("�L");
		ch_Style.add("����");
		ch_Style.add("����");
		ch_Style.add("����+����");
		ch_Style.setBounds(170, 20, 150, 20);
		ch_Style.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				setWord();
			}
			
		});
		this.add(ch_Style);
		
		lb_Size.setBounds(340, 0, 40, 20);
		this.add(lb_Size);
		
		for(int i=12;i<=40;i++){
			ch_Size.add(""+i);
		}
		ch_Size.setBounds(340, 20, 150, 20);
		ch_Size.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				setWord();
			}
			
		});
		this.add(ch_Size);
		
		lb_Front.setBounds(0, 60, 40, 20);
		this.add(lb_Front);
		
		ch_Front.add("�¦�");
		ch_Front.add("�Ŧ�");
		ch_Front.add("����");
		ch_Front.add("����");
		ch_Front.add("���");
		ch_Front.setBounds(0, 80, 150, 20);
		ch_Front.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				setTaColor();
			}
			
		});
		this.add(ch_Front);
		
		lb_Rear.setBounds(170, 60, 40, 20);
		this.add(lb_Rear);
		
		ch_Rear.add("�զ�");
		ch_Rear.add("�Ŧ�");
		ch_Rear.add("����");
		ch_Rear.add("����");
		ch_Rear.add("���");
		ch_Rear.setBounds(170, 80, 150, 20);
		ch_Rear.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				setTaColor();
			}
			
		});
		this.add(ch_Rear);
		
		cb.setBounds(340, 60, 60, 20);
		cb.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				cbeckBoxStates();
			}
			
		});
		this.add(cb);
		
		btn_Exit.setBounds(340, 80, 150, 20);
		btn_Exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		this.add(btn_Exit);
		
		ta.setBounds(0, 120, 490, 300);
		ta.setOpaque(true);
		this.add(ta);
	}
	
	public void setWord(){
		String str_Font = ch_Font.getSelectedItem();
		int int_Style = 0;
		switch(ch_Style.getSelectedIndex()){
		case 0:
			int_Style = Font.PLAIN;
			break;
		case 1:
			int_Style = Font.ITALIC;
			break;
		case 2:
			int_Style = Font.BOLD;
			break;
		case 3:
			int_Style = Font.BOLD + Font.ITALIC;
			break;
		}
		int int_Size = Integer.valueOf(ch_Size.getSelectedItem());
		ta.setFont(new Font(str_Font, int_Style, int_Size));
		
	}
	
	public void setTaColor(){
		Color c_Front = null;
		switch(ch_Front.getSelectedIndex()){
		case 0:
			c_Front = Color.BLACK;
			break;
		case 1:
			c_Front = Color.BLUE;
			break;
		case 2:
			c_Front = Color.RED;
			break;
		case 3:
			c_Front = Color.YELLOW;
			break;
		case 4:
			c_Front = Color.GREEN;
			break;
		}
		
		Color c_Rear = null;
		switch(ch_Rear.getSelectedIndex()){
		case 0:
			c_Rear = Color.WHITE;
			break;
		case 1:
			c_Rear = Color.BLUE;
			break;
		case 2:
			c_Rear = Color.RED;
			break;
		case 3:
			c_Rear = Color.YELLOW;
			break;
		case 4:
			c_Rear = Color.GREEN;
			break;
		}
		
		ta.setBackground(c_Rear);
		ta.setForeground(c_Front);
	}
	
	public void cbeckBoxStates(){
		if(cb.getState()){
			ta.setEditable(true);
		}else{
			ta.setEditable(false);
		}
	}
}