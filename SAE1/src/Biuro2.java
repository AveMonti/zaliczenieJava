import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Biuro2")
public class Biuro2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String[] wycieczkaDane = request.getParameter("lista").split(" ");
        request.getSession().setAttribute("wycieczka", wycieczkaDane[0]);
        request.getSession().setAttribute("cena", wycieczkaDane[1]);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("imie "+request.getSession().getAttribute("imie"));
        writer.println("liczba osob "+request.getSession().getAttribute("osoby"));
        writer.println("wycieczka "+request.getParameter("lista"));
        writer.println("<a href='BiuroSummary'>dalej</a> ");

        writer.println("</body>");
        writer.println("</html>");
    }
}
