//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "LoginServlet"
)
public class LoginServlet extends HttpServlet {
    public LoginServlet() {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this.isLogIn(request)) {
            request.getRequestDispatcher("profil.jsp").include(request, response);
        } else {
            this.logIn(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private boolean areCredentialsOk(String requestLogin, String requestPassword) {
        String login = "admin";
        String password = "admin";
        return requestLogin.equals(login) && requestPassword.equals(password);
    }

    private boolean isLogIn(HttpServletRequest request) {
        List<Cookie> cookies = Arrays.asList(request.getCookies());
        Optional<String> loginCookie = cookies.stream().filter((cookie) -> {
            return cookie.getName().equals("loginCookie");
        }).map(Cookie::getValue).findAny();
        Optional<String> passwordCookie = cookies.stream().filter((cookie) -> {
            return cookie.getName().equals("passwordCookie");
        }).map(Cookie::getValue).findAny();
        return loginCookie.isPresent() && passwordCookie.isPresent() ? this.areCredentialsOk((String)loginCookie.get(), (String)passwordCookie.get()) : false;
    }

    private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<String> requestLogin = Optional.ofNullable(request.getParameter("login"));
        Optional<String> requestPassword = Optional.ofNullable(request.getParameter("password"));
        if (!requestLogin.isPresent() || !requestPassword.isPresent()) {
            request.getRequestDispatcher("login.jsp").include(request, response);
        }

        if (this.areCredentialsOk((String)requestLogin.get(), (String)requestPassword.get())) {
            Cookie loginCookie = new Cookie("loginCookie", (String)requestLogin.get());
            Cookie passwordCookie = new Cookie("passwordCookie", (String)requestPassword.get());
            response.addCookie(loginCookie);
            response.addCookie(passwordCookie);
            request.getRequestDispatcher("profil.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("failLogin.jsp").include(request, response);
        }

    }
}
