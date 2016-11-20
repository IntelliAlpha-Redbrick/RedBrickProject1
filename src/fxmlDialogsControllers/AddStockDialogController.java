package fxmlDialogsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.svg.SVGGlyph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class AddStockDialogController extends DefaultDateClass implements Initializable{


    @FXML
    private JFXTextField txtQuantity;

    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXDatePicker dateStockDate;

    @FXML
    private JFXComboBox<Label	> comboBrickType;

    @FXML
    private JFXButton btnAddStock;
    
    @FXML
    private JFXButton btnClose;

    @FXML
    void btnAddStockEvent(ActionEvent event) {

    }

    @FXML
    void btnCloseEvent(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboBrickType.getItems().add(new Label("Brick Type 1"));
		comboBrickType.getItems().add(new Label("Brick Type 2"));
		comboBrickType.getItems().add(new Label("Brick Type 3"));
		comboBrickType.getItems().add(new Label("Brick Type 4"));
		comboBrickType.getItems().add(new Label("Brick Type 5"));
		
		dateStockDate.setValue(NOW_LOCAL_DATE());
		
		SVGGlyph close = new SVGGlyph(0, "CLOSE",
				"M810 274l-238 238 238 238-60 60-238-238-238 238-60-60 238-238-238-238 60-60 238 238 238-238z",
				Color.WHITE);
		close.setSize(12, 12);
		btnClose.setCursor(Cursor.HAND);

		btnClose.setGraphic(close);
		
		
	}

}
