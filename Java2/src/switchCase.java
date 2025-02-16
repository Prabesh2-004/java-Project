import java.util.*;     
public class switchCase {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        while(true){
            System.out.println("What Is Your Gender");
            System.out.println("1. Male\n2. Female\n3. Other\n4. Exit");
            String choose = scanner.nextLine();
            switch (choose) {
                case "1": Male(); break;
                case "2": Female(); break;
                case "3": Other(); break;
                case "4": return;
                default: System.out.println("Invalid choice");
            }
        }
    }
    private static void Male(){
        System.out.println("You are accepted by society");
    }
    private static void Female(){
        System.out.println("Your are accepted by society");
    }
    private static void Other(){
        System.out.println("You are not accepted by society");
    }
}
