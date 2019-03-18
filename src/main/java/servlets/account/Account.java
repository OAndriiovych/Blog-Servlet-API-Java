package servlets.account;

import db.database.Roles;
import db.database.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import view.controllersDTO.user.UserContDTO;

import javax.servlet.RequestDispatcher;
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
        if (!BaseServlet.checkSession(req, resp)) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }
        User user = null;
        HttpSession session = req.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.equals("id")) {
                try {
                    user = userServ.getByID((Integer) session.getAttribute(name));
                    break;
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        req.setAttribute("person", UserContDTO.convertToUserDTO(user));

        req.getRequestDispatcher("account.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //проверяем является ли полученный запрос multipart/form-data
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        String login = null;
        String lastname = null;
        String password = null;
        String path = null;
        if (!isMultipart) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
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
            List items = upload.parseRequest(request);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (item.isFormField()) {
                    //если принимаемая часть данных является полем формы
                    if (item.getFieldName().equals("lastname")) {
                        lastname = item.getString();
                    } else if (item.getFieldName().equals("email")) {
                        login = item.getString();
                    } else if (item.getFieldName().equals("psw")) {
                        password = item.getString();
                    }
                } else {
                    if(item.getSize()>393216){
                        request.setAttribute("size", true);
                        request.getRequestDispatcher("account.jsp").forward(request, response);
                        return;
                    }
                    //в противном случае рассматриваем как файл
                    path = processUploadedFile(item);


                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }
        User updateUser = null;
        HttpSession session = request.getSession();
        Enumeration<String> attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            if (name.equals("id")) {
                try {
                    updateUser=userServ.getByID((int) session.getAttribute(name));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        try {
            if (!login.equals("")){
                updateUser.setLogin(login);
            }
            if (!password.equals("")){
                updateUser.setPassw(password);
            }
            if (!lastname.equals("")){
                updateUser.setLastname(lastname);
            }
            if (!path.equals("")){
                updateUser.setWay_to_photo(path);
            }
            userServ.update(updateUser.getId_user(), updateUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("account.jsp").forward(request, response);

    }

    /**
     * Сохраняет файл на сервере, в папке upload.
     * Сама папка должна быть уже создана.
     *
     * @param item
     * @throws Exception
     */
    private String processUploadedFile(FileItem item) throws Exception {
        File uploadetFile = null;
        String way = null;
        //выбираем файлу имя пока не найдём свободное
        do {
            way = "/upload/" + random.nextInt() + item.getName();
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
