import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class CreateAddressFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfEname;
	private JTextField tfStreet;


	private JTextField tfPhoneNo;
	private JLabel lblWebiste;
	Connection mysqlConnection=null;
	private JTextField tfMno;
	private JLabel lblOrganizerId;
	private JComboBox<String> cb_OrgID;

	

	/**
	 * Launch the application.
	 */

	public CreateAddressFrame() {
		setTitle("Create Address");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("City");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 43, 108, 14);
		contentPane.add(lblNewLabel);
		tfEname=new JTextField();
	
		tfEname.setBounds(128, 41, 124, 20);
		contentPane.add(tfEname);
		tfEname.setColumns(10);
		
		JLabel lbl = new JLabel("Street");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(354, 43, 89, 14);
		contentPane.add(lbl);
		
		tfStreet = new JTextField();
		tfStreet.setBounds(450, 41, 124, 20);
		contentPane.add(tfStreet);
		tfStreet.setColumns(10);
		tfPhoneNo = new JTextField();
		tfPhoneNo.setBounds(128, 82, 124, 20);
		contentPane.add(tfPhoneNo);
		tfPhoneNo.setColumns(10);
		
		lblWebiste = new JLabel("Phone no");
		lblWebiste.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWebiste.setBounds(10, 84, 66, 14);
		contentPane.add(lblWebiste);
		
		
		JLabel lblNewLabel_1 = new JLabel("Mobile no");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(354, 85, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		tfMno = new JTextField();
		tfMno.setBounds(450, 82, 124, 20);
		contentPane.add(tfMno);
		tfMno.setColumns(10);
		
		lblOrganizerId = new JLabel("Organizer ID");
		lblOrganizerId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrganizerId.setBounds(10, 132, 83, 14);
		contentPane.add(lblOrganizerId);
		
		cb_OrgID = new JComboBox<String>();
	
	
		showOrgID();
		
		cb_OrgID.setBounds(128, 129, 48, 20);
		contentPane.add(cb_OrgID);
		
		JButton btnCreateR = new JButton("Create");
		btnCreateR.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreateR.setBounds(354, 129, 89, 23);
		contentPane.add(btnCreateR);
		
	
		

		btnCreateR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city=tfEname.getText();
				String street=tfStreet.getText();
				String phone=tfPhoneNo.getText();
				String mnp=tfMno.getText();
				String orgID=(String)cb_OrgID.getSelectedItem();
				int theOrgID=Integer.parseInt(orgID);
						
				try {
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into address(city,street,phone_no,mobile_no,Organizers_ID)  values (?,?,?,?,?)";
					PreparedStatement stmnt=mysqlConnection.prepareCall(query);
					stmnt.setString(1, city);
					stmnt.setString(2	, street);
					stmnt.setString(3, phone);
					stmnt.setString(4, mnp);
					stmnt.setInt(5, theOrgID);
					stmnt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Record Added");
		
					tfEname.setText("");
					tfStreet.setText("");
					tfPhoneNo.setText("");
					tfMno.setText("");
					



					
					
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
	
		
	
	}
public void showOrgID()
{
int a;
String conv;
	try 
	{
		mysqlConnection=DataBaseConnection.dbConnector();
		String query="Select Organizers_ID from Organizers";
		PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
		ResultSet rs=stmnt.executeQuery();
		while(rs.next())
			
		{
			a=rs.getInt(1);
			conv=String.valueOf(a);
			cb_OrgID.addItem(conv);
			
		}

}
	catch(Exception ee)
	{
	JOptionPane.showMessageDialog(null, ee);
	}
}
}
	
