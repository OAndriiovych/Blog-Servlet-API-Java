package servlets.post;

import view.DTO.post.PostAllDTO;
import view.DTO.post.PostLessDTO;
import view.DTO.post.PostLittleDTO;
import view.controllersDTO.post.PostContAll;
import view.controllersDTO.post.PostContLess;
import view.controllersDTO.post.PostContLittle;
import db.database.Post;
import db.servises.PostServ;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet("/search")
public class Search extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String like = req.getParameter("search");
        String message=null;
        if(like.replaceAll("\\s+","").equals("")){
            message="Sorry we didn't find anything((";
            req.setAttribute("like", like);
            req.setAttribute("message", message);
            req.getRequestDispatcher("search.jsp").forward(req, resp);
            return;
        }
        List<Post> postList = null;
        List<PostLessDTO> postLessDTOList = new LinkedList<>();
        try {
            postList = postServ.findLike(like);
            if(postList.isEmpty()){

            }
            else {
                for (Post post : postList) {
                    postLessDTOList.add(PostContLess.getPostLess(post));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("postLessDTOList", postLessDTOList);
        req.setAttribute("like", like);
        req.setAttribute("message", message);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }


}
