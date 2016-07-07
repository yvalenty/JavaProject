package com.gamemaschine;

public class Uczen extends Przedszkolak {
    
    public Uczen(String s, String ss) {
        super(s, ss);
        allowedTime=3;
    }
    
    public void gameKNP(){
        gcrecords =new int[repeats+1][2];
        gcmax=3;
        gcmin=1;
    }

    @Override
    public String getTyp() {
        return ("Uczeń");
    }
    @Override
    public String laugh() {
        return("Uczeń. Przegrałeś");
    }
    @Override
    public String congratulate() {
        return("Uczeń. Wygrałeś");
    }
    @Override
    public String remis() {
        return ("Uczeń. Remis");
    }
}
