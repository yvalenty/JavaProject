import com.gamemaschine.*;
import org.junit.Test;
import static junit.framework.Assert.*;
public class XORundTest {
    @Test
    public void rundTest() throws Exception{
        Przedszkolak p=new Przedszkolak("s","a");
        int k;
        for(k=0;k<100;k++){
            k=p.rund(0,7);
            assertTrue(k>=0 && k<=7);
        }
    }
}
