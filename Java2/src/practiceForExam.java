import java.util.*;
public class practiceForExam {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
            System.out.println("1. Prime Number\n2. Factorial\n3. Exit");
            String choose = scan.nextLine();
            switch(choose){
                case "1": prime(); break;
                case "2": factorial(); break;
                case "3": return;
                default: System.out.println("Invalid Choice");
            }
        }
    }
    public static void prime(){
        System.out.print("Enter N: ");
        int n = scan.nextInt(); 
        System.out.println("Prime numbers from 1 to " + n + ":");
        scan.nextLine();
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + " \n");
            }
        }
    }
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    public static void factorial(){
        long factorial = 1;
        System.out.println("Enter a Number: ");
        int fact = scan.nextInt();
        for (int i=1;i<=fact;i++){
            factorial *= i;
        }
        System.out.println("Factorial of " + fact + " is " + factorial);
        scan.nextLine();
    }
}

