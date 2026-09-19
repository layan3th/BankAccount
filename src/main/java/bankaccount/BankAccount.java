package bankaccount;

public class BankAccount {
    private double balance;
    private NotificationService notificationService;

    public BankAccount(double initialBalance, NotificationService notificationService) {
        this.balance = initialBalance;
        this.notificationService = notificationService;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            if (notificationService != null) {
                notificationService.sendNotification("Deposit " + amount + " balance " + balance);
            }
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            if (notificationService != null) {
                notificationService.sendNotification("Withdraw " + amount + " balance " + balance);
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}