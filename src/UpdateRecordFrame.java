

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class UpdateRecordFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfID;
	private JTextField tfNewContact;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnSponsors;
	private JRadioButton rdbtnBookie;
	private JButton btnUpdate;
	private JTextField tfName_1;
	private JTextField tfID_1;
	private JTextField tfSDate;
	private JButton btnUpdateDate;
	private JRadioButton rdbtnEvents;
	private JRadioButton rdbtnSpaceReq;
	private JTextField tfEDate;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	
	Connection mysqlConnection=null;
	private JTextField tfName_2;
	private JTextField tfID_2;
	private JComboBox<String> cb_Status;
	private JButton btnUpdateStatus;

	/**
	 * Launch the application.
	 */

	public UpdateRecordFrame() {
		setTitle("Update Records");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 664, 366);
		setResizable(false);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 25, 635, 294);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Contact Details", null, panel_1, null);
		panel_1.setLayout(null);
		
		rdbtnSponsors = new JRadioButton("Sponsors");
		rdbtnSponsors.setSelected(true);
		buttonGroup.add(rdbtnSponsors);
		rdbtnSponsors.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnSponsors.setBounds(48, 18, 86, 23);
		panel_1.add(rdbtnSponsors);
		rdbtnSponsors.setActionCommand("Sponsors");
		
		
		rdbtnBookie = new JRadioButton("Bookie");
		buttonGroup.add(rdbtnBookie);
		rdbtnBookie.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnBookie.setBounds(178, 18, 90, 23);
		panel_1.add(rdbtnBookie);
		rdbtnBookie.setActionCommand("Booked_By");
		
		tfName = new JTextField();
		tfName.setText("Name");
		tfName.setBounds(48, 65, 86, 20);
		panel_1.add(tfName);
		tfName.setColumns(10);
		
		
		tfName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfName.getText().equals("Name"))
					tfName.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfName.getText().equals(""))
					tfName.setText("Name");
			}
		});
		
		tfID = new JTextField();
		tfID.setText("ID");
		tfID.setBounds(150, 65, 86, 20);
		panel_1.add(tfID);
		tfID.setColumns(10);
		
		
		tfID.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfID.getText().equals("ID"))
					tfID.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfID.getText().equals(""))
					tfID.setText("ID");
			}
		});
		
		tfNewContact = new JTextField();
		tfNewContact.setText("New Contact");
		tfNewContact.setBounds(256, 65, 86, 20);
		panel_1.add(tfNewContact);
		tfNewContact.setColumns(10);
		
		tfNewContact.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfNewContact.getText().equals("New Contact"))
					tfNewContact.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfNewContact.getText().equals(""))
					tfNewContact.setText("New Contact");
			}
		});
		
		btnUpdate = new JButton("Update");
		
		
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String table=buttonGroup.getSelection().getActionCommand();
				String theName=tfName.getText();
				String ID=tfID.getText();
				String cont=tfNewContact.getText();
				int theID=Integer.parseInt(ID);
				if(table.equals("Sponsors")) {
				try {
					
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Update Sponsors set Contact_no=? where Name=? and Sponsors_ID=?";
					
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, cont);
					stmnt.setString(2, theName);
					stmnt.setInt(3,theID);
					stmnt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update Done");
					tfName.setText("Name");
					tfID.setText("ID");
					tfNewContact.setText("New Contact");
			

					
					
					
					
				}catch(Exception ee)
				{
						JOptionPane.showMessageDialog(null, ee);
				}
				
			}
				
				if(table.equals("Booked_By")) {
					try {
						
						mysqlConnection=DataBaseConnection.dbConnector();
						String query="Update Booked_By set Contact_no=? where Name=? and Booker_ID=?";
						
						PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
						stmnt.setString(1, cont);
						stmnt.setString(2, theName);
						stmnt.setInt(3,theID);
						stmnt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Update Done");
						tfName.setText("Name");
						tfID.setText("ID");
						tfNewContact.setText("New Contact");
					

						
						
						
					}catch(Exception ee)
					{
							JOptionPane.showMessageDialog(null, ee);
					}
					
					
				}
			
				
				if(table.equals("Contacts")) {
					try {
						
						mysqlConnection=DataBaseConnection.dbConnector();
						String query="Update Contacts set Telephone_no=? where Contact_Name=? and Contacts_ID=?";
						
						PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
						stmnt.setString(1, cont);
						stmnt.setString(2, theName);
						stmnt.setInt(3,theID);
						stmnt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Update Done");

						tfName.setText("Name");
						tfID.setText("ID");
						tfNewContact.setText("New Contact");
					
						
						
						
					}catch(Exception ee)
					{
							JOptionPane.showMessageDialog(null, ee);
					}
					
					
				}
				
				if(table.equals("Address")) {
					try {
						
						mysqlConnection=DataBaseConnection.dbConnector();
						String query="Update Address set phone_no=? where City=? and Address_ID=?";
						
						PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
						stmnt.setString(1, cont);
						stmnt.setString(2, theName);
						stmnt.setInt(3,theID);
						stmnt.executeUpdate();
						JOptionPane.showMessageDialog(null, "Update Done");
						tfName.setText("Name");
						tfID.setText("ID");
						tfNewContact.setText("New Contact");

					
						
						
					}catch(Exception ee)
					{
							JOptionPane.showMessageDialog(null, ee);
					}
					
					
				}
			
				
				
				
				
				}
			
			
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(442, 98, 89, 23);
		panel_1.add(btnUpdate);
		
		JRadioButton rdbtnAddress = new JRadioButton("Address");
		buttonGroup.add(rdbtnAddress);
		rdbtnAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnAddress.setBounds(302, 18, 109, 23);
		panel_1.add(rdbtnAddress);
		rdbtnAddress.setActionCommand("Address");
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Date", null, panel, null);
		panel.setLayout(null);
		
		rdbtnEvents = new JRadioButton("Events");
		buttonGroup_1.add(rdbtnEvents);
		rdbtnEvents.setSelected(true);
		rdbtnEvents.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnEvents.setBounds(40, 29, 86, 23);
		panel.add(rdbtnEvents);
		rdbtnEvents.setActionCommand("Events");
		
		
		rdbtnSpaceReq = new JRadioButton("Space Req");
		buttonGroup_1.add(rdbtnSpaceReq);
		rdbtnSpaceReq.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnSpaceReq.setBounds(231, 29, 103, 23);
		panel.add(rdbtnSpaceReq);
		rdbtnSpaceReq.setActionCommand("Space_Request");
		
		tfName_1 = new JTextField();
		tfName_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfName_1.getText().equals("Name"))
					tfName_1.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfName_1.getText().equals(""))
					tfName_1.setText("Name");
			}
		});
		
		tfName_1.setText("Name");
		tfName_1.setColumns(10);
		tfName_1.setBounds(40, 76, 86, 20);
		panel.add(tfName_1);
		
		tfID_1 = new JTextField();
		tfID_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfID_1.getText().equals("ID"))
					tfID_1.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfID_1.getText().equals(""))
					tfID_1.setText("ID");
			}
		});
		tfID_1.setText("ID");
		tfID_1.setColumns(10);
		tfID_1.setBounds(142, 76, 86, 20);
		panel.add(tfID_1);
		
		tfSDate = new JTextField();
		tfSDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfSDate.getText().equals("Start Date"))
					tfSDate.setText("");
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfSDate.getText().equals(""))
					tfSDate.setText("Start Date");
				
			}
		});
		tfSDate.setText("Start Date");
		tfSDate.setColumns(10);
		tfSDate.setBounds(248, 76, 86, 20);
		panel.add(tfSDate);
		
		btnUpdateDate = new JButton("Update");
		btnUpdateDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateDate.setBounds(434, 109, 89, 23);
		panel.add(btnUpdateDate);
		
		tfEDate = new JTextField();
		tfEDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				if(tfEDate.getText().equals("End Date"))
					tfEDate.setText("");
				
					
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfEDate.getText().equals(""))
					tfEDate.setText("End Date");
				
			}
		});
		tfEDate.setText("End Date");
		tfEDate.setBounds(379, 76, 86, 20);
		panel.add(tfEDate);
		tfEDate.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Event Status", null, panel_2, null);
		panel_2.setLayout(null);
		
		tfName_2 = new JTextField();
		tfName_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfName_2.getText().equals("Name"))
					tfName_2.setText("");
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfName_2.getText().equals(""))
					tfName_2.setText("Name");
			}
		});
		tfName_2.setText("Name");
		tfName_2.setBounds(26, 52, 86, 20);
		panel_2.add(tfName_2);
		tfName_2.setColumns(10);
		
		tfID_2 = new JTextField();
		tfID_2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(tfID_2.getText().equals("ID"))
					tfID_2.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(tfID_2.getText().equals(""))
					tfID_2.setText("ID");
				
			}
		});
		tfID_2.setText("ID");
		tfID_2.setBounds(196, 52, 86, 20);
		panel_2.add(tfID_2);
		tfID_2.setColumns(10);
		
		cb_Status = new JComboBox<String>();
		DefaultComboBoxModel<String>  model1=new DefaultComboBoxModel<String>();
		model1.addElement("Registered");
		model1.addElement("Cancelled");
		model1.addElement("Booked");
		model1.addElement("Completed");
		model1.addElement("Paid");
		cb_Status.setModel(model1);

		cb_Status.setBounds(483, 52, 101, 20);
		panel_2.add(cb_Status);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(413, 54, 46, 14);
		panel_2.add(lblStatus);
		
		btnUpdateStatus = new JButton("Update");
		btnUpdateStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String thename=tfName_2.getText();
				String ID=tfID_2.getText();
				int theID=Integer.parseInt(ID);
				int newStatus=getStatus();
				try {
					Connection mysqlConnection=DataBaseConnection.dbConnector();
					String query="Update Events Set Event_Status=? where Event_ID=? and Event_Name=?";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setInt(1, newStatus);
					stmnt.setInt(2, theID);
					stmnt.setString(3, thename);
					stmnt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Updated");
					tfName_2.setText("Name");
					tfID_2.setText("ID");
					
					
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
				
				
			}
		});
	
		btnUpdateStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateStatus.setBounds(239, 107, 89, 23);
		panel_2.add(btnUpdateStatus);
		
		
		rdbtnSpaceReq.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tfName_1.setEnabled(false);
				
			}
			
		});
		 
		rdbtnEvents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfName_1.setEnabled(true);
				
			}
			
		});
		
		btnUpdateDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tb=buttonGroup_1.getSelection().getActionCommand();
				String thename=tfName_1.getText();
				String ID=tfID_1.getText();
				int theID=Integer.parseInt(ID);
				String SD=tfSDate.getText();
				String ED=tfEDate.getText();
				if(tb.equals("Events"))
				{

				try 
				{
					Connection mysqlConnection=DataBaseConnection.dbConnector();
					String query="Update Events set Start_date=? ,end_date=? where Event_ID=? and Event_Name=?";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, SD);
					stmnt.setString(2, ED);
					stmnt.setInt(3, theID);
					stmnt.setString(4, thename);
					stmnt.executeUpdate();
			
					JOptionPane.showMessageDialog(null, "Update Done");




					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
				
				
				
			}
				
				if(tb.equals("Space_Request"))
				{

				try 
				{
					Connection mysqlConnection=DataBaseConnection.dbConnector();
					String query="Update Space_Request set from_date=?,to_date=? where Space_Request_ID=? ";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, SD);
					stmnt.setString(2, ED);
					stmnt.setInt(3, theID);
				
					stmnt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update Done");

			



					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
				
				
				
			}
				else {
					JOptionPane.showMessageDialog(null, "Invalid arguemnts");
				}
				}
			
		});
		
		
	
}
	public int getStatus() {
		String ans=(String)cb_Status.getSelectedItem();

		if(ans.equalsIgnoreCase("Registered"))
			return 1;
		else if(ans.equalsIgnoreCase("Cancelled"))
			return 2;
		else if(ans.equalsIgnoreCase("Booked"))
			return 3;
		else if(ans.equalsIgnoreCase("Completed"))
			return 4;
		else
			return 5;
			
	}
		}
