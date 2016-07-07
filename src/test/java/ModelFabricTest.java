import com.gamemaschine.*;
import org.junit.Test;
import static junit.framework.Assert.*;
public class ModelFabricTest {
    @Test
    public void testFabric() throws Exception{
        MainFrame model= new MainFrame();
        MainFrameView view=new MainFrameView();
        MainFrameController mf=new MainFrameController(model, view);
        Gracz gr=mf.fabryka(0);
        Przedszkolak p=new Przedszkolak("test","test");
        assertTrue(p.getTyp()==gr.getTyp());
        gr=mf.fabryka(1);
        Uczen u=new Uczen("test","test");
        assertTrue(u.getTyp()==gr.getTyp());
        gr=mf.fabryka(2);
        Student s=new Student("test","test");
        assertTrue(s.getTyp()==gr.getTyp());
    }
}
