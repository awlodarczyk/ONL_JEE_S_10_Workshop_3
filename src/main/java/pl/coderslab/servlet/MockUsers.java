package pl.coderslab.servlet;

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

@WebServlet(name = "MockUsers", value = "/user/mock")
public class MockUsers extends HttpServlet {

    private final UserService service = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        service.mockDb();

        String msg = URLEncoder.encode("Baza została przygotowana", StandardCharsets.UTF_8);
        ResponseHelper.sendRedirect(request,response,"success_msg",msg);}
}
