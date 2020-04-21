package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Alfavite {

    private ArrayList<Character> alf;
    private ArrayList<Character> num;
    private int s=0; //смещение char
    private int sn=0;// смещение int

    public Alfavite(){
        alf = new ArrayList<Character>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n'
                ,'o','p','q','r','s','t','u','v','w','x','y','z'));
        num = new ArrayList<Character>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
    }

    public void setOffsetChar(int n){//задать смещение букв
        s = n;
    }

    public void setOffsetNum(int n){//задать смещение цифр
        sn = n;
    }

    public Character changeChar(Character c) {//заменить букву со смещением
        int n = -1;
        for (int i = 0; i < alf.size(); i++) {
            Character t = alf.get(i);
            if (c == t) {
                n = i;
            }
        }
        if (n <= alf.size()-s) {
            return alf.get(n + s -1);
        }
        else {return alf.get(alf.size()-n);}
    }

    public Character changeNum(Character c) {//заменить число со смещением
        int n = -1;
        for (int i = 0; i < num.size(); i++) {
            Character t = num.get(i);
            if (c == t) {
                n = i;
            }
        }
        if (n <= num.size()-sn) {
            return num.get(n + sn -1);
        }
        else {return num.get(num.size()-n);}
    }

    public int getNumOfCharacter(Character charac){//получить номер буквы из алфавита букв
        int nu = -1;
        for (int i=0;i < alf.size();i++){
            if(charac == alf.get(i)){
                nu = i;
            }
            //else {nu = 1;}
        }
        return nu;
    }

    public int getNumOfNumber(Character chara){//получить номер числа из алфавита чисел
        int nu = -1;
        for (int i=0;i < num.size();i++){
            if(chara == num.get(i)){
                nu = i;
            }
            //else {nu = 1;}
        }
        return nu;
    }

    /*public ArrayList<Character> code(String string){
        ArrayList<Character> litsList = new ArrayList();
        char[] lits = string.toCharArray();
        for (int i=0;i < lits.length;i++){
            if (lits[i]>='a' && lits[i]<='z') {
                lits[i] = changeChar(lits[i]);
            }
            else if (lits[i]>='0' && lits[i]<='9'){
                lits[i] = changeNum(lits[i]);
            }
        }
        for (int i=0;i < lits.length;i++){
            litsList.add(lits[i]);
        }
        return litsList;
    }*/
}
