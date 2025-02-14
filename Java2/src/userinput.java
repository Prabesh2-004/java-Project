import java.util.*;
public class userinput {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("Enter First Number: ");
        int firstNumber = scanner.nextInt();
        System.out.println("Enter Second Number: ");
        int secondNumber = scanner.nextInt();
        System.out.println(firstNumber + " is divided by " + secondNumber + " is " + (firstNumber / secondNumber));
        System.out.println(firstNumber + " is multiply by " + secondNumber + " is " + (firstNumber * secondNumber));
        System.out.println( firstNumber + " is added to " + secondNumber + " is " + (firstNumber + secondNumber));
        System.out.println(firstNumber + " is subtract by "  + secondNumber + " is " + (firstNumber - secondNumber));

    }
}
