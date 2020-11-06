package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Node;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    public Button buttonOk;

    @FXML
    public Button buttonCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @FXML
    public TextField word_target;

    @FXML
    public TextField word_explain;

    DictionaryManagement dictionaryManagement = new DictionaryManagement();




    Word newWord = new Word();



    public void buttonOk_click(){
        newWord = dictionaryManagement.addWord(word_target.getText(),word_explain.getText());
        Controller.listWord.add(newWord);
        dictionaryManagement.ExportToFile(Controller.listWord);
        word_target.setText("");
        word_explain.setText("");
        Controller.stage.close();

    }

    public void setButtonCancel_click(){
        Controller.stage.close();

    }
}
