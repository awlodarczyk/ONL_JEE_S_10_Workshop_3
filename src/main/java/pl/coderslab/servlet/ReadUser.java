package pl.coderslab.servlet;

import pl.coderslab.service.UserService;
import pl.coderslab.util.ResponseHelper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ReadUser", value = "/user/show")
public class ReadUser extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String id = request.getParameter("id");
        String msg ="";
        String msg_type ="";
       if(id == null || id.isBlank()){
           msg_type ="error_msg";
           msg = URLEncoder.encode("Parametr id jest pusty", StandardCharsets.UTF_8);
           ResponseHelper.sendRedirect(response,"/user/list",msg_type,msg);
           return;
       }else {
           try{
               Integer _id = Integer.parseInt(id);
               request.setAttribute("user",service.findById(_id));
           }catch (NumberFormatException e){
               msg_type ="error_msg";
               msg = URLEncoder.encode("Parametr id powinien być liczbą", StandardCharsets.UTF_8);
               ResponseHelper.sendRedirect(response,"/user/list",msg_type,msg);
               return;
           }
       }
       request.getRequestDispatcher("/site/show.jsp").forward(request,response);
    }
}
