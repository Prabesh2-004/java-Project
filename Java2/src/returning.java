import java.util.*;
public class returning {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a First Number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter a Second Number: ");
        int secondNumber = scanner.nextInt();
        System.out.println(sum(firstNumber, secondNumber));
        scanner.close();
    }
    public static int sum(int firstNumber, int secondNumber){
        return firstNumber + secondNumber;
    }
}
