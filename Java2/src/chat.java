import java.util.Random;
import java.util.Scanner;
public class chat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int correctPin = 1234;
        int attempts = 0;
        int maxAttempts = 5;
        long balance = random.nextLong(190000) + 10000; //
        int pin;
        while (true) {
            System.out.print("Enter your ATM PIN: ");
            pin = scanner.nextInt();
            if (pin == correctPin) {
                System.out.println("Access Granted!\n");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect PIN. Attempts left: " + (maxAttempts - attempts));
                if (attempts >= maxAttempts) {
                    System.out.println("Too many incorrect attempts. Wait 10 seconds.");
                    for (int i = 10; i > 0; i--) {
                        System.out.println(i + "...");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    attempts = 0;
                }
            }
        }
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: Rs." + balance);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: Rs.");
                    int withdrawal = scanner.nextInt();
                    if (withdrawal > balance) {
                        System.out.println("Insufficient balance! Please enter a valid amount.");
                    } else {
                        balance -= withdrawal;
                        System.out.println("Transaction successful! New balance: Rs." + balance);
                    }
                    break;
                case 3:
                    System.out.print("Enter deposit amount: Rs.");
                    int deposit = scanner.nextInt();
                    if (deposit > balance && deposit < balance) {
                        System.out.println("Insufficient balance! Please enter a valid amount.");
                    } else {
                        balance += deposit;
                        System.out.println("Transaction successful! New balance: Rs." + balance);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please select a valid choice.");
            }
        }
    }
}
