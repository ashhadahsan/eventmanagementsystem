


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TheWelcomeFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfuname;
	private JPasswordField pwd;
	private JLabel lblPassword;
	private JLabel lblUserName;
	
	private JLabel lblBack;
	private JLabel lblWelcomeAdmin;
	Connection mysqlConnection=null;
	



	

	//@SuppressWarnings("deprecation")
	public TheWelcomeFrame() {
	setTitle("Admin");

		
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(620,500);
		setVisible(true);
		
	
	
		setLayout(null);
	
	lblUserName = new JLabel("User Name");
	lblUserName.setFont(new Font("Arial Black", Font.BOLD, 12));
	lblUserName.setBounds(123, 82, 81, 14);
	add(lblUserName);
	
	lblPassword = new JLabel("Password");
	lblPassword.setFont(new Font("Arial Black", Font.BOLD, 12));
	lblPassword.setBounds(123, 128, 81, 14);
	
	add(lblPassword);
	
	
	tfuname = new JTextField();
	tfuname.setBounds(265, 80, 96, 20);
	add(tfuname);
	
	
	pwd = new JPasswordField();
	

	pwd.setBounds(265, 128, 96, 20);
	add(pwd);
	

	JButton btnSubmit = new JButton("");
	//ArrayList<Admin> admin=readAllData();

	btnSubmit.addActionListener(new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			try {
				
			mysqlConnection=DataBaseConnection.dbConnector();
			String query="Select username,password from database_admin";
			PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
			ResultSet rs=stmnt.executeQuery();
			
			String uname=tfuname.getText();
			char []pswd=pwd.getPassword();
			String password=new String(pswd);
			while(rs.next()) {
				if(rs.getString(1).equals(uname) && rs.getString(2).equals(password)) {
					JOptionPane.showMessageDialog(null, "Login Succesfull");
					dispose();
					new MethodsFrame();
			

				
				}
				else {
					JOptionPane.showMessageDialog(null,"Invalid UserName or password");
					tfuname.setText("");
					pwd.setText("");
				}
				
			}
	
	
				
				
			}catch(Exception ee) {
				JOptionPane.showMessageDialog(null,ee);
			}
		
				
			

			
			
		
	}});
	btnSubmit.setIcon(new ImageIcon("C:\\Users\\Ashhad Rehman\\Desktop\\imgs\\submit.png"));
	btnSubmit.setBounds(306, 173, 55, 49);
	add(btnSubmit);
	lblWelcomeAdmin = new JLabel("Welcome Admin!");
	lblWelcomeAdmin.setFont(new Font("Arial Black", Font.BOLD, 12));
	lblWelcomeAdmin.setBounds(440, 11, 126, 14);
	add(lblWelcomeAdmin);
	lblBack = new JLabel("Back");
	lblBack.setFont(new Font("Arial Black", Font.BOLD, 12));
	lblBack.setBounds(482, 308, 48, 14);
	add(lblBack);
	
	

	}
	
	
}