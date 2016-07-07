import com.gamemaschine.*;
import org.junit.Test;
import static junit.framework.Assert.*;
public class TimerTest {
    @Test
    public void testXoRund() throws Exception{
        Gracz s;
        s=new Student("s","s");
        StudentView sv=new StudentView();
        Timeout timer = new Timeout(s, sv);
        assertEquals(timer.ret(),s.allowedTime);
    }
}
