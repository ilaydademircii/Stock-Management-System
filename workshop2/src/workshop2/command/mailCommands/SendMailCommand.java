package workshop2.command.mailCommands;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class SendMailCommand {

	public SendMailCommand() {
		super();
	}

	public void execute() throws Exception {

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.transport.protocl", "smtp");

		final String myAccountEmail = "ilaydademirci571@gmail.com";
		final String password = "iiwj ilmc xanj isvs";

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountEmail, password);

			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountEmail));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ilaydademirci571@gmail.com"));
			message.setSubject("Data List");
			message.setText(" Stok Kart Listesi");

			MimeMultipart multipart = new MimeMultipart();
			MimeBodyPart attachment = new MimeBodyPart();
			attachment.attachFile(new File("C:\\Users\\zehra\\guruyazilim\\workshop2\\StockCardList.pdf"));
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<h1> Data List<h1>", "text/html");

			multipart.addBodyPart(messageBodyPart);
			multipart.addBodyPart(attachment);
			message.setContent(multipart);
			Transport.send(message);
			JOptionPane.showMessageDialog(null, "Mail başarıyla gönderildi.", "  ", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Mail gönderilemedi.", "  ", JOptionPane.ERROR_MESSAGE);
		}

	}
}