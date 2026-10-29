package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount();
    }

    @Test
    void newAccountHasZeroBalance() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    void depositAddsAmountToBalance() {
        account.deposit(1000);

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void multipleDepositsAreAddedTogether() {
        account.deposit(1000);
        account.deposit(250);
        account.deposit(50);

        assertEquals(1300.0, account.getBalance());
    }

    @Test
    void withdrawSubtractsAmountFromBalance() {
        account.deposit(1000);

        account.withdraw(300);

        assertEquals(700.0, account.getBalance());
    }

    @Test
    void canWithdrawTheEntireBalance() {
        account.deposit(1000);

        account.withdraw(1000);

        assertEquals(0.0, account.getBalance());
    }

    @Test
    void withdrawingMoreThanBalanceThrowsAndLeavesBalanceUnchanged() {
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000.01));

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void negativeDepositThrowsAndLeavesBalanceUnchanged() {
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-1));

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void zeroDepositThrowsAndLeavesBalanceUnchanged() {
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void negativeWithdrawalThrowsAndLeavesBalanceUnchanged() {
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-1));

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void zeroWithdrawalThrowsAndLeavesBalanceUnchanged() {
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void nonFiniteAmountsAreRejectedWithoutChangingBalance() {
        account.deposit(1000);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(Double.POSITIVE_INFINITY));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(Double.NaN));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(Double.POSITIVE_INFINITY));

        assertEquals(1000.0, account.getBalance());
    }

    @Test
    void depositThatWouldOverflowBalanceThrowsWithoutChangingIt() {
        account.deposit(Double.MAX_VALUE);

        assertThrows(IllegalArgumentException.class, () -> account.deposit(Double.MAX_VALUE));

        assertEquals(Double.MAX_VALUE, account.getBalance());
    }
}
