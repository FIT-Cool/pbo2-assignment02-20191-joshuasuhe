import com.joshua.entity.Barang;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private MenuButton menuButton;
    @FXML
    private TextField txtCat;
    @FXML
    private ObservableList<Barang> items;
    @FXML
    private TableColumn<Barang, String> col01;
    @FXML
    private TableColumn<Barang, String> col02;
    @FXML
    private TableColumn<Barang, String> col03;
    @FXML
    private TableView<Barang> tableDepartment;

    @FXML
    private void savecatAction(ActionEvent actionEvent) {
    }

    @FXML
    private void saveAction(ActionEvent actionEvent) {
        Barang b = new Barang();
        b.setNama(txtName.getText().trim());
        b.setHarga(Double.parseDouble(txtPrice.getText().trim()));
        items.add(b);
    }

    @FXML
    private void resetAction(ActionEvent actionEvent) {
    }

    @FXML
    private void updateAction(ActionEvent actionEvent) {
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        items = FXCollections.observableArrayList();
        tableDepartment.setItems(items);
        col01.setCellValueFactory(data -> {
            Barang b = data.getValue();
            return new SimpleStringProperty(b.getNama());
        });
        col02.setCellValueFactory(data -> {
            Barang b = data.getValue();
            return new SimpleStringProperty(b.getHarga());
        });
        col03.setCellValueFactory(data -> {

            Barang b = data.getValue();
            return new SimpleStringProperty(b.getCategory());
        });
    }

    @FXML
    private void tableClicked(MouseEvent mouseEvent) {
        Barang b = tableDepartment.getSelectionModel().getSelectedItem();
        txtName.setText(b.getNama());
        txtPrice.setText(b.getHarga());
    }
}
