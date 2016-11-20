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
import pojo.Purchase;

public class PurchasePaneController implements Initializable {

	@FXML
	private TableView<Purchase> tablePurchaseData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadTablePurchaseOrders();
	}

	@SuppressWarnings("unchecked")
	public void loadTablePurchaseOrders() {

		TableColumn<Purchase, String> orderIdColumn = new TableColumn<>("Order ID");
		orderIdColumn.prefWidthProperty().bind(tablePurchaseData.widthProperty().multiply(0.15));
		orderIdColumn.setCellValueFactory(new PropertyValueFactory<>("purchaseOrderId"));

		TableColumn<Purchase, String> sellerNameColumn = new TableColumn<>("Name");
		sellerNameColumn.prefWidthProperty().bind(tablePurchaseData.widthProperty().multiply(0.25));
		sellerNameColumn.setCellValueFactory(new PropertyValueFactory<>("sellerName"));

		TableColumn<Purchase, String> sellerContactColumn = new TableColumn<>("Contact No.");
		sellerContactColumn.prefWidthProperty().bind(tablePurchaseData.widthProperty().multiply(0.15));
		sellerContactColumn.setCellValueFactory(new PropertyValueFactory<>("sellerContact"));

		TableColumn<Purchase, String> deliveryStatusColumn = new TableColumn<>("Delivery Status");
		deliveryStatusColumn.prefWidthProperty().bind(tablePurchaseData.widthProperty().multiply(0.1));
		deliveryStatusColumn.setCellValueFactory(new PropertyValueFactory<>("deliveryStatus"));

		TableColumn<Purchase, Double> totalAmountColumn = new TableColumn<>("Total Amount");
		totalAmountColumn.prefWidthProperty().bind(tablePurchaseData.widthProperty().multiply(0.1));
		totalAmountColumn.setCellValueFactory(new PropertyValueFactory<>("totalAmount"));

		TableColumn<Purchase, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(tablePurchaseData.widthProperty().multiply(0.1));
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		TableColumn<Purchase, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(tablePurchaseData.widthProperty().multiply(0.1));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		tablePurchaseData.setItems(getPurchase());
		tablePurchaseData.getColumns().addAll(orderIdColumn, sellerNameColumn, sellerContactColumn,
				deliveryStatusColumn, totalAmountColumn, pendingAmountColumn, buttonsColumn);

	}

	public Callback<TableColumn<Purchase, String>, TableCell<Purchase, String>> addButtons() {
		Callback<TableColumn<Purchase, String>, TableCell<Purchase, String>> cellFactory = //
				new Callback<TableColumn<Purchase, String>, TableCell<Purchase, String>>() {
					@Override
					public TableCell<Purchase, String> call(final TableColumn<Purchase, String> param) {
						final TableCell<Purchase, String> cell = new TableCell<Purchase, String>() {

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
										Purchase purchase = getTableView().getItems().get(getIndex());
										System.out.println(purchase.getPurchaseOrderId());
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

	public ObservableList<Purchase> getPurchase() {

		ObservableList<Purchase> purchaseData = FXCollections.observableArrayList();
		purchaseData.add(
				new Purchase("AA134", null, "Purchase type 1", 20, "21569870", "Hifzan", "Pending", 2000.00, 1000.00));
		purchaseData.add(
				new Purchase("AA134", null, "Purchase type 1", 20, "21569870", "Hifzan", "Complete", 2000.00, 0.00));
		purchaseData.add(
				new Purchase("AA133", null, "Purchase type 2", 20, "21569870", "Hifzan", "Pending", 2000.00, 1000.00));
		purchaseData.add(
				new Purchase("AA123", null, "Purchase type 1", 20, "21569870", "Hifzan", "Complete", 2000.00, 0.00));
		purchaseData.add(
				new Purchase("AA134", null, "Purchase type 3", 20, "21569870", "Hifzan", "Pending", 2000.00, 1000.00));
		purchaseData.add(
				new Purchase("AA134", null, "Purchase type 1", 20, "21569870", "Hifzan", "Pending", 2000.00, 1000.00));

		return purchaseData;

	}

}
