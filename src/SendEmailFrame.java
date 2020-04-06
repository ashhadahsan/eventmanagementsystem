import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.mail.DefaultAuthenticator;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;


public class SendEmailFrame extends JFrame  {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tfID;
	private JButton btnAttachFile;
	private JButton btnBack;
	private JButton btnSend;
	private JTextArea tfMsg;
	private JScrollPane scrollPane;
	private JTextField tfName;
	private JTextField tfSub;
	private JTextField tfPath;
	private JFileChooser fc;

	private int ID;
	private String Name;
	private String EMAIL;
	
	private String meseg;
	private String path;
	private String Sub;
	private File f;
	Connection mysqlConnection=null;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */

	public SendEmailFrame() {
		setTitle("Send Email");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Role:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 43, 63, 14);
		contentPane.add(lblNewLabel);
		

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(269, 438, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblSubject = new JLabel("ID:");
		lblSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject.setBounds(329, 40, 63, 20);
		contentPane.add(lblSubject);
		
		tfID = new JTextField();
		tfID.setBounds(431, 41, 124, 20);
		contentPane.add(tfID);
		tfID.setColumns(10);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMessage.setBounds(10, 142, 89, 14);
		contentPane.add(lblMessage);
		
		btnAttachFile = new JButton("Attach File");
	
		btnAttachFile.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAttachFile.setBounds(10, 370, 118, 23);
		contentPane.add(btnAttachFile);
		
		btnSend = new JButton("Send");
	
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSend.setBounds(558, 410, 89, 23);
		contentPane.add(btnSend);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 167, 637, 163);
		contentPane.add(scrollPane);
		
		tfMsg = new JTextArea();
		scrollPane.setViewportView(tfMsg);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(10, 84, 63, 14);
		contentPane.add(lblName);
		
		tfName = new JTextField();
		tfName.setBounds(136, 81, 145, 20);
		contentPane.add(tfName);
		tfName.setColumns(10);
		
		JLabel lblSubject_1 = new JLabel("Subject");
		lblSubject_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubject_1.setBounds(325, 85, 67, 14);
		contentPane.add(lblSubject_1);
		
		tfSub = new JTextField();
		tfSub.setBounds(431, 82, 124, 20);
		contentPane.add(tfSub);
		tfSub.setColumns(10);
		
		tfPath = new JTextField();
		tfPath.setEditable(false);
		tfPath.setEnabled(true);
		tfPath.setBounds(10, 339, 286, 20);
		contentPane.add(tfPath);
		tfPath.setColumns(10);
		
		JRadioButton rdbtnOrganizers = new JRadioButton("Organizers");
		buttonGroup.add(rdbtnOrganizers);
		rdbtnOrganizers.setBounds(81, 40, 77, 23);
		contentPane.add(rdbtnOrganizers);
		rdbtnOrganizers.setActionCommand("Organizers");		
		JRadioButton rdbtnSponsors = new JRadioButton("Sponsors");
		buttonGroup.add(rdbtnSponsors);
		rdbtnSponsors.setBounds(172, 40, 77, 23);
		contentPane.add(rdbtnSponsors);
		rdbtnSponsors.setActionCommand("Sponsors");
		rdbtnOrganizers.setSelected(true);
		
		btnAttachFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					fc=new JFileChooser();
					fc.showOpenDialog(null);
					
					//FileNameExtensionFilter filter = new FileNameExtensionFilter(".*pdf", "pdf","pdf");
					//fc.setFileFilter(filter);
					f=fc.getSelectedFile();
					
					
					 path=f.getAbsolutePath();
					tfPath.setText(path);
					fc.setDragEnabled(true);
					//fc.addChoosableFileFilter(new FileNameExtensionFilter("*.pdf","pdf"));
					//fc.addChoosableFileFilter(new FileNameExtensionFilter("*.jpeg","jpeg"));
					}catch(Exception ee)
					{
						JOptionPane.showMessageDialog(null,ee);
					}
				
			}
		});
		

		

		
		
		

		
		
		  
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(buttonGroup.getSelection().getActionCommand().equals("Sponsors"))
					addSponsors();
				else
					addOrganizers();

				try {
					sendEmail();
				} catch (EmailException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
	
	
			
		
		

	
	}
	
	public void addSponsors() {
		{
			String EyeD=tfID.getText();
			ID=Integer.parseInt(EyeD);
			Name=tfName.getText();
			
			try {
				
				mysqlConnection=DataBaseConnection.dbConnector();
				PreparedStatement stmnt=mysqlConnection.prepareStatement("Select email from Sponsors where Sponsors_id=? and name=?");
				stmnt.setInt(1, ID);
				stmnt.setString(2, Name);
				ResultSet rs=stmnt.executeQuery();
				while(rs.next()) {
					EMAIL=rs.getString(1);
					}
		

				
				
				
				
			}catch(Exception ee)
			{
				JOptionPane.showMessageDialog(null,ee);
				
			}
		}
		
	}
	
	public void addOrganizers() {
		String EyeD=tfID.getText();
		ID=Integer.parseInt(EyeD);
		Name=tfName.getText();
		
		try {
			
			mysqlConnection=DataBaseConnection.dbConnector();
			PreparedStatement stmnt=mysqlConnection.prepareStatement("Select email_address from Organizers where Organizers_id=? and name=?");
			stmnt.setInt(1, ID);
			stmnt.setString(2, Name);
			ResultSet rs=stmnt.executeQuery();
			while(rs.next())
				EMAIL=rs.getString(1);
			
	

			
			
			
		}catch(Exception ee)
		{
			JOptionPane.showMessageDialog(null,ee);
			
		}
	}
	
	


	
	
		
			
		public void sendEmail() throws EmailException
		{
			
			Sub=tfSub.getText();
			meseg=tfMsg.getText();
			try {
				 EmailAttachment attachment = new EmailAttachment();
				  
				  attachment.setPath(path);
				  attachment.setDisposition(EmailAttachment.ATTACHMENT);
				  attachment.setDescription("Details are attached");
				  attachment.setName(Name);

				  // Create the email message
				  MultiPartEmail email = new MultiPartEmail();
				  email.setHostName("smtp.googlemail.com");
				  email.setSmtpPort(465);
				  email.setSSLOnConnect(true);
				  email.setAuthenticator(new DefaultAuthenticator("SP19DB","databasetest"));
				  email.addTo(EMAIL);
				  email.setFrom("SP19DB@gmail.com");
				  email.setSubject(Sub);
				  email.setMsg(meseg);

				  // add the attachment
				  email.attach(attachment);

				  // send the email
				  email.send();
				  
				  JOptionPane.showMessageDialog(null, "Email Sent ");
				  


				
				  
				
			}catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, e);
			}

	
			
		}
}



	