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
public class MainPage extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostContAll pca = new PostContAll();
        PostContLess pcless = new PostContLess();
        List<PostAllDTO> listP = new LinkedList<>();
        List<PostLittleDTO> listP2 = new LinkedList<>();
        List<Post> posts = new LinkedList();
        int count = 0;
        int from = 0;
        int to = 12;
        int postAtPage = 12;
        int lastpage = 0;
        int presentpage = 1;
        int[] pages = new int[7];

        try {
            count = postServ.count();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (count % postAtPage == 0) {
            lastpage = count / postAtPage;
        } else {
            lastpage = count / postAtPage + 1;
        }

        if (req.getParameter("page") != null) {
            try {
                presentpage = Integer.parseInt(req.getParameter("page"));
            } catch (NumberFormatException e) {
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
            if (presentpage > (lastpage)) {
                presentpage = 1;
            }
        }
        int id = 0;
        for (int i = presentpage - 1; i <= presentpage + 3; i++) {
            if (i > 0) {
                pages[id] = i;
                id++;
            }
            if (i == lastpage) {
                break;
            }
        }
        pages[6] = lastpage;

        req.setAttribute("pages", pages);
        req.setAttribute("presentpage", presentpage);
        presentpage--;
        from += postAtPage * presentpage;
        to += postAtPage * presentpage;

        try {
            posts = postServ.last(from, to);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < posts.size(); i++) {
            Post p = posts.get(i);
            if (i < 3) {
                PostAllDTO postAllDTO = null;
                try {
                    postAllDTO = pca.getPostAllLite(p);
                    postAllDTO.setCountComment(commentServ.getCountComment(p.getId_post()));
                    postAllDTO.setWay_to_photo(postAllDTO.getWay_to_photo().replace("\\", "/"));
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
        req.getRequestDispatcher("/WEB-INF/jsp/main.jsp").forward(req, resp);
    }
}
