import java.util.*;
public class primeNumber {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Enter a Number: ");
        int prime = scanner.nextInt();
        for (int i = 1; i <= prime; i++){
            if ((i%i) !=0){
                System.out.println(i);
            }
        }

    }
}
