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
public class CreateEventTypes extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField tfType;
	
	private JButton btnCreate;
	Connection mysqlConnection=null;

	/**
	 * Launch the application.
	 */

	public CreateEventTypes() {
		setTitle("Create Event Types");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 628, 161);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl = new JLabel("Type");
		lbl.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl.setBounds(10, 31, 89, 14);
		contentPane.add(lbl);
		
		tfType = new JTextField();
		tfType.setBounds(94, 29, 124, 20);
		contentPane.add(tfType);
		tfType.setColumns(10);
		
		
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
				String Type=tfType.getText();
		
				try
				{
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Event_Types(Description) values(?)";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					
					stmnt.setString(1, Type);
					
					stmnt.executeUpdate();
			
					JOptionPane.showMessageDialog(null, "Record Added");
				
					tfType.setText("");
				

					
				}
				catch(Exception ee) {
					JOptionPane.showMessageDialog(null,ee);}
			}
		});
		
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(325, 27, 89, 23);
		contentPane.add(btnCreate);
	}
}
