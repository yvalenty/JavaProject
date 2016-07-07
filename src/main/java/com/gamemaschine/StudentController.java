package com.gamemaschine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentController extends UczenController {
    private Gracz model;
    private GraczView view;
    public StudentController(Gracz smodel, GraczView sview) {
        super(smodel, sview);
        this.model=smodel;
        this.view=sview;
    }

    public void gameDeer(){
        abstract class buttonList implements ActionListener {}
        buttonList bListner;
        bListner=new buttonList() {
            int i=0;
            String op1, op2;
            public final void actionPerformed(ActionEvent e) {
                if (e.getSource() == view.button1) {
                    model.select1 = 1;
                    op1="Jeleń";
                    model.select2 = model.rund(model.gcmin, model.gcmax);
                }
                if (e.getSource() == view.button2) {
                    model.select1 = 2;
                    op1="Zając";
                    model.select2 = model.rund(model.gcmin, model.gcmax);
                }
                if (model.select2==1)
                    op2="Jeleń";
                else
                    op2="Zając";
                if(model.select1==1 && model.select2==1) {
                    view.selN1.setText("Jeleń vs. Jeleń xD. Dostajesz 2 punkty.\nPzeciwnik dostaje 2");
                    model.gcrecords[i][0]=2;
                    model.gcrecords[i][1]=2;
                    i++;
                }
                else if(model.select1==1 && model.select2==2) {
                    view.selN1.setText("Jeleń vs. Zając xD. Nie dostajesz żadnych punktów.\nPzeciwnik dostaje 1");
                    model.gcrecords[i][0]=0;
                    model.gcrecords[i][1]=1;
                    i++;
                }
                else if(model.select1==2 && model.select2==1) {
                    view.selN1.setText("Zając vs. Jeleń xD. Dostajesz 1 punkt.\nPzeciwnik nie dostaje nic");
                    model.gcrecords[i][0]=1;
                    model.gcrecords[i][1]=0;
                    i++;
                }
                else if(model.select1==2 && model.select2==2) {
                    view.selN1.setText("Zając vs. Zając xD. Dostajesz 1 punkt.\nPzeciwnik tez dostaje 1");
                    model.gcrecords[i][0]=1;
                    model.gcrecords[i][1]=1;
                    i++;
                }
                if (i==model.repeats){
                    view.button1.setEnabled(false);
                    view.button2.setEnabled(false);
                    view.showWinner(model.takeWinner());
                }

            }
        };
        view.button1.addActionListener(bListner);
        view.button2.addActionListener(bListner);
    }
}
