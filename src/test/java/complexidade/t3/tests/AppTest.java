package complexidade.t3.tests;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import complexidade.t3.App;
import complexidade.t3.Chain;
import complexidade.t3.Domino;

public class AppTest {
	
	private List<Domino> boneyard;
	private Chain chain;
	
	@Before
	public void prepare() {
		boneyard = new LinkedList<Domino>();
        chain = new Chain();
	}
	
	@Test
	public void emptyTest() {
		assertTrue(App.dominoesAreChainable(chain, boneyard));
    	assertThat(chain.get(), is(empty()));
	}

	@Test
	public void singleTest() {
		boneyard.add(new Domino(0, 0));
        
    	assertTrue(App.dominoesAreChainable(chain, boneyard));
    	assertThat(chain.get().size(), is(equalTo(1)));
	}

	@Test
	public void twoTest() {
		boneyard.add(new Domino(0, 1));
		boneyard.add(new Domino(1, 0));
        
    	assertTrue(App.dominoesAreChainable(chain, boneyard));
    	assertThat(chain.get().size(), is(equalTo(2)));
	}
	
	@Test
	public void aLotTest() {
		boneyard.add(new Domino(0, 1));
		boneyard.add(new Domino(1, 2));
		boneyard.add(new Domino(2, 3));
		boneyard.add(new Domino(3, 4));
		boneyard.add(new Domino(4, 5));
		boneyard.add(new Domino(5, 6));
		boneyard.add(new Domino(6, 7));
		boneyard.add(new Domino(7, 8));
		boneyard.add(new Domino(8, 9));
		boneyard.add(new Domino(9, 0));
        
    	assertTrue(App.dominoesAreChainable(chain, boneyard));
    	assertThat(chain.get().size(), is(equalTo(10)));
	}

}
