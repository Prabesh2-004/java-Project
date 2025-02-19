import java.util.*;
public class traficlight2 {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while(true){
        System.out.print("Enter Current Traffic Light: ");
        String Traffic = scan.nextLine();
        if (Traffic.equals("red")){
            System.out.println("Next Light is Green");
        }
        else if (Traffic.equals("green")){
            System.out.println("Next Light is Yellow");
        }
        else if (Traffic.equals("yellow")){
            System.out.println("Next Light is Red");
        }
        else{
            System.out.println("Invalid Color");
        }
    }
}
}
