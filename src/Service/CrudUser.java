package Service;

import Model.User;

import java.util.ArrayList;
import java.util.List;

public interface CrudUser {
    String create(String body);
    List<User> readAll();
    void updateById(String body, int id);
    void deleteById(int id);
    void findAll();
    void findById(int id);
}
