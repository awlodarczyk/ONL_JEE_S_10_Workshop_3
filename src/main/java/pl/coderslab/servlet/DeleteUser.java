package pl.coderslab.servlet;

import pl.coderslab.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "DeleteUser", value = "/user/delete")
public class DeleteUser extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg ="";
        String msg_type ="";
        String id = request.getParameter("id");
        if(id == null || id.isBlank()){
            msg_type ="error_msg";
            msg = URLEncoder.encode("Parametr id jest pusty", StandardCharsets.UTF_8);
        }else {
            try {
                Integer _id = Integer.parseInt(id);
                if (service.remove(_id)) {
                    msg_type ="success_msg";
                    msg = URLEncoder.encode("Usunięto użytkownika poprawnie", StandardCharsets.UTF_8);
                } else {
                    msg_type ="error_msg";
                    msg = URLEncoder.encode("Nie znaleziono użytkownika w bazie", StandardCharsets.UTF_8);
                }
            }catch(NumberFormatException e){
                msg_type ="error_msg";
                msg = URLEncoder.encode("Parametr id musi być liczbą", StandardCharsets.UTF_8);
            }
        }
        response.sendRedirect("/user/list"+"?"+msg_type+"="+msg);
    }
}
