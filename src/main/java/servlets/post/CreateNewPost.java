package servlets.post;

import db.database.Post;
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
        if (servlets.account.BaseServlet.checkSession(req, resp)) {
            req.getRequestDispatcher("createpost.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/login");
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
        // Создаём класс фабрику
        DiskFileItemFactory factory = new DiskFileItemFactory();

        // Максимальный буфера данных в байтах,
        // при его привышении данные начнут записываться на диск во временную директорию
        // устанавливаем один мегабайт
        factory.setSizeThreshold(1024 * 1024);

        // устанавливаем временную директорию
        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        //Создаём сам загрузчик
        ServletFileUpload upload = new ServletFileUpload(factory);

        //максимальный размер данных который разрешено загружать в байтах
        //по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт.
        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(req);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (item.isFormField()) {
                    //если принимаемая часть данных является полем формы
                    if (item.getFieldName().equals("topic")) {
                        topic = item.getString();
                    } else if (item.getFieldName().equals("category")) {
                        category = item.getString();
                    } else if (item.getFieldName().equals("post")) {
                        body = item.getString();
                    }
                } else {
                    System.out.println(item.getSize());
                    if (item.getSize() > 26_214_400) {
                        message = "photo too big";
                        req.setAttribute("message", message);
                        req.getRequestDispatcher("createpost.jsp").forward(req, resp);
                        return;
                    }
                    //в противном случае рассматриваем как файл
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
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String id = attributeNames.nextElement();
            if (id.equals("id")) {
                user_id = (int) session.getAttribute(id);
                break;
            }
        }

        if (!category.equals("") &&
                !topic.equals("") &&
                !body.equals("") &&
                !path.equals("")) {
            Post post = new Post(category, topic, body, path, user_id);
            try {
                postServ.add(post);
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
        //выбираем файлу имя пока не найдём свободное
        do {
            way = "/lool/" + new Random().nextInt() + item.getName();
            String path = getServletContext().getRealPath(way);
            System.out.println(path);
            //String path=getServletContext().getRealPath("d:/test/"+random.nextInt() + item.getName());
            //String path ="d:/test/"+random.nextInt() + item.getName();
            uploadetFile = new File(path);
        } while (uploadetFile.exists());

        //создаём файл
        //uploadetFile.createNewFile();
        //записываем в него данные
        item.write(uploadetFile);
        return way;
    }
}
