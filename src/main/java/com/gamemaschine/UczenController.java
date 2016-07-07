package com.gamemaschine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UczenController extends PrzedszkolakController {
    private Gracz model;
    private GraczView view;

    public UczenController(Gracz umodel, GraczView uview) {
        super(umodel, uview);
        this.model=umodel;
        this.view=uview;
    }

    public void gameKNP(){
        abstract class buttonList implements ActionListener {}
        buttonList bListner;
        bListner=new buttonList() {
            int i=0;
            String op1, op2;
            public final void actionPerformed(ActionEvent e) {
                if (e.getSource() == view.button1) {
                    model.select1 = 1;
                    op1="Kamień";
                    model.select2 = model.rund(model.gcmin, model.gcmax);
                }
                if (e.getSource() == view.button2) {
                    model.select1 = 2;
                    op1="Nożyczki";
                    model.select2 = model.rund(model.gcmin, model.gcmax);
                }
                if (e.getSource() == view.button3) {
                    model.select1 = 3;
                    op1="Papier";
                    model.select2 = model.rund(model.gcmin, model.gcmax);
                }
                if (model.select2==1)
                    op2="Kamień";
                else if (model.select2==2)
                    op2="Nożyczki";
                else
                    op2="Papier";
                view.selN1.setText("Wybrałeś: " + op1 + "   ");
                view.selN2.setText("Przeciwnik wybrał: " + op2 + "   ");
                if((model.select1==1&&model.select2==2) || (model.select1==2&&model.select2==3) || (model.select1==3&&model.select2==1)) {
                    view.lw.setText("Wygrałeś");
                    model.gcrecords[i][0]=1;
                    model.gcrecords[i][1]=0;
                    i++;
                }
                else if ((model.select1==1&&model.select2==3) || (model.select1==2&&model.select2==1) || (model.select1==3&&model.select2==2)){
                    view.lw.setText("Przegrałeś");
                    model.gcrecords[i][0]=0;
                    model.gcrecords[i][1]=1;
                    i++;
                }
                else if (model.select1==model.select2){
                    view.lw.setText("Remis");
                    model.gcrecords[i][0]=0;
                    model.gcrecords[i][1]=0;
                    i++;
                }
                if (i==model.repeats){
                    view.button1.setEnabled(false);
                    view.button2.setEnabled(false);
                    view.button3.setEnabled(false);
                    view.showWinner(model.takeWinner());
                }
            }
        };
        view.button1.addActionListener(bListner);
        view.button2.addActionListener(bListner);
        view.button3.addActionListener(bListner);
    }

}
