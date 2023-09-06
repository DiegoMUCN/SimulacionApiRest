import Controller.ControllerUser;

import java.util.Scanner;

//https://www.adictosaltrabajo.com/2012/09/17/gson-java-json/
//https://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt
//https://www.javacodeexamples.com/gson-convert-json-to-a-typed-arraylist/14925
//https://www.lawebdelprogramador.com/foros/Java/826495-Obtener-ruta-de-ejecucion.html
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String url="";
        String headers="";
        String nombres="";
        String email="";
        String telefono="";
        int id=0;
        ControllerUser controller = null;

        while (true) {
            System.out.println("Menú de peticiones:");
            System.out.println("1. POST   4. GET ");
            System.out.println("2. PUT    5. GETALL");
            System.out.println("3. DELETE 6. Salir");
            System.out.print("Seleccione una opción: ");

            int selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("URL: http://localhost:8080/api/users");
                    url = "http://localhost:8080/api/users";
                    System.out.println("Headers: Content-Type: application/json");
                    headers = "Content-Type: application/json";
                    System.out.print("Body: Nombres: ");
                    nombres = scanner.nextLine();
                    System.out.print("Body: Email: ");
                    email = scanner.nextLine();
                    System.out.print("Body: Teléfono: ");
                    telefono = scanner.nextLine();
                    controller = new ControllerUser("POST", url, headers, nombres+","+email+","+telefono);
                    System.out.println("--------------------------");
                    System.out.println(controller.toString());
                    break;
                case 2:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("URL: http://localhost:8080/api/users");
                    url = "http://localhost:8080/api/users";
                    System.out.println("Headers: Content-Type: application/json");
                    headers = "Content-Type: application/json";
                    System.out.print("Body: Nombres :");
                    nombres = scanner.nextLine();
                    System.out.print("Body: Email: ");
                    email = scanner.nextLine();
                    System.out.print("Body: Teléfono: ");
                    telefono = scanner.nextLine();
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    controller = new ControllerUser("PUT", url, headers, nombres+","+email+","+telefono, id);
                    System.out.println("--------------------------");
                    System.out.println(controller.toString());
                    break;
                case 3:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("URL: http://localhost:8080/api/users");
                    url = "http://localhost:8080/api/users";
                    System.out.println("Headers: Content-Type: application/json");
                    headers = "Content-Type: application/json";
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    controller = new ControllerUser("DELETE", url, headers, "", id);
                    System.out.println("--------------------------");
                    System.out.println(controller.toString());
                    break;
                case 4:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("URL: http://localhost:8080/api/users");
                    url = "http://localhost:8080/api/users";
                    System.out.println("Headers: Content-Type: application/json");
                    headers = "Content-Type: application/json";
                    System.out.print("ID: ");
                    id = scanner.nextInt();
                    controller = new ControllerUser("GET", url, headers,"", id);
                    System.out.println("--------------------------");
                    System.out.println(controller.toString());
                    break;
                case 5:
                    scanner.nextLine(); // Consumir la nueva línea pendiente
                    System.out.println("URL: http://localhost:8080/api/users");
                    url = "http://localhost:8080/api/users";
                    System.out.println("Headers: Content-Type: application/json");
                    headers = "Content-Type: application/json";
                    controller = new ControllerUser("GETALL", url, headers, "");
                    System.out.println("--------------------------");
                    System.out.println(controller.toString());
                    break;
                case 6:
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