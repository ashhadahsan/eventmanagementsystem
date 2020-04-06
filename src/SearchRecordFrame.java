import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchRecordFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnSearch;
	Connection mysqlConnection=null;
	private JLabel label;
	private JLabel lblCriteria;
	private JTextField tfName;
	private JTextField tfID;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JRadioButton rdtbnName;
	private JRadioButton rdbtnID;
	private JRadioButton rdbtnBoth;
	private JRadioButton rdbtnb;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
	private JRadioButton rdbtnEventSponsors;
	private JRadioButton rdbtnSpaceRequest;
	private JRadioButton radioButton_6;
	private JRadioButton radioButton_7;
	private JRadioButton radioButton_8;
	private JRadioButton radioButton_9;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String thename;
	private String S;
	private int theID;
	private String tb;
	private JRadioButton rdbtnEventTypes;
	
	

	/**
	 * Launch the application.
	 */

	public SearchRecordFrame() {
		setResizable(true);
		setTitle("Search Record");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 726, 555);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 177, 659, 314);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(562, 114, 89, 23);
		contentPane.add(btnSearch);
		
		label = new JLabel("Record");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 39, 46, 14);
		contentPane.add(label);
		
		lblCriteria = new JLabel("Criteria");
		lblCriteria.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCriteria.setBounds(10, 118, 46, 14);
		contentPane.add(lblCriteria);
		
		
	
		tfName = new JTextField();
		tfName.setEnabled(false);
	
		tfName.setBounds(430, 101, 86, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfID = new JTextField();

		tfID.setEnabled(false);
		tfID.setBounds(430, 136, 86, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		
		

	
	
		rdtbnName = new JRadioButton("Name");
		buttonGroup_1.add(rdtbnName);
		rdtbnName.setActionCommand("Name");
		rdtbnName.setBounds(62, 115, 69, 23);
		contentPane.add(rdtbnName);
		
		rdbtnID = new JRadioButton("ID");
		buttonGroup_1.add(rdbtnID);
		rdbtnID.setActionCommand("ID");
		rdbtnID.setBounds(147, 115, 37, 23);
		contentPane.add(rdbtnID);
		
		rdbtnBoth = new JRadioButton("Both");
		buttonGroup_1.add(rdbtnBoth);
		rdbtnBoth.setActionCommand("Both");
		rdbtnBoth.setBounds(211, 115, 69, 23);
		contentPane.add(rdbtnBoth);
		
		rdbtnb = new JRadioButton("Events");
		buttonGroup.add(rdbtnb);
		rdbtnb.setSelected(true);
		rdbtnb.setActionCommand("Events");
		rdbtnb.setBounds(78, 27, 65, 23);
		contentPane.add(rdbtnb);
		
		radioButton_1 = new JRadioButton("Rooms");
		buttonGroup.add(radioButton_1);
		radioButton_1.setActionCommand("Rooms");
		radioButton_1.setBounds(77, 53, 81, 23);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("Organizers");
		buttonGroup.add(radioButton_2);
		radioButton_2.setActionCommand("Organizers");
		radioButton_2.setBounds(170, 27, 92, 23);
		contentPane.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("Bookie");
		buttonGroup.add(radioButton_3);
		radioButton_3.setActionCommand("Booked_by");
		radioButton_3.setBounds(176, 54, 65, 23);
		contentPane.add(radioButton_3);
		
		rdbtnEventSponsors = new JRadioButton("Event Sponsors");
		buttonGroup.add(rdbtnEventSponsors);
		rdbtnEventSponsors.setActionCommand("Sponsors_has_events");
		rdbtnEventSponsors.setBounds(264, 27, 118, 23);
		contentPane.add(rdbtnEventSponsors);
		rdbtnEventSponsors.setEnabled(false);
		
		rdbtnEventSponsors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "You can only search by event ID");
				
			}
			
		});
		
		
		rdbtnSpaceRequest = new JRadioButton("Space Request");
		buttonGroup.add(rdbtnSpaceRequest);
		rdbtnSpaceRequest.setActionCommand("Space_request");
		rdbtnSpaceRequest.setBounds(265, 54, 117, 23);
		contentPane.add(rdbtnSpaceRequest);
		
		radioButton_6 = new JRadioButton("Address");
		buttonGroup.add(radioButton_6);
		radioButton_6.setActionCommand("Address");
		radioButton_6.setBounds(389, 27, 89, 23);
		contentPane.add(radioButton_6);
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(336, 103, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(336, 138, 46, 14);
		contentPane.add(lblId);
		
		radioButton_7 = new JRadioButton("Venue");
		buttonGroup.add(radioButton_7);
		radioButton_7.setActionCommand("Venue");
		radioButton_7.setBounds(392, 54, 81, 23);
		contentPane.add(radioButton_7);
		
		radioButton_8 = new JRadioButton("Services");
		buttonGroup.add(radioButton_8);
		radioButton_8.setActionCommand("Services");
		radioButton_8.setBounds(534, 27, 81, 23);
		contentPane.add(radioButton_8);
		
		radioButton_9 = new JRadioButton("Sponsors");
		buttonGroup.add(radioButton_9);
		radioButton_9.setActionCommand("Sponsors");
		radioButton_9.setBounds(544, 54, 89, 23);
		contentPane.add(radioButton_9);
		
		rdbtnEventTypes = new JRadioButton("Event Types");
		buttonGroup.add(rdbtnEventTypes);
		rdbtnEventTypes.setBounds(75, 79, 109, 23);
		contentPane.add(rdbtnEventTypes);
		rdbtnEventTypes.setActionCommand("Event_Types");
		rdbtnEventTypes.setEnabled(true);
		
		
		
		rdtbnName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setEnabled(true);
				tfID.setEnabled(false);
				rdbtnEventTypes.setEnabled(false);
			}
			
		});
		
		
		rdbtnID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setEnabled(false);
				tfID.setEnabled(true);
				rdbtnEventSponsors.setEnabled(true);

			}
			
		});
		
	
		
		rdbtnBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfName.setEnabled(true);
				tfID.setEnabled(true);
				rdbtnEventSponsors.setEnabled(false);

				//System.out.println(rdbtnBoth.isSelected());

			}
			
		});
		
		
		
		
		btnSearch.addActionListener(new ActionListener() 
		
		{
			
		
			public void actionPerformed(ActionEvent e) 
			{
			
				tb=buttonGroup.getSelection().getActionCommand();
				boolean A=rdbtnBoth.isSelected();
				boolean B=rdtbnName.isSelected();
				boolean C=rdbtnID.isSelected();
			
				//boolean A=!(thename.isEmpty() && S.isEmpty());//ifboth are not empty means the user selects rdbtnBoth
				//boolean B=S.isEmpty(); //User selects Name only
				//boolean C=thename.isEmpty(); //User selects ID only
			
			
				
				if (A && tb.equalsIgnoreCase("Events")) 
				{
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Events where Event_name=? and Event_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();
						
					}
					catch(Exception ee)
					{
							JOptionPane.showMessageDialog(null, ee);
					}
		
					
				}
				else {
					
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);
					
				}
			
				
				
				if(A && tb.equalsIgnoreCase("Organizers")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);


					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Organizers where Name=? and Organizers_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}
					catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
			
				
				if(A && tb.equalsIgnoreCase("Address")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Address where City=? and Address_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				if(A && tb.equalsIgnoreCase("Rooms")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Rooms where Room_name=? and Room_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(A && tb.equalsIgnoreCase("Booked_By")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Booked_By where name=? and Booker_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(A && tb.equalsIgnoreCase("Venue")) {
					
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Venue where Venue_name=? and Venue_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(A && tb.equalsIgnoreCase("Sponsors")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Sponsors where name=? and Sponsors_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);
					}
				
				
				if(A && tb.equalsIgnoreCase("Event_Types")) 
				{
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * Event_Types where Description=? and 	Event_Types_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);
					}
				if(A && tb.equalsIgnoreCase("Services")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Services where Type=? and Service_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);
					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				
				
				
				
				if( B && tb.equalsIgnoreCase("Events")) {
					thename=tfName.getText();
					

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Events where Event_Name=?");
						stmnt.setString(1, thename);
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists,Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				

				if( B && tb.equalsIgnoreCase("Event_Types")) 
				{
					thename=tfName.getText();
					

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Event_Types where Description=?");
						stmnt.setString(1, thename);
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists,Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				if( B && tb.equalsIgnoreCase("Organizers")) {
					thename=tfName.getText();

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Organizers where Name=?");
					
						stmnt.setString(1, thename);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						mysqlConnection.close();

					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists,Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				
				
				if(B && tb.equalsIgnoreCase("Address")) {
					thename=tfName.getText();

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Address where City=?");
					
						stmnt.setString(1, thename);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists,Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);
					}
				
				if(B && tb.equalsIgnoreCase("Rooms")) {
					
					thename=tfName.getText();

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Rooms where Room_name=?");
					
						stmnt.setString(1, thename);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists,try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(B && tb.equalsIgnoreCase("Booked_By")) {
					thename=tfName.getText();

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Booked_By where Name=?");
					
						stmnt.setString(1, thename);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists,Try another crietria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				if(B && tb.equalsIgnoreCase("Services")) {
					thename=tfName.getText();

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Servcies where Type=?");
					
						stmnt.setString(1, thename);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists,Try another crietria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				
				if(B && tb.equalsIgnoreCase("Venue")) {
					thename=tfName.getText();

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Venue where Venue_name=?");
					
						stmnt.setString(1, thename);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(B && tb.equalsIgnoreCase("Sponsors")) {
					thename=tfName.getText();

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Sponsors where Name=?");
					
						stmnt.setString(1, thename);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				
				if(C && tb.equalsIgnoreCase("Events")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Events where Event_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				
				if(C && tb.equalsIgnoreCase("Event_Types")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Event_Types where Event_Types_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(C && tb.equalsIgnoreCase("Organizers")) {
					
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Organizers where Organizers_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				if(C && tb.equalsIgnoreCase("Organizers")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Organizers where Organizers_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(C && tb.equalsIgnoreCase("Sponsors_has_events")) 
				{
				
					
				
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Sponsors_has_Events where Event_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				if(C && tb.equalsIgnoreCase("Address")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						String query="Select * from Address where Address_ID=?";
						PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
//						mysqlConnection.close();

						
					}catch(Exception ee)
					{
							JOptionPane.showMessageDialog(null,ee);
					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);
					}
				
				if(C && tb.equalsIgnoreCase("Services"))
				{
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Services where Service_ID=?");
					
						stmnt.setInt(1, theID);
				
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));		
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				if(C && tb.equalsIgnoreCase("Rooms")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Rooms where Room_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
					//	mysqlConnection.close();

					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				if(C && tb.equalsIgnoreCase("Booked_By")) {
					
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Booked_By where Booker_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
							JOptionPane.showMessageDialog(null, ee);
					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}

				if(C && tb.equalsIgnoreCase("Venue")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Venue where Venue_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);
					}
				if(C && tb.equalsIgnoreCase("Sponsors")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Sponsors where Sponsors_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
								JOptionPane.showMessageDialog(null, ee);
					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);
					}

				if(C && tb.equalsIgnoreCase("Space_Request")) {
					S=tfID.getText();
					theID=Integer.parseInt(S);
					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Select * from Space_Request where Space_Request_ID=?");
					
						stmnt.setInt(1, theID);
				
						ResultSet rs=stmnt.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
					//	mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);
					}
				}
				else {
					//JOptionPane.showMessageDialog(null, "Such record does not exists, Try another criteria ");
					rdtbnName.setSelected(false);
					rdbtnID.setSelected(false);
					rdbtnBoth.setSelected(false);}
				
				
				
			}
			
			
				
				
					
				
				
				
	
			
		
		}
		
		);
		
		
	
		

	}
}
