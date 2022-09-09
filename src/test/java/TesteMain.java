import org.example.Main;
import org.junit.Test;

public class TesteMain {
    @Test(expected = Test.None.class)
    public void main(){
        (new Main()).main(new String[]{});
    }
}
