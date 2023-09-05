package Model;

public class User {
    private int id;
    private String names;
    private String email;
    private String phone;
//Constructor de la clase user (POJO)
    public User(int id, String names, String email, String phone) {
        this.id = id;
        this.names = names;
        this.email = email;
        this.phone = phone;
    }
//Getters y Setters
    public int getId() {
        return id;
    }
    public String getNames() {
        return names;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNames(String names) {
        this.names = names;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
