package Service;

import Model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrudUserImpl implements CrudUser {
    private List<User> users;
    private User user;

    public CrudUserImpl() {
        try {
            users = new ArrayList<>();
            String ruta = System.getProperty("user.dir") + "/dbusuarios.txt";
            File file = new File(ruta);
            Gson gson = new Gson();
            BufferedReader br = new BufferedReader(new FileReader(file));
            users = gson.fromJson(br, new TypeToken<List<User>>(){}.getType()); // line 6

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String create(String body) {
        int tempid = (int) users.stream().count() + 1;
        users.add(new User(tempid, body.split(",")[0], body.split(",")[1], body.split(",")[2]));
        try {
            Gson gson = new Gson();
            // convert your list to json
            String jsonList = gson.toJson(users);
            String ruta = System.getProperty("user.dir") + "/dbusuarios.txt";
            File file = new File(ruta);
            file.delete();
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(jsonList);
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Se ha creado el usuario con éxito y sus datos son: \nID: " + tempid + " Nombres: " + body.split(",")[0] + " Email: " + body.split(",")[1] + " Teléfono: " + body.split(",")[2];
    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public void updateById(String body, int id) {
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, new User(id, body.split(",")[0], body.split(",")[1], body.split(",")[2]));
            }
        }
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId() == id) {
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
            if (users.get(i).getId() == id) {
                Gson gson = new Gson();
                // convert your list to json
                String jsonList = gson.toJson(users.get(i));
                // print your generated json
                System.out.println("Lista de usuarios: " + jsonList);
            }
        }
    }
}
