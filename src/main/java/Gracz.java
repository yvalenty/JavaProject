public abstract class Gracz implements Lose, Win {
    String name = "bez imienia";
    String surname = "bez nazwiska";
    int allowedTime = 0;
    int select1=0, select2=0;
    public Gracz() {}
    double payment;
    int repeats;
    int[][] gcrecords;
    public abstract String getTyp();
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
    public void setName(String n){
        this.name=n;
    }
    public void setSurname (String n){
        this.surname=n;
    }



    public void takeWinner(){
        //showResults();
        if(gcrecords[repeats][0]> gcrecords[repeats][1]){
            congratulate();
        }
        else if(gcrecords[repeats][0]< gcrecords[repeats][1]){
            laugh();
        }
        else
            remis();
  };


}