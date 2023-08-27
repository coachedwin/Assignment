package Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationService {
	 private static NotificationService instance;
	    private List<String> subscribedUsers;
	    private NotificationChannel emailChannel;
	    private NotificationChannel smsChannel;

	    private NotificationService() {
	        subscribedUsers = new ArrayList<>();
	        // Mocking the list of subscribed users
	        subscribedUsers.add("shivrastogi01@gmail.com");
//	        subscribedUsers.add("+1234567890");

	        emailChannel = new EmailNotificationChannel();
	        smsChannel = new SMSNotificationChannel();
	    }
	    public static NotificationService getInstance() {
	        if (instance == null) {
	            instance = new NotificationService();
	        }
	        return instance;
	    }
	    public void sendNotification(String channel, String subject, String message) {
	        for (String user : subscribedUsers) {
	            if (channel.equalsIgnoreCase("email")) {
	                emailChannel.sendNotification(subject, message);
	            } else if (channel.equalsIgnoreCase("sms")) {
	                smsChannel.sendNotification(subject, message);
	            } else {
	                System.out.println("Error: Channel '" + channel + "' not supported.");
	            }
	        }
	    }
}
