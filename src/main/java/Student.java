import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Student extends Uczen {
    
    public Student(String s, String ss) {
        super(s, ss);
        allowedTime=6;
    }
    
    public void gameDeer(){
        JPanel mpan, pan1, pan2, pan3;
        mpan = new JPanel();
        mpan.setLayout(new BoxLayout(mpan, BoxLayout.X_AXIS));
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        mpan.add(pan1);
        mpan.add(pan2);
        mpan.add(pan3);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/d.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/r.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JButton button1=new JButton(imageIcon);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        JButton button2=new JButton(imageIcon2);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        pan1.add(button1);
        pan2.add(button2);
        gameWindow.setBackground(Color.white);
        mpan.setBackground(Color.white);
        pan1.setBackground(Color.white);
        pan2.setBackground(Color.white);
        pan3.setBackground(Color.white);
        gameWindow.setLayout(new BoxLayout(gameWindow, BoxLayout.Y_AXIS));
        gameWindow.add(mpan);
        JLabel selN1= new JLabel("");
        JLabel lw= new JLabel("");
        pan3.add(selN1);
        pan3.add(lw);
        gameWindow.add(pan3);

        records =new int[repeats+1][2];
        int max=2, min=1;

        abstract class buttonList implements ActionListener {}

        buttonList bListner;

        bListner=new buttonList() {
            int i=0;
            String op1, op2;
            public final void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    select1 = 1;
                    op1="Jeleń";
                    select2 = rund(min, max);
                }
                if (e.getSource() == button2) {
                    select1 = 2;
                    op1="Zając";
                    select2 = rund(min, max);
                }
                if (select2==1)
                    op2="Jeleń";
                else
                    op2="Zając";
                if(select1==1 && select2==1) {
                    selN1.setText("Jeleń vs. Jeleń xD. Dostajesz 2 punkty.\nPzeciwnik dostaje 2");
                    records[i][0]=2;
                    records[i][1]=2;
                    i++;
                }
                else if(select1==1 && select2==2) {
                    selN1.setText("Jeleń vs. Zając xD. Nie dostajesz żadnych punktów.\nPzeciwnik dostaje 1");
                    records[i][0]=0;
                    records[i][1]=1;
                    i++;
                }
                else if(select1==2 && select2==1) {
                    selN1.setText("Zając vs. Jeleń xD. Dostajesz 1 punkt.\nPzeciwnik nie dostaje nic");
                    records[i][0]=1;
                    records[i][1]=0;
                    i++;
                }
                else if(select1==2 && select2==2) {
                    selN1.setText("Zając vs. Zając xD. Dostajesz 1 punkt.\nPzeciwnik tez dostaje 1");
                    records[i][0]=1;
                    records[i][1]=1;
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

    }

     @Override
    public String getTyp() {
        return ("Student");
    }
     @Override
    public void startGame(int i) {
         if (i==0)
            gameCoin();
         else if (i==1)
            gameKNP();
         else if(i==2)
            gameDeer();
         else
             gameXO();
    }
        @Override
        public void laugh() {
            JOptionPane.showMessageDialog(null, "Student. Przegrałeś\n" + niewyplata());
        }
    @Override
    public void congratulate() { JOptionPane.showMessageDialog(null, "Student. Wygrałeś\n" + wyplata()); }
    @Override
    public void remis() {
        JOptionPane.showMessageDialog(null, "Student. Remis. Sprobuj ponownie");
    }
}
