import java.lang.*;

class Timeout implements Runnable {
    public Timeout(Gracz g){
        stimeout=g.allowedTime;
    }
    int minutes;
    int sec;
    int stimeout;
    public void run() {
        int time = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException exc) {
                System.out.println("Wątek zliczania czasu zoostał przerwany.");
                return;
            }
            time++;
            minutes = time/60;
            sec = time%60;
            if (minutes>stimeout) {
                System.out.println("Straciłeś zbyt dużo czsu. Przegrałeś.");
                System.exit(0);
            }
        }
    }
}
