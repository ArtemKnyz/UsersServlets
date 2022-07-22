package servlets;

import accounts.AccountService;
import accounts.UserProfile;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignInServlet extends HttpServlet {
    AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws NullPointerException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        //UserProfile profile = accountService.getDbService().addUser(login);
        UserProfile profile = null;
        if (((profile == null)) || (!profile.getPass().equals(password))) {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            // System.out.println("user " + login + " Unauthorized");
            response.getWriter().println("Unauthorized");
        } else {
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            //System.out.println("user " + login + " Authorized");
            response.getWriter().println("Authorized: " + login);

        }
    }
}
