import java.util.Scanner;
public class trafficLight {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("Enter Current Traffic Light: ");
            System.out.println("1. Red\n2. Yellow\n3. Green\n4. Exit");
            String trafficLight = scan.nextLine();
            switch(trafficLight){
                case "1": red(); break;
                case "2": yellow(); break;
                case "3": green(); break;
                case "4": return;
                default: System.out.println("Invalid Traffic Light or choice.");
            }
        }
    }
    private static void red(){
        System.out.println("Next Light is Green");
    }
    private static void yellow(){
        System.out.println("Next Light is Red");
    }
    private static void green(){
        System.out.println("Next Light is Yellow");
    }

}
