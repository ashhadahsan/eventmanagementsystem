import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class TopSponsorsChart {
	Connection mysqlConnection=null;
	
	
	public TopSponsorsChart()
	{
		
		try {
			mysqlConnection=DataBaseConnection.dbConnector();
		
			PreparedStatement stmnt=mysqlConnection.prepareStatement("SELECT sponsors.Name,COUNT(sponsors_has_events.Sponsors_ID) AS result FROM event_planning.events INNER JOIN sponsors_has_events ON (events.Event_ID) inner join sponsors GROUP BY name ORDER BY result");
			
			ResultSet rs=stmnt.executeQuery();
			DefaultPieDataset dataset=new DefaultPieDataset();
			
			while(rs.next())
			{
				dataset.setValue(rs.getString(1),rs.getInt(2));
				
			}
			JFreeChart chart=ChartFactory.createPieChart("Top Sponsors",dataset,true,true,false);
			int width = 720;    
		      int height = 600;
		     String name= JOptionPane.showInputDialog("Enter name for the graph");
		      File pieChart = new File( "C:\\Users\\Ashhad Rehman\\Desktop\\DBOutputs\\Graphs\\"+name+".jpeg" );
		     // JFileChooser fc=new JFileChooser();
		      ChartUtilities.saveChartAsJPEG( pieChart , chart , width , height );
		      JOptionPane.showMessageDialog(null, "Your file has been saved as"+pieChart.getAbsolutePath());
	

		
			
			
			
		}catch(Exception ee) {
			JOptionPane.showMessageDialog(null, ee);
			}
		
		
	}

}
