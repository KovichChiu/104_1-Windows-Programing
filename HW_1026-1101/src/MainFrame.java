import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.border.Border;

public class MainFrame extends JFrame {
	
	private TimeLabel[] lb_h = new TimeLabel[2];
	private TimeLabel[] lb_m = new TimeLabel[2];
	private TimeLabel[] lb_s = new TimeLabel[2];

	int h = 0, m = 0, s = 0, times = 0;;

	private JLabel[] lb_point = new JLabel[2];
	private JButton btn_go = new JButton("Go");
	private JButton btn_pause = new JButton("Pause");
	private JButton btn_record = new JButton("Record");
	private JButton btn_stop = new JButton("Stop");
	private JButton btn_exit = new JButton("Exit");
	private JTextArea ta = new JTextArea();
	private ImageIcon img = new ImageIcon("Number/point.png");
	private JScrollPane scroll = new JScrollPane(ta, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
			ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	private Timer t;

	public MainFrame() {
		this.setTitle("�i�O�����X�� v0.1 by Kovich");
		this.setSize(750, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);

		for (int i = 0; i < 2; i++) {
			lb_h[i] = new TimeLabel();
			lb_h[i].setBounds(20 + 100 * i, 0, 100, 150);
			this.add(lb_h[i]);
			lb_m[i] = new TimeLabel();
			lb_m[i].setBounds(270 + 100 * i, 0, 100, 150);
			this.add(lb_m[i]);
			lb_s[i] = new TimeLabel();
			lb_s[i].setBounds(520 + 100 * i, 0, 100, 150);
			this.add(lb_s[i]);
		}
		setImg();
		lb_point[0] = new JLabel();
		lb_point[0].setIcon(img);
		lb_point[0].setBounds(220, 0, 30, 150);
		this.add(lb_point[0]);
		lb_point[1] = new JLabel();
		lb_point[1].setIcon(img);
		lb_point[1].setBounds(470, 0, 30, 150);
		this.add(lb_point[1]);

		btn_go.setBounds(40, 170, 110, 25);
		btn_go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeStart();
				btn_Enabletrue();
			}
		});
		this.add(btn_go);

		btn_pause.setBounds(175, 170, 110, 25);
		btn_pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("Pause")){
					ta.append(" �� Pause...\n");
					btn_pause.setText("Continue");
					t.stop();
				}else{
					btn_pause.setText("Pause");
					ta.append(" �� Continue...\n");
					t.start();
				}
			}
		});
		this.add(btn_pause);

		btn_record.setBounds(310, 170, 110, 25);
		btn_record.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ta.append((++times)+"\t�� " + hToString() + " : " + mToString() + " : " + sToString()+"\n");
			}
		});
		this.add(btn_record);

		btn_stop.setBounds(445, 170, 110, 25);
		btn_stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TimeStop();
				btn_Enablefalse();
				btn_pause.setText("Pause");
				btn_exit.setEnabled(true);
			}
		});
		this.add(btn_stop);

		btn_exit.setBounds(580, 170, 110, 25);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.add(btn_exit);
		
		btn_Enablefalse();

		scroll.setBounds(40, 210, 650, 240);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		scroll.setBorder(border);
		this.add(scroll);

	}

	public void TimeStart() {
		t = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				s++;
				if (s / 60 > 0) {
					s = 0;
					m++;
				}
				if (m / 60 > 0) {
					m = 0;
					h++;
				}
				if(s%2==1){
					lb_point[0].setIcon(null);
					lb_point[1].setIcon(null);
				}else{
					lb_point[0].setIcon(img);
					lb_point[1].setIcon(img);
				}
				if(h<100){
					setImg();
				}else{
					s=0;m=0;h=0;
				}
			}
		});
		t.start();
	}

	public void TimeStop() {
		t.stop();
		ta.append("---------- STOP at �� " + hToString() + " : " + mToString() + " : " + sToString() + " ----------\n");
		ta.append("Please Press \"Exit\" To Leave...");
		s = 0;
		m = 0;
		h = 0;
		times = 0;
		setImg();
	}

	public void setImg() {
		for (int i = 0; i < 2; i++) {
			lb_h[i].setImg(hToString().charAt(i) - '0');
			lb_m[i].setImg(mToString().charAt(i) - '0');
			lb_s[i].setImg(sToString().charAt(i) - '0');
		}
	}

	public String hToString() {
		String str_h = (h / 10 >= 1) ? ("" + h) : ("0" + h);
		return str_h;
	}

	public String mToString() {
		String str_m = (m / 10 >= 1) ? ("" + m) : ("0" + m);
		return str_m;
	}

	public String sToString() {
		String str_s = (s / 10 >= 1) ? ("" + s) : ("0" + s);
		return str_s;
	}

	public void btn_Enabletrue() {
		btn_go.setEnabled(false);
		btn_pause.setEnabled(true);
		btn_record.setEnabled(true);
		btn_stop.setEnabled(true);
		btn_exit.setEnabled(true);
	}

	public void btn_Enablefalse() {
		btn_go.setEnabled(true);
		btn_pause.setEnabled(false);
		btn_record.setEnabled(false);
		btn_stop.setEnabled(false);
		btn_exit.setEnabled(false);
	}
}
