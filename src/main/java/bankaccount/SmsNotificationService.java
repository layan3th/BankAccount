package bankaccount;

public class SmsNotificationService implements NotificationService {
    @Override
    public void sendMessage(String message) {
        System.out.println("SMS: " + message);
    }
}