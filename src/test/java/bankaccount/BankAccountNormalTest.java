package bankaccount;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class BankAccountNormalTest {
    private BankAccount account;

    @Before

    public void setUp() {

        NotificationService service = new SmsNotificationService();

        account = new BankAccount(1000, service);

    }
    
   @Test
    public void testDeposit() {
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300);
        assertEquals(700, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdraw_notEnoughBalance() {
        account.withdraw(1001);
    }
    @Test
    public void testValidDeposit() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(1000, service);
        account.deposit(500);
        assertEquals(1500, account.getBalance(),0.001);
    }

    @Test
    public void testValidWithdraw() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(1000, service);
        account.withdraw(300);
        assertEquals(700, account.getBalance(),0.001);
    }

    @Test
    public void testInitialBalance() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(500, service);
        assertEquals(500, account.getBalance(),0.001);
    }

    @Test
    public void testAccountNotNull() {
        NotificationService service = new SmsNotificationService();
        BankAccount account = new BankAccount(1000, service);
        assertNotNull(account);
    }
}