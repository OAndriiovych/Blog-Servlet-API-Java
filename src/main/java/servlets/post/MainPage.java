package servlets.post;


import view.DTO.post.PostAllDTO;
import view.DTO.post.PostLessDTO;
import view.DTO.post.PostLittleDTO;
import view.controllersDTO.post.PostContAll;
import view.controllersDTO.post.PostContLess;
import db.database.Post;
import db.database.User;
import db.servises.CommentServ;
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

@WebServlet("/main")
public class MainPage extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        CommentServ commentServ = new CommentServ();
        commentServ.connect();

        PostServ postServ = new PostServ();
        PostContAll pca = new PostContAll();
        PostContLess pcless = new PostContLess();
        List<PostAllDTO> listP = new LinkedList<>();
        List<PostLittleDTO> listP2 = new LinkedList<>();
        List<Post> posts = new LinkedList();

        postServ.connect();

        try {
            posts = postServ.last(12);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        postServ.closeConnection();

        int size = posts.size() - (posts.size() % 3);

        for (int i = 0; i < size; i++) {
            Post p = posts.get(i);

            if (i < 3) {
                PostAllDTO postAllDTO = null;
                try {
                    postAllDTO = pca.getPostAllLite(p);
                    postAllDTO.setCountComment(commentServ.getCountComment(p.getId_post()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                listP.add(postAllDTO);
            } else {
                PostLessDTO postLessDTO = null;
                try {
                    postLessDTO = pcless.getPostLess(p);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                listP2.add(postLessDTO);
            }
        }
        req.setAttribute("bigPosts", listP);
        req.setAttribute("littlePosts", listP2);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }


}
