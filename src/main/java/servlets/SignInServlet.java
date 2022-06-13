package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        UserProfile profile = accountService.getUserByLogin(login);
        if (profile == null || !profile.getPass().equals(password)) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            System.out.println("Unauthorized");

            response.getWriter().println("Unauthorized");

            return;
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        System.out.println("Authorized");
        response.getWriter().println("Authorized");


    }
}
