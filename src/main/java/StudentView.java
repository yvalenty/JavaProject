import javax.swing.*;
import java.awt.*;

public class StudentView extends UczenView{
    public void gameDeer(){
        mpan = new JPanel();
        mpan.setLayout(new BoxLayout(mpan, BoxLayout.X_AXIS));
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        mpan.add(pan1);
        mpan.add(pan2);
        mpan.add(pan3);
        imageIcon = new ImageIcon(new ImageIcon("src/d.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        imageIcon2 = new ImageIcon(new ImageIcon("src/r.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        button1=new JButton(imageIcon);
        button1.setOpaque(false);
        button1.setContentAreaFilled(false);
        button1.setFocusPainted(false);
        button2=new JButton(imageIcon2);
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
        selN1= new JLabel("");
        lw= new JLabel("");
        pan3.add(selN1);
        pan3.add(lw);
        gameWindow.add(pan3);
    }
}
