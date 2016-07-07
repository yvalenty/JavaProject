import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Uczen extends Przedszkolak {
    
    public Uczen(String s, String ss) {
        super(s, ss);
        allowedTime=4;
    }
    
    public void gameKNP(){
        JPanel mpan, pan1, pan2, pan3,pan4;
        mpan = new JPanel();
        mpan.setLayout(new BoxLayout(mpan, BoxLayout.X_AXIS));
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        pan4 = new JPanel();
        mpan.add(pan1);
        mpan.add(pan2);
        mpan.add(pan3);
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("src/knb1.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("src/knb2.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("src/knb3.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JButton button1=new JButton(imageIcon);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        //button1.setBorderPainted(false);
        JButton button2=new JButton(imageIcon2);
        button2.setOpaque(false);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        JButton button3=new JButton(imageIcon3);
        button3.setOpaque(false);
        button3.setContentAreaFilled(false);
        button3.setFocusPainted(false);
        pan1.add(button1);
        pan2.add(button2);
        pan3.add(button3);

        gameWindow.setBackground(Color.white);
        mpan.setBackground(Color.white);
        pan1.setBackground(Color.white);
        pan2.setBackground(Color.white);
        pan3.setBackground(Color.white);
        gameWindow.setLayout(new BoxLayout(gameWindow, BoxLayout.Y_AXIS));
        gameWindow.add(mpan);
        JLabel selN1= new JLabel("");
        JLabel selN2= new JLabel("");
        JLabel lw= new JLabel("");
        pan4.add(selN1);
        pan4.add(selN2);
        pan4.add(lw);
        gameWindow.add(pan4);


        records =new int[repeats+1][2];
        int max=3, min=1;

        abstract class buttonList implements ActionListener {}

        buttonList bListner;
        bListner=new buttonList() {
            int i=0;
            String op1, op2;
            public final void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    select1 = 1;
                    op1="Kamień";
                    select2 = rund(min, max);
                }
                if (e.getSource() == button2) {
                    select1 = 2;
                    op1="Nożyczki";
                    select2 = rund(min, max);
                }
                if (e.getSource() == button3) {
                    select1 = 3;
                    op1="Papier";
                    select2 = rund(min, max);
                }
                if (select2==1)
                    op2="Kamień";
                else if (select2==2)
                    op2="Nożyczki";
                else
                    op2="Papier";
                selN1.setText("Wybrałeś: " + op1 + "   ");
                selN2.setText("Przeciwnik wybrał: " + op2 + "   ");
                if((select1==1&&select2==2) || (select1==2&&select2==3) || (select1==3&&select2==1)) {
                    System.out.println("Wygrałeś");
                    lw.setText("Wygrałeś");
                    records[i][0]=1;
                    records[i][1]=0;
                    i++;
                }
                else if ((select1==1&&select2==3) || (select1==2&&select2==1) || (select1==3&&select2==2)){
                    System.out.println("Przegrałeś");
                    lw.setText("Przegrałeś");
                    records[i][0]=0;
                    records[i][1]=1;
                    i++;
                }
                else if (select1==select2){
                    System.out.println("Remis");
                    records[i][0]=0;
                    records[i][1]=0;
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
                    button3.setEnabled(false);
                    takeWinner();
                }
            }
        };
        button1.addActionListener(bListner);
        button2.addActionListener(bListner);
        button3.addActionListener(bListner);

    }

    @Override
    public String getTyp() {
        return ("Uczeń");
    }
     @Override
    public void startGame(int i) {
         if (i==0)
            gameCoin();
         else if (i==1)
            gameKNP();
         else
             gameXO();
    }
    @Override
    public void laugh() {
        JOptionPane.showMessageDialog(null, "Uczeń. Przegrałeś\n" + niewyplata());
    }
    @Override
    public void congratulate() {
        JOptionPane.showMessageDialog(null, "Uczeń. Wygrałeś\n" + wyplata());
    }
    @Override
    public void remis() {
        JOptionPane.showMessageDialog(null, "Uczeń. Remis. Sprobuj ponownie");
    }
}
