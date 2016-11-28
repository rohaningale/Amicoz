package crunchify.com.tutorials;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
 

public class CrunchifyEmailTest {

	@SuppressWarnings("resource")
	public static void main(String args[]) {
 
		// Spring Bean file you specified in /src/main/resources folder
		String crunchifyConfFile = "crunchify-bean.xml";
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(crunchifyConfFile);
 
		// @Service("crunchifyEmail") <-- same annotation you specified in CrunchifyEmailAPI.java
		CrunchifyEmailAPI crunchifyEmailAPI = (CrunchifyEmailAPI) context.getBean("crunchifyEmail");
		String toAddr = args[0]; //"anandk10@gmail.com";
		String fromAddr = args[1]; // "amicoz.network@gmail.com";
 
		// email subject
		String subject = args[2]; //"Hey.. This email sent by Crunchify's Spring MVC Tutorial";
 
		// email body
		String body = args[3]; //"There you go.. You got an email.. Let's understand details on how Spring MVC works -- By Crunchify Admin";
		crunchifyEmailAPI.crunchifyReadyToSendEmail(toAddr, fromAddr, subject, body);
	}
	
	
}
