import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Singleton tmp = Singleton.getInstance( );
        MainFrame model= new MainFrame();
        MainFrameView view = new MainFrameView();
        view.sMainFrameView();
        MainFrameController controller = new MainFrameController(model, view);
        controller.MainView();
        try {
            tmp.demoMethod();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
