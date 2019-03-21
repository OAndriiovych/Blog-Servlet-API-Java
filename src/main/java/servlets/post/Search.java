package servlets.post;

import view.DTO.post.PostLessDTO;

import view.controllersDTO.post.PostContLess;
import db.database.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
        String message="Sorry we didn't find anything((";
        if(like.replaceAll("\\s+","").equals("")){
            req.setAttribute("like", like);
            req.setAttribute("message", message);
            req.getRequestDispatcher("search.jsp").forward(req, resp);
            return;
        }
        List<Post> postList = null;
        List<PostLessDTO> postLessDTOList = new LinkedList<>();
        try {
            postList = postServ.findLike(like);
            if(!postList.isEmpty()){
                for (Post post : postList) {
                    PostLessDTO postLessDTO =PostContLess.getPostLess(post);
                    postLessDTO.setWay_to_photo(postLessDTO.getWay_to_photo().replace("\\", "/"));
                    postLessDTOList.add(postLessDTO);
                }
            }
            else {
                req.setAttribute("message", message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("postLessDTOList", postLessDTOList);
        req.setAttribute("like", like);
        req.getRequestDispatcher("search.jsp").forward(req, resp);
    }
}
