package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public TextField word_target;

    @FXML
    public Button buttonSearch;

    @FXML
    public ListView listView;

    @FXML
    public TextArea word_explain;

    @FXML
    public Button addWord;

    @FXML
    public Button deleteWord;

    @FXML
    public Button changeWord;

    @FXML
    public Button Audio;


    AddController addController;

    public static List<Word> listWord = new ArrayList<>();

    List<Word> wordSearch = new ArrayList<>();
    Word newWord = new Word();
    static Stage stage = new Stage();
    DictionaryManagement dictionaryManagement = new DictionaryManagement();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listWord = dictionaryManagement.loadFromFile();
    }

    public void buttonSearch_click() {
        wordSearch = dictionaryManagement.searchWord(word_target.getText(), listWord);
        listView.getItems().clear();
        for (int i = 0; i < wordSearch.size(); i++) {
            listView.getItems().add(wordSearch.get(i).getWord_target());
        }
    }

    public void listView_click() {
        try {
            String text = wordSearch.get(listView.getSelectionModel().getSelectedIndex()).getWord_explain();
            word_explain.setText(dictionaryManagement.getString(text));
            word_target.setText(wordSearch.get(listView.getSelectionModel().getSelectedIndex()).getWord_target());
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }

    @FXML
    public void buttonAdd_click() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("AddControl.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }


    public void buttondelete_click() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("DelControl.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * botton sua nghia cua tu.
     */
    public void buttonchange_click() {
        dictionaryManagement.deleteWord(word_target.getText(), listWord);
        newWord = dictionaryManagement.addWord(word_target.getText(),word_explain.getText());
        listWord.add(newWord);
        dictionaryManagement.ExportToFile(listWord);


    }

    public void autoSearch() {
        wordSearch = dictionaryManagement.searchWord(word_target.getText(), listWord);
        listView.getItems().clear();
        for (int i = 0; i < wordSearch.size(); i++) {
            listView.getItems().add(wordSearch.get(i).getWord_target());
        }

        if (listWord.size() > 0 ) {
            word_explain.setText(dictionaryManagement.getString(" "));
        }
    }



}
