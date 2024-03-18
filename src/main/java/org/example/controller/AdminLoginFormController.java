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
import org.example.bo.custom.AdminBO;
import org.example.bo.custom.UserBO;
import org.example.dto.AdminDTO;
import org.example.dto.UserDTO;

import java.io.IOException;

public class AdminLoginFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextField txtUsername;

    private AdminBO adminBO= (AdminBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.ADMIN);

    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        if (checkCredential()) {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/AdminDashboardForm.fxml"));
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent);
            Stage stage = (Stage) root.getScene().getWindow();
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        }
    }

    @FXML
    void lblReaderLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserLoginForm.fxml");
    }

    public void setUI (AnchorPane pane, String location) throws IOException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(getClass().getResource(location)));
    }

    public boolean checkCredential(){
        AdminDTO adminDTO = adminBO.search(txtUsername.getText());
        if (adminDTO != null) {
            String password = adminDTO.getPassword();
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
            txtUsername.requestFocus();
            txtUsername.setFocusColor(Color.RED);
            return false;
        }
    }

}

