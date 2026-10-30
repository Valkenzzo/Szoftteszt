package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

class BankServiceTest {

    @Test
    void depositSendsNotification() {

        NotificationService notificationService =
                mock(NotificationService.class);

        BankService bankService =
                new BankService(notificationService);

        BankAccount account =
                new BankAccount();

        bankService.deposit(account, 1000);

        assertEquals(
                1000.0,
                account.getBalance()
        );

        verify(notificationService)
                .send("Deposit successful");
    }

    @Test
    void failedDepositDoesNotChangeBalanceOrSendNotification() {
        NotificationService notificationService =
                mock(NotificationService.class);
        BankService bankService =
                new BankService(notificationService);
        BankAccount account =
                new BankAccount();
        account.deposit(1000);

        assertThrows(
                IllegalArgumentException.class,
                () -> bankService.deposit(account, -100)
        );

        assertEquals(1000.0, account.getBalance());
        verifyNoInteractions(notificationService);
    }
}
