import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BiuroSummary")
public class BiuroSummary extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        page(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        page(request, response);
    }

    private void page(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.println("<!DOCTYPE html>");
        writer.println("<html>");
        writer.println("<body>");
        writer.println("Podsumowanie");
        int cena = Integer.valueOf(request.getSession().getAttribute("cena").toString());
        int osoby = Integer.valueOf(request.getSession().getAttribute("osoby").toString());
        String suma = String.valueOf(cena*osoby);
        writer.println("koszt: "+suma);
        writer.println("</html>");
    }
}
