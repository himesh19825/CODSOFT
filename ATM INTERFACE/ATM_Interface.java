import java.util.Scanner;

class CustomBankAccount {
    private double accountBalance;

    public CustomBankAccount(double initialBalance) {
        this.accountBalance = initialBalance;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void depositAmount(double amount) {
        if (amount > 0) {
            accountBalance += amount;
            System.out.println("Deposit successful. New account balance: " + accountBalance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdrawAmount(double amount) {
        if (amount > 0 && amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrawal successful. New account balance: " + accountBalance);
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }
}

class BankingATM {
    private CustomBankAccount bankAccount;
    private Scanner scanner;

    public BankingATM(CustomBankAccount bankAccount) {
        this.bankAccount = bankAccount;
        this.scanner = new Scanner(System.in);
    }

    public void initiate() {
        int choice;
        do {
            displayOptionsMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    bankAccount.depositAmount(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    bankAccount.withdrawAmount(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current account balance: " + bankAccount.getAccountBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using the banking ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);
    }

    private void displayOptionsMenu() {
        System.out.println("\nBanking ATM Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
}

public class Main {
    public static void main(String[] args) {
        CustomBankAccount bankAccount = new CustomBankAccount(1000); // Initial account balance
        BankingATM atm = new BankingATM(bankAccount);
        atm.initiate();
    }
}
