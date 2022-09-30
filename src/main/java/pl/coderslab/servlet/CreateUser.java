package pl.coderslab.servlet;

import pl.coderslab.exception.ServiceException;
import pl.coderslab.model.User;
import pl.coderslab.service.UserService;
import pl.coderslab.util.ResponseHelper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "CreateUser", value = "/user/create")
public class CreateUser extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/site/create.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg ="";
        String msg_type ="";
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if(
                username == null || username.isBlank() ||
                password == null || password.isBlank() ||
                email == null || email.isBlank()
        ){
            msg_type ="error_msg";
            msg = URLEncoder.encode("Parametr username/password/email jest pusty", StandardCharsets.UTF_8);
            ResponseHelper.sendRedirect(request,response,msg_type,msg);
            return;
        }else {
            try {
                User user = service.create(username, email, password);
                if(user!=null){
                    msg_type = "success_msg";
                    msg = URLEncoder.encode(String.format("Użytkownik %s utworzony",user.getUsername()), StandardCharsets.UTF_8);
                }
            }catch (ServiceException e){
                msg_type ="error_msg";
                msg = URLEncoder.encode(e.getMessage(), StandardCharsets.UTF_8);
                ResponseHelper.sendRedirect(request,response,msg_type,msg);
                return;
            }
        }
        response.sendRedirect("/user/list"+"?"+msg_type+"="+msg);
    }
}
