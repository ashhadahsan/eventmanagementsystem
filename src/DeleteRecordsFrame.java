import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import javax.swing.border.EmptyBorder;


import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DeleteRecordsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnDlt;
	Connection mysqlConnection=null;
	private JLabel label;
	private JTextField tfName;
	private JTextField tfID;

	private JRadioButton rdbtnb;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	private JRadioButton radioButton_3;
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
	
	

	/**
	 * Launch the application.
	 */

	public DeleteRecordsFrame() {
		setResizable(true);
		setTitle("Search Record");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 680, 233);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnDlt = new JButton("Delete");
		
		btnDlt.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDlt.setBounds(562, 99, 89, 23);
		contentPane.add(btnDlt);
		
		label = new JLabel("Record");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(10, 39, 46, 14);
		contentPane.add(label);
		
		
	
		tfName = new JTextField();
	
		tfName.setBounds(78, 101, 86, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		tfID = new JTextField();
		tfID.setBounds(304, 99, 86, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
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
		lblName.setBounds(10, 103, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblId.setBounds(226, 103, 46, 14);
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
		radioButton_9.setBounds(265, 27, 89, 23);
		contentPane.add(radioButton_9);
		
		
		
		
		btnDlt.addActionListener(new ActionListener() 
		
		{
			
		
			public void actionPerformed(ActionEvent e) 
			{
			

				if(tfName.getText().isEmpty()|| tfID.getText().isEmpty() ) {
					JOptionPane.showMessageDialog(null, "Both fields are required");
					tfName.setText("");
					tfID.setText("");
				}
				else 
				
				{
					tb=buttonGroup.getSelection().getActionCommand();
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);	
				
			
			
				
				if (tb.equalsIgnoreCase("Events")) 
				{
					

					

					try {
						
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Events where Event_name=? and Event_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");
						//mysqlConnection.close();
						
					}
					catch(Exception ee)
					{
							JOptionPane.showMessageDialog(null, ee);
					}
		
					
				}
		
			
				
				
				if(tb.equalsIgnoreCase("Organizers")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);


					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Organizers where Name=? and Organizers_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						stmnt.execute();

						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");

						
						//mysqlConnection.close();

						
					}
					catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				
				
				if( tb.equalsIgnoreCase("Contacts")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Contacts where Contact_name=? and Contacts_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
					
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");


						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
	
				if( tb.equalsIgnoreCase("Address")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Address where City=? and Address_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");


						//mysqlConnection.close();

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
			
				
				if(tb.equalsIgnoreCase("Rooms")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Rooms where Room_name=? and Room_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");

						


						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
			
				if( tb.equalsIgnoreCase("Booked_By")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Booked_By where name=? and Booker_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");


						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
			
				if( tb.equalsIgnoreCase("Venue")) {
					
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Venue where Venue_name=? and Venue_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
				
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");



						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
				
				if(tb.equalsIgnoreCase("Sponsors")) {
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("Delete from Sponsors where name=? and Sponsors_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");

				


						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);

					}
		
					
				}
			
				if( tb.equalsIgnoreCase("Services"))
				{
					thename=tfName.getText();
					S=tfID.getText();
					theID=Integer.parseInt(S);

					try {
						mysqlConnection=DataBaseConnection.dbConnector();
		

						
						PreparedStatement stmnt=mysqlConnection.prepareStatement("delete from Services where Type=? and Service_ID=?");
						stmnt.setString(1, thename);
						stmnt.setInt(2, theID);
						stmnt.execute();
						JOptionPane.showMessageDialog(null, "Record deleted");
						tfName.setText("");
						tfID.setText("");

						
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null, ee);
					}
		
					
				}
				}
			
				
				
				
			}	
				
					
				
				
				
	
			
		
		}
		
		);
		
		
	
		

	}
}
