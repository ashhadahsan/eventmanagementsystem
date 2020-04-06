import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class Simple {
	public Simple() throws EmailException
	{
		  EmailAttachment attachment = new EmailAttachment();
		  
		  attachment.setPath("F:\\hahahahha.pdf");
		  attachment.setDisposition(EmailAttachment.ATTACHMENT);
		  attachment.setDescription("Picture of John");
		  attachment.setName("John");

		  // Create the email message
		  MultiPartEmail email = new MultiPartEmail();
		  email.setHostName("smtp.googlemail.com");
		  email.setSmtpPort(465);
		  email.setSSLOnConnect(true);
		  email.setAuthenticator(new DefaultAuthenticator("SP19DB","databasetest"));
		  email.addTo("ashhadahsan@gmail.com", "John Doe");
		  email.setFrom("SP19DB@gmail.com", "Me");
		  email.setSubject("The picture");
		  email.setMsg("Here is the picture you wanted");

		  // add the attachment
		  email.attach(attachment);

		  // send the email
		  email.send();
		
	}

}
