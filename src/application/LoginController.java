package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.svg.SVGGlyph;
import com.jfoenix.validation.RequiredFieldValidator;

import de.jensd.fx.fontawesome.AwesomeIcon;
import de.jensd.fx.fontawesome.Icon;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private JFXButton btnExit;

	@FXML
	private JFXButton btnLogin;

	@FXML
	private JFXTextField txtUsername;

	@FXML
	private JFXPasswordField txtPassword;

	@FXML
	private Label lblStatusMessage;

	@FXML
	private AnchorPane paneRoot;

	private static Stage currentStage;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		lblStatusMessage.setText(null);
		btnLogin.setCursor(Cursor.HAND);
		SVGGlyph close = new SVGGlyph(0, "CLOSE",
				"M810 274l-238 238 238 238-60 60-238-238-238 238-60-60 238-238-238-238 60-60 238 238 238-238z",
				Color.WHITE);
		close.setSize(12, 12);
		btnExit.setCursor(Cursor.HAND);

		btnExit.setGraphic(close);

		// exit application on clicking on close button
		btnExit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});

		/*
		 * this code helps in disabling the login button when username and
		 * password fields are empty. once both the fields are filled, login
		 * buton is enabled
		 */
		btnLogin.disableProperty().bind(Bindings.isEmpty(txtUsername.textProperty()));
		btnLogin.disableProperty().bind(Bindings.isEmpty(txtPassword.textProperty()));

		/*
		 * Field Validator this code adds ReqiredFieldValidator to username and
		 * password fields this will display a messagein the bottom if the
		 * fields are empty
		 */
		usernameValidator();
		passwordValidator();
	}

	public void passwordValidator() {
		RequiredFieldValidator passwordValidator = new RequiredFieldValidator();
		txtPassword.getValidators().add(passwordValidator);
		passwordValidator.setMessage("Password Required");
		passwordValidator.setIcon(new Icon(AwesomeIcon.WARNING, "12", ";", "error"));
		txtPassword.focusedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					txtPassword.validate();
					lblStatusMessage.setText(null);
				}
			}
		});
	}

	public void usernameValidator() {
		RequiredFieldValidator usernameValidator = new RequiredFieldValidator();
		txtUsername.getValidators().add(usernameValidator);
		usernameValidator.setMessage("Username Required");
		usernameValidator.setIcon(new Icon(AwesomeIcon.WARNING, "12", ";", "error"));
		txtUsername.focusedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				if (!newValue) {
					txtUsername.validate();
					lblStatusMessage.setText(null);
				}
			}
		});
	}

	// put your login logic here
	@FXML
	private void executeLogin(ActionEvent event) throws IOException {
		String username = txtUsername.getText();
		String password = txtPassword.getText();

		// place here your logic for login.
		// after login, main application will open and login screen will send
		// user details to main application
		// and main application will retrieve data according to the user details
		// it receive
		// and that user will beable to use it.

		if (username.equals("a") && password.equals("a")) {

			
			//setLoggedUser is static method of MainAppController class
			//It sends current user details to the MainAppController
			//in place of username, pass the data like userid/username which will be required
			//by MainApp to get other data like employee tables etc.
			MainAppController.setLoggedUser(username);
			
			
			// Code to open main application
			// Platform.setImplicitExit(false);
			//Below code should be executed if user logs in successfully.
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("MainApp.fxml"));
			Parent root = loader.load();
			
			//Parent root = FXMLLoader.load(getClass().getResource("MainApp.fxml"));
			Scene scene = new Scene(root);
			Stage appStage = new Stage();
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			appStage.setScene(scene);
			appStage.setMinWidth(1024);
			appStage.setMinHeight(600);
			appStage.show();

			//this code hides the login window
			//getCurrentStage return the login window which is set using setCurrentStage from Main.java
			getCurrentStage().hide();

		} else {
			lblStatusMessage.setText("Login failed. Please enter correct Username and Password");
			
		}
	}

	public static Stage getCurrentStage() {
		return currentStage;
	}

	public static void setCurrentStage(Stage currentStage) {
		LoginController.currentStage = currentStage;
	}
}
