import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class CreateVenueFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfEname;
	private JTextField tfOD;

	private JButton btnCreate;
	Connection mysqlConnection=null;

	/**
	 * Launch the application.
	 */

	public CreateVenueFrame() {
		setTitle("Create Venue");
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
		tfEname=new JTextField();
	
		tfEname.setBounds(128, 41, 124, 20);
		contentPane.add(tfEname);
		tfEname.setColumns(10);
		
		JLabel lbl = new JLabel("OtherDetails");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(354, 43, 89, 14);
		contentPane.add(lbl);
		
		tfOD = new JTextField();
		tfOD.setBounds(450, 41, 124, 20);
		contentPane.add(tfOD);
		tfOD.setColumns(10);
		
	
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String city=tfEname.getText();
				String street=tfOD.getText();

				try {
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Venue(Venue_Name,Other_Details)  values (?,?)";
					PreparedStatement stmnt=mysqlConnection.prepareCall(query);
					stmnt.setString(1, city);
					stmnt.setString(2	, street);
					
					stmnt.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Record Added");
		
					tfEname.setText("");
					tfOD.setText("");
				
					



					
					
				}catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(485, 127, 89, 23);
		contentPane.add(btnCreate);
		
	
	}
}
