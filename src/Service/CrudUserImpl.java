package Service;
import java.util.ArrayList;
import java.util.List;
import Model.User;
public class CrudUserImpl implements CrudUser {
    private List<User> users;
    private User user;

    public CrudUserImpl() {
    }

    @Override
    public String create(String body) {
        // Implementa la lógica para crear un usuario a partir de la cadena "body"
        // Incrementa el ID automáticamente
        // Agrega el usuario a la lista
        return "Usuario creado correctamente";
    }

    @Override
    public List<User> readAll() {
        return users;
    }

    @Override
    public void updateById(String body, int id) {
        // Implementa la lógica para actualizar un usuario por ID a partir de la cadena "body"
    }

    @Override
    public void deleteById(int id) {
        // Implementa la lógica para eliminar un usuario por ID
    }

    @Override
    public List<User> findAll() {
        return users;
    }

    @Override
    public User findById(int id) {
        // Implementa la lógica para encontrar un usuario por ID
        return null;
    }
}
