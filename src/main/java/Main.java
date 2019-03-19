

import db.database.Post;
import db.database.User;
import db.servises.CommentServ;
import db.servises.PostServ;
import db.servises.UserServ;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws SQLException {
        int count=72;
        int from=0;
        int to=12;
        int postAtPage=12;
        int lastpage = 0;
        int presentpage =4;
        int[] pages = new int[7];



            if(count%postAtPage==0){
                lastpage=count/postAtPage;
            }
            else {
                lastpage=count/postAtPage+1;
            }

            if(presentpage>(lastpage)){
                presentpage=0;
            }
int id=0;
        for(int i = presentpage-1;i<=presentpage+3;i++) {

            if (i > 0) {
                pages[id]=i;
                id++;
            }
        }
        pages[6]=lastpage;
        from+=12*presentpage;
        to+=12*presentpage;
        for(int i = 0;i<pages.length;i++){
            System.out.println(pages[i]);
        }
        System.out.println(Arrays.asList(pages));


    }


}
