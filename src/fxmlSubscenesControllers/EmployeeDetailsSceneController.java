package fxmlSubscenesControllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.svg.SVGGlyph;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.paint.Color;
import pojo.Employee;

public class EmployeeDetailsSceneController implements Initializable {

	@FXML
	private JFXButton btnBack;

	@FXML
	private Label lblEmpID;

	@FXML
	private Label lblEmpName;

	@FXML
	private Label lblLastPayAmount;

	@FXML
	private Label lblPaymentDate;

	@FXML
	private TableView<?> tableEmpTransactions;

	private Employee emp;

	@FXML
	void btnBackToEmployees(ActionEvent event) {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		SVGGlyph back = new SVGGlyph(0, "BACK",
				"M341.31,74.135c-0.078-4.985-2.163-9.911-5.688-13.438l-55-55C277.023,2.096,271.963,0,266.872,0s-10.151,2.096-13.75,5.697L69.841,188.978c-3.601,3.599-5.697,8.659-5.697,13.75s2.096,10.151,5.697,13.75l183.281,183.281c3.599,3.601,8.659,5.697,13.75,5.697s10.151-2.096,13.75-5.697l55-55c3.591-3.598,5.681-8.651,5.681-13.734s-2.09-10.136-5.681-13.734L221.06,202.728L335.622,88.166C339.287,84.499,341.387,79.318,341.31,74.135L341.31,74.135z",
				Color.WHITE);

		back.setSize(12, 12);
		btnBack.setGraphic(back);

		emp = new Employee("EMP12001", "Jamal Khan", 1200.00, new Date());

		setEmployeeDetails();
	}

	public void setEmployeeDetails() {
		lblEmpID.setText(emp.getEmployeeId());
		lblEmpName.setText(emp.getEmployeeName());
		lblLastPayAmount.setText(Double.toString(emp.getLastPaymentAmount()));
		lblPaymentDate.setText(String.valueOf(emp.getLastPaymentDate()));
	}
	
	
	/*for table columns, we need pojo for displaying transaction data for employee with employee id
	So not writing the code here
	Here is the sample code:
	
	public void loadTableEmpTransactions() {
		TableColumn<Transaction, Date> transactionDateColumn = new TableColumn<>("Date");
		transactionDateColumn.prefWidthProperty().bind(tableEmpTransactions.widthProperty().divide(5));
		transactionDateColumn.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));//here is the attribute name from the transaction pojo

	
	
	*/
	

}
