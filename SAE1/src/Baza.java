import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "Baza")
public class Baza extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/Servlet?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","admin");
            Statement statement;
            String sql = "Select name, surname from osoby where surname like '%"+request.getParameter("search")+"%'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter writer = response.getWriter();
            writer.println("<!DOCTYPE html>");
            writer.println("<html>");
            writer.println("<body>");
            boolean notExists = true;
            while (resultSet.next()){
                notExists = false;
                String imie = resultSet.getString("name");
                String nazwisko = resultSet.getString("surname");
                writer.println(imie + " " +nazwisko);
                writer.println("<br>");
            }
            if(notExists){
                writer.println("Nie znaleziono");
            }
            writer.println("<a href=index5.jsp>back</a>");
            writer.println("</body>");
            writer.println("</html>");


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
