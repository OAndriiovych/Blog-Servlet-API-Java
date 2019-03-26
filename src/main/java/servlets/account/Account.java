package servlets.account;

import db.database.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import view.controllersDTO.user.UserContDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@WebServlet("/account")
public class Account extends BaseServlet {
    private Random random = new Random();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!BaseServlet.checkSession(req) && !BaseServlet.checkCookies(req)) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        User user = null;
        try {
            user = userServ.getByID(getIdFromSession(req));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.setAttribute("person", UserContDTO.convertToUserDTO(user));

        req.getRequestDispatcher("WEB-INF/jsp/account.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String login = null;
        String lastname = null;
        String password = null;
        String path = null;
        if (!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);
        ServletFileUpload upload = new ServletFileUpload(factory);
        /**
         * conctatnt
         */
        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    if (item.getFieldName().equals("lastname")) {
                        lastname = item.getString();
                    } else if (item.getFieldName().equals("email")) {
                        login = item.getString();
                    } else if (item.getFieldName().equals("psw")) {
                        password = item.getString();
                    }
                } else if (item.getSize() > 1) {
                    if (item.getSize() > 393216000) {
                        request.setAttribute("size", true);
                        request.getRequestDispatcher("WEB-INF/jsp/account.jsp").forward(request, response);
                        return;
                    }
                    path = processUploadedFile(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        User updateUser = null;
        try {
            updateUser = userServ.getByID(getIdFromSession(request));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (!login.equals("")) {
                updateUser.setLogin(login);
            }
            if (!password.equals("")) {
                updateUser.setPassw(password);
            }
            if (!lastname.equals("")) {
                updateUser.setLastname(lastname);
            }
            if (path != null) {
                updateUser.setWay_to_photo(path);
            }
            userServ.update(updateUser.getId_user(), updateUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("WEB-INF/jsp/account.jsp").forward(request, response);
    }

    private String processUploadedFile(FileItem item) throws Exception {
        File uploadetFile = null;
        String way = null;
        do {
            way = "/images/users/" + random.nextInt() + item.getName();
            uploadetFile = new File(getServletContext().getRealPath(way));
        } while (uploadetFile.exists());
        item.write(uploadetFile);
        return way;
    }
}
