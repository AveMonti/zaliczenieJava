import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;

@WebServlet(name = "Servlet")
public class Servlet extends HttpServlet {

    private static int counter = 0;

    protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //     response.setContentType("text/html;charset=UTF-8");
//        writer.println("<!DOCTYPE html>");
//        writer.println("<html>");
//        writer.println("<body>");
//        String imie = request.getParameter("imie");
//        writer.println("<a href = 'Strona?imie="+imie+"'>Zobacz strone</a>");
////        writer.println(request.getHeader("User-Agent"));
////        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
////        response.setHeader("Location","https://www.wp.pl");
//
//
//        writer.println("</body>");
//        writer.println("</html>");
        PrintWriter writer = response.getWriter();
        writer.println("Witaj " + request.getParameter("imie"));
        writer.println(request.getParameter("login"));
        writer.println(counter++);

        writer.println(request.getLocale().getLanguage());
        writer.println(request.getLocale().getCountry());
        String[] values = request.getParameterValues("checkbox");
        writer.println(Arrays.asList(values));

        Cookie cookie_counter = new Cookie("counter", String.valueOf(counter));

        response.addCookie(cookie_counter);
    }

    protected void doGet1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        writer.println(counter++);
        Date date = new Date();
//        response.setIntHeader("Refresh",1);
        writer.println(date);
        String c = String.valueOf(counter);
        Cookie cookie_counter = new Cookie("counter", c);
        response.addCookie(cookie_counter);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }




}
