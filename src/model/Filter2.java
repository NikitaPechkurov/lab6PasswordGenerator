package model;

import java.util.ArrayList;

public class Filter2 extends Filter{

    public Filter2(Alfavite A){
        alfavite = A;
    }

    @Override
    public ArrayList<Character> filter(ArrayList<Character> a){
        for (int i=0;i < a.size();i++){
            if (a.get(i)>='a' && a.get(i)<='z') {
                a.set(i,alfavite.changeChar(a.get(i)));
            }
            else if (a.get(i)>='0' && a.get(i)<='9'){
                a.set(i,alfavite.changeNum(a.get(i)));
            }
        }
        return a;
    }
}
