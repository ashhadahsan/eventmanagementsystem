import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
public class CreateEventFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfEname;
	private JTextField tfPart;
	private JTextField tfSDate;
	private JTextField tfEDate;
	private JLabel lblComments;
	private JLabel lblOtherrDetails;
	private JTextField tfDis;
	private JTextField tfPaid;
	private JTextField tfCost;
	private JTextField tfXtraCost;
	private JButton btnCreate;
	private JLabel lblOrganzierId;
	private JLabel lblEventStatus;
	private JLabel lblEventType;
	private JLabel lblVenue;
	private JLabel lblFreeOrCommercial;
	private JTextArea tfcmnt;
	private JTextArea tfdet;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	Connection mysqlConnection=null;
	private JComboBox<String> cb_Org;
	private JComboBox<String> cb_Status;
	private 	DefaultComboBoxModel<String>  model1;
	private 	DefaultComboBoxModel<String>  model2;
	private JComboBox<String> cb_Event;
	private JComboBox<String> cb_Venue;
	private JComboBox<String> cb_free;

	/**
	 * Launch the application.
	 */

	public CreateEventFrame() {
		setTitle("Create Event");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Event Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 43, 89, 14);
		contentPane.add(lblNewLabel);
		
		tfEname = new JTextField();
	
		tfEname.setBounds(136, 40, 124, 20);
		contentPane.add(tfEname);
		tfEname.setColumns(10);
		
		tfPart = new JTextField();
		tfPart.setBounds(431, 41, 124, 20);
		contentPane.add(tfPart);
		tfPart.setColumns(10);
		
		JLabel lblName = new JLabel("Start Date");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(10, 84, 89, 14);
		contentPane.add(lblName);
		
		tfSDate = new JTextField();
		tfSDate.setBounds(136, 81, 124, 20);
		contentPane.add(tfSDate);
		tfSDate.setColumns(10);
		
		JLabel lblSubject_1 = new JLabel("Amount Paid");
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject_1.setBounds(344, 121, 113, 14);
		contentPane.add(lblSubject_1);
		
		tfEDate = new JTextField();
		tfEDate.setBounds(431, 82, 124, 20);
		contentPane.add(tfEDate);
		tfEDate.setColumns(10);
		
	
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEndDate.setBounds(344, 84, 77, 16);
		contentPane.add(lblEndDate);
		
		JLabel lblParticpants = new JLabel("Particpants");
		lblParticpants.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParticpants.setBounds(344, 43, 77, 16);
		contentPane.add(lblParticpants);
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDiscount.setBounds(10, 121, 55, 16);
		contentPane.add(lblDiscount);
		
		JLabel lblC = new JLabel("Calculate Cost");
		lblC.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblC.setBounds(10, 163, 89, 14);
		contentPane.add(lblC);
		
		JLabel lblExtraCost = new JLabel("Extra Cost");
		lblExtraCost.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExtraCost.setBounds(344, 163, 77, 14);
		contentPane.add(lblExtraCost);
		
		lblComments = new JLabel("Comments");
		lblComments.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblComments.setBounds(10, 343, 89, 14);
		contentPane.add(lblComments);
		
		lblOtherrDetails = new JLabel("Other Details");
		lblOtherrDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOtherrDetails.setBounds(344, 297, 89, 14);
		contentPane.add(lblOtherrDetails);
		
		tfDis = new JTextField();
		tfDis.setText("0");
		tfDis.setBounds(136, 119, 124, 20);
		contentPane.add(tfDis);
		tfDis.setColumns(10);
		
		tfPaid = new JTextField();
		tfPaid.setText("0");
		tfPaid.setColumns(10);
		tfPaid.setBounds(431, 119, 124, 20);
		contentPane.add(tfPaid);
		
		tfCost = new JTextField();
		tfCost.setText("0");
		tfCost.setColumns(10);
		tfCost.setBounds(136, 161, 124, 20);
		contentPane.add(tfCost);
		
		tfXtraCost = new JTextField();
		tfXtraCost.setText("0");
		tfXtraCost.setColumns(10);
		tfXtraCost.setBounds(431, 161, 124, 20);
		contentPane.add(tfXtraCost);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(522, 438, 89, 23);
		contentPane.add(btnCreate);
		
		lblOrganzierId = new JLabel("Organzier ID");
		lblOrganzierId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrganzierId.setBounds(10, 213, 89, 14);
		contentPane.add(lblOrganzierId);
		
		lblEventStatus = new JLabel("Event Status");
		lblEventStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEventStatus.setBounds(344, 213, 89, 14);
		contentPane.add(lblEventStatus);
		
		lblEventType = new JLabel("Event Type ID");
		lblEventType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEventType.setBounds(10, 260, 89, 14);
		contentPane.add(lblEventType);
		
		lblVenue = new JLabel("Venue ID");
		lblVenue.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVenue.setBounds(344, 260, 62, 14);
		contentPane.add(lblVenue);
		
		lblFreeOrCommercial = new JLabel("Free or commercial");
		lblFreeOrCommercial.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFreeOrCommercial.setBounds(10, 297, 134, 14);
		contentPane.add(lblFreeOrCommercial);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 375, 227, 62);
		contentPane.add(scrollPane);
		
		tfcmnt = new JTextArea();
		scrollPane.setViewportView(tfcmnt);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(372, 339, 243, 88);
		contentPane.add(scrollPane_1);
		
		tfdet = new JTextArea();
		scrollPane_1.setViewportView(tfdet);
		
		cb_Org = new JComboBox<String>();
		cb_Org.setBounds(136, 211, 55, 20);
		
		
		contentPane.add(cb_Org);
		
		cb_Status = new JComboBox<String>();
		cb_Status.setBounds(443, 211, 112, 20);
		contentPane.add(cb_Status);
		
	 model1=new DefaultComboBoxModel<String>();
		model1.addElement("Registered");
		model1.addElement("Cancelled");
		model1.addElement("Booked");
		model1.addElement("Completed");
		model1.addElement("Paid");
		cb_Status.setModel(model1);
		cb_Event = new JComboBox<String>();
		cb_Event.setBounds(136, 258, 55, 20);
		contentPane.add(cb_Event);
		
		cb_Venue = new JComboBox<String>();
		cb_Venue.setBounds(443, 258, 55, 20);
		contentPane.add(cb_Venue);
		
		cb_free = new JComboBox<String>();
		cb_free.setBounds(136, 295, 113, 20);
		contentPane.add(cb_free);
		model2=new DefaultComboBoxModel<String>();
		model2.addElement("Free");
		model2.addElement("Commercial");
		cb_free.setModel(model2);
		
		
		
		getOrganizerID();
		getEventTypeID();
		getVenueID();

		

		
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=tfEname.getText();
				String SD=tfSDate.getText();
				String ED=tfEDate.getText();
				String part=tfPart.getText();
				int thePart=Integer.parseInt(part);
				
				String dis=tfDis.getText();
				int theDis=Integer.parseInt(dis);
				
				String Paid=tfPaid.getText();
				int thePaid=Integer.parseInt(Paid);
				
				String Cost=tfCost.getText();
				int theCost=Integer.parseInt(Cost);
				String extracost=tfXtraCost.getText();
				int theExtraCost=Integer.parseInt(extracost);
				String Comment=tfcmnt.getText();
				String od=tfdet.getText();
				String OID=(String)cb_Org.getSelectedItem();
				int theOID=Integer.parseInt(OID);
				String EType=(String)cb_Event.getSelectedItem();
				int theType=Integer.parseInt(EType);
				String Ven=(String)cb_Venue.getSelectedItem();
				int theVenue=Integer.parseInt(Ven);
				int theStatus=getStatus();
			
			
				
				int theFree=getfreeorcom();
				
				
				
				
		
				try
				{
				
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Events"
							+ "(Event_Name,"
							+ "Start_Date,"
							+ "End_Date,"
							+ "number_of_partcipants,"
							+ "Discount,"
							+ "Amount_Paid"
							+ ",Calculated_Cost,"
							+ "Extra_Cost,"
							+ "Comments,"
							+ "Other_Details,"
							+ "Organizers_ID,"
							+ "Event_Types_ID,"
							+ "Venue_id,"
							+ "event_status,"
							+ "free_or_commercial) "
							+ "values("
							+ "?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?"
							+ ",?)";
					
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, Name);
					stmnt.setString(2, SD);
					stmnt.setString(3, ED);
					stmnt.setInt(4, thePart);
					stmnt.setInt(5, theDis);
					stmnt.setInt(6, thePaid);
					stmnt.setInt(7, theCost);
					stmnt.setInt(8, theExtraCost);
					stmnt.setString(9, Comment);
					stmnt.setString(10, od);
					stmnt.setInt(11, theOID);
					stmnt.setInt(12, theType);
					stmnt.setInt(13, theVenue);
					stmnt.setInt(14, theStatus);
					stmnt.setInt(15, theFree);
					
					
					stmnt.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Added");
					tfEname.setText("");
					tfSDate.setText("");
					tfEDate.setText("");
					tfPart.setText("");
					tfDis.setText("");
					tfCost.setText("");
					tfPaid.setText("");
					tfXtraCost.setText("");
					tfcmnt.setText("");
					tfdet.setText("");
				
				

					
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null,ee);}
			}
		});
		
		
	}
	public void getOrganizerID()
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
				cb_Org.addItem(conv);
				
			}

	}
		catch(Exception ee)
		{
		JOptionPane.showMessageDialog(null, ee);
		}
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
	
	public void getEventTypeID()
	
	{
		int a;
		String conv;
			try 
			{
				mysqlConnection=DataBaseConnection.dbConnector();
				String query="Select Event_Types_ID from Event_Types";
				PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
				ResultSet rs=stmnt.executeQuery();
				while(rs.next())
					
				{
					a=rs.getInt(1);
					conv=String.valueOf(a);
					cb_Event.addItem(conv);
					
				}

		}
			catch(Exception ee)
			{
			JOptionPane.showMessageDialog(null, ee);
			}
	}
	public void getVenueID()
	{
		int a;
		String conv;
			try 
			{
				mysqlConnection=DataBaseConnection.dbConnector();
				String query="Select Venue_ID from Venue";
				PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
				ResultSet rs=stmnt.executeQuery();
				while(rs.next())
					
				{
					a=rs.getInt(1);
					conv=String.valueOf(a);
					cb_Venue.addItem(conv);
					
				}

		}
			catch(Exception ee)
			{
			JOptionPane.showMessageDialog(null, ee);
			}
	}
	
	public int getfreeorcom() {
		String ans=(String)cb_free.getSelectedItem();
		if(ans.equalsIgnoreCase("Free"))
			return 1;
		else 
			return 2;
		
	}
	

	
}

