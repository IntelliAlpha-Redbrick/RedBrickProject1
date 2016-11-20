package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import pojo.Sales;

public class SalesPaneController implements Initializable {

	@FXML
	private TableView<Sales> tableSalesOrders;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loadTableSalesOrders();
	}

	@SuppressWarnings("unchecked")
	public void loadTableSalesOrders() {

		//Columns: Order ID, Name, Contact, Amount Paid, Pending Amount, Details
		
		TableColumn<Sales, String> orderIdColumn = new TableColumn<>("Order ID");
		orderIdColumn.prefWidthProperty().bind(tableSalesOrders.widthProperty().multiply(0.15));
		orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("salesOrderId"));

		TableColumn<Sales, String> customerNameColumn = new TableColumn<>("Name");
		customerNameColumn.prefWidthProperty().bind(tableSalesOrders.widthProperty().multiply(0.25));
		customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

		TableColumn<Sales, String> contactColumn = new TableColumn<>("Contact No.");
		contactColumn.prefWidthProperty().bind(tableSalesOrders.widthProperty().multiply(0.15));
		contactColumn.setCellValueFactory(new PropertyValueFactory<>("customerContact"));

		TableColumn<Sales, String> deliveryStatusColumn = new TableColumn<>("Delivery Status");
		deliveryStatusColumn.prefWidthProperty().bind(tableSalesOrders.widthProperty().multiply(0.1));
		deliveryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryStatus"));

		TableColumn<Sales, Double> totalAmountColumn = new TableColumn<>("Total Amount");
		totalAmountColumn.prefWidthProperty().bind(tableSalesOrders.widthProperty().multiply(0.1));
		totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

		TableColumn<Sales, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(tableSalesOrders.widthProperty().multiply(0.1));
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		TableColumn<Sales, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(tableSalesOrders.widthProperty().multiply(0.1));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		tableSalesOrders.setItems(getSales());
		tableSalesOrders.getColumns().addAll(orderIdColumn, customerNameColumn, contactColumn, deliveryStatusColumn,
				totalAmountColumn, pendingAmountColumn, buttonsColumn);

	}

	public Callback<TableColumn<Sales, String>, TableCell<Sales, String>> addButtons() {
		Callback<TableColumn<Sales, String>, TableCell<Sales, String>> cellFactory = //
				new Callback<TableColumn<Sales, String>, TableCell<Sales, String>>() {
					@Override
					public TableCell<Sales, String> call(final TableColumn<Sales, String> param) {
						final TableCell<Sales, String> cell = new TableCell<Sales, String>() {

							final JFXButton btn = new JFXButton("View Details");
							
							@Override
							public void updateItem(String item, boolean empty) {
								super.updateItem(item, empty);
								if (empty) {
									setGraphic(null);
									setText(null);
								} else {
									btn.getStyleClass().add("detailsButton");
									btn.setOnAction((ActionEvent event) -> {
										Sales sale = getTableView().getItems().get(getIndex());
										System.out.println(sale.getSalesOrderId());
									});
									setGraphic(btn);
									setText(null);
								}
							}
						};
						return cell;
					}
				};

		return cellFactory;
	}

	public ObservableList<Sales> getSales() {

		ObservableList<Sales> salesData = FXCollections.observableArrayList();
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Unpaid", 1000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Delivered", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Unpaid", 1000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Delivered", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Unpaid", 1000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Delivered", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));
		salesData.add(new Sales("AA1234", "Jamal", "9999999999", "Pending", "Paid", 2000.00, 2000.00));

		return salesData;

	}

}
