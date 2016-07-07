import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PrzedszkolakController extends GraczController {
    private Przedszkolak model;
    private PrzedszkolakView view;

    public PrzedszkolakController(Przedszkolak pmodel, PrzedszkolakView pview) {
        this.model=pmodel;
        this.view=pview;
    }

    public void gameCoin(){
        abstract class buttonList implements ActionListener{}

        buttonList bListner;
        bListner=new buttonList() {
            int i=0;
            String op1, op2;
            public final void actionPerformed(ActionEvent e) {
                if (e.getSource() == view.button1) {
                    model.selectgc1 = 1;
                    op1="Orła";
                    model.selectgc2 = model.rund(model.gcmin, model.gcmax);
                }
                if (e.getSource() == view.button2) {
                    model.selectgc1 = 2;
                    op1="Reszkę";
                    model.selectgc2 = model.rund(model.gcmin, model.gcmax);
                }
                if (model.selectgc2==1)
                    op2="Orła";
                else
                    op2="Reszkę";
                view.selN1.setText("Wybrałeś: " + op1 + "   ");
                view.selN2.setText("Przeciwnik wybrał: " + op2 + "   ");
                if (model.selectgc1 == model.selectgc2) {
                    view.lw.setText("Wygrałeś");
                    model.gcrecords[i][0] = 1;
                    model.gcrecords[i][1] = 0;
                    i++;
                } else {
                    view.lw.setText("Przegrałeś");
                    model.gcrecords[i][0] = 0;
                    model.gcrecords[i][1] = 1;
                    i++;

                }


                if (i==model.repeats){
                    view.button1.setEnabled(false);
                    view.button2.setEnabled(false);
                    //model.takeWinner();
                }
            }
        };
        view.button1.addActionListener(bListner);
        view.button2.addActionListener(bListner);
    }

    public void gameXO(){
        abstract class buttonList implements ActionListener{}
        buttonList bListner;
        bListner=new buttonList() {
            public final void actionPerformed(ActionEvent e){
                for (int i = 0; i < 9; i++) {
                    if (e.getSource() == view.buttons[i]) {
                        if(model.gameArea[i]==0) {
                            view.buttons[i].setText("X");
                            model.gameArea[i]=1;
                            model.freecell--;
                            check_if_win();
                            if(model.endGame)
                                break;
                            else {
                                model.compMove();
                                view.buttons[model.ret].setText("O");
                                check_if_win();
                            }
                        }
                    }
                }
            }

        };
        for (int i=0; i<9; i++){
            view.buttons[i].addActionListener(bListner);
            view.buttons[i].setEnabled(true);
        }
        if(model.rund(0,1)==1) {
            model.moveMaked=false;
            model.compMove();
            view.buttons[model.ret].setText("O");
        }
    }

    public void check_if_win(){
        int winCounterGamer;
        int winCounterComp;
        for (int i=0; i<8; i++) {
            winCounterGamer = 0;
            winCounterComp = 0;
            if (!model.endGame){
                for (int j = 0; j < 3; j++) {
                    if (model.gameArea[model.winCombo[i][j]] == 1)
                        winCounterGamer++;
                    if (model.gameArea[model.winCombo[i][j]] == 2)
                        winCounterComp++;
                    if (winCounterGamer == 3) {
                        for (int k = 0; k < 9; k++) {
                            view.buttons[k].setEnabled(false);
                        }
                        model.endGame = true;
                        model.gcrecords[model.playedGames][0] = 1;
                        model.gcrecords[model.playedGames][1] = 0;
                        model.playedGames++;
                        view.endGame("Wygrales");
                        if(model.playedGames<model.repeats)
                            restart();
                        break;
                    }
                    if (winCounterComp == 3) {
                        for (int k = 0; k < 9; k++) {
                            view.buttons[k].setEnabled(false);
                        }
                        model.endGame = true;
                        view.endGame("Wygral komputer");
                        model.gcrecords[model.playedGames][0] = 0;
                        model.gcrecords[model.playedGames][1] = 1;
                        model.playedGames++;
                        if(model.playedGames<model.repeats)
                            restart();
                        break;
                    }
                    if (model.freecell == 0) {
                        for (int k = 0; k < 9; k++) {
                            view.buttons[k].setEnabled(false);
                        }
                        model.endGame = true;
                        view.endGame("Remis");
                        model.gcrecords[model.playedGames][0] = 0;
                        model.gcrecords[model.playedGames][1] = 0;
                        model.playedGames++;
                        if(model.playedGames<model.repeats)
                            restart();
                        break;
                    }
                }
            }
        }
    }

    public void restart(){
        for (int k = 0; k < 9; k++) {
            view.buttons[k].setText(" ");
            view.buttons[k].setEnabled(true);
            model.gameArea[k]=0;
        }
        model.freecell=9;
        model.moveMaked=false;
        model.endGame=false;
        model.selectedWinCombo=10;
    }

}
