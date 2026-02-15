import java.util.*;

public class ATMInterface {

    static Scanner sc = new Scanner(System.in);

    static String userId = "sujit777";
    static int pin = 1234;
    static double balance = 10000;

    static ArrayList<String> transactionHistory = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("===== Welcome to ATM =====");

        System.out.print("Enter User ID: ");
        String enteredId = sc.next();

        System.out.print("Enter PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredId.equals(userId) && enteredPin == pin) {
            menu();
        } else {
            System.out.println("❌ Invalid User ID or PIN");
        }
    }

    static void menu() {
        int choice;

        do {
            System.out.println("\n--- ATM MENU ---");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> showHistory();
                case 2 -> withdraw();
                case 3 -> deposit();
                case 4 -> transfer();
                case 5 -> System.out.println("Thank you for using ATM 😊");
                default -> System.out.println("Invalid option!");
            }

        } while (choice != 5);
    }

    static void showHistory() {
        System.out.println("\n--- Transaction History ---");

        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String t : transactionHistory) {
                System.out.println(t);
            }
        }
    }

    static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdraw ₹" + amount);
            System.out.println("✔ Withdraw Successful");
        } else {
            System.out.println("❌ Insufficient Balance");
        }
    }

    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        balance += amount;
        transactionHistory.add("Deposit ₹" + amount);
        System.out.println("✔ Deposit Successful");
    }

    static void transfer() {
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transfer ₹" + amount);
            System.out.println("✔ Transfer Successful");
        } else {
            System.out.println("❌ Insufficient Balance");
        }
    }
}