package Service;
import Model.User;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class CrudUserImpl implements CrudUser {
    private List<User> users;
    private User user;

    public CrudUserImpl() {
        users = new ArrayList<>();
        user = new User(0, "", "", ""); // Inicialización de usuario
    }

    @Override
    public String create(String body) {
        users.add(new User(Integer.parseInt(body.split(",")[0]),body.split(",")[1],body.split(",")[2],body.split(",")[3]));
        return body;
    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public void updateById(String body, int id) {
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId()==id){
                users.set(i,new User(Integer.parseInt(body.split(",")[0]),body.split(",")[1],body.split(",")[2],body.split(",")[3]));
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId()==id){
                users.remove(i);
            }
        }
    }

    @Override
    public void findAll() {
        // create a new Gson instance
        Gson gson = new Gson();
        // convert your list to json
        String jsonList = gson.toJson(users);
        // print your generated json
        System.out.println("Lista de usuarios: " + jsonList);
    }

    @Override
    public void findById(int id) {
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId()==id){
                Gson gson = new Gson();
                // convert your list to json
                String jsonList = gson.toJson(users.get(i));
                // print your generated json
                System.out.println("Lista de usuarios: " + jsonList);
            }
        }
    }
}
