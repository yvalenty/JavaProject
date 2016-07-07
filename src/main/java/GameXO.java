import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class GameXO {

    //Important!!! Change table start from 0 to 1 in order to avoid fake reactions
    int c1[]={0,1,2};
    int c2[]={3,4,5};
    int c3[]={6,7,8};
    int c4[]={0,3,6};
    int c5[]={1,4,7};
    int c6[]={2,5,8};
    int c7[]={0,4,8};
    int c8[]={2,4,6};
    int winCombo[][] ={c1,c2,c3,c4,c5,c6,c7,c8};
    int gameArea[]={0,0,0,0,0,0,0,0,0};
    int freecell=9;
    int gSelect;
    int cSelect;
    JButton[] buttons = new JButton[9];
    boolean moveMaked=false;
    boolean endGame=false;
    int selectedWinCombo;

    public GameXO(){
        selectedWinCombo=10;
        JFrame frameXO;
        //MainFrame.act_deact(0);
        JPanel mainPanel;
        frameXO = new JFrame("Game Machine");
        frameXO.setLayout(new BoxLayout(frameXO.getContentPane(), BoxLayout.Y_AXIS));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,3));
        frameXO.add(mainPanel);
        frameXO.setSize(300,300);
        frameXO.setResizable(false);
        frameXO.setLocationRelativeTo(null);
        frameXO.setVisible(true);

        for (int i=0; i<9; i++){
            buttons[i] = new JButton(" ");
            buttons[i].addActionListener(bListner);
            mainPanel.add(buttons[i]);
        }
        init();
    }

    public int rund(int min, int max){
        Random rn = new Random();
        return rn.nextInt((max - min)+1) + min;
    }
    buttonList bListner;
    public void init(){
        if(rund(0,1)==1) {
            moveMaked=false;
            compMove();
        }
        for (int i=0; i<9; i++){
            buttons[i].setEnabled(true);
        }
        bListner=new buttonList() {
            public final void actionPerformed(ActionEvent e){
                for (int i = 0; i < 9; i++) {
                    if (e.getSource() == buttons[i]) {
                        if(gameArea[i]==0) {
                            buttons[i].setText("X");
                            gameArea[i]=1;
                            freecell--;
                            check_if_win();
                            if(endGame)
                                break;
                            else {
                                compMove();
                                check_if_win();
                            }
                        }
                    }
                }
            }

        };
        for (int i=0; i<9; i++){
            buttons[i].addActionListener(bListner);
        }
    }

    public void check_if_win(){
        int winCounterGamer;
        int winCounterComp;
        for (int i=0; i<8; i++) {
            winCounterGamer = 0;
            winCounterComp = 0;
            if (!endGame){
                for (int j = 0; j < 3; j++) {
                    if (gameArea[winCombo[i][j]] == 1)
                        winCounterGamer++;
                    if (gameArea[winCombo[i][j]] == 2)
                        winCounterComp++;
                    if (winCounterGamer == 3) {
                        for (int k = 0; k < 9; k++) {
                            buttons[k].setEnabled(false);
                        }
                        endGame = true;
                        JOptionPane.showMessageDialog(null, "Wygrales");
                        break;
                    }
                    if (winCounterComp == 3) {
                        for (int k = 0; k < 9; k++) {
                            buttons[k].setEnabled(false);
                        }
                        endGame = true;
                        JOptionPane.showMessageDialog(null, "Wygral komputer");
                        break;
                    }
                    if (freecell == 0) {
                        for (int k = 0; k < 9; k++) {
                            buttons[k].setEnabled(false);
                        }
                        endGame = true;
                        JOptionPane.showMessageDialog(null, "Remis");
                        break;
                    }
                }
        }
        }
    }


    public void compMove() {
        moveMaked = false;
        int wcount = 0;
        int com = 0;
        int randomTry[];
        randomTry = new int[9];
        int tryN = 0;
        int flag = 0;
        int len = 0;
        int enemyMayWinFlag, compMayWinFlag = 0;
        if (!moveMaked){
            for (int i = 0; i < 8; i++) {
                enemyMayWinFlag = 0;
                for (int k = 0; k < 3; k++) {
                    if (!moveMaked && gameArea[winCombo[i][k]] == 2) {
                        enemyMayWinFlag++;
                        if (enemyMayWinFlag > 1) {
                            for (int j = 0; j < 3; j++) {
                                if (gameArea[winCombo[i][j]] == 0) {
                                    gameArea[winCombo[i][j]] = 2;
                                    buttons[winCombo[i][j]].setText("0");
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
                                    buttons[winCombo[i][j]].setText("0");
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
                            else {
                                flag = 1;
                                randomTry[len] = com;
                                len++;
                            }
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
                            buttons[gSelect].setText("0");
                            freecell--;
                            moveMaked = true;
                        }
                    }
                }
                else
                    selectedWinCombo=10;

                flag=0;
                if(len>8 &&  !moveMaked){
                    int flag2=0;
                    while (flag2==0){
                        int x=rund(0,8);
                        if (gameArea[x]==0){
                            gameArea[x]=2;
                            buttons[x].setText("0");
                            flag2=1;
                            moveMaked=true;
                            freecell--;
                        }
                    }
                }
            }
        }
    }

    /*public boolean check_if_win(boolean endGame){
        int winCounterGamer;
        int winCounterComp;
        for (int i=0; i<8; i++){
            winCounterGamer=0;
            winCounterComp=0;
            for(int j=0;j<3;j++){
                if(gameArea[winCombo[i][j]]==1)
                    winCounterGamer++;
                if(gameArea[winCombo[i][j]]==2)
                    winCounterComp++;
                if(winCounterGamer==3 || winCounterComp==3)
                    return !endGame;
            }
        }
        return endGame;
    }

    public boolean compMove(boolean g){

        moveMaked=false;
        int wcount=0;
        int com=0;
        int randomTry[];
        randomTry= new int[9];
        int tryN=0;
        int flag=0;
        int len=0;
        int selectedWinCombo=10;
        //Select strategy
        int flag3, flagStSelect=0;
        for (int i=0; i<9;i++){
            flag3=0;
            for (int k=0; k<3; k++){
                if(gameArea[winCombo[i][k]]==1)
                    flag3++;
            }
            if(flag3>2)
                //Select try to not lose strategy

                flagStSelect=1;
            break;
        }
        if(flagStSelect==0){
            //Select try to win strategy
            //Strategia try to win
            while(moveMaked==false){
                if(selectedWinCombo==10) {
                    while (flag == 0) {
                        com = rund(0, 8);
                        for (int k = 0; k < 9; k++) {
                            if (randomTry[k] == com)
                                break;
                            else {
                                flag = 1;
                                randomTry[len] = com;
                                len++;
                            }
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
                    int x=rund(0,2);
                    gSelect=winCombo[com][x];
                    gameArea[gSelect]=2;
                    buttons[gSelect].setText("0");
                    moveMaked=true;
                }
                else
                    selectedWinCombo=10;



                flag=0;
                if(len==9){
                    int flag2=0;
                    while (flag2==0){
                        int x=rund(0,8);
                        if (gameArea[x]==0){
                            gameArea[x]=2;
                            buttons[gSelect].setText("0");
                            flag2=1;
                        }

                    }
                    moveMaked=true;
                    freecell--;
                }
            }
        }


        //Strategia try to not lose


        return !g;
    }
    public boolean gamerMove(boolean g){
        for(int i=0; i<9; i++){
            buttons[i].setEnabled(true);
        }

        if (moveMaked) return !g;
        else return g;
    }

    abstract class buttonList implements ActionListener {}

    buttonList bListner;


    public void init() {
        int smin=1, smax=2, i;
        boolean gameTaker, endGame;
        endGame=false;
        i=rund(smin,smax);
        gameTaker = (i != 0);
        //gameTaker = true;
        while(freecell>0 && endGame==false) {
            //if (gameTaker)
               // gameTaker = compMove(gameTaker);
            //else
                gameTaker = gamerMove(gameTaker);
            check_if_win(endGame);
        }
        bListner=new buttonList() {
            public final void actionPerformed(ActionEvent e) {
                for(int i=0; i<9;i++){
                    if(e.getSource()==buttons[i]){
                        gameArea[i]=1;
                        buttons[i].setText("Y");
                        freecell--;
                        moveMaked=true;
                        for(int j=0; j<9; j++){
                            buttons[i].setEnabled(true);
                        }
                        compMove(true);
                    }
                }

            }
        };
        for (int i=0; i<9; i++){
            buttons[i].addActionListener(bListner);
        }





        //frameXO.setDefaultCloseOperation(MainFrame.act_deact(1));

    }
    */
    abstract class buttonList implements ActionListener {}


}
