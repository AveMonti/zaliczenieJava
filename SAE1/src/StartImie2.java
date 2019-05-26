import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="StartImie2")
public class StartImie2 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("imie", request.getParameter("imie"));
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter write = response.getWriter();

        write.println("<!DOCTYPE html>");
        write.println("<html>");
        write.println("<body>");
        write.println("Witaj: " +request.getParameter("imie"));
        write.println("<a href='Strona'>dalej</a>");
        write.println("</body>");
        write.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
