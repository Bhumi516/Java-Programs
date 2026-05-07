// Name   : Bhumi Bhadre 
// Roll No: 31
// Experiment 5: Implementation of Exception Handling
// Program: BankAccount with user-defined exceptions
//          LowBalanceException and NegativeNumberException

// ===================== Custom Exception 1 =====================
class LowBalanceException extends Exception {
    private double balance;
    private double amount;

    LowBalanceException(double balance, double amount) {
        super("Insufficient balance! Available: Rs." + balance
            + ", Requested: Rs." + amount);
        this.balance = balance;
        this.amount  = amount;
    }

    double getBalance() { return balance; }
    double getAmount()  { return amount; }
}

// ===================== Custom Exception 2 =====================
class NegativeNumberException extends Exception {
    private double number;

    NegativeNumberException(double number) {
        super("Negative amount not allowed! Entered: Rs." + number);
        this.number = number;
    }

    double getNumber() { return number; }
}

// ===================== BankAccount Class =====================
class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    BankAccount(String accountHolder, String accountNumber, double initialBalance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance       = initialBalance;
    }

    // Balance Enquiry
    void balanceEnquiry() {
        System.out.println("------------------------------------");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Current Balance: Rs." + balance);
        System.out.println("------------------------------------");
    }

    // Deposit
    void deposit(double amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException(amount);
        }
        balance += amount;
        System.out.println("Rs." + amount + " deposited successfully.");
        System.out.println("Updated Balance: Rs." + balance);
    }

    // Withdraw
    void withdraw(double amount) throws LowBalanceException, NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException(amount);
        }
        if (amount > balance) {
            throw new LowBalanceException(balance, amount);
        }
        balance -= amount;
        System.out.println("Rs." + amount + " withdrawn successfully.");
        System.out.println("Updated Balance: Rs." + balance);
    }
}

// ===================== Main Application =====================
public class BankAccountDemo {
    public static void main(String[] args) {

        BankAccount acc = new BankAccount("Atharv Kate", "SB-101-2025", 5000.00);

        System.out.println("========== Bank Account Demo ==========\n");

        // 1. Balance Enquiry
        System.out.println("-- Balance Enquiry --");
        acc.balanceEnquiry();

        // 2. Valid Deposit
        System.out.println("\n-- Depositing Rs.2000 --");
        try {
            acc.deposit(2000);
        } catch (NegativeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 3. Valid Withdrawal
        System.out.println("\n-- Withdrawing Rs.1500 --");
        try {
            acc.withdraw(1500);
        } catch (LowBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // 4. Negative Deposit — triggers NegativeNumberException
        System.out.println("\n-- Depositing Rs.-500 (Invalid) --");
        try {
            acc.deposit(-500);
        } catch (NegativeNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Deposit operation completed.");
        }

        // 5. Negative Withdrawal — triggers NegativeNumberException
        System.out.println("\n-- Withdrawing Rs.-200 (Invalid) --");
        try {
            acc.withdraw(-200);
        } catch (LowBalanceException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } catch (NegativeNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Withdrawal operation completed.");
        }

        // 6. Withdrawal exceeding balance — triggers LowBalanceException
        System.out.println("\n-- Withdrawing Rs.10000 (Exceeds Balance) --");
        try {
            acc.withdraw(10000);
        } catch (LowBalanceException e) {
            System.out.println("Exception Caught: " + e.getMessage());
            System.out.println("Shortfall        : Rs." + (e.getAmount() - e.getBalance()));
        } catch (NegativeNumberException e) {
            System.out.println("Exception Caught: " + e.getMessage());
        } finally {
            System.out.println("Withdrawal operation completed.");
        }

        // 7. Final Balance Enquiry
        System.out.println("\n-- Final Balance Enquiry --");
        acc.balanceEnquiry();
    }
}
