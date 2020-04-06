import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
public class CreateSponsorFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfEname;
	private JTextField tfContact;
	private JTextField tfEmail;

	private JButton btnCreate;
	private JLabel lblServiceId;
	Connection mysqlConnection=null;
	private JComboBox<String> cb_Service;

	/**
	 * Launch the application.
	 */

	public CreateSponsorFrame() {
		setTitle("Create Sponsor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 43, 89, 14);
		contentPane.add(lblNewLabel);
		
		tfEname = new JTextField();

		tfEname.setBounds(136, 40, 124, 20);
		contentPane.add(tfEname);
		tfEname.setColumns(10);
		
		tfContact = new JTextField();
		tfContact.setBounds(431, 41, 124, 20);
		contentPane.add(tfContact);
		tfContact.setColumns(10);
		
		JLabel lbl = new JLabel("Email");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(10, 84, 89, 14);
		contentPane.add(lbl);
		
		tfEmail = new JTextField();
		tfEmail.setBounds(136, 81, 124, 20);
		contentPane.add(tfEmail);
		tfEmail.setColumns(10);
		
	
		
		JLabel lblParticpants = new JLabel("Contact");
		lblParticpants.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParticpants.setBounds(344, 43, 77, 16);
		contentPane.add(lblParticpants);
		
		lblServiceId = new JLabel("Service ID");
		lblServiceId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblServiceId.setBounds(344, 84, 77, 14);
		contentPane.add(lblServiceId);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Name=tfEname.getText();
				String email=tfEmail.getText();
				String Contact=tfContact.getText();
				String SID=(String)cb_Service.getSelectedItem();
				int theSID=Integer.parseInt(SID);
			
				try
				{
					
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Sponsors(Name,Contact_No,email,Service_ID) values(?,?,?,?)";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, Name);
					stmnt.setString(2, Contact);
					stmnt.setString(3, email);
					
					stmnt.setInt(4, theSID);
					
					stmnt.executeUpdate();
		
					JOptionPane.showMessageDialog(null, "Records Added");
					tfEname.setText("");
					tfEmail.setText("");
					tfContact.setText("");
				
					
				
					
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(531, 157, 89, 23);
		contentPane.add(btnCreate);
		
		cb_Service = new JComboBox<String>();
		cb_Service.setBounds(431, 82, 48, 20);
		contentPane.add(cb_Service);
		getServiceID();
		

	}
	
	public void getServiceID() {
		String a;
		int b;
		try {
			mysqlConnection=DataBaseConnection.dbConnector();
			String query="Select Service_ID from Services";
			PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
			ResultSet rs=stmnt.executeQuery();
			while(rs.next()) {
				b=rs.getInt(1);
				a=String.valueOf(b);
				cb_Service.addItem(a);
				}
				
			
		
				
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
