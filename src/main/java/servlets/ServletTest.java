package servlets;

import db.database.Users;
import db.servises.UserServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/account")
public class ServletTest extends HttpServlet {

    UserServ userServ = new UserServ();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("email");
        try {
            if (userServ.isUser(name)) {
                resp.sendRedirect("wordify/have.html");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String password = req.getParameter("psw");
        try {
            userServ.add(new Users(name, password));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("wordify/success.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("wordify/account.html");
        view.forward(req, resp);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("d:/SS/blog/web/index.jsp");
//        requestDispatcher.forward(req, resp);
    }

    @Override
    public void init() throws ServletException {
        super.init();
        userServ.connect();
    }

    @Override
    public void destroy() {
        userServ.closeConnection();
        super.destroy();
    }
}
