package servlets;



import db.database.Post;
import db.servises.PostServ;
import db.servises.UserServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/hell")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostServ postServ = new PostServ();
        UserServ userServ = new UserServ();
        List<Post> listP = new LinkedList<>();
        List<String> listA = new LinkedList<>();
        postServ.connect();
        userServ.connect();
//        try {
//            listP.add(postServ.last());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        postServ.closeConnection();
        userServ.closeConnection();
        for (Post p : listP) {
            try {
                listA.add(postServ.getAuthor(p.getUser_id()));
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            p.setPost(p.getPost().substring(0, 100) + "...");
        }
        //List listP = new LinkedList<>();

        req.setAttribute("myList", listP);
        req.getRequestDispatcher("main2.jsp").forward(req, resp);
    }


}
