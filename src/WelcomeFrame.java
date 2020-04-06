import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class WelcomeFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JButton Address;

	private JButton Bookie;
	private JButton EventTypes;
	private JButton Events;
	private JButton Organizers;
	private JButton Room;
	private JButton Space;
	private JButton Sponsor;
	private JButton btnEventSponsors;

	/**
	 * Launch the application.
	 */

	public WelcomeFrame() {
	
		setResizable(false);
		setTitle("Create Address");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 675, 209);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Address=new JButton("Address");
	
		
	
		Address.setFont(new Font("Tahoma", Font.BOLD, 12));
		Address.setBounds(10, 41, 89, 23);
		contentPane.add(Address);
		Address.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateAddressFrame();
				
			}
			
		});
		
		Bookie = new JButton("Bookie");
		Bookie.setFont(new Font("Tahoma", Font.BOLD, 12));
		Bookie.setBounds(10, 110, 89, 23);
		contentPane.add(Bookie);
		Bookie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateBookieFrame();
				
			}
			
		});
		
		Events = new JButton("Events");
		Events.setFont(new Font("Tahoma", Font.BOLD, 12));
		Events.setBounds(300, 75, 89, 23);
		contentPane.add(Events);
		
		Events.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateEventFrame();
				
			}
			
		});
		
		EventTypes = new JButton("Event Types");
		EventTypes.setFont(new Font("Tahoma", Font.BOLD, 12));
		EventTypes.setBounds(154, 75, 108, 23);
		contentPane.add(EventTypes);
		EventTypes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateEventTypes();
				
			}
			
		});
		Sponsor = new JButton("Sponsors");
		Sponsor.setFont(new Font("Tahoma", Font.BOLD, 12));
		Sponsor.setBounds(415, 75, 89, 23);
		contentPane.add(Sponsor);
		
		Sponsor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateSponsorFrame();
			}
			
		});
		
		Space = new JButton("Space");
		Space.setFont(new Font("Tahoma", Font.BOLD, 12));
		Space.setBounds(144, 110, 108, 23);
		contentPane.add(Space);
		Space.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateSpaceRequestFrame();
				
			}
			
		});
		
		Room = new JButton("Rooms");
		Room.setFont(new Font("Tahoma", Font.BOLD, 12));
		Room.setBounds(300, 41, 89, 23);
		contentPane.add(Room);
		Room.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateRoomFrame();
				
			}
			
		});
		
		Organizers = new JButton("Organzier");
		Organizers.setFont(new Font("Tahoma", Font.BOLD, 12));
		Organizers.setBounds(144, 41, 100, 23);
		contentPane.add(Organizers);
		
		JButton btnVenue = new JButton("Venue");
		btnVenue.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				new CreateVenueFrame();
			}
		});
		btnVenue.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVenue.setBounds(405, 41, 89, 23);
		contentPane.add(btnVenue);
		
		btnEventSponsors = new JButton("Event Sponsors");
		btnEventSponsors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CreateSponsorEvents();
			}
		});
		btnEventSponsors.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEventSponsors.setBounds(10, 75, 129, 23);
		contentPane.add(btnEventSponsors);
		
		Organizers.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				new CreateOrganzierFrame();
				
			}
			
		}
		);
		
	
	}
}
