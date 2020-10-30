package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.assets.User;

public class SignUpController {

  @FXML
  private ResourceBundle resources;

  @FXML
  private URL location;

  @FXML
  private TextField login_field;

  @FXML
  private PasswordField password_field;

  @FXML
  private Button SignUpButton;

  @FXML
  private TextField SignUpSurname;

  @FXML
  private TextField SignUpName;

  @FXML
  private CheckBox SignUpMan;

  @FXML
  private CheckBox SignUpWoman;

  @FXML
  void initialize() {
    SignUpButton.setOnAction(event ->{

      SignUpNewUser();
    } );

  }
  private void SignUpNewUser()
  {
    DataBaseHandler dbHandler = new DataBaseHandler();

    String firstname = SignUpName.getText();
    String lastname = SignUpSurname.getText();
    String username = login_field.getText();
    String password = password_field.getText();
    String gender = "";
    if(SignUpMan.isSelected())
      gender = "Man";
    else
      gender = "Woman";

User user = new User ( firstname, lastname, username,password,gender);

    dbHandler.signUpUser(user);

  }
}

