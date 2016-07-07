import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Singleton player = Singleton.getInstance( );
        MainFrame model= new MainFrame();
        MainFrameView view = new MainFrameView();
        view.sMainFrameView();
        MainFrameController controller = new MainFrameController(model, view);
        controller.MainView();
        try {
            player.playMusic();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
