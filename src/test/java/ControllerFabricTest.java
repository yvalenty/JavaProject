import com.gamemaschine.*;
import org.junit.Test;
import static junit.framework.Assert.*;
public class ControllerFabricTest {
    @Test
    public void testCFabric() throws Exception{
        MainFrame model= new MainFrame();
        MainFrameView view=new MainFrameView();
        MainFrameController mf=new MainFrameController(model, view);
        Gracz gr;
        GraczView gv;
        GraczController gc, gc2;
        gr=new Przedszkolak("test","test");
        gv=new PrzedszkolakView();
        gc=mf.fabrykaKontolerow(0,gr, gv);
        gc2=new PrzedszkolakController(gr,gv);
        assertTrue(gc.getClass()==gc2.getClass());
        gr=new Uczen("test","test");
        gv=new UczenView();
        gc=mf.fabrykaKontolerow(1,gr, gv);
        gc2=new UczenController(gr,gv);
        assertTrue(gc.getClass()==gc2.getClass());
        gr=new Student("test","test");
        gv=new StudentView();
        gc=mf.fabrykaKontolerow(2,gr, gv);
        gc2=new StudentController(gr,gv);
        assertTrue(gc.getClass()==gc2.getClass());

    }
}
