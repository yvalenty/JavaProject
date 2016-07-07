package com.gamemaschine;

public class MainFrame {
    private int game=0, gamer;
    private double gcharge;
    private int gcounts;
    private String gname, gsurname;
    Gracz Gamer;

    public String getName(){
        return gname;
    }

    public void setName(String n){
        this.gname=n;
    }

    public String getSurname(){
        return gsurname;
    }

    public void setSurname(String n){
        this.gsurname=n;
    }

    public int getGame(){
        return game;
    }

    public void setGame(int n){
        this.game=n;
    }

    public int getGamer(){
        return gamer;
    }

    public void setGamer(int n){
        this.gamer=n;
    }

    public int getRepeats(){
        return gcounts;
    }

    public void setRepeats(int n){
        this.gcounts=n;
    }

    public double getCharge(){
        return gcharge;
    }

    public void setCharge(double n){
        this.gcharge=n;
    }

    public MainFrame(){
        Gamer = null;
    }
}
