package pl.coderslab.service;

import com.github.javafaker.Faker;
import pl.coderslab.dao.UserDao;
import pl.coderslab.exception.ServiceException;
import pl.coderslab.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserService {

    private final UserDao dao;

    public UserService() {
        this.dao = new UserDao();
    }

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    public User create(String username, String email, String password){
        if(
                verifyEmail(email) && verifyPassword(password) &&
                dao.findByUsername(username)==null && dao.findByEmail(email)==null
        ){
            User user = new User(username, email, password);
            return dao.create(user);
        }else{
            if(verifyEmail(email)==false) throw new ServiceException(String.format("Email [%s] niepoprawny",email));
            if(verifyPassword(password)==false) throw new ServiceException(String.format("Hasło niepoprawne",email));
        }
        return null;
    }
    public User update(Integer id, String username, String email, String password){
        if(verifyEmail(email) && verifyPassword(password)) {
            User user = new User(id, username, email, password);
            dao.update(user);
            return user;
        }else{
            if(verifyEmail(email)==false) throw new ServiceException(String.format("Email [%s] niepoprawny",email));
            if(verifyPassword(password)==false) throw new ServiceException(String.format("Hasło niepoprawne",email));
        }
        return null;
    }
    public boolean remove(Integer id){
        dao.delete(id);
        return dao.read(id)==null;
    }
    public User findById(Integer id){
        return dao.read(id);
    }
    public List<User> findAll(){
       return Arrays.asList(dao.findAll());
    }

    private boolean verifyPassword(String password){
        return Pattern.matches("(?=.*[A-Z].*[a-z])" +
                "[A-Za-z0-9]{10,15}",password);

    }
    private boolean verifyEmail(String email){
        String regexStr = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}";
        Pattern pattern = Pattern.compile(regexStr);
        return pattern.matcher(email).matches();
    }

    public void mockDb() {
        dao.createUserTable();
        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setEmail(faker.internet().emailAddress());
            user.setPassword(faker.internet().password(10,15,true,true));
            user.setUsername(faker.name().username());
            dao.create(user);
        }

    }
}
