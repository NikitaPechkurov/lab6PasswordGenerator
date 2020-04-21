package sample;

import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Alfavite;
import model.Filter1;
import model.Filter2;

import java.net.URL;
import java.util.*;

public class Controller implements Initializable{
    public TextField loginTextField;
    public TextField urlTextField;
    public ListView listView;
    public Button genButton;
    private String login;
    private String URL;
    private ObservableList<String> strings = FXCollections.observableArrayList();//список для вывода паролей
    private ArrayList<Character> aListCharacter = new ArrayList<Character>();//список для преобразования
    public Alfavite A = new Alfavite();//общий алфавит
    public Filter1 f1;
    public Filter2 f2;

    @Override
    public void initialize(java.net.URL url, ResourceBundle rb){

    }

    public void generate(ActionEvent actionEvent) {
        String string = "";
        login = loginTextField.getText();
        URL = urlTextField.getText();
        //в зависимости от того, цифра или буква стоит первой задаем:
        if (getChar(URL)>='a' && getChar(URL)<='z'){//задаем число смещения на !Порядок в алфавите !Первой буквы URL
            A.setOffsetChar(A.getNumOfCharacter(getChar(URL)));
            A.setOffsetNum(URL.length());//смещение цифр на длину URL
        }
        else if (getChar(URL)>='0' && getChar(URL)<='9'){// если первая буква логина - число
            A.setOffsetNum(A.getNumOfNumber(getChar(URL)));//смещение цифр на порядок первой цифры
            A.setOffsetChar(URL.length());//смещение букв на длину URL
        }
        aListCharacter = toArrayListCharacter(login);//получили ArrayList<char>
        f1 = new Filter1(A);//создали экземпляры фильтров
        f2 = new Filter2(A);
        for (int i=0;i < URL.length();i++){//преобразуем (сделаем смещение) пароля i раз, где i - длина URL
            f1.filter(aListCharacter);//преобразовали 1
            f2.filter(aListCharacter);//преобразовали 2
            for (int y = 0;y < aListCharacter.size();y++){
                string += aListCharacter.get(y);//записали в строку преобразованный ArrayList<char>
            }
            strings.add(string);//добавили в список вывода
            string="";
        }
        //loginTextField.setText(string);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        listView.setItems(strings);//список добавили в ListView
    }

    public ArrayList<Character> toArrayListCharacter(String s){//преобразовать строку в ArrayList<Character>
        ArrayList<Character> litsList = new ArrayList();
        char[] lits = s.toCharArray();
        for (int i=0;i < lits.length;i++){
            litsList.add(lits[i]);
        }
        return litsList;
    }

    public char getChar(String string){//метод получаения первой буквы из строки
        char[] a = string.toCharArray();
        return a[0];
    }
}
