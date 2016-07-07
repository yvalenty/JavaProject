import com.gamemaschine.*;
import org.junit.Test;
import static junit.framework.Assert.*;
public class ViewFabricTest {
    @Test
    public void testFabricView() throws Exception{
        MainFrame model= new MainFrame();
        MainFrameView view=new MainFrameView();
        MainFrameController mf=new MainFrameController(model, view);
        GraczView gr=mf.fabrykaWidokow(0);
        PrzedszkolakView p=new PrzedszkolakView();
        assertTrue(p.getClass()==gr.getClass());
        gr=mf.fabrykaWidokow(1);
        UczenView u=new UczenView();
        assertTrue(u.getClass()==gr.getClass());
        gr=mf.fabrykaWidokow(2);
        StudentView s=new StudentView();
        assertTrue(s.getClass()==gr.getClass());
    }
}
