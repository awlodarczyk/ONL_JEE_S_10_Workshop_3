package pl.coderslab.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter("/*")
public class CharsetFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8"); // ustawiam kodowanie dla requestow
        response.setCharacterEncoding("utf-8"); // ustawiam kodowanie dla response
//        response.setContentType("text/html");
//        response.setContentType("application/pdf");
//        response.setContentType("image/png"); //potencjalnie ustawiam typ wysylanych danych do klienta
        chain.doFilter(request, response); //przekazuje potencjalnie do innych filtrow lub serwletu
    }
}
