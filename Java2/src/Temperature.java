import java.util.*;
public class Temperature {
    public double celsius(double f){
        return (f * 9/5) + 32;
    }
    public double fahrenheit(double c){
        return ((c - 32) * 5 / 9);
    }
    public static Temperature temperature = new Temperature();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("1. Celsius to Fehrenheit\n2. Fehrenheit to celsius\n3. Exit");
            String choose = scanner.nextLine();
            switch(choose){
                case "1": celsius(); break;
                case "2": fehrenheit(); break;
                case "3": return;
                default: System.out.println("Invalid choice please choose again");
            }
        }
    }
    private static void celsius(){
        System.out.println("Enter a Degree You want to convert: ");
        double cel = scanner.nextDouble();
        double celsiusResult = temperature.celsius(cel);
        System.out.println(celsiusResult);
        scanner.nextLine(); 
    }
    private static void fehrenheit(){
        System.out.println("Enter a Degree you want to convert: ");
        double fah = scanner.nextDouble();
        double fahResult = temperature.fahrenheit(fah);
        System.out.println(fahResult);
        scanner.nextLine();
    }
}