package org.example.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.bo.BOFactory;
import org.example.bo.custom.UserBO;
import org.example.dto.UserDTO;
import org.example.entity.User;

import java.io.IOException;

public class UserLoginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUserName;

    public static String userId;

    private UserBO userBO= (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);

    public void initialize(){
        userId = "U001";
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        if (checkCredential()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/UserDashboardForm.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    void lblAdminLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/AdminLoginForm.fxml");
    }

    @FXML
    void lblRegisterOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserRegisterForm.fxml");
    }

    public void setUI (AnchorPane pane, String location) throws IOException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(getClass().getResource(location)));
    }

    public boolean checkCredential(){
        UserDTO userDTO = userBO.searchByName(txtUserName.getText());
        if (userDTO != null) {
            String password = userDTO.getPassword();
            if (password.equals(txtPassword.getText())) {
                return true;
            } else {
                txtPassword.requestFocus();
                txtPassword.setFocusColor(Color.RED);
                return false;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "User name invalid");
            alert.showAndWait();
            txtUserName.requestFocus();
            txtUserName.setFocusColor(Color.RED);
            return false;
        }
    }
}
