import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
public class CreateBookieFrame extends JFrame {

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
	private JLabel lblEventId;
	Connection mysqlConnection=null;
	private JComboBox <String>cb_Event;
	
	

	/**
	 * Launch the application.
	 */

	public CreateBookieFrame() {
		setTitle("Create Bookie");
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
		tfEname.setBounds(136, 41, 124, 20);
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
		
		lblEventId = new JLabel("Event ID");
		lblEventId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEventId.setBounds(342, 85, 62, 14);
		contentPane.add(lblEventId);
		
		cb_Event=new JComboBox<String>();
	
		getEvents();
	
		cb_Event.setBounds(431, 82, 62, 20);
		contentPane.add(cb_Event);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=tfEname.getText();
				String cont=tfContact.getText();
				String em=tfEmail.getText();
				String eid=(String)cb_Event.getSelectedItem();
				int theEID=Integer.parseInt(eid);
				try {
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Booked_By(name,contact_no,email,event_id) values (?,?,?,?)";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, name);
					stmnt.setString(2, cont);
					stmnt.setString(3, em);
					stmnt.setInt(4, theEID);
					stmnt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Record Added");
					
					tfEname.setText("");
					tfContact.setText("");
					tfEmail.setText("");
			
					
					
				}catch(Exception ee) {
					JOptionPane.showMessageDialog(null, ee);
				}
				
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(504, 120, 89, 23);
		contentPane.add(btnCreate);
		
		
		
		
	}
	public void getEvents()
	{
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
}
