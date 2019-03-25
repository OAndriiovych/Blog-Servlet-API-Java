package servlets.account;

import db.database.Roles;
import db.database.User;
import view.DTO.user.UserDTO;
import view.controllersDTO.user.UserContDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/listofusers")
public class ListOfUsers extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = null;
        try {
            user = userServ.getByID(getIdFromSession(req));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }

        if (user == null || !(user.getUser_role() == Roles.ADMIN)) {
            resp.sendRedirect(req.getContextPath() + "/");
            return;
        }
        List<UserDTO> userDTOList = new LinkedList<>();
        List<User> userList = null;
        try {
            userList = userServ.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (User u : userList) {
            userDTOList.add(UserContDTO.convertToUserDTO(u));
        }
        req.setAttribute("userDTOList", userDTOList);
        req.getRequestDispatcher("WEB-INF/jsp/listOfUsers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        Roles role = Roles.valueOf(req.getParameter("role").toUpperCase());
        String message = null;
        User user = null;
        try {
            user = userServ.getByID(userServ.getID(email));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user != null) {
            user.setUser_role(role);
            try {
                userServ.update(user.getId_user(), user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            message = "Update user's \"" + user.getLogin() + "\" role to " + role;

        } else {
            message = "Did not find the user";
        }
        req.setAttribute("message", message);
        doGet(req, resp);
    }
}
