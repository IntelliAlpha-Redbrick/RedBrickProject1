package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

	Stage mainWindow = new Stage();

	/*static {
        Font.loadFont(App.class.getResource("/resources/fonts/roboto/Roboto-Regular.ttf").toExternalForm(), 10);
    }
*/
	
	@Override
	public void start(Stage primaryStage) {

		mainWindow = primaryStage;

		try {

			// loading main window

			/*
			 * AnchorPane root = (AnchorPane)
			 * FXMLLoader.load(getClass().getResource("MainApp.fxml")); Scene
			 * scene = new Scene(root, 1024,700);
			 * scene.getStylesheets().add(getClass().getResource(
			 * "application.css").toExternalForm());
			 * mainWindow.setMinWidth(1024); mainWindow.setMinHeight(700);
			 */

			// loading login window
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
			AnchorPane decorator = loader.load();
			
			Scene scene = new Scene(decorator);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			decorator.setBackground(null);
			mainWindow.initStyle(StageStyle.TRANSPARENT);

			mainWindow.setScene(scene);
			scene.setFill(null);

			mainWindow.setTitle("RedBrick");
			mainWindow.show();
			LoginController.setCurrentStage(mainWindow);

		} catch (Exception e) {
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("Application Launch Error");
			errorAlert.setHeaderText("Something went wrong");
			errorAlert.setContentText("It seems someting went wrong while starting RedBricks. Please restart the application.");
			errorAlert.show();
			
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
