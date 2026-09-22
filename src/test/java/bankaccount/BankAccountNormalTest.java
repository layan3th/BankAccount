package bankaccount;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankAccountNormalTest {

    private BankAccount account;

    @Before
    public void setUp() {
        NotificationService service = new SmsNotificationService();
        account = new BankAccount(1000, service);
    }

    @Test
    public void testInitialBalance() {
        assertNotNull(account);
        assertEquals(1000, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        account.deposit(500);
        assertTrue(account.getBalance() > 1000);
    }

    @Test
    public void testWithdraw() {
        account.withdraw(300);
        assertFalse(account.getBalance() > 1000);
    }

    @Test
    public void testDepositAndWithdraw() {
        account.deposit(500);
        account.withdraw(200);
        assertEquals(1300, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositZero() {
        account.deposit(0);
        assertEquals(1000, account.getBalance(), 0.001);
    }

    @Test(expected = IllegalStateException.class)
    public void testWithdrawNotEnoughBalance() {
        account.withdraw(1001);
    }
}