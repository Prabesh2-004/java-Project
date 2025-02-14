import java.util.*;
public class Dog {
    String name;
    
    public Dog(String name){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a Name: ");
        this.name = scanner.nextLine();
    }
}
