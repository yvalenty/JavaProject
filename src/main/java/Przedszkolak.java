import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Przedszkolak extends Gracz {
    public Przedszkolak (String s, String ss) {
         name = s;
         surname=ss;
         allowedTime=2;
    }
    public int rund(int min, int max){
        Random rn = new Random();
        return rn.nextInt((max - min)+1) + min;
    }

    public int ret(){
        return (0);
    }

    public void gameXO(){
        GameXO nGame = new GameXO();
//
    }

    public void gameCoin(){
        JPanel mpan, pan1, pan2, pan3,pan4;
        mpan = new JPanel();
        mpan.setLayout(new BoxLayout(mpan, BoxLayout.X_AXIS));
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        mpan.add(pan1);
        mpan.add(pan2);
        gameWindow.setBackground(Color.white);
        mpan.setBackground(Color.white);
        pan1.setBackground(Color.white);
        pan2.setBackground(Color.white);
        pan3.setBackground(Color.white);
        gameWindow.setLayout(new BoxLayout(gameWindow, BoxLayout.Y_AXIS));
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/u.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/u2.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel picLabel = new JLabel();
        picLabel.setIcon(imageIcon);
        JLabel picLabel2 = new JLabel();
        picLabel2.setIcon(imageIcon2);
        pan1.add(picLabel);
        pan2.add(picLabel2);


        int max=2, min=1;
        records =new int[repeats+1][2];
        JButton button1=new JButton("Orzeł");
        JButton button2=new JButton("Reszka");
        JLabel selN1= new JLabel("");
        JLabel selN2= new JLabel("");
        JLabel lw= new JLabel("");
        pan1.add(button1);
        pan2.add(button2);
        gameWindow.add(mpan);
        gameWindow.add(pan3);
        pan3.add(selN1);
        pan3.add(selN2);
        pan3.add(lw);

        abstract class buttonList implements ActionListener{}

        buttonList bListner;
        bListner=new buttonList() {
            int i=0;
            String op1, op2;
            public final void actionPerformed(ActionEvent e) {
                    if (e.getSource() == button1) {
                        select1 = 1;
                        op1="Orła";
                        select2 = rund(min, max);
                    }
                    if (e.getSource() == button2) {
                        select1 = 2;
                        op1="Reszkę";
                        select2 = rund(min, max);
                    }
                    if (select2==1)
                        op2="Orła";
                    else
                        op2="Reszkę";
                    selN1.setText("Wybrałeś: " + op1 + "   ");
                    selN2.setText("Przeciwnik wybrał: " + op2 + "   ");
                    if (select1 == select2) {
                        lw.setText("Wygrałeś");
                        records[i][0] = 1;
                        records[i][1] = 0;
                        i++;
                    } else {
                        lw.setText("Przegrałeś");
                        records[i][0] = 0;
                        records[i][1] = 1;
                        i++;

                    }
                    if (i == repeats) {
                        for (int k = 0; k < repeats; k++) {
                            System.out.println(records[k][0] + "   " + records[k][1]);
                        }
                    }

                    if (i==repeats){
                    button1.setEnabled(false);
                    button2.setEnabled(false);
                    takeWinner();
                    }
            }
        };
        button1.addActionListener(bListner);
        button2.addActionListener(bListner);
    };

    @Override
    public String getTyp() {
        return ("Przedszkolak");
    }

    @Override
    public void laugh() {
        JOptionPane.showMessageDialog(null, "Przedszkolak. Przegrałeś\n" + niewyplata());
    }

    @Override
    public void congratulate() {
        JOptionPane.showMessageDialog(null, "Przedszkolak. Wygrałeś\n" + wyplata());
    }

    @Override
    public void startGame(int i) {
        if (i==0)
            gameCoin();
        else
            gameXO();
    }

    public void remis() {
        JOptionPane.showMessageDialog(null, "Przedszkolak. Remis");
    }

    @Override
    public String niewyplata() {
        payment=records[repeats][1]*payment;
        return("Przeciwnik dostaje " + payment);
    }

    @Override
    public String wyplata() {
        payment=records[repeats][0]*payment;
        return("Dostajesz " + payment);
    }
    
}
