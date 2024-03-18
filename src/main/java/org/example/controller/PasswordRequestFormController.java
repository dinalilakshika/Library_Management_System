package org.example.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.dto.UserDTO;

import java.io.IOException;

public class PasswordRequestFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtPassword;

    private UserBO userBO= (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        ((Stage) root.getScene().getWindow()).close();
    }

    @FXML
    void btnConfirmOnAction(ActionEvent event) throws IOException {
        if (!isEmptyCheck()) {
            if (checkPassword()) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/PasswordChangeForm.fxml"));
                Parent parent = fxmlLoader.load();
                Scene scene = new Scene(parent);
                Stage stage = (Stage) root.getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid password");
                alert.showAndWait();
                txtPassword.requestFocus();
                txtPassword.setFocusColor(Color.RED);
            }
        }else {
            System.out.println("error");
        }
    }

    private boolean isEmptyCheck() {

        if(txtPassword.getText().isEmpty()){
            txtPassword.requestFocus();
            txtPassword.setFocusColor(Color.RED);
            return true;
        }
        return false;
    }

    public boolean checkPassword(){
        UserDTO userDTO = userBO.searchUser(UserLoginFormController.userId);
        String password = userDTO.getPassword();
        if (txtPassword.getText().equals(password)){
            return true;
        } else {
            return false;
        }
    }
}
