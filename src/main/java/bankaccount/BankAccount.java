package bankaccount;


public class BankAccount {
	private double balance;
    private NotificationService notificationService;

    public BankAccount(double balance, NotificationService notificationService) {
        this.balance = balance;
        this.notificationService = notificationService;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
    if (amount < 0) {
        throw new IllegalArgumentException("لا يمكن إيداع مبلغ سالب");
    }

    balance = balance + amount;
    notificationService.sendMessage(" deposit " + amount);

    }

    public void withdraw(double amount) {
        if (amount > balance) {
            notificationService.sendMessage("الرصيد غير كافي");
            throw new IllegalStateException("الرصيد غير كافي");
        }
        balance = balance - amount;
        notificationService.sendMessage(" withdraw " + amount);
    }
}