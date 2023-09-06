import Controller.ControllerUser;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ControllerUser controller = null;

        while (true) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Crear ControllerUser con parámetros (constructor 1)");
            System.out.println("2. Crear ControllerUser con parámetros (constructor 2)");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.print("Método: ");
                    String method = scanner.nextLine();
                    System.out.print("URL: http://localhost:8080/api/users");
                    String url = "http://localhost:8080/api/users";
                    System.out.print("Headers: Content-Type: application/json");
                    String headers = "Content-Type: application/json";
                    System.out.print("Body: Nombres: ");
                    String nombres = scanner.nextLine();
                    System.out.print("Body: Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Body: Teléfono: ");
                    String telefono = scanner.nextLine();
                    controller = new ControllerUser(method, url, headers, nombres+","+email+","+telefono);
                    System.out.println("--------------------------");
                    System.out.println(controller.toString());
                    break;
                case 2:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.print("Método: ");
                    method = scanner.nextLine();
                    System.out.print("URL: http://localhost:8080/api/users");
                    url = "http://localhost:8080/api/users";
                    System.out.print("Headers: Content-Type: application/json");
                    headers = "Content-Type: application/json";
                    System.out.print("Body: Nombres :");
                    nombres = scanner.nextLine();
                    System.out.print("Body: Email: ");
                    email = scanner.nextLine();
                    System.out.print("Body: Teléfono: ");
                    telefono = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    controller = new ControllerUser(method, url, headers, nombres+","+email+","+telefono, id);
                    System.out.println("--------------------------");
                    System.out.println(controller.toString());
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}