package servlets.post;

import db.servises.CommentServ;
import db.servises.PostServ;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public abstract class BaseServlet extends HttpServlet {

    static CommentServ commentServ = new CommentServ();
    static PostServ postServ = new PostServ();
    @Override
    public void init() throws ServletException {
        super.init();
        commentServ.connect();
        postServ.connect();
    }

    @Override
    public void destroy() {
        commentServ.closeConnection();
        postServ.closeConnection();
        super.destroy();
    }
}
