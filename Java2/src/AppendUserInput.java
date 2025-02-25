import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppendUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = "user_input.txt"; // File name

        while (true) { // Loop to get multiple inputs
            System.out.print("Enter your data (type 'exit' to stop): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break; // Exit the loop
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write(input);
                writer.newLine(); // Add a newline character
                System.out.println("Data appended to file.");
            } catch (IOException e) {
                System.err.println("Error writing to file: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Program terminated.");
    }
}