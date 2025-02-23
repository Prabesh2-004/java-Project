import java.util.*;
public class pnumber {
    public static boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for (int i=2;i*i <=num;i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Enter a Number: ");
        int num = scan.nextInt();
        System.out.println("Prime Number form 1 to " + num + " is");
        for (int a=1;a<=num;a++){
            if(isPrime(a)){
                System.out.println(a + " ");
            }
        }
    }
    
}
