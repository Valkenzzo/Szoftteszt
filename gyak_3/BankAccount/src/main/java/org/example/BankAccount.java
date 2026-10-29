package org.example;

public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        validatePositiveFiniteAmount(amount);

        double newBalance = balance + amount;
        if (!Double.isFinite(newBalance)) {
            throw new IllegalArgumentException("The resulting balance must be finite.");
        }

        balance = newBalance;
    }

    public void withdraw(double amount) {
        validatePositiveFiniteAmount(amount);
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient funds.");
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    private static void validatePositiveFiniteAmount(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException("The amount must be a positive finite number.");
        }
    }
}
