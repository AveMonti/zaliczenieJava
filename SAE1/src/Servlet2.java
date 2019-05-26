import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Servlet2")
public class Servlet2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        Cookie cookie_color = new Cookie("color", request.getParameter("select"));
        response.addCookie(cookie_color);
        Cookie cookie_size = new Cookie("size", request.getParameter("select_size"));
        response.addCookie(cookie_size);

        List<Cookie> cookies = Arrays.asList(request.getCookies());

        String color = cookies.stream()
                .filter(cookie -> cookie.getName().equals("color"))
                .map(Cookie::getValue)
                .findAny().orElse("black");

        String size = cookies.stream()
                .filter(cookie -> cookie.getName().equals("size"))
                .map(Cookie::getValue)
                .findAny().orElse("8");

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<div>");
        writer.println("<div>");
        writer.println("<div>");
        writer.println(getServletConfig().getInitParameter("email"));
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter writer = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<div>");
        writer.println("<div>");
        writer.println("<div>");
        writer.println(getServletConfig().getInitParameter("email"));
        writer.println("<br>");
        writer.println(getServletContext().getInitParameter("context"));
        writer.println("</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
