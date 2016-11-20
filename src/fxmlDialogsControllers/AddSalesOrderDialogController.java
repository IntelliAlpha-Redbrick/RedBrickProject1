package fxmlDialogsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.svg.SVGGlyph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class AddSalesOrderDialogController extends DefaultDateClass implements Initializable {

	@FXML
	private JFXDatePicker dateOrderDate;

	@FXML
	private JFXComboBox<Label> comboTypeOfOrder;

	@FXML
	private JFXTextField txtQuantity;

	@FXML
	private JFXTextField txtRate;

	@FXML
	private JFXTextField txtAdjustedAmount;

	@FXML
	private JFXTextArea txtDeliveryDetails;

	@FXML
	private JFXTextField txtTotalAmount;

	@FXML
	private JFXTextField txtPaidAmount;

	@FXML
	private JFXButton btnConfirmOrder;

	@FXML
	private JFXButton btnClose;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboTypeOfOrder.getItems().add(new Label("Order Type 1"));
		comboTypeOfOrder.getItems().add(new Label("Order Type 2"));
		comboTypeOfOrder.getItems().add(new Label("Order Type 3"));
		comboTypeOfOrder.getItems().add(new Label("Order Type 4"));
		comboTypeOfOrder.getItems().add(new Label("Order Type 5"));

		dateOrderDate.setValue(NOW_LOCAL_DATE());
		
		SVGGlyph close = new SVGGlyph(0, "CLOSE",
				"M810 274l-238 238 238 238-60 60-238-238-238 238-60-60 238-238-238-238 60-60 238 238 238-238z",
				Color.WHITE);
		close.setSize(12, 12);
		btnClose.setCursor(Cursor.HAND);

		btnClose.setGraphic(close);

	}

	@FXML
	void btnCloseEvent(ActionEvent event) {
		((Node) (event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void btnConfirmOrderEvent(ActionEvent event) {

	}

}
