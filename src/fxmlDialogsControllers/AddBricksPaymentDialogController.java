package fxmlDialogsControllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.svg.SVGGlyph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class AddBricksPaymentDialogController extends DefaultDateClass implements Initializable {

    @FXML
    private AnchorPane root;


    @FXML
    private JFXTabPane tabpaneBricksPayment;

    @FXML
    private Tab tabAddBricks;

    @FXML
    private JFXTextField txtEmployeeNameBrick;

    @FXML
    private JFXTextField txtNumOfBricks;

    @FXML
    private JFXDatePicker dateBricksDate;

    @FXML
    private JFXButton btnAddBricks;

    @FXML
    private Tab tabMakePayment;

    @FXML
    private JFXTextField txtEmployeeNamePayment;

    @FXML
    private Label lblPendingAmount;

    @FXML
    private JFXTextField txtAmountPaid;

    @FXML
    private JFXDatePicker datePaymentDate;

    @FXML
    private JFXButton btnAddPayment;
    
    @FXML
    private JFXButton btnClose;

    @FXML
    void btnAddBricksEvent(ActionEvent event) {

    }

    @FXML
    void btnAddPaymentEvent(ActionEvent event) {

    }

    @FXML
    void btnCloseEvent(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide();

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		dateBricksDate.setValue(NOW_LOCAL_DATE());
		datePaymentDate.setValue(NOW_LOCAL_DATE());
		
		SVGGlyph close = new SVGGlyph(0, "CLOSE",
				"M810 274l-238 238 238 238-60 60-238-238-238 238-60-60 238-238-238-238 60-60 238 238 238-238z",
				Color.WHITE);
		close.setSize(12, 12);
		btnClose.setCursor(Cursor.HAND);

		btnClose.setGraphic(close);
	}
	
	

}
