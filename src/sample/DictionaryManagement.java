package sample;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;


public class DictionaryManagement {
    Dictionary dictionary = new Dictionary();

    public Dictionary getDictionary() {
        return dictionary;
    }

    int n;


    public DictionaryManagement() {
    }


    /**
     * doc du lieu tu file txt.
     * Chay tai intellj.
     */


    /**
     * Doc du lieu tu file txt.
     * Ham chay cho app.
     *
     * @return file.
     */
    public List<Word> loadFromFile() {
        List<Word> list = new ArrayList<>();
        try {
            Scanner readfile =
                    new Scanner(new FileInputStream("./dictinonaries1.txt"));
            String line;
            while (readfile.hasNextLine()) {
                line = readfile.nextLine();
                String[] text = line.split("\\|");
                list.add(new Word(text[0], text[1]));
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public String getString(String text) {
        String[] arr = text.split("\\-");
        String rs = arr[0];
        for (int i = 1; i < arr.length; i++) {
            rs += "\n-" + arr[i];
        }
        return rs;
    }

    /**
     * ham
     * tach word_target va word_explain ra khoi 1 dong.
     * Ham chay cho intellj.
     *
     * @param line 1 dong trong tu dien
     */

    public void splitWord(String line) {
        StringTokenizer str = new StringTokenizer(line, "      ");
        while (str.hasMoreTokens()) {
            int i = 0;
            String target = str.nextToken();
            String explain = str.nextToken();
            dictionary.word.setWord_target(target);
            dictionary.word.setWord_explain(explain);
            Word word = new Word(target, explain);
            dictionary.addWord(word);
        }

    }

    /**
     * Ham search .
     * Ham chay cho app.
     *
     * @param word_target truyen vao tu can search
     * @param list        truyen vao list de search
     * @return search
     */
    public List<Word> searchWord(String word_target, List<Word> list) {
        List<Word> wordList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWord_target().startsWith(word_target)) {
                wordList.add(list.get(i));
            }
        }
        return wordList;
    }



    /**
     * them 1 tu vao list.
     * chay cho app.
     *
     * @param word_target  tieng anh
     * @param word_explain tieng viet
     * @return list
     */
    public Word addWord(String word_target, String word_explain) {
        // List <Word> list = new ArrayList<>();
        Word word = new Word(word_target, word_explain);
        // list.add(new Word(word_target,word_explain));
        return word;
    }

    /**
     * Xoa 1 tu trong tu dien bang cach nhap word_target.
     */

    public void deleteWord(String word_target, List<Word> list) {
        for (int i = 0; i < list.size(); i++) {
            if (word_target.equals(list.get(i).getWord_target())) {
                list.remove(i);
            }

        }
    }


    /**
     * Sua du lieu trong tu dien.
     */

    public void changeWord(String word_target, String word_explain) {


    }



    /**
     * Ham ghi ra file txt.
     *
     * @param list file doc vao.
     */
    public void ExportToFile(List<Word> list) {
        try {
            String word_target;
            String word_explain;
            FileWriter fw = new FileWriter("./dictinonaries1.txt");
            for (int i = 0; i < list.size(); i++) {
                word_target = list.get(i).getWord_target();
                fw.write(word_target);
                fw.write("|");
                word_explain = list.get(i).getWord_explain();
                fw.write(word_explain);
                fw.write("\n");

            }
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }


}