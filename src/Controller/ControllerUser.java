package Controller;

import Service.CrudUser;
import Model.User;
import Service.CrudUserImpl;

public class ControllerUser {
    private final String url;
    private final String headers;
    private final String body;
    private final int id;
    private final CrudUserImpl user;

    private final String versionProtocol = "HTTP/1.1";

    public ControllerUser(String method, String url, String headers, String body) {
        this.url = "http://localhost:8080/api/users";
        this.headers = headers;
        this.body = body;
        this.id = 0; // Inicialización del id
        this.user = new CrudUserImpl(); // Inicialización del CRUD de usuarios
    }

    public ControllerUser(String method, String url, String headers, String body, int id) {
        this.url = "http://localhost:8080/api/users";
        this.headers = headers;
        this.body = body;
        this.id = id;
        this.user = new CrudUserImpl(); // Inicialización del CRUD de usuarios
    }

    public String GetUsers() {
        // Lógica para obtener todos los usuarios del servidor
        user.findAll();
        return null;
    }

    public String GetUsersById(int id) {
        // Lógica para obtener un usuario por su id del servidor
        user.findById(id);
        return null;
    }

    public String PostUser(String body) {
        // Lógica para crear un nuevo usuario en el servidor
        user.create(body);
        return null;
    }

    public void DeleteUserById(int id) {
        // Lógica para eliminar un usuario por su id en el servidor
        user.deleteById(id);
    }

    public void PutUserId(String body, int id) {
        // Lógica para actualizar un usuario por su id en el servidor
        user.updateById(body,id);
    }

    @Override
    public String toString() {
        return "ControllerUser{" +
                "url='" + url + '\'' +
                ", headers='" + headers + '\'' +
                ", body='" + body + '\'' +
                ", id=" + id +
                ", user=" + user +
                '}';
    }
}
