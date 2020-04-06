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

import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
public class CreateSponsorEvents extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;

	private JButton btnCreate;
	Connection mysqlConnection=null;
	private JComboBox<String> cb_Event;
	private JComboBox<String> cb_Sponsor;

	/**
	 * Launch the application.
	 */

	public CreateSponsorEvents() {
		setTitle("Create Sponsor has events");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 654, 186);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Event ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 43, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lbl = new JLabel("Sponsors ID");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(259, 43, 89, 14);
		contentPane.add(lbl);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				String EID=(String)cb_Event.getSelectedItem();
				int theEID=Integer.parseInt(EID);
				String SID=(String)cb_Sponsor.getSelectedItem();
				int theSID=Integer.parseInt(SID);
				try
				{
					
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Sponsors_has_Events(Sponsors_ID,Event_ID) values(?,?)";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setInt(1, theSID);
					stmnt.setInt(2, theEID);
					stmnt.executeUpdate();
		
					JOptionPane.showMessageDialog(null, "Records Added");
			
				
					
				
					
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(522, 39, 89, 23);
		contentPane.add(btnCreate);
		
		cb_Event = new JComboBox<String>();
		cb_Event.setBounds(109, 41, 63, 20);
		contentPane.add(cb_Event);
		
		cb_Sponsor = new JComboBox<String>();
		cb_Sponsor.setBounds(372, 41, 63, 20);
		contentPane.add(cb_Sponsor);
		getEventID();
		 getSponsorsID();
		
		

	}
	
	public void getEventID() {
		String a;
		int b;
		try {
			mysqlConnection=DataBaseConnection.dbConnector();
			String query="Select Event_ID from Events";
			PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
			ResultSet rs=stmnt.executeQuery();
			while(rs.next()) {
				b=rs.getInt(1);
				a=String.valueOf(b);
				cb_Event.addItem(a);
				}
				
			
		
				
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	
	public void getSponsorsID() {
		String a;
		int b;
		try {
			mysqlConnection=DataBaseConnection.dbConnector();
			String query="Select Sponsors_ID from Sponsors";
			PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
			ResultSet rs=stmnt.executeQuery();
			while(rs.next()) {
				b=rs.getInt(1);
				a=String.valueOf(b);
				cb_Sponsor.addItem(a);
			
				}
				
			
		
				
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
