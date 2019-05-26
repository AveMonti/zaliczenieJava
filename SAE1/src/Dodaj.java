import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "Dodaj")
public class Dodaj extends HttpServlet {
    static List<String> koszyk = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        page(response, request);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       page(response, request);
    }

    private void page(HttpServletResponse response, HttpServletRequest request) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String value = request.getParameter("wartosc");
        koszyk.add(value);
        request.getSession().setAttribute("lista", koszyk);
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<form action='Dodaj' method='post'>");
        writer.println("<input type='text', name='wartosc'>");
        writer.println("<input type='submit', value='ok'>");
        writer.println("<ul>");
        for(String s : koszyk){
            if (s!=null) {
                writer.println("<li>" + s + "</li>");
            }
        }
        writer.println("</ul>");

        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
    }
}
