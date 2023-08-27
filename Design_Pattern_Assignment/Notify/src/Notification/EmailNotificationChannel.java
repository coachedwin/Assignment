package Notification;

public class EmailNotificationChannel extends NotificationChannel {
	 @Override
	    public void sendNotification(String subject, String message) {
	        System.out.println("Sending Email: Subject: " + subject + ", Message: " + message);
	    }

}
