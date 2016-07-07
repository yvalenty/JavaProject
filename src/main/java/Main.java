public class Main {
    public static void main(String[] args) {
        MainFrame model= new MainFrame();
        MainFrameView view = new MainFrameView();
        view.sMainFrameView();
        MainFrameController controller = new MainFrameController(model, view);
        controller.MainView();
    }
}
