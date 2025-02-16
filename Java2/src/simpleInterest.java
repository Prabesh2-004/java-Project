import java.util.*;
public class simpleInterest {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("1. Simple Interest\n2. Compound Interest\n3. Exit");
            String choice = scanner.nextLine();
            switch(choice){
                case "S": simpleInterests(); break;
                case "C": compoundInterest(); break;
                case "E": return;
                default: System.out.println("Invalid Choice");
            }
        }
    }
    private static void simpleInterests(){
        System.out.println("Enter a Value");
        System.out.print("Principal Amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Time in Year: ");
        double time = scanner.nextDouble();
        System.out.print("Rate of Interest: ");
        double rate = scanner.nextDouble();
        System.out.println((principal * time * rate/100));
        scanner.nextLine();
    }
    private static void compoundInterest(){
        System.out.println("Enter a Value");
        System.out.print("Principal Amount: ");
        double principal = scanner.nextDouble();
        System.out.print("Time in Year: ");
        double time = scanner.nextDouble();
        System.out.print("Rate of Interest: ");
        double rate = scanner.nextDouble();
        double result = principal * Math.pow(((1 + (rate/100))), time);
        System.out.println(result);
        scanner.nextLine();
    }
}
