import com.gamemaschine.*;
import org.junit.Test;
import static junit.framework.Assert.*;
public class XORundTest {
    @Test
    public void rundTest() throws Exception{
        Przedszkolak p=new Przedszkolak("s","a");
        for(int k=0;k<8;k++){
            k=p.rund(0,7);
            assertTrue(k>-1 && k<8);
        }
    }
}
