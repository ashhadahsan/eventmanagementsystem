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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
public class CreateSpaceRequestFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfFrom;
	private JTextField tfTo;

	private JButton btnCreate;
	private JLabel lblRoomId;
	private JLabel lblNewLabel_1;
	Connection msyqlConnection=null;
	private JComboBox<String> cb_Room;
	private JComboBox <String>cbBookingStatus;
	private DefaultComboBoxModel<String> model;
	private JLabel lblOrganizersId;
	private JComboBox<String> cb_Org;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnNo;
	private JRadioButton rdbtnNewRadioButton;

	/**
	 * Launch the application.
	 */

	public CreateSpaceRequestFrame() {
		setTitle("Create Space Request");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Occupancy");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 43, 77, 14);
		contentPane.add(lblNewLabel);
		
		tfFrom = new JTextField();
		tfFrom.setBounds(431, 41, 124, 20);
		contentPane.add(tfFrom);
		tfFrom.setColumns(10);
		
		JLabel lbl = new JLabel("Date To");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(10, 84, 89, 14);
		contentPane.add(lbl);
		
		tfTo = new JTextField();
		tfTo.setBounds(136, 81, 124, 20);
		contentPane.add(tfTo);
		tfTo.setColumns(10);
		
		lblRoomId = new JLabel("Room ID");
		lblRoomId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomId.setBounds(344, 85, 65, 14);
		contentPane.add(lblRoomId);
		
		lblNewLabel_1 = new JLabel("Booking Status");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 115, 116, 14);
		contentPane.add(lblNewLabel_1);
	
		
		JLabel lblParticpants = new JLabel("Date From");
		lblParticpants.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParticpants.setBounds(344, 43, 77, 16);
		contentPane.add(lblParticpants);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Name=buttonGroup.getSelection().getActionCommand();
				String DF=tfFrom.getText();
				String DT=tfTo.getText();
				String rID=(String)cb_Room.getSelectedItem();
				int RID=Integer.parseInt(rID);
				String OID=(String)cb_Org.getSelectedItem();
				int theOID=Integer.parseInt(OID);
			
				int BSID=getBookingStatus();
				try
				{
					msyqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Space_Request(Occupancy_Y_N,From_Date,To_Date,Room_ID,Organizers_ID,Booking_Status) values(?,?,?,?,?,?)";
					PreparedStatement stmnt=msyqlConnection.prepareStatement(query);
					stmnt.setString(1, Name);
					stmnt.setString(2, DF);
					stmnt.setString(3, DT);
					stmnt.setInt(4, RID);
					stmnt.setInt(5, theOID);
					stmnt.setInt(6,BSID);
					stmnt.executeUpdate();
		
					JOptionPane.showMessageDialog(null, "Record Added");
					tfFrom.setText("");
					tfTo.setText("");
					

					
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null,ee);}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(490, 167, 89, 23);
		contentPane.add(btnCreate);
		
		cb_Room = new JComboBox<String>();
		cb_Room.setBounds(462, 82, 53, 20);
		contentPane.add(cb_Room);
		
		cbBookingStatus = new JComboBox<String>();
		cbBookingStatus.setBounds(136, 113, 124, 20);
		contentPane.add(cbBookingStatus);
		getRoomID();
		model=new DefaultComboBoxModel<String>();
		
		model.addElement("Provisional");
		model.addElement("Confirmed");
		model.addElement("Ended");
		cbBookingStatus.setModel(model);
		
		lblOrganizersId = new JLabel("Organizers ID");
		lblOrganizersId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOrganizersId.setBounds(344, 116, 108, 14);
		contentPane.add(lblOrganizersId);
		
		cb_Org = new JComboBox<String>();
		cb_Org.setBounds(462, 113, 53, 20);
		contentPane.add(cb_Org);
		
		rdbtnNewRadioButton = new JRadioButton("Yes");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(125, 40, 53, 23);
		rdbtnNewRadioButton.setActionCommand("Yes");
		contentPane.add(rdbtnNewRadioButton);
		
		
		rdbtnNo = new JRadioButton("No");
		buttonGroup.add(rdbtnNo);
		rdbtnNo.setBounds(198, 40, 53, 23);
		contentPane.add(rdbtnNo);
		rdbtnNo.setActionCommand("No");
		getOrganizerID();
		

	}
	public int getBookingStatus()
	{
		String a=(String)cbBookingStatus.getSelectedItem();
		if(a.equalsIgnoreCase("Provisional"))
			return 1;
		else if(a.equalsIgnoreCase("Confirmed"))
			return 2;
		else 
			return 3;
			
	}
	
	public void getRoomID()
	{
		String a;
		int b;
		try {
			msyqlConnection=DataBaseConnection.dbConnector();
			String query="Select Room_ID from Rooms";
			PreparedStatement stmnt=msyqlConnection.prepareStatement(query);
			ResultSet rs=stmnt.executeQuery();
			while(rs.next()) {
				b=rs.getInt(1);
				a=String.valueOf(b);
				cb_Room.addItem(a);
				}
				
			
		
				
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void getOrganizerID() 
	{
		String a;
		int b;
		try {
			msyqlConnection=DataBaseConnection.dbConnector();
			String query="Select Organizers_ID from Organizers";
			PreparedStatement stmnt=msyqlConnection.prepareStatement(query);
			ResultSet rs=stmnt.executeQuery();
			while(rs.next())
			{
				b=rs.getInt(1);
				a=String.valueOf(b);
				cb_Org.addItem(a);
				}
				
			
		
				
			
		}catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
		
	}
	}

