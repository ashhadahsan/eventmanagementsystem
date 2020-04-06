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
public class CreateRoomFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;


	Connection mysqlConnection=null;
	private JLabel lblNewLabel;
	private JLabel lblRateperday;
	private JLabel lblNewLabel_1;
	private JTextField tfEname;
	private JTextField tfType;
	private JTextField tfRate;
	private JButton btnCreate;

	/**
	 * Launch the application.
	 */

	public CreateRoomFrame() {
		setTitle("Create Room");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 31, 46, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(347, 31, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		lblRateperday = new JLabel("Rate per Day");
		lblRateperday.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRateperday.setBounds(10, 80, 89, 14);
		contentPane.add(lblRateperday);
		
		tfEname = new JTextField();
		tfEname.setBounds(119, 29, 107, 20);
		contentPane.add(tfEname);
		tfEname.setColumns(10);
		
		tfType = new JTextField();
		tfType.setColumns(10);
		tfType.setBounds(403, 28, 107, 20);
		contentPane.add(tfType);
		
		tfRate = new JTextField();
		tfRate.setColumns(10);
		tfRate.setBounds(119, 78, 107, 20);
		contentPane.add(tfRate);
		
		btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String Name=tfEname.getText();
				
				
				String Type=tfType.getText();
				String Rate=tfRate.getText();
				int theRate=Integer.parseInt(Rate);
				
				try
				{
					
					mysqlConnection=DataBaseConnection.dbConnector();
					String query="Insert into Rooms(Room_Name,Type,Rate_per_Day) values(?,?,?)";
					PreparedStatement stmnt=mysqlConnection.prepareStatement(query);
					stmnt.setString(1, Name);
					stmnt.setString(2, Type);
				
					stmnt.setInt(3, theRate);
					
					stmnt.executeUpdate();

					JOptionPane.showMessageDialog(null, "Records Added");
					tfEname.setText("");
					tfType.setText("");
					tfRate.setText("");
					
					
				
					
					
				}
				catch(Exception ee)
				{
					JOptionPane.showMessageDialog(null, ee);
				}
				
				
				
				
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreate.setBounds(421, 77, 89, 23);
		contentPane.add(btnCreate);
		
		

	}
}