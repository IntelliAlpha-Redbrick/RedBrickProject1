package application;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import pojo.Employee;

public class EmployeesPaneController implements Initializable {

	@FXML
	private JFXTabPane employeesTabPane;

	@FXML
	private Tab patherTab;

	@FXML
	private Tab dhulaiTab;

	@FXML
	private Tab beldaarTab;

	@FXML
	private Tab firemanTab;

	@FXML
	private Tab nikasiTab;

	@FXML
	private Tab othersTab;

	@FXML
	private TableView<Employee> patherEmployeesTable;

	@FXML
	private TableView<Employee> dhulaiEmployeesTable;

	@FXML
	private TableView<Employee> beldaarEmployeesTable;

	@FXML
	private TableView<Employee> firemanEmployeesTable;

	@FXML
	private TableView<Employee> nikasiEmployeesTable;

	@FXML
	private TableView<Employee> othersEmployeesTable;

	private TableView<Employee> filterTable;

	@FXML
	private JFXTextField txtSearchFilter;
	

	/* Set column for table */
	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setTableName(patherEmployeesTable);

		loadPatherEmployeesTable();

		loadDhulaiEmployeesTable();

		loadBeldaarEmployeesTable();

		loadFiremanEmployeesTable();

		loadNikasiEmployeesTable();

		loadOthersEmployeesTable();

		employeesTabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

			@Override
			public void changed(ObservableValue<? extends Tab> observable, Tab oldTab, Tab newTab) {
				if (newTab == patherTab) {
					setTableName(patherEmployeesTable);
				}
				if (newTab == dhulaiTab) {
					setTableName(dhulaiEmployeesTable);

				}
				if (newTab == beldaarTab) {
					setTableName(beldaarEmployeesTable);

				}
				if (newTab == firemanTab) {
					setTableName(firemanEmployeesTable);

				}
				if (newTab == nikasiTab) {
					setTableName(nikasiEmployeesTable);
				}
				if (newTab == othersTab) {
					setTableName(othersEmployeesTable);
				}
			}
		});
	}

	/*
	 * Observable list: Get data from DB into employeesData object and that
	 * ObservableList object will be passed to the table to be displayed so the
	 * flow is like: DB -> ObservableList -> Table
	 */
	public ObservableList<Employee> getEmployees() {
		ObservableList<Employee> employeesData = FXCollections.observableArrayList();

		/*
		 * TODO:it is very important to set Employees Constructor dynamically //
		 * and put data into it from DB. // There are 3 types of constructors
		 * depending upon the tables. // Check in Employees.java pojo // this
		 * can be achieved if we know which table is calling this method //OR
		 * make sepererate Observable list as per the constructors
		 */

		employeesData.add(new Employee("AA1234", "Jamal", 777, 1000.00));
		employeesData.add(new Employee("AA1234", "Hifzan", 12, 1000.00));
		employeesData.add(new Employee("AA1234", "Saurabh", 25, 1000.00));
		employeesData.add(new Employee("AA1234", "Jamal", 34, 1000.00));
		employeesData.add(new Employee("AA1234", "Hifzan", 777, 1000.00));
		employeesData.add(new Employee("AA1234", "Saurabh", 687, 1000.00));
		employeesData.add(new Employee("AA1234", "Jamal", 98, 1000.00));
		employeesData.add(new Employee("AA1234", "Hifzan", 100, 1000.00));
		employeesData.add(new Employee("AA1234", "Saurabh", 100, 1000.00));
		employeesData.add(new Employee("AA1234", "Jamal", 777, 1000.00));
		employeesData.add(new Employee("AA1234", "Hifzan", 12, 1000.00));
		employeesData.add(new Employee("AA1234", "Saurabh", 25, 1000.00));
		employeesData.add(new Employee("AA1234", "Jamal", 34, 1000.00));
		employeesData.add(new Employee("AA1234", "Hifzan", 777, 1000.00));
		employeesData.add(new Employee("AA1234", "Saurabh", 687, 1000.00));
		employeesData.add(new Employee("AA1234", "Jamal", 98, 1000.00));
		employeesData.add(new Employee("AA1234", "Hifzan", 100, 1000.00));

		return employeesData;
	}

	/*
	 * Pather Tab Employees Table and Filter code Pather Employees Table
	 * contains 4 columns Employee ID, Name, Bricks, Pending Amount
	 *
	 */
	@SuppressWarnings("unchecked")
	public void loadPatherEmployeesTable() {

		TableColumn<Employee, String> empIdColumn = new TableColumn<>("Employee ID");
		empIdColumn.prefWidthProperty().bind(patherEmployeesTable.widthProperty().multiply(0.2));
		empIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

		// Name Column
		TableColumn<Employee, String> empNameColumn = new TableColumn<>("Name");
		empNameColumn.prefWidthProperty().bind(patherEmployeesTable.widthProperty().multiply(0.3));
		empNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

		// Bricks Column
		TableColumn<Employee, Integer> bricksColumn = new TableColumn<>("Bricks");
		bricksColumn.prefWidthProperty().bind(patherEmployeesTable.widthProperty().multiply(0.15));
		bricksColumn.setCellValueFactory(new PropertyValueFactory<>("numOfBricks"));

		// Pending Amount Column
		TableColumn<Employee, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(patherEmployeesTable.widthProperty().multiply(0.15));
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		TableColumn<Employee, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(patherEmployeesTable.widthProperty().multiply(0.15));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		patherEmployeesTable.setItems(getEmployees());
		patherEmployeesTable.getColumns().addAll(empIdColumn, empNameColumn, bricksColumn, pendingAmountColumn,
				buttonsColumn);

		filterEmployeesTableData();
	}

	/*
	 * Dhulai Tab Employees Table and Filter code Pather Employees Table
	 * contains 4 columns Employee ID, Name, Bricks, Pending Amount
	 *
	 */
	@SuppressWarnings("unchecked")
	public void loadDhulaiEmployeesTable() {
		TableColumn<Employee, String> empIdColumn = new TableColumn<>("Employee ID");
		empIdColumn.prefWidthProperty().bind(dhulaiEmployeesTable.widthProperty().multiply(0.2));
		empIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

		// Name Column
		TableColumn<Employee, String> empNameColumn = new TableColumn<>("Name");
		empNameColumn.prefWidthProperty().bind(dhulaiEmployeesTable.widthProperty().multiply(0.3));
		empNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

		// Bricks Column
		TableColumn<Employee, Integer> bricksColumn = new TableColumn<>("Bricks");
		bricksColumn.prefWidthProperty().bind(dhulaiEmployeesTable.widthProperty().multiply(0.15));
		bricksColumn.setCellValueFactory(new PropertyValueFactory<>("numOfBricks"));

		// Pending Amount Column
		TableColumn<Employee, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(dhulaiEmployeesTable.widthProperty().multiply(0.15));
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		TableColumn<Employee, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(dhulaiEmployeesTable.widthProperty().multiply(0.15));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		dhulaiEmployeesTable.setItems(getEmployees());
		dhulaiEmployeesTable.getColumns().addAll(empIdColumn, empNameColumn, bricksColumn, pendingAmountColumn,
				buttonsColumn);

		filterEmployeesTableData();
	}

	/*
	 * Beldaar Tab Employees Table and Filter code Pather Employees Table
	 * contains 4 columns Employee ID, Name, Bricks/ No. of lines, Pending
	 * Amount
	 *
	 */
	@SuppressWarnings("unchecked")
	public void loadBeldaarEmployeesTable() {
		TableColumn<Employee, String> empIdColumn = new TableColumn<>("Employee ID");
		empIdColumn.prefWidthProperty().bind(beldaarEmployeesTable.widthProperty().multiply(0.2));
		empIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

		// Name Column
		TableColumn<Employee, String> empNameColumn = new TableColumn<>("Name");
		empNameColumn.prefWidthProperty().bind(beldaarEmployeesTable.widthProperty().multiply(0.3));
		empNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

		// Bricks Column
		TableColumn<Employee, Integer> bricksColumn = new TableColumn<>("Number of Lines");
		bricksColumn.prefWidthProperty().bind(beldaarEmployeesTable.widthProperty().multiply(0.15));
		bricksColumn.setCellValueFactory(new PropertyValueFactory<>("numOfLines"));

		// Pending Amount Column
		TableColumn<Employee, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(beldaarEmployeesTable.widthProperty().multiply(0.15));
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		TableColumn<Employee, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(beldaarEmployeesTable.widthProperty().multiply(0.15));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		beldaarEmployeesTable.setItems(getEmployees());
		beldaarEmployeesTable.getColumns().addAll(empIdColumn, empNameColumn, bricksColumn, pendingAmountColumn,
				buttonsColumn);

		filterEmployeesTableData();
	}

	/*
	 * Fireman Tab Employees Table and Filter code Pather Employees Table
	 * contains 4 columns Employee ID, Name, No. of lines, Pending Amount
	 *
	 */
	@SuppressWarnings("unchecked")
	public void loadFiremanEmployeesTable() {
		TableColumn<Employee, String> empIdColumn = new TableColumn<>("Employee ID");
		empIdColumn.prefWidthProperty().bind(firemanEmployeesTable.widthProperty().multiply(0.2));
		empIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

		// Name Column
		TableColumn<Employee, String> empNameColumn = new TableColumn<>("Name");
		empNameColumn.prefWidthProperty().bind(firemanEmployeesTable.widthProperty().multiply(0.3));
		empNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

		// Bricks Column
		TableColumn<Employee, Integer> bricksColumn = new TableColumn<>("Number of Lines");
		bricksColumn.prefWidthProperty().bind(firemanEmployeesTable.widthProperty().multiply(0.15));
		bricksColumn.setCellValueFactory(new PropertyValueFactory<>("numOfLines"));

		// Pending Amount Column
		TableColumn<Employee, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(firemanEmployeesTable.widthProperty().multiply(0.15));
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		TableColumn<Employee, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(firemanEmployeesTable.widthProperty().multiply(0.15));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		firemanEmployeesTable.setItems(getEmployees());
		firemanEmployeesTable.getColumns().addAll(empIdColumn, empNameColumn, bricksColumn, pendingAmountColumn,
				buttonsColumn);

		filterEmployeesTableData();
	}

	/*
	 * Nikasi Tab Employees Table contains 4 columns Employee ID, Bricks,
	 * Pending Amount
	 *
	 */
	@SuppressWarnings("unchecked")
	public void loadNikasiEmployeesTable() {
		TableColumn<Employee, String> empIdColumn = new TableColumn<>("Employee ID");
		empIdColumn.prefWidthProperty().bind(nikasiEmployeesTable.widthProperty().multiply(0.2));
		empIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

		// Name Column
		TableColumn<Employee, String> empNameColumn = new TableColumn<>("Name");
		empNameColumn.prefWidthProperty().bind(nikasiEmployeesTable.widthProperty().multiply(0.3));
		empNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

		// Bricks Column
		TableColumn<Employee, Integer> bricksColumn = new TableColumn<>("Bricks");
		bricksColumn.prefWidthProperty().bind(nikasiEmployeesTable.widthProperty().multiply(0.15));
		bricksColumn.setCellValueFactory(new PropertyValueFactory<>("numOfBricks"));

		// Pending Amount Column
		TableColumn<Employee, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(nikasiEmployeesTable.widthProperty().multiply(0.15));
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		TableColumn<Employee, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(nikasiEmployeesTable.widthProperty().multiply(0.15));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		nikasiEmployeesTable.setItems(getEmployees());
		nikasiEmployeesTable.getColumns().addAll(empIdColumn, empNameColumn, bricksColumn, pendingAmountColumn,
				buttonsColumn);

		filterEmployeesTableData();
	}

	/*
	 * Others Tab Employees Table contains 5 columns Employee ID, Name, Salary,
	 * Pending Amount, Payment Date
	 */
	@SuppressWarnings("unchecked")
	public void loadOthersEmployeesTable() {
		TableColumn<Employee, String> empIdColumn = new TableColumn<>("Employee ID");
		empIdColumn.prefWidthProperty().bind(othersEmployeesTable.widthProperty().multiply(0.15));
		empIdColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));

		// Name Column
		TableColumn<Employee, String> empNameColumn = new TableColumn<>("Name");
		empNameColumn.prefWidthProperty().bind(othersEmployeesTable.widthProperty().multiply(0.3));// 0.5
		empNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

		// Salary Column
		TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary");
		salaryColumn.prefWidthProperty().bind(nikasiEmployeesTable.widthProperty().multiply(0.1));// 0.1
		salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

		// Pending Amount Column
		TableColumn<Employee, Double> pendingAmountColumn = new TableColumn<>("Pending Amount");
		pendingAmountColumn.prefWidthProperty().bind(othersEmployeesTable.widthProperty().multiply(0.1));// 0.2
		pendingAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pendingAmount"));

		// Pending Amount Column
		TableColumn<Employee, Date> paymentDateColumn = new TableColumn<>("Payment Amount");
		paymentDateColumn.prefWidthProperty().bind(othersEmployeesTable.widthProperty().multiply(0.15));// 0.2
		paymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("paymentDate"));

		TableColumn<Employee, String> buttonsColumn = new TableColumn<>("");
		buttonsColumn.prefWidthProperty().bind(othersEmployeesTable.widthProperty().multiply(0.15));
		buttonsColumn.setCellValueFactory(new PropertyValueFactory<>("DUMMY"));
		buttonsColumn.setCellFactory(addButtons());

		othersEmployeesTable.setItems(getEmployees());
		othersEmployeesTable.getColumns().addAll(empIdColumn, empNameColumn, salaryColumn, pendingAmountColumn,
				paymentDateColumn, buttonsColumn);

		filterEmployeesTableData();
	}

	/*
	 * Filter search code. here i want to dynamically give table name and
	 * data.so that on searching, it searches only in the current table. for
	 * that we need to add event listener on tabs
	 */
	public void filterEmployeesTableData() {
		txtSearchFilter.textProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(Observable observable) {

				if (txtSearchFilter.textProperty().get().isEmpty()) {
					getTableName().setItems(getEmployees());
					return;
				}
				ObservableList<Employee> filteredItems = FXCollections.observableArrayList();
				ObservableList<TableColumn<Employee, ?>> cols = getTableName().getColumns();

				for (int i = 0; i < getEmployees().size(); i++) {
					for (int j = 0; j < cols.size()-1; j++) {
						TableColumn<Employee, ?> col = cols.get(j);
						String cellValue = col.getCellData(getEmployees().get(i)).toString();
						cellValue = cellValue.toLowerCase();
						if (cellValue.contains(txtSearchFilter.textProperty().get().toLowerCase())) {
							filteredItems.add(getEmployees().get(i));
							break;
						}
					}
				}
				if (filteredItems.isEmpty()) {

					getTableName().setPlaceholder(MainAppController.getTablePlaceHolder());
				}
				getTableName().setItems(filteredItems);
			}
		});
	}

	public TableView<Employee> getTableName() {
		return filterTable;
	}

	public void setTableName(TableView<Employee> table) {
		this.filterTable = table;
	}

	/*function to add buttons to rows (View Details)
	 * This function is used in all the tables for adding View Details button
	 * to every column.
	 * 
	 * It contains the logic to set Detals scene on the window, which contains back button
	 * to return back to the table
	 * 
	 * it calls setScene and passes the id to the next scene.
	 */
	public Callback<TableColumn<Employee, String>, TableCell<Employee, String>> addButtons() {
		Callback<TableColumn<Employee, String>, TableCell<Employee, String>> cellFactory = //
				new Callback<TableColumn<Employee, String>, TableCell<Employee, String>>() {
					@Override
					public TableCell<Employee, String> call(final TableColumn<Employee, String> param) {
						final TableCell<Employee, String> cell = new TableCell<Employee, String>() {

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
										Employee employee = getTableView().getItems().get(getIndex());
										System.out.println(employee.getEmployeeId());
										
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

}
