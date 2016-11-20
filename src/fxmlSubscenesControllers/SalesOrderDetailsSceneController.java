package fxmlSubscenesControllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class SalesOrderDetailsSceneController {

    @FXML
    private JFXButton btnBack;

    @FXML
    private Label lblOrderID;

    @FXML
    private Label lblOrderDate;

    @FXML
    private Label lblSaleType;

    @FXML
    private Label lblQuantity;

    @FXML
    private Label lblAmountPaid;

    @FXML
    private Label lblPendingAmount;

    @FXML
    private Label lblOrderStatus;

    @FXML
    private Label lblCustomerName;

    @FXML
    private Label lblDeliveryDetails;

    @FXML
    private Label lblRate;

    @FXML
    private Label lblAdjustedAmount;

    @FXML
    private JFXTextField txtAmount;

    @FXML
    private JFXButton btnUpdateOrder;

    @FXML
    void btnBackToSales(ActionEvent event) {

    }

    @FXML
    void btnUpdateOrderClick(ActionEvent event) {

    }

}
