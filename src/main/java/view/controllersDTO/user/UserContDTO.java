package view.controllersDTO.user;

import db.database.User;
import view.DTO.user.UserDTO;

public class UserContDTO {
    public static final UserDTO convertToUserDTO(User user) {
        return new UserDTO(
                user.getLogin(),
                user.getLastname(),
                user.getDate_of_reg(),
                user.getWay_to_photo(),
                user.getUser_role());
    }
}
