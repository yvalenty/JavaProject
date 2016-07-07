package com.gamemaschine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Singleton player = Singleton.getInstance( );//tworzenie singletona
        MainFrame model= new MainFrame();
        MainFrameView view = new MainFrameView(); //tworzenie głównego okna programu
        view.sMainFrameView();
        MainFrameController controller = new MainFrameController(model, view); //Controller głównego okna
        controller.MainView();
        try {
            player.playMusic();//play music
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
