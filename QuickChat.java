import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class QuickChat {

    static int messageCount = 0; // added missing variable

    public static void startQuickChat() {
        Scanner scanner = new Scanner(System.in);
        while (true) { // fixed comment error

            System.out.println("Welcome to QuickChat");
            System.out.println("Select transaction:");
            System.out.println("Option 1 Select QuickChat");
            System.out.println("Option 2 Select QuickChat");
            System.out.println("Option 3 Quit");

            System.out.print("Enter choice 1,2 or3");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("You Selected: Select QuickChat");
                    System.out.println("This feature is coming soon, please stay tuned ");
                    break;

                case 2:
                    System.out.println("You selected: Send QuickChat");
                    String recipient;

                    do {
                        System.out.println("Enter your number(must start with +27 and be exactly 12 characters):");
                        recipient = scanner.nextLine();
                    } while (!(recipient.startsWith("+27") && recipient.length() == 12));

                    System.out.print("Enter your QuickChat(must be 250 characters or less):");
                    String message = scanner.nextLine();

                    if (message.length() > 250) {
                        System.out.println("Please enter a QuickChat of less than 250 characters. ");
                        return;
                    }

                    String messageID = generateMessageID();
                    int currentMessageCount = ++messageCount;

                    String messageHash = generateMessageHash(messageID, currentMessageCount, message);
                    System.out.println("MessageHash" + messageHash);

                    System.out.println("Choose an option");
                    System.out.println("Option 1-Send QuickChat");
                    System.out.println("Option 2-Disregard QuickChat");
                    System.out.println("Option 3-Store QuickChat to send later");

                    int subChoice = scanner.nextInt();
                    scanner.nextLine();

                    switch (subChoice) {

                        case 1:
                            System.out.println("Message sent and stored in system");
                            break;

                        case 2:
                            System.out.println("Message discarded");
                            break;

                        case 3:
                            storeMessageToTextFile(messageID, recipient, message, messageHash); // fixed method name
                            break;

                        default:
                            System.out.println("Invalid option");
                    }
                    break;
            }
        }
    }

    private static String generateMessageHash(String messageId, int count, String message) {

        String[] words = message.trim().split("\\s+"); // fixed type
        String first = words.length > 0 ? words[0] : "";
        String last = words.length > 1 ? words[words.length - 1] : first;

        return messageId.substring(0, 2) + ":" + count + ":" + first.toUpperCase() + last.toUpperCase(); // added return
    }

    private static String generateMessageID() {
        Random random = new Random();
        String ID = "";

        for (int i = 0; i < 10; i++) {
            ID += random.nextInt(10); // fixed generation
        }

        return ID;
    }

    private static void storeMessageToTextFile(String ID, String recipient, String message, String MessageHash) {

        try (FileWriter file = new FileWriter("stored_message.txt", true)) {

            file.write("Message ID" + ID + "\n");
            file.write("Recipient" + recipient + "\n");
            file.write("Hash: " + MessageHash + "\n"); // fixed hash
            file.write("Message:" + message + "\n");
            file.write("----\n");

            System.out.println("Message stored successfully in the text file.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
