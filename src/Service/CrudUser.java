package Service;
import java.util.List;
import Model.User;
public interface CrudUser {
    String create(String body);
    List<User> readAll();
    void updateById(String body, int id);
    void deleteById(int id);
    List<User> findAll();
    User findById(int id);
}
