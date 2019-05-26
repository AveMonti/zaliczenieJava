import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "LogoutServlet")
public class LogoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clearCookies(request, response);

        request.getRequestDispatcher("index.jsp").include(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private void clearCookies(HttpServletRequest request, HttpServletResponse response){
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        Optional<Cookie> loginCookie = cookies.stream().filter(cookie -> cookie.getName().equals("loginCookie")).findAny();
        Optional<Cookie> passwordCookie = cookies.stream().filter(cookie -> cookie.getName().equals("passwordCookie")).findAny();

        if (loginCookie.isPresent()){
            loginCookie.get().setMaxAge(0);
            response.addCookie(loginCookie.get());
        }

        if (passwordCookie.isPresent()){
            passwordCookie.get().setMaxAge(0);
            response.addCookie(passwordCookie.get());
        }


    }
}
