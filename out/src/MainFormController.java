import com.joshua.entity.Barang;
import com.joshua.entity.Category;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {

    public ComboBox<Category> combobox;
    public Button btnSave;
    public Button btnReset;
    public Button btnUpdate;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrice;
    @FXML
    private TextField txtCat;
    @FXML
    private ObservableList<Barang> item;
    @FXML
    private TableColumn<Barang, String> col01;
    @FXML
    private TableColumn<Barang, String> col02;
    @FXML
    private TableColumn<Barang, String> col03;
    @FXML
    private TableView<Barang> tableDepartment;
    @FXML
    private ObservableList<Category> Categories;
    int hitung;

    @FXML
    public void savecatAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if(txtCat.getText().isEmpty()){
            alert.setTitle("Error");
            alert.setContentText("Please fill category name");
            alert.show();
        }
        else{
            Category c = new Category();
            c.setCatName(txtCat.getText());
            hitung=(int) Categories.stream().filter(p ->p.getCatName().equalsIgnoreCase(txtCat.getText())).count();
            if(hitung>0){
                alert.setTitle("Error");
                alert.setContentText("Duplicate category name");
                alert.show();
            }
            else {
                Categories.add(c);
                txtCat.clear();
            }
        }

    }

    public void saveAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty() || combobox.getValue() == null) {
            alert.setTitle("Error");
            alert.setContentText("Please fill category/name/price");
            alert.show();
        } else {
            Barang b = new Barang();
            b.setNama(txtName.getText());
            hitung = (int) item.stream().filter(p -> p.getNama().equalsIgnoreCase(txtName.getText())).count();
            if (hitung > 0) {
                alert.setTitle("Error");
                alert.setContentText("Duplicate item name");
                alert.show();
            } else {
                b.setNama(txtName.getText().trim());
                b.setHarga((txtPrice.getText().trim()));
                b.setCategory((combobox.getValue()));
                item.add(b);
            }


        }
    }

    public void updateAction(ActionEvent actionEvent) {
        Barang b = tableDepartment.getSelectionModel().getSelectedItem();
        b.setNama(txtName.getText());
        b.setHarga(txtPrice.getText());
        b.setCategory((combobox.getValue()));
        tableDepartment.refresh();
        btnSave.setDisable(false);
        btnReset.setDisable(true);

    }

    public void resetAction(ActionEvent actionEvent) {
        txtName.setText("");
        txtPrice.setText("");
        txtCat.setText("");
        combobox.setValue(null);
        btnUpdate.setDisable(true);
        btnSave.setDisable(false);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        item = FXCollections.observableArrayList();
        tableDepartment.setItems(item);
        Categories = FXCollections.observableArrayList();
        combobox.setItems(Categories);
        col01.setCellValueFactory(data -> {
            Barang b = data.getValue();
            return new SimpleStringProperty(b.getNama());
        });
        col02.setCellValueFactory(data ->{
            Barang b = data.getValue();
            return new SimpleStringProperty(b.getHarga());
        });
        col03.setCellValueFactory(data ->{
            Barang b = data.getValue();
            return new SimpleStringProperty(b.getCategory().getCatName());
        });

    }

    public void tableClicked(MouseEvent mouseEvent) {
        Barang b =tableDepartment.getSelectionModel().getSelectedItem();
        txtName.setText(b.getNama());
        b.setHarga(txtPrice.getText());
        b.setCategory((combobox.getValue()));
        btnUpdate.setDisable(false);
        btnSave.setDisable(true);
    }
}
