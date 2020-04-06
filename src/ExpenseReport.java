import static com.itextpdf.io.font.FontConstants.TIMES_BOLD;
import static com.itextpdf.kernel.font.PdfFontFactory.createFont;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;

public class ExpenseReport {
	
	
	Connection mysqlConnection=null;
	public ExpenseReport() throws IOException {
		
		mysqlConnection=DataBaseConnection.dbConnector();
		String fname=JOptionPane.showInputDialog(null,"Enter the name of the file");
		
		String path=new String("C:\\Users\\Ashhad Rehman\\Desktop\\DBOutputs\\PDF\\"+fname+".pdf");
		
		PdfWriter writer=new PdfWriter(path);
		
		
		PdfDocument pdf=new PdfDocument(writer);
		
		Document doc=new Document(pdf);
		
		DateFormat df=new SimpleDateFormat("dd/MM/yyy HH:mm:ss");
		Date date=new Date();
		Text Reportname=new Text(" Name: Expense Report for  "+date);
		@SuppressWarnings("deprecation")
		PdfFont font=createFont(TIMES_BOLD);
		Reportname.setFont(font);
		Text generatedDate=new Text("Date create :"+df.format(date));
		generatedDate.setFont(font);
		
		Paragraph pgraph=new Paragraph();
		Paragraph pgraph2=new Paragraph();
		pgraph.add(Reportname);
		pgraph2.add(generatedDate);
		doc.add(pgraph);
		doc.add(pgraph2);
		
		float [] point= {100F,120F,120F,120F,120F,120F}; //define coloumns number and spaces
		Table table=new Table(point);
		
		try {
			PreparedStatement stmnt=mysqlConnection.prepareStatement("select  event_ID as ID,event_name as Name ,amount_paid as paidAmount,extra_cost ,(calculated_cost-discount) as expectedCost,(amount_paid+extra_cost) as actualCost from events");
			ResultSet rs=stmnt.executeQuery();
			table.addCell("ID");
			table.addCell("Name");
			table.addCell("Paid Amount");
			table.addCell("Extra Amount");
			table.addCell("Excepted cost");
			table.addCell("Actual Cost");
			
	
	   

			 
			while(rs.next()) {
				//table.addCell(rs.getInt(1));
				
				String v1=rs.getString(1);
				String v2=rs.getString(2);
				String v3=rs.getString(3);
				String v4=rs.getString(4);
				String v5=rs.getString(5);
				String v6=rs.getString(6);
				table.addCell(v1);
				table.addCell(v2);
				table.addCell(v3);
				table.addCell(v4);
				table.addCell(v5);
				table.addCell(v6);
				

				
			}
			doc.add(table);
			doc.close();
			JOptionPane.showMessageDialog(null, "You file is stored in  C:\\Users\\Ashhad Rehman\\Desktop\\DBOutputs\\PDF\\"+fname+".pdf");

		

		
	}catch(Exception e) {
		System.out.println(e);
	}

}
	}
