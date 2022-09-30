package pl.coderslab.servlet;

import pl.coderslab.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReadAllUsers", value = "/user/list")
public class ReadAllUsers extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users",service.findAll());
        request.getRequestDispatcher("/site/list.jsp").forward(request,response);
    }

}
