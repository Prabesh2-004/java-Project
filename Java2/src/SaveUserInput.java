import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveUserInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some data: ");
        
        // Read user input
        String userInput = scanner.nextLine();
        
        // Save the input to a file
        try (FileWriter writer = new FileWriter("userInput.txt")) {
            writer.write(userInput);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data.");
            e.printStackTrace();
        }
        
        scanner.close();
    }
}
    
