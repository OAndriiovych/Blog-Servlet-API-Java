package servlets.account;

import db.database.Roles;
import db.database.Users;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

@WebServlet("/registration")
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
        Users users= new Users(name, req.getParameter("psw"),req.getParameter("lastname"));
        HttpSession session = req.getSession();
        try {
            userServ.add(users);
            //resp.addCookie(new Cookie("id", Integer.toString(users.getId_user())));
            users=userServ.getUser(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        login(users,session);
        resp.sendRedirect("success.html");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(checkSession(req,resp)){
            return;
        }
        RequestDispatcher view = req.getRequestDispatcher("reg.html");
        view.forward(req, resp);
    }

}
