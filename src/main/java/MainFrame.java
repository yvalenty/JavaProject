public class MainFrame {
    //Declaration of variables
    private int game=0, gamer;
    private double gcounts, gcharge;
    private String gname, gsurname;
    private String[] gamesStrings = { "Wybieranie strony monety", "Kamień,nożyce, papier", "Polowanie na jelenie", "Krzyżyk i kółko"};
    Gracz Gamer;
    public String getGamesStrings(int i){
        return gamesStrings[i];
    }

    public String getName(){
        return gname;
    }

    public void setName(String n){
        this.gname=n;
    }

    public String getSurname(){
        return gsurname;
    }

    public void setSurname(String n){
        this.gsurname=n;
    }

    public int getGame(){
        return game;
    }

    public void setGame(int n){
        this.game=n;
    }

    public int getGamer(){
        return gamer;
    }

    public void setGamer(int n){
        this.gamer=n;
    }

    public double getCounts(){
        return gcounts;
    }

    public void setCounts(int n){
        this.gcounts=n;
    }

    public double getCharge(){
        return gcharge;
    }

    public void setCharge(double n){
        this.gcharge=n;
    }

    //constructor
    public MainFrame(){
        Gamer = null;
    }
}
