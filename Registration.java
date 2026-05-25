import java.util.Scanner;

public class Registration {
    public String userName;
    public String password;
    public String phoneNumber;

    Scanner scanner = new Scanner(System.in);

    public boolean checkUsername(String Username) {
        return Username.contains("_") && Username.indexOf("_") <= 5;
    }

    public boolean checkPassword(String Password) {
        return Password.length() >= 8 &&
                Password.matches(".*[A-Z].*") &&
                Password.matches(".*[0-9].*") &&
                Password.matches(".*[!@#$%^&*()].*");
    }

    public boolean checkPhoneNumber(String PhoneNumber) {
        return PhoneNumber.matches("(\\+27|0)[0-9]{9}");
    }

    public void Register() {

        do {
            System.out.println("Enter username (must contain '_' and not be more then 5:");
            userName = scanner.nextLine();

            if (!checkUsername(userName)) {
                System.out.println("Invalid username try again");
            }

        } while (!checkUsername(userName));

        do {
            System.out.println("Enter PhoneNumber");
            phoneNumber = scanner.nextLine();

            if (!checkPhoneNumber(phoneNumber)) {
                System.out.println("Invalid PhoneNumber try again");
            }

        } while (!checkPhoneNumber(phoneNumber));

        do {
            System.out.print("Enter Password");
            password = scanner.nextLine();

            if (!checkPassword(password)) {
                System.out.println("Invalid Password. Try again");
            }

        } while (!checkPassword(password));
    }
}
