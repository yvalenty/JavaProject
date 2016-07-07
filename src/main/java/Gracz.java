import javax.swing.*;

public abstract class Gracz implements Lose, Win {
    JFrame frameXO;
    JPanel gameWindow=new JPanel();
    String name = "bez imienia";
    String surname = "bez nazwiska";
    int allowedTime = 0;
    int select1=0, select2=0;
    public Gracz() {}
    double payment;
    int repeats;
    int[][] records;
    public abstract String getTyp();
    public abstract void startGame(int i);


    public void showResults(){
        JTextArea textArea = new JTextArea(6, 18);
        textArea.setText("-----------Wyniki-----------\n" + "Gracz1                Gracz2\n");
        textArea.setText(textArea.getText()+ "-------------------------------\n");
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        for (int i=0; i<repeats; i++){
            for (int k=0; k<2; k++){
                textArea.setText(textArea.getText()+ "    " + records[i][k] + "                        ");
                records[repeats][k]+=records[i][k];
            }
            textArea.setText(textArea.getText()+ "\n");
        }
        textArea.setText(textArea.getText()+ "-------------------------------\n");
        textArea.setText(textArea.getText()+ "    " + records[repeats][0] + "                            " + records[repeats][1] +"\n");

        JOptionPane.showMessageDialog(gameWindow, scrollPane);
    }

    public void takeWinner(){
        showResults();
        if(records[repeats][0]> records[repeats][1]){
            congratulate();
        }
        else if(records[repeats][0]< records[repeats][1]){
            laugh();
        }
        else
            remis();
  };

  public String getName() {
    return name;
  }
  
   public void setPayment(double p) {
    this.payment=p;
  }
   
    public void setRepeats(int r) {
    this.repeats=r;
  }
  
    public String getSurname() {
    return surname;
  }
    
    
}