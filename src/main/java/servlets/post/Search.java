package servlets.post;

import DTO.post.PostAllDTO;
import DTO.post.PostLittleDTO;
import controllersDTO.post.PostContAll;
import controllersDTO.post.PostContLittle;
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
public class Search extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*for doPost*/
       // int id = Integer.valueOf(req.getParameter("post"));
        PostServ postServ = new PostServ();
        postServ.connect();
        List<Post> list = new LinkedList<>();
        PostAllDTO postAllLong = null;

        try {
            postAllLong=PostContAll.getPostAllLong(postServ.getByID(4));
            list= postServ.last(3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<PostLittleDTO> postLittleDTOList = new LinkedList<>();
        for(Post post:list) {
            postLittleDTOList.add(PostContLittle.getPostLittle(post));
        }

        req.setAttribute("postAllLong", postAllLong);
        req.setAttribute("postList", postLittleDTOList);
        req.getRequestDispatcher("search.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
