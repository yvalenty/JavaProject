package com.gamemaschine;

import java.lang.*;

public class Timeout implements Runnable  {
    public Timeout(Gracz g, GraczView gv){
        stimeout=g.allowedTime;
        gs=gv;
    }
    public int ret(){
        return stimeout;
    }
    GraczView gs;
    int minutes;
    int sec;
    int stimeout;

    public void run() {
        int time = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch(InterruptedException exc) {
                return;
            }
            time++;
            minutes = time/60;
            sec = time%60;
            if (minutes==stimeout) {
                gs.timeEnd();
            }
        }
    }
}
