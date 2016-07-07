package com.gamemaschine;

import java.awt.event.*;

public class MainFrameController {
    private MainFrame model;
    private MainFrameView view;
    Listener gSelect;
    GraczView gamerview;
    WindowListener wListen;
    Thread thread;
    public MainFrameController(MainFrame model, MainFrameView view){
        this.model=model;
        this.view=view;
    }

    //fabryka modeli
    public Gracz fabryka(int n){
        Gracz g=null;
        if(n==0){
            g=new Przedszkolak(model.getName(),model.getSurname());
        }
        else if(n==1){
            g=new Uczen(model.getName(),model.getSurname());
        }
        else if(n==2){
            g=new Student(model.getName(),model.getSurname());
        }
        return g;
    }

    //fabryka widoków
    public GraczView fabrykaWidokow(int n){
        GraczView g=null;
        if(n==0){
            g=new PrzedszkolakView();
        }
        else if(n==1){
            g=new UczenView();
        }
        else if(n==2){
            g=new StudentView();
        }
        return g;
    }

    //fabryka kontrolerów
    public GraczController fabrykaKontolerow(int n, Gracz gm, GraczView gv){
        GraczController g=null;
        if(n==0){
            g=new PrzedszkolakController(gm, gv);
        }
        else if(n==1){
            g=new UczenController(gm, gv);
        }
        else if(n==2){
            g=new StudentController(gm, gv);
        }
        return g;
    }

    public void MainView(){
        gSelect=new Listener();
        wListen=new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                gamerview.gameWindow.setVisible(false);
                view.pan4.setVisible(false);
                view.mainPanel.setVisible(true);
                view.pan3.setVisible(true);
                view.frame.setEnabled(true);
                view.frame.setVisible(true);
                thread.interrupt();
            }
            @Override
            public void windowOpened(WindowEvent e) {
                view.frame.setEnabled(false);
                view.frame.setVisible(false);
            }
        };
        view.g1.addActionListener(gSelect);
        view.g2.addActionListener(gSelect);
        view.g3.addActionListener(gSelect);
        view.g4.addActionListener(gSelect);
        view.selector1.addActionListener(gSelect);
        //Exit pressed
        view.exi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //Start pressed
        view.start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    model.setName(view.imie.getText());
                    model.setSurname(view.naz.getText());
                    model.setRepeats(Integer.parseInt(view.rep.getText().trim()));
                    model.setCharge(Double.parseDouble(view.wp.getText()));
                    if(model.getRepeats()==0) throw new Exception();//zakaz wprowadzenia 0 powtórzeń
                    Gracz gamer=fabryka(model.getGamer());
                    gamerview=fabrykaWidokow(model.getGamer());
                    GraczController gamercontroller=fabrykaKontolerow(model.getGamer(), gamer, gamerview);
                    gamer.repeats=model.getRepeats();
                    gamer.payment=model.getCharge();
                    gamer.setResultsTable();
                    model.Gamer=gamer;
                    view.startInfo("Zaczynamy grę\nMasz czas: " + gamer.allowedTime + " minuty");
                    Timeout timer = new Timeout(gamer, gamerview);
                    thread = new Thread(timer);
                    thread.start();
                    if(model.getGame()==0) {
                        gamerview.gameCoin();
                        gamercontroller.gameCoin();
                    }
                    else if (model.getGame() == 1) {
                        gamer.gameKNP();
                        gamerview.gameKNP();
                        gamercontroller.gameKNP();
                    }
                    else if (model.getGame() == 2) {
                        gamer.gameDeer();
                        gamerview.gameDeer();
                        gamercontroller.gameDeer();
                    }
                    else if(model.getGame()==3) {
                        gamer.gameXO();
                        gamerview.gameXO();
                        gamercontroller.gameXO();
                        gamerview.frameXO.addWindowListener(wListen);
                    }

                    view.mainPanel.setVisible(false);
                    view.pan3.setVisible(false);
                    view.pan4.add(view.ex);
                    view.frame.add(gamerview.gameWindow);
                    gamerview.gameWindow.add(view.pan4);
                    view.pan4.setVisible(true);
                    view.ex.addActionListener(new ActionListener() {
                        //Back pressed
                        public void actionPerformed(ActionEvent e) {
                            gamerview.gameWindow.setVisible(false);
                            view.pan4.setVisible(false);
                            view.mainPanel.setVisible(true);
                            view.pan3.setVisible(true);
                            thread.interrupt();
                        }
                    });
                }
                catch (Exception err){
                    view.startInfo("Wprowadź poprawne dane");
                    System.out.print(err);
                }

            }
        });
    }
    
    public class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.selector1) {
                view.g1.setSelected(true);
                model.setGame(0);
                if (view.selector1.getSelectedIndex() == 0) {
                    model.setGamer(0);
                    view.g2.setEnabled(false);
                    view.g3.setEnabled(false);
                }
                if (view.selector1.getSelectedIndex() == 1) {
                    model.setGamer(1);
                    view.g2.setEnabled(true);
                    view.g3.setEnabled(false);
                }
                if (view.selector1.getSelectedIndex() == 2) {
                    model.setGamer(2);
                    view.g2.setEnabled(true);
                    view.g3.setEnabled(true);
                }
            }
            if (e.getSource() == view.g1) {
                if(view.g1.isSelected())
                    model.setGame(0);
            }
            if (e.getSource() == view.g2) {
                if(view.g2.isSelected())
                    model.setGame(1);
            }
            if (e.getSource() == view.g3) {
                if(view.g3.isSelected())
                    model.setGame(2);
            }
            if (e.getSource() == view.g4) {
                if(view.g4.isSelected())
                    model.setGame(3);
            }
        }
    }
}