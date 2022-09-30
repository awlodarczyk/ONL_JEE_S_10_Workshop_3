package pl.coderslab.model;


import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    private int id;
    private String username;
    private String email;
    private String password;

    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(int id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User map(ResultSet resultSet) throws SQLException {
        this.setId(resultSet.getInt("id"));
        this.setUsername(resultSet.getString("username"));
        this.setEmail(resultSet.getString("email"));
        this.setPassword(resultSet.getString("password"));
        return this;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
//                to jest ZLOOOOOOOO - hasło w toString - ZLOOOOOO
                ", password='" + password + '\'' +
                '}';
    }
}