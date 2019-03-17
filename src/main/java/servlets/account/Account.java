package servlets.account;

import db.database.Roles;
import db.database.User;
import view.controllersDTO.user.UserContDTO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet("/account")
public class Account extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!BaseServlet.checkSession(req, resp)) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
//            RequestDispatcher view = req.getRequestDispatcher("/login");
//            view.forward(req, resp);
        }
        User user = null;
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.equals("id")) {
                try {
                   user= userServ.getByID((Integer) session.getAttribute(name));
                   break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        req.setAttribute("person", UserContDTO.convertToUserDTO(user));

        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

}
