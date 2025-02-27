import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class groupProject {
    private static Scanner scan = new Scanner(System.in);
    private static String fileName = "User_Data.txt";               //storing the user input data 

    public static void main(String[] args) {
        while (true) {
            System.out.println("Choose:");
            System.out.println("1. Register\n2. Login\n3. Exit");
            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    register();
                    break;
                case "2":                   //Allow User to choose one of the option;
                    login();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid Choice Please choose Again");
            }
        }
    }

    private static void register() {                    //Allow user to fill their details
        System.out.print("Enter Your FullName: ");
        String name = scan.nextLine();
        System.out.print("Enter Your Address: ");
        String address = scan.nextLine();
        System.out.print("Enter Your Age:  ");
        String agestr = scan.nextLine();
        int age = Integer.parseInt(agestr);
        if(age >= 18){
        System.out.print("Enter Your Phone Number: ");
        String phone = scan.nextLine();
        System.out.print("Enter Your CitizenShip Number: ");
        String citizenship = scan.nextLine();
        if(citizenShipExist(citizenship)){
            System.out.println("You MotherFucker! What are You Thinking CitizenShip With Same Number Exist Come Suck My Dick Bitch!");
            return;
        }
        System.out.print("Enter Your Role(Admin/User): ");
        String role = scan.nextLine();
        if (!role.equals("user") && !role.equals("admin")) {
            System.out.println("Invalid Role: Default role 'user' ");
            role = "user";
        }
        System.out.print("Enter your Username: ");
        String username = scan.nextLine();                  //checking username already exist of not if condition true it return if condition false it will continue
        if (usernameExists(username)) {
            System.out.println("Username already exists.");
            return;
        }
        System.out.print("Enter your Password: ");
        String password = scan.nextLine();
        saveUserToFile(new User(name, address, agestr, phone, citizenship, role, username, password));                  //saving the data to the file name User_Data.txt
        System.out.println("Registration successful! You can now log in.");
    }
    else{
        System.out.println("Fuck Yourself Kid Go Drink Some Milk.");
        return;
    }
    }
    private static boolean citizenShipExist(String citizenship){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine()) != null){
                String[] userDetails = line.split(",");
                if(userDetails[4].equals(citizenship)){
                    return true;
                }
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred while checking CitizenShip Number.");
        }
        return false;
    }

    private static boolean usernameExists(String username) {                //it check the given username is already exist in file or not in a file called User_Data.txt
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {        // try-catch block in Java is a mechanism to handle exceptions. This ensures that the application continues to run even if an error occurs. The code inside the try block is executed, and if any exception occurs, it is then caught by the catch block.
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 6 && userDetails[6].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while checking username.");
        }
        return false;
    }

    private static void saveUserToFile(User user) {         //it will create a file. if the file already exist it will store data in end of the file,without overwritting existing content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(user.getName() + "," + user.getAddress() + "," + user.getAge() + "," + user.getPhone() + "," + user.getCitizenship() + "," + user.getRole() + "," + user.getUsername() + "," + user.getPassword());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving user data.");
        }
    }

    public static void login() {
        System.out.print("Enter your username: ");
        String username = scan.nextLine();
        System.out.print("Enter your password: ");
        String password = scan.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(",");
                if (userDetails.length > 6 && userDetails[6].equals(username) && userDetails[7].equals(password)) {
                    System.out.println("Welcome, " + userDetails[0] + "!");
                    found = true;
                    User user = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4], userDetails[5], userDetails[6], userDetails[7]);
                    dashboard(user);
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid Username or Password");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while logging in.");
        }
    }

    public static void dashboard(User user) {
        while(true){
            if (user.getRole().equals("admin")) {
                System.out.println("1. Process Applications\n2. Logout");
                String choice = scan.nextLine();
                switch(choice){
                    case "1": processApplication(); break;
                    case "2": return;
                    default: System.out.println("Invalid Choice");
                }
            }
            else{
                System.out.println("1. Apply For License\n2. Check Status\n3. Logout");
                String choice = scan.nextLine();
                switch(choice){
                    case "1": applyforLicense(user); break;
                    case "2": checkStatus(user); break;
                    case "3": return;
                    default: System.out.println("Invalid Choice");
                }
            }
        }
    }
    public static void processApplication(){
        try (BufferedReader reader = new BufferedReader(new FileReader("Applications.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] applicationDetails = line.split(",");
                if (applicationDetails.length > 3 && applicationDetails[3].equals("Pending")) {
                    System.out.println("Processing application for " + applicationDetails[0] + " - Category: " + applicationDetails[1]);
                    System.out.print("Approve application? (yes/no): ");
                    String decision = scan.nextLine().toLowerCase();
                    if (decision.equals("yes")) {
                        applicationDetails[3] = "Approved";
                    } else {
                        applicationDetails[3] = "Rejected";
                    }
                    updateApplicationStatus(applicationDetails);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing applications.");
        }
        System.out.println("Application processing complete.");

    }
    public static void applyforLicense(User user){
        System.out.print("Enter desired license category (Car, Bike, Bus): ");
        String category = scan.nextLine();
        System.out.print("Enter training completion certificate number: ");
        String certificate = scan.nextLine();
        saveApplicationToFile(new Application(user.getUsername(), category, certificate, "Pending"));
        System.out.println("Application submitted successfully.");
    }
    public static void checkStatus(User user){
        try (BufferedReader reader = new BufferedReader(new FileReader("Applications.txt"))) {
            String line;
            boolean found = false;
            while ((line = reader.readLine()) != null) {
                String[] applicationDetails = line.split(",");
                if (applicationDetails.length > 3 && applicationDetails[0].equals(user.getUsername())) {
                    System.out.println("Application Status: " + applicationDetails[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("No application found.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while checking application status.");
        }

    }
    private static void saveApplicationToFile(Application application) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Applications.txt", true))) {
            writer.write(application.getUsername() + "," + application.getCategory() + "," + application.getCertificate() + "," + application.getStatus());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while saving application data.");
        }
    }
    private static void updateApplicationStatus(String[] applicationDetails) {
        try (BufferedReader reader = new BufferedReader(new FileReader("Applications.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Applications.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] currentDetails = line.split(",");
                if (currentDetails.length > 3 && currentDetails[0].equals(applicationDetails[0])) {
                    writer.write(String.join(",", applicationDetails));
                } else {
                    writer.write(line);
                }
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while updating application status.");
        }
        // Rename temp file to original file
        new java.io.File("Applications.txt").renameTo(new java.io.File("Applications.txt"));
    }
}

class User {
    private String name;
    private String address;
    private String age;
    private String phone;
    private String citizenship;
    private String role;
    private String username;
    private String password;

    public User(String name, String address, String age, String phone, String citizenship, String role, String username, String password) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
        this.citizenship = citizenship;
        this.role = role;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public String getAge(){
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getRole() {
        return role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
class Application {
    private String username;
    private String category;
    private String certificate;
    private String status;

    public Application(String username, String category, String certificate, String status) {
        this.username = username;
        this.category = category;
        this.certificate = certificate;
        this.status = status;
    }
    public String getUsername() {
        return username;
    }

    public String getCategory() {
        return category;
    }

    public String getCertificate() {
        return certificate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
