package org.example.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.dto.UserDTO;

public class PasswordChangeFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtUsername;

    private UserBO userBO= (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void btnDoneOnAction(ActionEvent event) {
        UserDTO userDTO = userBO.searchUser(UserLoginFormController.userId);

        String newUserName = txtUsername.getText();
        String newPassword = txtPassword.getText();

        UserDTO newUserDTO = new UserDTO(userDTO.getUserId(), newUserName, userDTO.getEmail(), newPassword);

        boolean isUpdated = userBO.updateUser(newUserDTO);
        if (isUpdated){
            Image image = new Image("/Assets/icons/iconsOk.png");
            try {
                Notifications notifications = Notifications.create();
                notifications.graphic(new ImageView(image));
                notifications.text("User update complete");
                notifications.title("success");
                notifications.hideAfter(Duration.seconds(5));
                notifications.position(Pos.TOP_RIGHT);
                notifications.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
            ((Stage) root.getScene().getWindow()).close();
        }
    }
}
