package application;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainAppController implements Initializable {

	/* All Controls */

	@FXML
	private AnchorPane mainWindow;

	@FXML
	private MenuItem menuDataBackup;

	@FXML
	private MenuItem menuPrinterSetup;

	@FXML
	private MenuItem menuLogout;

	@FXML
	private MenuItem menuExit;

	@FXML
	private MenuItem menuExportEmployee;

	@FXML
	private MenuItem menuImportEmoloyee;

	@FXML
	private MenuItem menuHelp;

	@FXML
	private MenuItem menuAbout;

	@FXML
	private AnchorPane paneTitlebar;

	@FXML
	private JFXHamburger burgerSidebar;

	@FXML
	private Label labelHeading;

	@FXML
	private StackPane paneButtonLeft;

	@FXML
	private StackPane paneButttonRight;

	@FXML
	private AnchorPane mainAnchorPane;

	@FXML
	private AnchorPane paneContent;

	@FXML
	private JFXDrawer drawerSidebar;

	@FXML
	private VBox vboxDrawer;

	@FXML
	private JFXButton btnHome;

	@FXML
	private JFXButton btnEmployees;

	@FXML
	private JFXButton btnStock;

	@FXML
	private JFXButton btnSales;

	@FXML
	private JFXButton btnPurchase;

	// Topbar buttons
	private JFXButton btnAddEmployees;
	private JFXButton btnAddBricks;
	private JFXButton btnAddPurchase;
	private JFXButton btnAddSales;
	private JFXButton btnAddStock;

	private static Label tablePlaceHolder;

	// Logged username. this helps in setting preferences and retrieving data
	private static String loggedUser;

	// All methods

	// initialize
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loggedUser = getLoggedUser();
		// Setting homepane on startup
		btnHomeClick(null);
		drawerSidebar.setSidePane(vboxDrawer);
		burgerClickedEvent(null);

		tablePlaceHolder = new Label("No records found.");
		tablePlaceHolder.getStyleClass().add("tablePlaceHolder");
		setTablePlaceHolder(tablePlaceHolder);

		// System.out.println("mainApp:"+loggedUser);

	}

	@FXML
	void burgerClickedEvent(MouseEvent event) {
		if (drawerSidebar.isHidden() || drawerSidebar.isHidding()) {
			drawerSidebar.open();
			AnchorPane.setLeftAnchor(mainAnchorPane, 230.0);

		} else {
			drawerSidebar.close();
			AnchorPane.setLeftAnchor(mainAnchorPane, 0.0);
		}
	}

	// Sidebar Home Button Click Event
	@FXML
	void btnHomeClick(ActionEvent event) {

		try {
			// Adds Active Buttonstyle class to this button
			setActiveStyle(btnHome);

			// Removes Active Buttonstyle class from all other buttons
			removeActiveStyle(btnSales, btnStock, btnPurchase, btnEmployees);

			labelHeading.setText("Viraj Brick Store");

			// this code can be used to set a button with username on clicking
			// of which will show up a popup with logout and other options. but
			// it needs time
			/*
			 * btnUser = new JFXButton(loggedUser); btnUser.setMinWidth(130);
			 * 
			 * JFXPopup popup = new JFXPopup(); popup.setContent(new
			 * JFXButton("Logout"));
			 * popup.setStyle("-fx-background-color:WHITE");
			 * 
			 * popup.setSource(btnUser); btnUser.setOnMouseClicked((e)->
			 * popup.show(PopupVPosition.BOTTOM, PopupHPosition.LEFT));
			 * 
			 * // setting width for buttons btnUser.setMinWidth(130);
			 * 
			 * // adding buttons to the panes
			 * paneButtonLeft.getChildren().clear();
			 * paneButttonRight.getChildren().clear();
			 * paneButttonRight.getChildren().add(btnUser);
			 */

			// Add HomePane to Dashboard
			paneButtonLeft.getChildren().clear();
			paneButttonRight.getChildren().clear();
			switchScene("HomePane.fxml");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Sidebar Employees Button Click Event
	@FXML
	void btnEmployeesClick(ActionEvent event) {

		try {
			// Adds Active Buttonstyle class to this button
			setActiveStyle(btnEmployees);

			// Adds Active Buttonstyle class to this button
			removeActiveStyle(btnSales, btnStock, btnPurchase, btnHome);

			// set heading
			labelHeading.setText("Employees");

			// ADD Employees Button
			btnAddEmployees = new JFXButton("Add Employees");
			btnAddEmployees.getStyleClass().add("redbrickButtons");

			// ADD Bricks button
			btnAddBricks = new JFXButton("Add Bricks");
			btnAddBricks.getStyleClass().add("redbrickButtons");

			// Add Employees Event
			btnAddEmployees.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					openWindowDialog("/fxmlDialogs/AddEmployeeDialog.fxml");
				}
			});

			// Add Bricks Event
			btnAddBricks.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					openWindowDialog("/fxmlDialogs/AddBricksPaymentDialog.fxml");

				}
			});
			// setting width for buttons
			btnAddEmployees.setMinWidth(130);
			btnAddBricks.setMinWidth(130);

			// adding buttons to the panes
			paneButtonLeft.getChildren().clear();
			paneButtonLeft.getChildren().add(btnAddEmployees);
			paneButttonRight.getChildren().clear();
			paneButttonRight.getChildren().add(btnAddBricks);

			// Add HomePane to Dashboard
			switchScene("EmployeesPane.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Sidebar Purchase Button Click Event
	@FXML
	void btnPurchaseClick(ActionEvent event) {
		try {
			// Adds Active Buttonstyle class to this button
			setActiveStyle(btnPurchase);

			// Adds Active Buttonstyle class to this button
			removeActiveStyle(btnSales, btnStock, btnEmployees, btnHome);

			labelHeading.setText("Purchase");

			// ADD Employees Button
			btnAddPurchase = new JFXButton("Add Purchase");
			btnAddPurchase.getStyleClass().add("redbrickButtons");

			// Add Purchase Event
			btnAddPurchase.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					openWindowDialog("/fxmlDialogs/AddPurchaseOrderDialog.fxml");
				}
			});

			// setting width for buttons
			btnAddPurchase.setMinWidth(130);

			// adding buttons to the panes
			paneButtonLeft.getChildren().clear();
			paneButttonRight.getChildren().clear();
			paneButttonRight.getChildren().add(btnAddPurchase);

			// Add HomePane to Dashboard
			switchScene("PurchasePane.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Sidebar Sales Button Click Event
	@FXML
	void btnSalesClick(ActionEvent event) {
		try {
			// Adds Active Buttonstyle class to this button
			setActiveStyle(btnSales);

			// Adds Active Buttonstyle class to this button
			removeActiveStyle(btnStock, btnEmployees, btnHome, btnPurchase);

			labelHeading.setText("Sales");

			btnAddSales = new JFXButton("Add Sales");
			btnAddSales.getStyleClass().add("redbrickButtons");

			// Add Sales Event
			btnAddSales.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					openWindowDialog("/fxmlDialogs/AddSalesOrderDialog.fxml");
				}
			});

			// setting width for buttons
			btnAddSales.setMinWidth(130);

			// adding buttons to the panes
			paneButtonLeft.getChildren().clear();
			paneButttonRight.getChildren().clear();
			paneButttonRight.getChildren().add(btnAddSales);

			// Add HomePane to Dashboard
			switchScene("SalesPane.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Sidebar Stock Button Click Event
	@FXML
	void btnStockClick(ActionEvent event) {
		try {
			// Adds Active Buttonstyle class to this button
			setActiveStyle(btnStock);

			// Adds Active Buttonstyle class to this button
			removeActiveStyle(btnSales, btnPurchase, btnHome, btnEmployees);

			labelHeading.setText("Stock");

			btnAddStock = new JFXButton("Add Stock");
			btnAddStock.getStyleClass().add("redbrickButtons");

			// Add Sales Event
			btnAddStock.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					openWindowDialog("/fxmlDialogs/AddStockDialog.fxml");
				}
			});

			// setting width for buttons
			btnAddStock.setMinWidth(130);

			// adding buttons to the panes
			paneButtonLeft.getChildren().clear();
			paneButttonRight.getChildren().clear();
			paneButttonRight.getChildren().add(btnAddStock);

			// Add HomePane to Dashboard
			switchScene("StockPane.fxml");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void menuAboutAction(ActionEvent event) {
		openWindowDialog("/fxmlDialogs/AboutDialog.fxml");
	}

	@FXML
	void menuExitAction(ActionEvent event) {
		Alert exitAlert = new Alert(AlertType.CONFIRMATION);
		exitAlert.setTitle("Exit Confirmation");
		exitAlert.setHeaderText("Do you really want to exit?");
		exitAlert.setContentText(null);

		Optional<ButtonType> result = exitAlert.showAndWait();
		if (result.get() == ButtonType.OK) {
			Platform.exit();
		} else {
			return;
		}
	}

	public void setActiveStyle(Button button1) {
		if (!(button1.getStyleClass().contains("btnSidebar-clicked")))
			button1.getStyleClass().add("btnSidebar-clicked");
	}

	public void removeActiveStyle(Button button1, Button button2, Button button3, Button button4) {
		Button[] buttonArray = new Button[4];

		buttonArray[0] = button1;
		buttonArray[1] = button2;
		buttonArray[2] = button3;
		buttonArray[3] = button4;

		for (int i = 0; i < buttonArray.length; i++) {
			if (buttonArray[i].getStyleClass().contains("btnSidebar-clicked")) {
				buttonArray[i].getStyleClass().remove("btnSidebar-clicked");
			}
		}
	}

	public void switchScene(String FXMLFile) {
		try {

			mainAnchorPane.getChildren().clear();

			FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLFile));
			paneContent = (AnchorPane) loader.load();

			mainAnchorPane.getChildren().add(paneContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openWindowDialog(String FXMLFile) {

		try {
			Stage window = new Stage();
			window.initModality(Modality.APPLICATION_MODAL);
			window.setResizable(false);
			/*
			 * below line of code remove the dialog titlebar and borders, but
			 * then will need to add close button in ech dialogs.
			 * 
			 */

			if (FXMLFile.contains("AboutDialog.fxml")) {
				window.initStyle(StageStyle.DECORATED);

			} else {
				window.initStyle(StageStyle.TRANSPARENT);
			}

			FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLFile));
			AnchorPane anchorpane = (AnchorPane) loader.load();

			Scene scene = new Scene(anchorpane);

			window.setScene(scene);
			window.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Label getTablePlaceHolder() {
		return tablePlaceHolder;
	}

	public static void setTablePlaceHolder(Label tablePlaceHolder) {
		MainAppController.tablePlaceHolder = tablePlaceHolder;
	}

	/**
	 * @return the loggedUser
	 */
	public static String getLoggedUser() {
		return loggedUser;
	}

	/**
	 * @param loggedUser
	 *            the loggedUser to set
	 */
	public static void setLoggedUser(String loggedUser) {
		MainAppController.loggedUser = loggedUser;
	}

}
