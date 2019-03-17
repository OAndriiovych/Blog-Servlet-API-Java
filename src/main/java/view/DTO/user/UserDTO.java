package view.DTO.user;

import db.database.Roles;

import java.util.Date;

public class UserDTO {
    protected String login;
    protected String lastname;
    protected Date date_of_reg;
    protected String way_to_photo;
    protected Roles role;

    public UserDTO(String login, String lastname, Date date_of_reg, String way_to_photo, Roles role) {
        this.login = login;
        this.lastname = lastname;
        this.date_of_reg = date_of_reg;
        this.way_to_photo = way_to_photo;
        this.role = role;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getDate_of_reg() {
        return date_of_reg;
    }

    public void setDate_of_reg(Date date_of_reg) {
        this.date_of_reg = date_of_reg;
    }

    public String getWay_to_photo() {
        return way_to_photo;
    }

    public void setWay_to_photo(String way_to_photo) {
        this.way_to_photo = way_to_photo;
    }
}
