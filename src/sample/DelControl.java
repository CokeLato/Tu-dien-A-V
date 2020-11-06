package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class DelControl implements Initializable {
    @FXML
    public Button buttonOk;

    @FXML
    public Button buttonCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public TextField word_target;

    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public void buttonOk_click(){
        dictionaryManagement.deleteWord(word_target.getText(), Controller.listWord);
        dictionaryManagement.ExportToFile(Controller.listWord);
        dictionaryManagement.ExportToFile(Controller.listWord);
        word_target.setText("");
        Controller.stage.close();

    }

    public void setButtonCancel_click(){
        Controller.stage.close();

    }
}
