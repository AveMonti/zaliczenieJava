import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Biuro1")
public class Biuro1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("<form action='Biuro2'>");
        writer.println("<select name='lista'>");
        writer.println("<option>czechy 500</option>");
        writer.println("<option>berlin 1500</option>");
        writer.println("</select>");
        writer.println("<input type='submit', value='dalej'>");
        writer.println("</form>");
        writer.println("</body>");
        writer.println("</html>");
        request.getSession().setAttribute("imie", request.getParameter("imie"));
        request.getSession().setAttribute("osoby", request.getParameter("osoby"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
