package application;

import java.net.URL;
import java.util.Date;
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
import pojo.Stock;

public class StockPaneController implements Initializable {

	@FXML
	private TableView<Stock> tableStockFinished;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loadTableStockFinished();

	}

	@SuppressWarnings("unchecked")
	public void loadTableStockFinished() {

		TableColumn<Stock, String> stockIdColumn = new TableColumn<>("Stock ID");
		stockIdColumn.prefWidthProperty().bind(tableStockFinished.widthProperty().multiply(0.15));//this is to give column width 20%
		stockIdColumn.setCellValueFactory(new PropertyValueFactory<>("stockId"));

		TableColumn<Stock, String> brickTypeColumn = new TableColumn<>("Brick Type");
		brickTypeColumn.prefWidthProperty().bind(tableStockFinished.widthProperty().multiply(0.15));
		brickTypeColumn.setCellValueFactory(new PropertyValueFactory<>("brickType"));

		TableColumn<Stock, Date> stockDateColumn = new TableColumn<>("Date");
		stockDateColumn.prefWidthProperty().bind(tableStockFinished.widthProperty().multiply(0.2));
		stockDateColumn.setCellValueFactory(new PropertyValueFactory<>("stockDate"));

		TableColumn<Stock, Integer> quantityColumn = new TableColumn<>("Quantity");
		quantityColumn.prefWidthProperty().bind(tableStockFinished.widthProperty().multiply(0.15));//this is to give column width 15%
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

		TableColumn<Stock, Integer> inStockColumn = new TableColumn<>("In Stock");
		inStockColumn.prefWidthProperty().bind(tableStockFinished.widthProperty().multiply(0.15));
		inStockColumn.setCellValueFactory(new PropertyValueFactory<>("inStock"));

		TableColumn<Stock, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(tableStockFinished.widthProperty().multiply(0.15));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());
		
		tableStockFinished.setItems(getStock());
		tableStockFinished.getColumns().addAll(stockIdColumn, brickTypeColumn, stockDateColumn, quantityColumn, inStockColumn, buttonsColumn);

		
	}

	public Callback<TableColumn<Stock, String>, TableCell<Stock, String>> addButtons() {
		Callback<TableColumn<Stock, String>, TableCell<Stock, String>> cellFactory = //
				new Callback<TableColumn<Stock, String>, TableCell<Stock, String>>() {
					@Override
					public TableCell<Stock, String> call(final TableColumn<Stock, String> param) {
						final TableCell<Stock, String> cell = new TableCell<Stock, String>() {

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
										Stock stock= getTableView().getItems().get(getIndex());
										System.out.println(stock.getStockId());
										
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
	
	public ObservableList<Stock> getStock() {
		ObservableList<Stock> stockData = FXCollections.observableArrayList();

		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 5, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("13", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 13333, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("43", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("sd", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 789, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("6", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("34", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("87", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("454", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("456", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 54587, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));
		stockData.add(new Stock("AABBCC", "Brick Type1", 10, 5, null));

		return stockData;
	}
	
	

}
