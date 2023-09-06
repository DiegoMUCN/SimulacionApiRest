package Service;

import Model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface CrudUser {
    String create(String body) throws IOException;
    List<User> readAll();
    void updateById(String body, int id);
    void deleteById(int id);
    void findAll();
    void findById(int id);
}
