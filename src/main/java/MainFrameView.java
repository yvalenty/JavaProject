import javax.swing.*;
import java.awt.*;

public class MainFrameView {
    static JFrame frame;
    private String[] gamesStrings = { "Wybieranie strony monety", "Kamień,nożyce, papier", "Polowanie na jelenie", "Krzyżyk i kółko"};
    JPanel mainPanel;
    JPanel pan1, pan2, pan3, ppan1, ppan2, pan4;
    JComboBox selector1;
    JButton start, exi, ex;
    JRadioButton g1= new JRadioButton(gamesStrings[0]);
    JRadioButton g2= new JRadioButton(gamesStrings[1]);
    JRadioButton g3= new JRadioButton(gamesStrings[2]);
    JRadioButton g4= new JRadioButton(gamesStrings[3]);
    JFormattedTextField imie, naz, rep, wp;

    public void sMainFrameView() {
        String[] labelStrings = {"Wybierz typ gracza","Wybierz grę", "Wpisz imie", "Wpisz nazwisko", "Wprowadź ilosć powtozeń", "Wprowadź wpłaty"};
        String[] gamersStrings = { "Przedszkolak", "Uczeń", "Student"};
        start=new JButton("Start");
        exi=new JButton("Exit");

        //Add elements to main window
        frame = new JFrame("Game Machine");
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        mainPanel = new JPanel();
        pan1 = new JPanel();
        pan2 = new JPanel();
        pan3 = new JPanel();
        ppan1 =new JPanel();
        ppan2 =new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
        ppan1.setLayout(new FlowLayout());
        ppan1.setAlignmentX(Component.RIGHT_ALIGNMENT);
        ppan2.setLayout(new BoxLayout(ppan2, BoxLayout.Y_AXIS));
        ppan2.setAlignmentX(Component.RIGHT_ALIGNMENT);
        pan1.setAlignmentX(Component.CENTER_ALIGNMENT);
        pan2.setLayout(new BoxLayout(pan2, BoxLayout.Y_AXIS));

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(g1);
        bgroup.add(g2);
        bgroup.add(g3);
        bgroup.add(g4);
        selector1 = new JComboBox(gamersStrings);
        selector1.setSelectedIndex(0);
        imie = new JFormattedTextField("                             ");
        naz = new JFormattedTextField("                             ");
        rep = new JFormattedTextField("                             ");
        wp = new JFormattedTextField("                             ");
        for(int i=0; i<6;i++){
            JLabel label = new JLabel(labelStrings[i]);
            if(i<1)
                ppan1.add(label);
            else if (i<2)
                ppan2.add(label);
            else
                pan2.add(label);
            switch(i){
                case 0:
                    ppan1.add(selector1);
                    break;
                case 1:
                    ppan2.add(g1);
                    ppan2.add(g2);
                    ppan2.add(g3);
                    ppan2.add(g4);
                    g1.setSelected(true);
                    g2.setEnabled(false);
                    g3.setEnabled(false);
                    break;
                case 2:
                    pan2.add(imie);
                    break;
                case 3:
                    pan2.add(naz);
                    break;
                case 4:
                    pan2.add(rep);
                    break;
                case 5:
                    pan2.add(wp);
                    break;
            }
        }
        pan1.add(ppan1);
        pan1.add(ppan2);
        pan3.add(start);
        pan3.add(exi);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,10,0,0));
        mainPanel.add(pan2);
        mainPanel.add(Box.createHorizontalStrut(10));
        mainPanel.add(new JSeparator(SwingConstants.VERTICAL));
        mainPanel.add(Box.createHorizontalStrut(10));
        mainPanel.add(pan1);
        frame.add(mainPanel);
        frame.add(pan3);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(494,215);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        pan4 = new JPanel();
        pan4.setBackground(Color.WHITE);
        ex=new JButton("Back");

    }

    public void startInfo(String n){
        JOptionPane.showMessageDialog(null, n);
    }

}
