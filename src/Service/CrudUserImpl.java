package Service;

import Model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CrudUserImpl implements CrudUser {
    private ArrayList<User> users = new ArrayList<>();
    private User user;

    public CrudUserImpl() {
        try {
            users = new ArrayList<>();
            user = new User(0, "", "", "");
            String ruta = System.getProperty("user.dir") + "/dbusuarios.txt";
            File file = new File(ruta);
            if (file.exists()){
                String content = new String(Files.readAllBytes(Paths.get(ruta)));
                if (!content.isEmpty()) {
                    TypeToken<ArrayList<User>> typeListUser = new TypeToken<ArrayList<User>>() {};
                    users = new Gson().fromJson(content, typeListUser);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String create(String body) {
        int tempid = 0;
        if (users.stream().count() == 0) {
            tempid = 1;
        } else {
            for (int i = 0; i < users.stream().count(); i++) {
                tempid = users.get(i).getId() + 1;
            }
        }
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
        if (users.stream().count() == 0) {
            System.out.println("No hay usuarios registrados en el sistema.");
            return;
        }
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, new User(id, body.split(",")[0], body.split(",")[1], body.split(",")[2]));
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
                    String s = "Se ha actualizado el usuario con éxito y sus datos son: \nID: " + id + " Nombres: " + body.split(",")[0] + " Email: " + body.split(",")[1] + " Teléfono: " + body.split(",")[2];
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            /*else {
                System.out.println("El usuario que desea actualizar no existe");
            }*/
        }
    }

    @Override
    public void deleteById(int id) {
        if (users.stream().count() == 0) {
            System.out.println("No hay usuarios registrados en el sistema.");
            return;
        }
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
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
                    String s = "Se ha eliminado el usuario con éxito y sus datos son: \nID: " + id;
                    System.out.println(s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
           /* else {
                System.out.println("El usuario que desea eliminar no existe");
            }*/
        }
    }

    @Override
    public void findAll() {
        // create a new Gson instance
        Gson gson = new Gson();
        // convert your list to json
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
        final String jsonList = prettyGson.toJson(users);
        // print your generated json
        System.out.println("Lista de usuarios: " + jsonList);
    }

    @Override
    public void findById(int id) {
        if (users.stream().count() == 0) {
            System.out.println("No hay usuarios registrados en el sistema.");
            return;
        }
        for (int i = 0; i < users.stream().count(); i++) {
            if (users.get(i).getId() == id) {
                Gson gson = new Gson();
                // convert your list to json
                //String jsonList = gson.toJson(users.get(i));
                final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
                final String jsonList = prettyGson.toJson(users.get(i));
                // print your generated json
                System.out.println("El usuario encontrado: " + jsonList);
            }
            /*else {
                System.out.println("El usuario que desea buscar no existe");
            }*/
        }
    }
}
