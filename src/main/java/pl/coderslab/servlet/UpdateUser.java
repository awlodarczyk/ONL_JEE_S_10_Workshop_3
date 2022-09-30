package pl.coderslab.servlet;

import pl.coderslab.exception.ServiceException;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;
import pl.coderslab.util.ResponseHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "UpdateUser", value = "/user/edit")
public class UpdateUser extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if(id == null || id.isBlank()){
            request.setAttribute("error_msg","Parametr id jest pusty");
        }else {
            try{
                Integer _id = Integer.parseInt(id);
                request.setAttribute("user",service.findById(_id));
            }catch (NumberFormatException e){
                String msg_type ="error_msg";
                String msg = URLEncoder.encode("Parametr id jest pusty", StandardCharsets.UTF_8);
                ResponseHelper.sendRedirect(response,"/user/list",msg_type,msg);
            }
        }
        request.getRequestDispatcher("/site/edit.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg ="";
        String msg_type ="";
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if(
                id == null || id.isBlank() ||
                username == null || username.isBlank() ||
                password == null || password.isBlank() ||
                email == null || email.isBlank()
        ){
            msg_type ="error_msg";
            msg = URLEncoder.encode("Parametr id/username/password/email jest pusty", StandardCharsets.UTF_8);
            ResponseHelper.sendRedirect(request,response,msg_type,msg);
            return;
        }else {

            try {
                Integer _id = Integer.parseInt(id);
                User user = service.update(_id,username, email, password);
                if(user!=null){
                    msg_type = "success_msg";
                    msg = URLEncoder.encode(String.format("Użytkownik %s zaktualizowany",user.getUsername()), StandardCharsets.UTF_8);
                }
            }catch (ServiceException e){
                msg_type ="error_msg";
                msg = URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
                ResponseHelper.sendRedirect(request,response,msg_type,msg);
                return;
            }catch (NumberFormatException e){
                msg_type="error_msg";
                msg = URLEncoder.encode("Parametr id powinien być liczbą", StandardCharsets.UTF_8);
                ResponseHelper.sendRedirect(request,response,msg_type,msg);
                return;
            }
        }
        response.sendRedirect("/user/list"+"?"+msg_type+"="+msg);
    }
}
