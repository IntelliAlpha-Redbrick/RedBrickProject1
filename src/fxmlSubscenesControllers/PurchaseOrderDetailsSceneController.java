package fxmlSubscenesControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PurchaseOrderDetailsSceneController {

	@FXML
	private JFXButton btnBack;

	@FXML
	private Label lblOrderID;

	@FXML
	private Label lblOrderDate;

	@FXML
	private Label lblPurchaseType;

	@FXML
	private Label lblQuantity;

	@FXML
	private Label lblAmountPaid;

	@FXML
	private Label lblPendingAmount;

	@FXML
	private Label lblOrderStatus;

	@FXML
	private Label lblSellerName;

	@FXML
	private Label lblContactNo;

	@FXML
	private JFXTextField txtAmount;

	@FXML
	private JFXButton btnUpdateOrder;

	@FXML
	void btnBackToPurchase(ActionEvent event) {

	}

	@FXML
	void btnUpdateOrderClick(ActionEvent event) {

	}

}
