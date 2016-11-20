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

public class AddPurchaseOrderController extends DefaultDateClass implements Initializable {

	@FXML
	private JFXTextField txtContact;

	@FXML
	private JFXTextField txtName;

	@FXML
	private JFXTextField txtQuantity;

	@FXML
	private JFXTextArea txtDescription;

	@FXML
	private JFXTextField txtTotalAmount;

	@FXML
	private JFXTextField txtPaidAmount;

	@FXML
	private JFXDatePicker dateOrderDate;

	@FXML
	private JFXComboBox<Label> comboPurchaseType;

	@FXML
	private JFXButton btnConfirmOrder;
	
    @FXML
    private JFXButton btnClose;

	@FXML
	void btnCloseEvent(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();

	}

	@FXML
	void btnConfirmOrderEvent(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboPurchaseType.getItems().add(new Label("Purchase Type 1"));
		comboPurchaseType.getItems().add(new Label("Purchase Type 2"));
		comboPurchaseType.getItems().add(new Label("Purchase Type 3"));
		comboPurchaseType.getItems().add(new Label("Purchase Type 4"));
		comboPurchaseType.getItems().add(new Label("Purchase Type 5"));

		dateOrderDate.setValue(NOW_LOCAL_DATE());
		
		SVGGlyph close = new SVGGlyph(0, "CLOSE",
				"M810 274l-238 238 238 238-60 60-238-238-238 238-60-60 238-238-238-238 60-60 238 238 238-238z",
				Color.WHITE);
		close.setSize(12, 12);
		btnClose.setCursor(Cursor.HAND);

		btnClose.setGraphic(close);
	}
}
