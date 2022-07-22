package servlets;

import accounts.AccountService;
import dbService.DBException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    public AccountService accountService;

    public SignUpServlet(AccountService accountService) {
        this.accountService = accountService;

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            accountService.dbService.addUser(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        System.out.println("user: " + login + ", pass: " + password + ", add in map");
        response.getWriter().println("user add in table");


    }
}
