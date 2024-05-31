import java.util.Scanner;

public class BankingApplication {

    private static double balance = 0.0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            showMenu();
            int choice = getChoice();
            exit = performOperation(choice);
        }

        System.out.println("Thank you for using Simple Banking Application. Goodbye!");
    }

    private static void showMenu() {
        System.out.println("\n--- Simple Banking Application Menu ---");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Please choose an option: ");
    }

    private static int getChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume newline left-over
        return choice;
    }

    private static boolean performOperation(int choice) {
        switch (choice) {
            case 1:
                depositMoney();
                break;
            case 2:
                withdrawMoney();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return false;
    }

    private static void depositMoney() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over

        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited " + amount + ". New balance is " + balance);
        } else {
            System.out.println("Invalid amount. Deposit failed.");
        }
    }

    private static void withdrawMoney() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline left-over

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew " + amount + ". New balance is " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
        } else {
            System.out.println("Invalid amount. Withdrawal failed.");
        }
    }

    private static void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
