package Unit.T3;

import T3.App;
import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Test;

public class InvalidInputTest extends AppTest {

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidOne() throws Exception {
        //T3.App.main();

        throw new InvalidArgumentException(new String[]{"todo"});
	}
}
