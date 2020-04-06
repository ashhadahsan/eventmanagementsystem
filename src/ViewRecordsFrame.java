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

public class ViewRecordsFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnSearch;
	Connection mysqlConnection=null;
	private JRadioButton rdbtnOrganizers;
	private JRadioButton rdbtnEvents;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnRooms;
	private JRadioButton rdbtnBookie;
	private JRadioButton rdbtnSpaceRequests;
	private JRadioButton rdbtnSponsors;
	private JRadioButton rdbtnContacts;
	private JRadioButton rdbtnAddress;
	private JRadioButton rdbtnVenue;

	/**
	 * Launch the application.
	 */

	public ViewRecordsFrame() {
		setResizable(false);
		setTitle("Welcome");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 792, 527);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 158, 766, 329);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setColumnSelectionAllowed(true);
		scrollPane.setViewportView(table);
		
		btnSearch = new JButton("Search");
		
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setBounds(558, 53, 89, 23);
		contentPane.add(btnSearch);
		
		JPanel panel = new JPanel();
		panel.setBounds(6, 11, 641, 136);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnEvents = new JRadioButton("Events");
		rdbtnEvents.setBounds(6, 19, 65, 23);
		panel.add(rdbtnEvents);
		rdbtnEvents.setSelected(true);
		buttonGroup.add(rdbtnEvents);
		rdbtnEvents.setActionCommand("Events");
		
		rdbtnRooms = new JRadioButton("Rooms");
		rdbtnRooms.setBounds(6, 58, 65, 23);
		panel.add(rdbtnRooms);
		buttonGroup.add(rdbtnRooms);
		rdbtnRooms.setActionCommand("Rooms");
		
		rdbtnOrganizers = new JRadioButton("Organizers");
		rdbtnOrganizers.setBounds(87, 19, 91, 23);
		panel.add(rdbtnOrganizers);
		buttonGroup.add(rdbtnOrganizers);
		
		rdbtnOrganizers.setActionCommand("Organizers");
		
		rdbtnBookie = new JRadioButton("Bookie");
		rdbtnBookie.setBounds(87, 58, 65, 23);
		panel.add(rdbtnBookie);
		buttonGroup.add(rdbtnBookie);
		rdbtnBookie.setActionCommand("Booked_by");
		
		rdbtnContacts = new JRadioButton("Event Sponsors");
		rdbtnContacts.setBounds(188, 19, 137, 23);
		panel.add(rdbtnContacts);
		buttonGroup.add(rdbtnContacts);
		rdbtnContacts.setActionCommand("Sponsors_has_events");
		
		
		rdbtnSpaceRequests = new JRadioButton("Space Requests");
		rdbtnSpaceRequests.setBounds(169, 58, 133, 23);
		panel.add(rdbtnSpaceRequests);
		buttonGroup.add(rdbtnSpaceRequests);
		rdbtnSpaceRequests.setActionCommand("Space_request");
		
		rdbtnAddress = new JRadioButton("Address");
		rdbtnAddress.setBounds(327, 19, 86, 23);
		panel.add(rdbtnAddress);
		buttonGroup.add(rdbtnAddress);
		rdbtnAddress.setActionCommand("Address");
		
		rdbtnVenue = new JRadioButton("Venue");
		rdbtnVenue.setBounds(332, 58, 81, 23);
		panel.add(rdbtnVenue);
		buttonGroup.add(rdbtnVenue);
		rdbtnVenue.setActionCommand("Venue");
		
		JRadioButton rdbtnService = new JRadioButton("Services");
		rdbtnService.setBounds(436, 19, 98, 23);
		panel.add(rdbtnService);
		buttonGroup.add(rdbtnService);
		rdbtnService.setActionCommand("Services");
		
		rdbtnSponsors = new JRadioButton("Sponsors");
		rdbtnSponsors.setBounds(436, 58, 81, 23);
		panel.add(rdbtnSponsors);
		buttonGroup.add(rdbtnSponsors);
		
		rdbtnSponsors.setActionCommand("Sponsors");
		
		JRadioButton rdbtnEventTypes = new JRadioButton("Event Types");
		buttonGroup.add(rdbtnEventTypes);
		rdbtnEventTypes.setBounds(230, 94, 109, 23);
		panel.add(rdbtnEventTypes);
		rdbtnEventTypes.setActionCommand("Event_Types");
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mysqlConnection=DataBaseConnection.dbConnector();
					//String inp=JOptionPane.showInputDialog(null,"Enter table name");
					String tb=buttonGroup.getSelection().getActionCommand();
					String query="Select * from "+tb;
					PreparedStatement stmnnt=mysqlConnection.prepareStatement(query);
					//stmnnt.setInt(1, 1);
					ResultSet rs=stmnnt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					
				}catch(Exception ee)
				{
						JOptionPane.showMessageDialog(null,ee);
				}
				
			}
		});
		
		
	
		

	}
}
