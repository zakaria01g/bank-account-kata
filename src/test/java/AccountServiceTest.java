import com.interview.bankaccount.model.Account;
import com.interview.bankaccount.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountServiceTest {
    private AccountService accountService;
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
        accountService = new AccountService(account);
    }

    @Test
    void shouldIncreaseBalanceOnDeposit() {
        double depositAmount = 100.0;
        double expectedBalance = 100.0;

        accountService.deposit(depositAmount);

        assertEquals(expectedBalance, account.getBalance(), "Balance should correctly increase after deposit");
    }
}
