import com.gamemaschine.*;
import org.junit.Test;
import static junit.framework.Assert.*;
public class XORundTest {
    @Test
    public void rundTest() throws Exception{
        Przedszkolak p=new Przedszkolak("s","a");
        int k;
        for(int i=0;i<100;i++){
            k=p.rund(0,7);
            assertTrue(k>=0 && k<=7);
        }
    }
}
