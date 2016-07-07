import java.awt.event.*;

public class MainFrameController {
    private MainFrame model;
    private MainFrameView view;
    Listener gSelect;
    PrzedszkolakController pcontroller;
    PrzedszkolakView pview;
    UczenController ucontroller;
    UczenView uview;
    StudentController scontroller;
    StudentView sview;
    WindowListener wListen;

    public MainFrameController(MainFrame model, MainFrameView view){
        this.model=model;
        this.view=view;
    }

    public void MainView(){
        gSelect=new Listener();
        wListen=new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                pview.gameWindow.setVisible(false);
                view.pan4.setVisible(false);
                view.mainPanel.setVisible(true);
                view.pan3.setVisible(true);
                view.frame.setEnabled(true);
                view.frame.setVisible(true);

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
                    view.startInfo("Zaczynamy grę\n");
                    if(model.getGamer()==0) {
                        Przedszkolak prz = new Przedszkolak(model.getName(), model.getSurname());
                        prz.repeats=model.getRepeats();
                        prz.setResultsTable();
                        model.Gamer = prz;
                        pview=new PrzedszkolakView();
                        pcontroller = new PrzedszkolakController(prz, pview);
                        if(model.getGame()==0) {
                            pview.gameCoin();
                            pcontroller.gameCoin();
                        }
                        if(model.getGame()==3) {
                            prz.gameXO();
                            pview.gameXO();
                            pcontroller.gameXO();
                            pview.frameXO.addWindowListener(wListen);
                        }
                    }
                    if(model.getGamer()==1) {
                        Uczen ucz = new Uczen(model.getName(), model.getSurname());
                        ucz.repeats=model.getRepeats();
                        ucz.setResultsTable();
                        model.Gamer = ucz;
                        uview=new UczenView();
                        ucontroller = new UczenController(ucz, uview);
                        pview=uview;
                        if (model.getGame() == 0) {
                            uview.gameCoin();
                            ucontroller.gameCoin();
                        }
                        if (model.getGame() == 1) {
                            ucz.gameKNP();
                            uview.gameKNP();
                            ucontroller.gameKNP();
                        }
                        if(model.getGame()==3) {
                            ucz.gameXO();
                            uview.gameXO();
                            ucontroller.gameXO();
                            uview.frameXO.addWindowListener(wListen);
                        }

                    }
                    if(model.getGamer()==2) {
                        Student std = new Student(model.getName(), model.getSurname());
                        std.repeats=model.getRepeats();
                        std.setResultsTable();
                        model.Gamer = std;
                        sview=new StudentView();
                        scontroller = new StudentController(std, sview);
                        uview=sview;
                        pview=uview;
                        if (model.getGame() == 0) {
                            sview.gameCoin();
                            scontroller.gameCoin();
                        }
                        if (model.getGame() == 1) {
                            std.gameKNP();
                            sview.gameKNP();
                            scontroller.gameKNP();
                        }
                        if (model.getGame() == 2) {
                            std.gameDeer();
                            sview.gameDeer();
                            scontroller.gameDeer();
                        }
                        if(model.getGame()==3) {
                            std.gameXO();
                            sview.gameXO();
                            scontroller.gameXO();
                            sview.frameXO.addWindowListener(wListen);
                        }
                    }

                    //model.Gamer.startGame(model.getGame());
                    view.mainPanel.setVisible(false);
                    view.pan3.setVisible(false);
                    view.pan4.add(view.ex);
                    view.frame.add(pview.gameWindow);
                    pview.gameWindow.add(view.pan4);
                    view.pan4.setVisible(true);
                    view.ex.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            pview.gameWindow.setVisible(false);
                            view.pan4.setVisible(false);
                            view.mainPanel.setVisible(true);
                            view.pan3.setVisible(true);
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