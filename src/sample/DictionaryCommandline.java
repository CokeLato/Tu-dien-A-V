package sample;

import java.util.*;

public class DictionaryCommandline {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public DictionaryManagement getDictionaryManagement() {
        return dictionaryManagement;
    }

    public DictionaryCommandline() {
    }

    /**
     * Show all Words of list.
     */
    public void showAllWords() {
        System.out.println("No      | English       | VietNamese");
        for (int i = 0; i < dictionaryManagement.getDictionary().getListWord().size(); i++) {
            System.out.println(i + 1 + "         " + dictionaryManagement.dictionary.getListWord().get(i).getWord_target()
                    + "             " + dictionaryManagement.dictionary.getListWord().get(i).getWord_explain());


        }

    }

    /**
     * Menu chuc nang.
     */
//    public void dictionaryAdvanced() {
//        int choose;
//        Scanner sc = new Scanner(System.in);
//        boolean check = true;
//        System.out.println("1: insertfromfile");
//        System.out.println("2: dictionarylookup");
//        System.out.println("3: Showallwords");
//        System.out.println("4: addline");
//        System.out.println("5: deleteline");
//        System.out.println("6: changeline");
//        System.out.println("7: outfile");
//        System.out.println("8: quicksearch");
//        System.out.println("9: exit");
//        while (check == true) {
//            System.out.print("Lua chon cua ban: ");
//            choose = sc.nextInt();
//
//            switch (choose) {
//
//                case 1:
//                    dictionaryManagement.insertFromFile();
//                    break;
//                case 2:
//                    System.out.println(dictionaryManagement.dictionaryLookup());
//                    break;
//                case 3:
//                    showAllWords();
//                    break;
//                case 4:
//                    dictionaryManagement.addline();
//                    break;
//                case 5:
//                    dictionaryManagement.deleteline();
//                    break;
//                case 6:
//                    dictionaryManagement.changeline();
//                    break;
//                case 7:
//                  //  dictionaryManagement.dictionaryExportToFile();
//                    break;
//                case 8:
//                    dictionarySearcher();
//                    break;
//                case 9:
//                    check = false;
//                    break;
//                default:
//
//
//            }
//        }
//
//    }

    /**
     * Quick search English.
     */
    public void dictionarySearcher(){
        Scanner sc = new Scanner(System.in);
        String search;
        search = sc.nextLine();
        for (int i = 0 ; i<dictionaryManagement.getDictionary().getListWord().size(); i++){
            if
            (getDictionaryManagement().getDictionary().getListWord().get(i).getWord_target().startsWith(search)){
                System.out.println(dictionaryManagement.dictionary.getListWord().get(i).getWord_target());
            }
        }
    }

}
