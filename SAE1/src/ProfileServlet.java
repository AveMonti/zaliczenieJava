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

@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (isLogIn(request)) {
            request.getRequestDispatcher("koszyk.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private boolean isLogIn(HttpServletRequest request) {
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        Optional<String> loginCookie = cookies.stream().filter(cookie -> cookie.getName().equals("loginCookie")).map(Cookie::getValue).findAny();
        Optional<String> passwordCookie = cookies.stream().filter(cookie -> cookie.getName().equals("passwordCookie")).map(Cookie::getValue).findAny();

        return (loginCookie.isPresent() && passwordCookie.isPresent());
    }
}
