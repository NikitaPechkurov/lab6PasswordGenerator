package model;

import java.util.ArrayList;

public abstract class Filter {
    protected Alfavite alfavite;

    public Filter(){
        alfavite = new Alfavite();
    }

    public abstract ArrayList<Character> filter(ArrayList<Character> a);
}
