package servlets.account;

import db.database.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class Registration extends BaseServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("email");
        try {
            if (userServ.isUser(name)) {
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User(name, req.getParameter("psw"), req.getParameter("lastname"));
        User userLogin = null;
        HttpSession session = req.getSession();
        try {
            userServ.add(user);
            //resp.addCookie(new Cookie("id", Integer.toString(users.getId_user())));
            userLogin = userServ.getUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        login(userLogin, session);
        resp.sendRedirect(req.getContextPath() + "/");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (BaseServlet.checkSession(req, resp)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        RequestDispatcher view = req.getRequestDispatcher("registration.jsp");
        view.forward(req, resp);
    }

}
