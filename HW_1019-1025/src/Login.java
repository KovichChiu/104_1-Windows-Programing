import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	private String account = "test0001";
	private String passwd = "test0001";
	private JLabel lb_Account = new JLabel("Account",JLabel.RIGHT);
	private JLabel lb_Passwd = new JLabel("Password",JLabel.RIGHT);
	private JTextField tf_Account = new JTextField();
	private JPasswordField pf_Passwd = new JPasswordField();
	private JButton btn_Sure = new JButton("確定");
	private JButton btn_Exit = new JButton("Exit");
	private MainFrame mf;
	
	public Login(){
		
		this.setTitle("Login");
		this.setSize(400, 200);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		lb_Account.setBounds(0, 20, 100, 20);
		this.add(lb_Account);
		
		tf_Account.setBounds(120, 20, 250, 20);
		this.add(tf_Account);
		
		lb_Passwd.setBounds(0, 60, 100, 20);
		this.add(lb_Passwd);
		
		pf_Passwd.setBounds(120, 60, 250, 20);
		this.add(pf_Passwd);
		
		btn_Sure.setBounds(70, 120, 80, 20);
		btn_Sure.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(isLogin()){
					mf = new MainFrame();
					mf.setVisible(true);
					Login.this.setVisible(false);
				}else{
					JOptionPane.showMessageDialog(Login.this,"錯誤的帳號或密碼");
				}
			}
		});
		this.add(btn_Sure);
		
		btn_Exit.setBounds(220, 120, 80, 20);
		btn_Exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		this.add(btn_Exit);
	}
	
	public boolean isLogin(){
		String Acc = tf_Account.getText();
		char[] char_Pwd = pf_Passwd.getPassword();
		String str_Pwd = String.valueOf(char_Pwd);
		return (Acc.equals(account) && str_Pwd.equals(passwd))?true:false;
	}
}
