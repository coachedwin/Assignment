package Notification;


public class Main {
	 public static void main (String [] args) {
		 
		 String channel = args[0];
	        String subject = args[1];
	        String message = args[2];
	     
		 

	        // Send notifications to subscribed users
	        NotificationService notificationService =NotificationService.getInstance();
	        notificationService.sendNotification(channel, subject, message);
	        
	        
	        
	 }

}
