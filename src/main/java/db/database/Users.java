package db.database;

import java.sql.Date;

public class Users {
    private int id_user;
    private String login;
    private String passw;
    private Date date_of_reg;
    private Roles user_role;

    @Override
    public String toString() {
        return "Users{" +
                "id_user=" + id_user +
                ", login='" + login + '\'' +
                ", passw='" + passw + '\'' +
                ", date_of_reg=" + date_of_reg +
                ", user_role=" + user_role +
                '}';
    }

    public Users(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }

    public Users(String login, String passw, Roles user_role) {
        this.login = login;
        this.passw = passw;
        this.user_role = user_role;
    }

    public Users(int id_user, String login, String passw, Date date_of_reg, Roles user_role) {
        this.id_user = id_user;
        this.login = login;
        this.passw = passw;
        this.date_of_reg = date_of_reg;
        this.user_role = user_role;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public Date getDate_of_reg() {
        return date_of_reg;
    }

    public void setDate_of_reg(Date date_of_reg) {
        this.date_of_reg = date_of_reg;
    }

    public Roles getUser_role() {
        return user_role;
    }

    public void setUser_role(Roles user_role) {
        this.user_role = user_role;
    }

}

