package Controller;

import Model.User;
import Service.CrudUser;
import Service.CrudUserImpl;

import java.util.List;

public class ControllerUser {
    private final String versionProtocol = "HTTP/1.1";
    private String url;
    private String headers;
    private String body;
    private int id;
    private CrudUserImpl crudUser;

    public ControllerUser(String method, String url, String headers, String body) {
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.id = 0; // Inicializar id a 0 o algún valor por defecto
        this.crudUser = new CrudUserImpl();
    }
    public ControllerUser(String method, String url, String headers, String body,int id) {
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.id = id; // Inicializar id a 0 o algún valor por defecto
        this.crudUser = new CrudUserImpl();
        //se debe usar un switch para detectar el tipó de metodo
        //los metodos usados deben mostrar el string de lo que se realiza
    }
    // Implementa los métodos GetUsers, GetUsersById, PostUser, DeleteUserById, PutUserId, toString
}
