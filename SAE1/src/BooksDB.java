import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "BooksDB")
public class BooksDB extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8888","root","123qweasd");
            Statement statement;

            String sql;
            String label;

            if (request.getParameter("select").equals("book")){
                sql = "Select title from books where author like '%"+request.getParameter("search")+"%'";
                label = "title";
            } else {
                sql = "Select author from books where title like '%"+request.getParameter("search")+"%'";
                label = "author";
            }

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
                String title = resultSet.getString(label);
                writer.println(title);
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
