package com.gamemaschine;

import java.util.Random;

public class Przedszkolak extends Gracz {

    public Przedszkolak (String s, String ss) {
        name = s;
        surname=ss;
        allowedTime=2;
        gcmax=2;
        gcmin=1;
    }
    public void setResultsTable(){
        gcrecords=new int[repeats+1][2];
    }

    public void gameXO(){
        freecell=9;
        moveMaked=false;
        endGame=false;
        selectedWinCombo=10;
    }

    public int rund(int min, int max){
        Random rn = new Random();
        return rn.nextInt((max - min)+1) + min;
    }

    public void compMove() {
        moveMaked = false;
        int wcount = 0;
        int com = 0;
        int randomTry[];
        randomTry = new int[9];
        int flag = 0;
        int len = 0;
        int enemyMayWinFlag;
        //check try not to lose strategy
        if (!moveMaked){
            for (int i = 0; i < 8; i++) {
                enemyMayWinFlag = 0;
                for (int k = 0; k < 3; k++) {
                    if (!moveMaked && gameArea[winCombo[i][k]] == 1) {
                        enemyMayWinFlag++;
                        if (enemyMayWinFlag > 1) {
                            for (int j = 0; j < 3; j++) {
                                if (gameArea[winCombo[i][j]] == 0) {
                                    gameArea[winCombo[i][j]] = 2;
                                    ret=winCombo[i][j];
                                    freecell--;
                                    moveMaked = true;
                                    break;
                                }
                            }
                            break;
                        }
                    }
                }

            }
        }
        //Strategia try to win
        if(!moveMaked){
            while(moveMaked==false){
                if(selectedWinCombo==10) {
                    while (flag == 0) {
                        com = rund(0, 7);
                        for (int k = 0; k < 9; k++) {
                            if (randomTry[k] == com)
                                break;
                            flag = 1;
                            randomTry[len] = com;
                            len++;
                        }
                    }
                    selectedWinCombo=com;
                }
                else
                    com=selectedWinCombo;
                for (int j=0; j<3; j++) {
                    if (gameArea[winCombo[com][j]] == 0 || gameArea[winCombo[com][j]] == 2) {
                        wcount++;
                    }
                }
                if (wcount==3){
                    while(moveMaked==false) {
                        int x = rund(0, 2);
                        gSelect = winCombo[com][x];
                        if(gameArea[gSelect] !=2 && gameArea[gSelect]!=1) {
                            gameArea[gSelect] = 2;
                            ret=gSelect;
                            freecell--;
                            moveMaked = true;
                        }
                    }
                }
                else
                    selectedWinCombo=10;
                flag=0;
                //Strategia "Remis. Niema o czym mysleć"
                if(len>8 &&  !moveMaked){
                    int flag2=0;
                    while (flag2==0){
                        int x=rund(0,8);
                        if (gameArea[x]==0){
                            gameArea[x]=2;
                            ret=x;
                            flag2=1;
                            moveMaked=true;
                            freecell--;
                        }
                    }
                }
            }
        }
    }



    @Override
    public String getTyp() {
        return ("Przedszkolak");
    }

    @Override
    public String laugh() {
        return("Przedszkolak. Przegrałeś");
    }

    @Override
    public String congratulate() {
        return("Przedszkolak. Wygrałeś");
    }

    public String remis() {
        return ("Przedszkolak. Remis");
    }

    @Override
    public String niewyplata() {
        payment= gcrecords[repeats][1]*payment;
        return("Przeciwnik dostaje: " + payment);
    }

    @Override
    public String wyplata() {
        payment= gcrecords[repeats][0]*payment;
        return("Dostajesz: " + payment);
    }
    
}
