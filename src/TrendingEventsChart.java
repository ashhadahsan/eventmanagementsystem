import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class TrendingEventsChart {
	Connection mysqlConnection=null;
	
	
	public TrendingEventsChart()
	{
		
		try {
			mysqlConnection=DataBaseConnection.dbConnector();
		
			PreparedStatement stmnt=mysqlConnection.prepareStatement("select description,count(events.Event_Types_ID) as result from events,event_types where event_types.Event_Types_ID=events.Event_Types_ID group by events.Event_Name order by result");
			
			ResultSet rs=stmnt.executeQuery();
			DefaultPieDataset dataset=new DefaultPieDataset();
			
			while(rs.next())
			{
				dataset.setValue(rs.getString(1),rs.getInt(2));
				
			}
			JFreeChart chart=ChartFactory.createPieChart("Trending Events ",dataset,true,true,false);
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
