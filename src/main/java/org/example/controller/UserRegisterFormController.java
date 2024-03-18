package org.example.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.example.bo.BOFactory;
import org.example.bo.custom.BooksBO;
import org.example.bo.custom.UserBO;
import org.example.dto.BooksDTO;
import org.example.dto.UserDTO;

import java.io.IOException;
import java.util.regex.Pattern;

public class UserRegisterFormController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXPasswordField txtPasswordReEnter;

    @FXML
    private JFXTextField txtUsername;

    private UserBO userBO= (UserBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);


    @FXML
    void btnSignupOnAction(ActionEvent event) {
        String userName = txtUsername.getText();
        String email = txtEmail.getText();
        String password = txtPassword.getText();
        String password2 = txtPasswordReEnter.getText();

        if(userName.isEmpty() || email.isEmpty() || password.isEmpty() || password2.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Fill all fields");
            BoxBlur blur = new BoxBlur(3, 3, 1);
            root.setEffect(blur);
            alert.showAndWait();
            root.setEffect(null);
            return;
        }

        if (validate()) {
            String userId = splitUserId(userBO.getLastUserId());

            boolean b = userBO.addUser(new UserDTO(userId, txtUsername.getText(), txtEmail.getText(), txtPasswordReEnter.getText()));
            if (b) {
                Image image = new Image("/Assets/icons/iconsOk.png");
                try {
                    Notifications notifications = Notifications.create();
                    notifications.graphic(new ImageView(image));
                    notifications.text("User register complete");
                    notifications.title("success");
                    notifications.hideAfter(Duration.seconds(5));
                    notifications.position(Pos.TOP_RIGHT);
                    notifications.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    void lblAdminLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/AdminLoginForm.fxml");
    }

    @FXML
    void lblLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserLoginForm.fxml");
    }

    @FXML
    void lblReaderLoginOnAction(MouseEvent event) throws IOException {
        setUI(root,"/view/UserLoginForm.fxml");
    }

    public void setUI (AnchorPane pane, String location) throws IOException {
        pane.getChildren().clear();
        pane.getChildren().add(FXMLLoader.load(getClass().getResource(location)));
    }


    private static String splitUserId(String currentUserId) {
        if(currentUserId != null) {
            String[] split = currentUserId.split("U0");

            int id = Integer.parseInt(split[1]);
            id++;
            if(id < 10) {
                return "U00" + id;
            } else if (id < 100) {
                return "U0" + id;
            } else {
                return "u" + id;
            }
        } else {
            return "U001";
        }
    }

    private boolean validate(){

        boolean matches1 = Pattern.matches("^([ \\u00c0-\\u01ffa-zA-Z'\\-]{2,})+$", txtUsername.getText());
        if(!matches1){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Invalid user name");
            alert.showAndWait();
            return false;
        }

        boolean matches4 = Pattern.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", txtEmail.getText());
        if (!matches4) {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Invalid email");
            alert.showAndWait();
            return false;
        }

        if (!txtPassword.getText().equals(txtPasswordReEnter.getText())){
            Alert alert = new Alert(Alert.AlertType.ERROR,"Password does not match");
            alert.showAndWait();
            return false;
        }
        return true;
    }

}
