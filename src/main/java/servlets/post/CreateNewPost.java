package servlets.post;

import db.database.Post;
import db.database.Roles;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

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

@WebServlet("/createpost")
public class CreateNewPost extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (servlets.account.BaseServlet.getRole(req) != Roles.USER) {
            req.getRequestDispatcher("createpost.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/account");
            return;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //проверяем является ли полученный запрос multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(req);
        String topic = null;
        String category = null;
        String body = null;
        String path = null;
        String message = null;
        if (!isMultipart) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024 * 1024);
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 1024 * 10);
        try {
            List items = upload.parseRequest(req);
            Iterator iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    if (item.getFieldName().equals("topic")) {
                        topic = item.getString();
                    } else if (item.getFieldName().equals("category")) {
                        category = item.getString();
                    } else if (item.getFieldName().equals("post")) {
                        body = item.getString();
                    }
                } else {
                    System.out.println(item.getSize());
                    if (item.getSize() >  41_943_040) {
                        message = "photo too big";
                        req.setAttribute("message", message);
                        req.getRequestDispatcher("createpost.jsp").forward(req, resp);
                        return;
                    }
                    path = processUploadedFile(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        int user_id = 0;
        HttpSession session = req.getSession();
        try {
            user_id = (int) session.getAttribute("id");
        } catch (NullPointerException e) {
            resp.sendRedirect(req.getContextPath() + "/account");
            return;
        }

        if (!category.equals("") &&
                !topic.equals("") &&
                !body.equals("") &&
                !path.equals("")) {
            try {
                postServ.add(new Post(category, topic, body, path, user_id));
                message = "All is okey!";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            message = "Something went wrong category= " + category + "; topic=" + topic + "; post=" + body + "; way to photo=" + path;
        }
        req.setAttribute("message", message);
        req.getRequestDispatcher("createpost.jsp").forward(req, resp);
    }

    private String processUploadedFile(FileItem item) throws Exception {
        File uploadetFile = null;
        String way = null;
        do {
            way = "/images/posts/" + new Random().nextInt() + item.getName();
            String path = getServletContext().getRealPath(way);
            System.out.println(path);
            uploadetFile = new File(path);
        } while (uploadetFile.exists());
        item.write(uploadetFile);
        return way;
    }
}
