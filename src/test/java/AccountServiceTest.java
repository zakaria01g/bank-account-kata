import com.interview.bankaccount.exception.InsufficientFundsException;
import com.interview.bankaccount.model.Account;
import com.interview.bankaccount.model.Transaction;
import com.interview.bankaccount.model.TransactionType;
import com.interview.bankaccount.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void shouldDecreaseBalanceOnWithdrawal() {
        double initialDeposit = 200.0;
        double withdrawalAmount = 50.0;
        double expectedBalance = 150.0;
        accountService.deposit(initialDeposit);

        accountService.withdraw(withdrawalAmount);

        assertEquals(expectedBalance, account.getBalance(), "Balance should correctly decrease after withdrawal");
    }

    @Test
    void shouldThrowExceptionOnOverdraft() {
        double initialDeposit = 100.0;
        double withdrawalAmount = 150.0;
        accountService.deposit(initialDeposit);

        assertThrows(InsufficientFundsException.class, () -> accountService.withdraw(withdrawalAmount),
                "Should throw InsufficientFundsException when withdrawal amount exceeds balance");
    }

    @Test
    void shouldRecordTransactionsOnDepositAndWithdrawal() {
        accountService.deposit(100.0);
        accountService.withdraw(50.0);

        List<Transaction> transactions = account.getTransactions();

        assertEquals(2, transactions.size(), "There should be two transactions recorded");
        assertEquals(TransactionType.DEPOSIT, transactions.get(0).getType());
        assertEquals(TransactionType.WITHDRAWAL, transactions.get(1).getType());
    }
}
