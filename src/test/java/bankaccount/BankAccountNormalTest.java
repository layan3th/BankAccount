package bankaccount;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountNormalTest {

    @Test
    void testValidDeposit() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(1000, service);
        account.deposit(500);
        assertEquals(1500, account.getBalance());
    }

    @Test
    void testValidWithdraw() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(1000, service);
        account.withdraw(300);
        assertEquals(700, account.getBalance());
    }

    @Test
    void testInitialBalance() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(500, service);
        assertEquals(500, account.getBalance());
    }

    @Test
    void testWithdrawMoreThanBalance() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(100, service);
        account.withdraw(500);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(200, service);
        account.deposit(-50);
        assertTrue(account.getBalance() == 200);
    }

    @Test
    void testAccountNotNull() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(1000, service);
        assertNotNull(account);
    }
}
