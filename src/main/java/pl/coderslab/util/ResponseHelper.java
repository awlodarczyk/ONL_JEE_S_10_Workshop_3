package pl.coderslab.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseHelper {

    public static void sendRedirect(HttpServletRequest request, HttpServletResponse response, String msg_type,String msg) throws IOException {

        if(request.getHeader("referer")!=null) {
            if (request.getHeader("referer").contains("?")) {
                response.sendRedirect(request.getHeader("referer").substring(0, request.getHeader("referer").indexOf("?")) + "?" + msg_type + "=" + msg);
            } else {
                response.sendRedirect(request.getHeader("referer") + "?" + msg_type + "=" + msg);
            }
        }else {
            throw new NullPointerException("Header(\"referer\") is NULL");
        }
    }
    public static void sendRedirect(HttpServletResponse response,String path, String msg_type,String msg) throws IOException {

        response.sendRedirect(path + "?" + msg_type + "=" + msg);
    }
}
