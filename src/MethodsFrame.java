

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class MethodsFrame extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblWelcome;
	private JButton btnCreateRecords;
	private JButton btnUpdateRecords;
	private JButton btnDeleteRecords;
	private JButton btnShowRecords;
	private JLabel lblExpenseReport;
	private JLabel lblTopSponsor;
	private JLabel lblNewLabel;
	private JButton btnEventChart;
	private JButton btnSponsorChart;
	private JButton btnGetPdfExpense;
	private JLabel label;
	
	private JSeparator separator;
	private JSeparator separator_1;
	private JButton btnEventReport;
	private JButton btnSearchRecord;

	/**
	 * Launch the application.
	 */

	public MethodsFrame() {
		setTitle("Methods");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 200, 673, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWelcome = new JLabel("Welcome to Event Planner");
		lblWelcome.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lblWelcome.setForeground(Color.RED);
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcome.setBounds(128, 11, 341, 45);
		contentPane.add(lblWelcome);
		
		btnCreateRecords = new JButton("Create Records");
		btnCreateRecords.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCreateRecords.setForeground(Color.BLACK);
		btnCreateRecords.setBounds(30, 124, 145, 23);
		contentPane.add(btnCreateRecords);
		
		
		btnCreateRecords.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new CreateOptions();
				
			}
			
		});
		
		btnUpdateRecords = new JButton("Update Records");
		btnUpdateRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdateRecordFrame();
				}
		});
		btnUpdateRecords.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdateRecords.setForeground(Color.BLACK);
		btnCreateRecords.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnUpdateRecords.setBounds(28, 168, 147, 23);
		contentPane.add(btnUpdateRecords);
		
		btnDeleteRecords = new JButton("Delete Records");
		btnDeleteRecords.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDeleteRecords.setForeground(Color.BLACK);
		btnDeleteRecords.setBounds(30, 221, 145, 23);
		contentPane.add(btnDeleteRecords);
		
		

		btnDeleteRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteRecordsFrame();
			}
		});
		
		btnShowRecords = new JButton("View Records");
		btnShowRecords.setFont(new Font("Tahoma", Font.BOLD, 12));

		btnShowRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewRecordsFrame();
			}
		});
		btnShowRecords.setBounds(30, 271, 145, 23);
		contentPane.add(btnShowRecords);
		
		btnEventChart = new JButton("Generate Pie Chart");
		btnEventChart.setFont(new Font("Tahoma", Font.BOLD, 12));
		
	

		btnEventChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				new TrendingEventsChart();
			}
		});
		btnEventChart.setBounds(492, 140, 155, 23);
		contentPane.add(btnEventChart);
		
		btnGetPdfExpense = new JButton("Get PDF Report");
		btnGetPdfExpense.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGetPdfExpense.setBounds(492, 260, 155, 23);
		contentPane.add(btnGetPdfExpense);
		btnGetPdfExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ExpenseReport();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		separator = new JSeparator();
		separator.setBounds(10, 107, 277, 228);
		contentPane.add(separator);
		
		lblNewLabel = new JLabel("Treding Event Type");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(350, 144, 119, 14);
		contentPane.add(lblNewLabel);
		
		lblTopSponsor = new JLabel("Top Sponsor");
		lblTopSponsor.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTopSponsor.setBounds(350, 201, 119, 14);
		contentPane.add(lblTopSponsor);
		
		btnSponsorChart = new JButton("Generate Pie Chart");
		btnSponsorChart.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSponsorChart.setBounds(492, 197, 153, 23);
		contentPane.add(btnSponsorChart);
		
		
		
		btnSponsorChart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TopSponsorsChart();
			}
		});
		
		lblExpenseReport = new JLabel("Expense Report");
		lblExpenseReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblExpenseReport.setBounds(349, 264, 119, 14);
		contentPane.add(lblExpenseReport);
		
		
		
		separator_1 = new JSeparator();
		separator_1.setBounds(331, 107, 320, 228);
		contentPane.add(separator_1);
		
		label = new JLabel("Data Analysis Section");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(410, 82, 247, 14);
		contentPane.add(label);
		
		JLabel lblRecordManagement = new JLabel("Event Management");
		lblRecordManagement.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRecordManagement.setBounds(30, 83, 247, 14);
		contentPane.add(lblRecordManagement);

		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(53, 395, 575, 86);
		contentPane.add(separator_2);
		
		JLabel lblEventDetails = new JLabel("Event Details");
		lblEventDetails.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEventDetails.setBounds(350, 312, 94, 14);
		contentPane.add(lblEventDetails);
		
		btnEventReport = new JButton("Get PDF Report");
		btnEventReport.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEventReport.setBounds(492, 312, 155, 23);
		contentPane.add(btnEventReport);
		
		
		btnEventReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EventDetailsReport();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		
		btnSearchRecord = new JButton("Search Record");
		btnSearchRecord.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearchRecord.setBounds(30, 309, 145, 23);
		contentPane.add(btnSearchRecord);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new TheWelcomeFrame();
	
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogout.setBounds(558, 11, 89, 23);
		contentPane.add(btnLogout);
		btnSearchRecord.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SearchRecordFrame();
				
			}
			
		});
		
		
		btnSearchRecord = new JButton("Send Email");
	}
}
