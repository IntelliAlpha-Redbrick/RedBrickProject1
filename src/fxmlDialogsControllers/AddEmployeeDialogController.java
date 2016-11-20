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

public class AddEmployeeDialogController extends DefaultDateClass implements Initializable{


    @FXML
    private JFXTextField txtEmployeeName;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextArea txtAddress;

    @FXML
    private JFXTextField txtLocation;

    @FXML
    private JFXDatePicker dateEmployeeDate;

    @FXML
    private JFXComboBox<Label> comboEmployeeType;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXButton btnClear;

    @FXML
    private JFXTextField txtSupervisor;

    @FXML
    private JFXButton btnClose;
    
    @FXML
    void btnClearEvent(ActionEvent event) {

    }

    @FXML
    void btnCloseEvent(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void btnSaveEvent(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comboEmployeeType.getItems().add(new Label("Employee Type 1"));
		comboEmployeeType.getItems().add(new Label("Employee Type 2"));
		comboEmployeeType.getItems().add(new Label("Employee Type 3"));
		comboEmployeeType.getItems().add(new Label("Employee Type 4"));
		comboEmployeeType.getItems().add(new Label("Employee Type 5"));	
		
		dateEmployeeDate.setValue(NOW_LOCAL_DATE());
		
		SVGGlyph close = new SVGGlyph(0, "CLOSE",
				"M810 274l-238 238 238 238-60 60-238-238-238 238-60-60 238-238-238-238 60-60 238 238 238-238z",
				Color.WHITE);
		close.setSize(12, 12);
		btnClose.setCursor(Cursor.HAND);

		btnClose.setGraphic(close);
		
	}

}
