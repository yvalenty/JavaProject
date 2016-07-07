public class Student extends Uczen {
    
    public Student(String s, String ss) {
        super(s, ss);
        allowedTime=4;
    }

    public void gameDeer(){
        gcrecords =new int[repeats+1][2];
        gcmax=2;
        gcmin=1;
    }

    @Override
    public String getTyp() {
        return ("Student");
    }
    @Override
    public String laugh() {
            return("Student. Przegrałeś");
        }
    @Override
    public String congratulate() {return("Student. Wygrałeś"); }
    @Override
    public String remis() {
        return("Student. Remis");
    }
}
