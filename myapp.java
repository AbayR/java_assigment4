import controllers.UserController;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class myapp {
    private final UserController controller;
    private final Scanner scanner;

    public myapp(UserController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to Medicines");
            System.out.println("Select option:");
            System.out.println("1. Get all medicines");
            System.out.println("2. Get medicines by id");
            System.out.println("3. Add medicine");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllUsersMenu();
                } else if (option == 2) {
                    getUserByIdMenu();
                } else if (option == 3) {
                    createUserMenu();
                } else {
                    break;
                }
            } catch (InputMismatchException __) {
                System.out.println("Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("*************************");

        }
    }

    public void getAllUsersMenu() {
        String response = controller.getAllUsers();
        System.out.println(response);
    }

    public void getUserByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        String response = controller.getUser(id);
        System.out.println(response);
    }

    public void createUserMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter Price");
        Double price = scanner.nextDouble();
        System.out.println("Please enter Expiration date");
        Double expiration_date = scanner.nextDouble();
        System.out.println("Please enter manufacturer");
        String manufacturer = scanner.next();
        System.out.println("Please enter Usage of medicine");
        String usage = scanner.next();

        String response = controller.createUser(name, price, expiration_date, manufacturer, usage);
        System.out.println(response);
    }
}