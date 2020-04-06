import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class CreateOrganzierFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfEname;
	private JTextField tfEmail;
	
	private JButton btnCreate;
	Connection mysqlConnection=null;

	/**
	 * Launch the application.
	 */

	public CreateOrganzierFrame() {
		setTitle("Create Organzier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 43, 108, 14);
		contentPane.add(lblNewLabel);
		
		tfEname = new JTextField();
		tfEname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}
		});
		tfEname.setBounds(128, 41, 124, 20);
		contentPane.add(tfEname);
		tfEname.setColumns(10);
		
		JLabel lbl = new JLabel("Email");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(354, 43, 89, 14);
		contentPane.add(lbl);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(450, 41, 124, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
		
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=tfEname.getText();
				String Email=tfEmail.getText();
		
				try
				{
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Organizers(Name,Email_Address) values(?,?)";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, Name);
					stmnt.setString(2, Email);
					
					stmnt.executeUpdate();
			
					JOptionPane.showMessageDialog(null, "Record Added");
					tfEname.setText("");
					tfEmail.setText("");
				

					
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null,ee);}
			}
		});
		
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(452, 80, 89, 23);
		contentPane.add(btnCreate);
	}
}
