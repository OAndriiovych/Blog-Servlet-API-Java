package servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/gotohell")
public class Test extends HttpServlet  {
    @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        java.sql.Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            //property.load(new FileInputStream(wayToProperty));
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/blog_db",
                    "postgres",
                    "mct");
            PreparedStatement prpStat = conn.prepareStatement("INSERT INTO users (login, passw,user_role) VALUES ('123456','132','user')");
            prpStat.executeUpdate();
            prpStat.close();

        } //catch (IOException e) {
        //System.err.println("ОШИБКА: Файл свойств отсуствует!");
        //}
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void run(Thread thread) {

    }
}
