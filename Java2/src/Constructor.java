import java.util.*;
public class Constructor {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int i = 0;
        System.out.print("Enter a Number: ");
        int number = scan.nextInt();
        do{
            System.out.println(i);
            i+=2;
        }while(i<=number);
    }
}
