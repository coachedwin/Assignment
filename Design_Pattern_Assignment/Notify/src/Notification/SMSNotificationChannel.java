package Notification;



public class SMSNotificationChannel extends NotificationChannel{
	 @Override
	    public void sendNotification(String subject, String message) {
	        System.out.println("Sending SMS: Subject: " + subject + ", Message: " + message);
	    }
}
