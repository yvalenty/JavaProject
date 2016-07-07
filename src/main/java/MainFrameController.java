import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrameController {
    private MainFrame model;
    private MainFrameView view;
    Listener gSelect;

    public MainFrameController(MainFrame model, MainFrameView view){
        this.model=model;
        this.view=view;
    }

    public void MainView(){
        gSelect=new Listener();
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
                if(model.getGamer()==0)
                    model.Gamer=new Przedszkolak(model.getName(), model.getSurname());
                if(model.getGamer()==1)
                    model.Gamer=new Uczen(model.getName(), model.getSurname());
                if(model.getGamer()==2)
                    model.Gamer=new Student(model.getName(), model.getSurname());
                try {
                    model.setName(view.imie.getText());
                    model.setSurname(view.naz.getText());
                    model.setCounts(Integer.parseInt(view.rep.getText().trim()));
                    model.setCharge(Double.parseDouble(view.wp.getText()));
                    JOptionPane.showMessageDialog(null, "Zaczynamy grę\n");
                    model.Gamer.startGame(model.getGame());
                    view.mainPanel.setVisible(false);
                    view.pan3.setVisible(false);
                    view.frame.add(model.Gamer.gameWindow);
                    view.pan4 = new JPanel();
                    JButton ex=new JButton("Back");
                    view.pan4.add(ex);
                    view.pan4.setBackground(Color.white);
                    model.Gamer.gameWindow.add(view.pan4);
                    ex.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            model.Gamer.gameWindow.setVisible(false);
                            view.pan4.setVisible(false);
                            view.mainPanel.setVisible(true);
                            view.pan3.setVisible(true);
                        }
                    });
                }
                catch (Exception err){
                    JOptionPane.showMessageDialog(null, "Wprowadź poprawne dane");
                }

            }
        });
    }

    public class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view.selector1) {
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
                    model.setGamer(1);
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