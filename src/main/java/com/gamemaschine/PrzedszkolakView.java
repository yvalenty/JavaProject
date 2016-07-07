package com.gamemaschine;

import javax.swing.*;
import java.awt.*;

public class PrzedszkolakView extends GraczView {
    JPanel mpan, pan1, pan2, pan3, pan4;
    ImageIcon imageIcon, imageIcon2;
    JLabel picLabel, picLabel2;
    JPanel mainPanel;

    public void gameCoin(){
        imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/resources/u.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        imageIcon2 = new ImageIcon(new ImageIcon(getClass().getResource("/resources/u2.jpg")).getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        picLabel = new JLabel();
        picLabel2 = new JLabel();
        button1=new JButton("Orzeł");
        button2=new JButton("Reszka");
        selN1= new JLabel("");
        selN2= new JLabel("");
        lw= new JLabel("");
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
        picLabel.setIcon(imageIcon);
        picLabel2.setIcon(imageIcon2);
        pan1.add(picLabel);
        pan2.add(picLabel2);
        pan1.add(button1);
        pan2.add(button2);
        gameWindow.add(mpan);
        gameWindow.add(pan3);
        pan3.add(selN1);
        pan3.add(selN2);
        pan3.add(lw);
    }

    public void gameXO(){
        buttons= new JButton[9];
        frameXO = new JFrame("Game Machine");
        frameXO.setLayout(new BoxLayout(frameXO.getContentPane(), BoxLayout.Y_AXIS));
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3,3));
        frameXO.add(mainPanel);
        frameXO.setSize(300,300);
        frameXO.setResizable(false);
        frameXO.setLocationRelativeTo(null);
        frameXO.setVisible(true);
        for (int i=0; i<9; i++){
            buttons[i] = new JButton(" ");
            mainPanel.add(buttons[i]);
        }
    }

    public void endGame(String n){
        JOptionPane.showMessageDialog(null, n);
    }

    public void showWinner(String n){
        JOptionPane.showMessageDialog(null, n);
    }
}
