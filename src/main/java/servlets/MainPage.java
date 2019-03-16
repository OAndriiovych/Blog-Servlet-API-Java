package servlets;


import DTO.post.PostAllDTO;
import DTO.post.PostLessDTO;
import DTO.post.PostLittleDTO;
import controllersDTO.post.PostContAll;
import controllersDTO.post.PostContLess;
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

        UserServ userServ = new UserServ();

        CommentServ commentServ = new CommentServ();
        commentServ.connect();

        PostServ postServ = new PostServ();
        PostContAll pca = new PostContAll();
        PostContLess pcless = new PostContLess();
        List<PostAllDTO> listP = new LinkedList<>();
        List<PostLittleDTO> listP2 = new LinkedList<>();
        List<Post> posts = new LinkedList();

        postServ.connect();
        userServ.connect();
        try {
            posts = postServ.last(12);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        postServ.closeConnection();

        int size = posts.size() - (posts.size() % 3);

        for (int i = 0; i < size; i++) {
            Post p = posts.get(i);
            User user = null;
            try {
                user = userServ.getByID(p.getUser_id());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (i <3) {
                PostAllDTO postAllDTO = pca.getPostAllLite(p);
                postAllDTO.setAuthor(user.getLastname());
                postAllDTO.setWay_to_author_photo(user.getWay_to_photo());
                try {
                    postAllDTO.setCountComment(commentServ.getCountComment(p.getId_post()));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                listP.add(postAllDTO);
            } else {
                PostLessDTO postLessDTO = pcless.getPostLess(p);
                postLessDTO.setAuthor(user.getLastname());
                postLessDTO.setWay_to_author_photo(user.getWay_to_photo());
                listP2.add(postLessDTO);
            }
        }

        userServ.closeConnection();

        req.setAttribute("bigPosts", listP);
        req.setAttribute("littlePosts", listP2);
        req.getRequestDispatcher("main.jsp").forward(req, resp);
    }


}
