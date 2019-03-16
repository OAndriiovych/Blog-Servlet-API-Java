package db.database;

import java.sql.Date;
import java.util.Objects;

public class User {
    private int id_user;
    private String login;
    private String passw;
    private String lastname;
    private Date date_of_reg;
    private String way_to_photo;
    private Roles user_role;

    public String getWay_to_photo() {
        return way_to_photo;
    }

    public void setWay_to_photo(String way_to_photo) {
        this.way_to_photo = way_to_photo;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User users = (User) o;
        return id_user == users.id_user &&
                Objects.equals(login, users.login) &&
                Objects.equals(passw, users.passw) &&
                Objects.equals(lastname, users.lastname) &&
                Objects.equals(date_of_reg, users.date_of_reg) &&
                user_role == users.user_role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_user, login, passw, lastname, date_of_reg, user_role);
    }



    public User(int id_user, String login, String passw, String lastname, Date date_of_reg, String way_to_photo, Roles user_role) {
        this.id_user = id_user;
        this.login = login;
        this.passw = passw;
        this.lastname = lastname;
        this.date_of_reg = date_of_reg;
        this.way_to_photo = way_to_photo;
        this.user_role = user_role;
    }

    public User(String login, String passw, String lastname, String way_to_photo, Roles user_role) {
        this.login = login;
        this.passw = passw;
        this.lastname = lastname;
        this.way_to_photo = way_to_photo;
        this.user_role = user_role;
    }
    public User(String login, String passw, String lastname, String way_to_photo) {
        this.login = login;
        this.passw = passw;
        this.lastname = lastname;
        this.way_to_photo = way_to_photo;
        this.user_role = user_role;
    }
    public User(String login, String passw, String lastname, Roles user_role) {
        this.login = login;
        this.passw = passw;
        this.lastname = lastname;
        this.user_role = user_role;
    }
    public User(String login, String passw, String lastname) {
        this.login = login;
        this.passw = passw;
        this.lastname = lastname;
    }

    public User(String login, String passw) {
        this.login = login;
        this.passw = passw;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }



    public int getId_user() {
        return id_user;
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

    public Roles getUser_role() {
        return user_role;
    }

    public void setUser_role(Roles user_role) {
        this.user_role = user_role;
    }

}

