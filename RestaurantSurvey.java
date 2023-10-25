import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RestaurantSurvey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = "";

        System.out.println("Welcome to the Restaurant Survey System!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register");
            System.out.println("2. Take a Restaurant Survey");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    username = registerUser(scanner);
                    break;
                case 2:
                    takeRestaurantSurvey(scanner, username);
                    break;
                case 3:
                    System.out.println("Exiting the Restaurant Survey System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static String registerUser(Scanner scanner) {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        // Simulate user registration logic here (e.g., save to a data structure or database).
        System.out.println("Registration successful!");
        return username;
    }

    private static void takeRestaurantSurvey(Scanner scanner, String username) {
        System.out.println("Restaurant Survey Questions:");
        System.out.print("1. How often do you dine out at restaurants? ");
        String question1 = scanner.nextLine();
        System.out.print("2. What is your favorite type of cuisine? ");
        String question2 = scanner.nextLine();
        System.out.print("3. How would you rate the service at your last restaurant visit (1-5)? ");
        int question3 = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("4. What improvements would you suggest for our restaurant? ");
        String question4 = scanner.nextLine();

        // Store survey responses in a text file
        try (FileWriter writer = new FileWriter("restaurant_survey_responses.txt", true)) {
            writer.write("Username: " + username + "\n");
            writer.write("1. How often do you dine out: " + question1 + "\n");
            writer.write("2. Favorite cuisine: " + question2 + "\n");
            writer.write("3. Service rating: " + question3 + "\n");
            writer.write("4. Suggestions: " + question4 + "\n");
            writer.write("\n");
            System.out.println("Survey completed. Thank you!");
        } catch (IOException e) {
            System.err.println("Error writing survey responses to file: " + e.getMessage());
        }
    }
}
