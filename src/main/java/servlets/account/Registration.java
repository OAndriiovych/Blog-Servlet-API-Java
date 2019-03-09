package servlets.account;

import db.database.Users;
import db.servises.UserServ;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/reg")
public class Registration extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws  IOException {

        String name = req.getParameter("email");
        try {
            if (userServ.isUser(name)) {
                resp.sendRedirect("have.html");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String password = req.getParameter("psw");
        try {
            userServ.add(new Users(name, password));
            resp.addCookie(new Cookie("id", Integer.toString(userServ.getID(name))));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("success.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(checkCookies(req,resp)){
            return;
        }
        RequestDispatcher view = req.getRequestDispatcher("reg.html");
        view.forward(req, resp);
    }

}
