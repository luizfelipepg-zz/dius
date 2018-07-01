package luiz.glingani;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class DiusTest {
	
	private Dius dius;
	
	@Before
	public void setUp(){
		dius = new Dius();
	}

	@Test
	public void test1() {
		String[] args = {"atv", "atv", "atv", "vga"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("249"), total);
	}
	
	@Test
	public void test2() {
		String[] args = {"atv", "ipd", "ipd", "atv", "ipd", "ipd", "ipd"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("2718.95"), total);
	}
	
	@Test
	public void test3() {
		String[] args = {"mbp", "vga", "ipd"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("1949.98"), total);
	}
	
	@Test
	public void test4() {
		String[] args = {"vga", "mbp", "ipd"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("1949.98"), total);
	}
	
	@Test
	public void test5() {
		String[] args = {"vga"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("30"), total);
	}
	
	@Test
	public void test6() {
		String[] args = {"mbp"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("1399.99"), total);
	}
	
	@Test
	public void test7() {
		String[] args = {"ipd"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("549.99"), total);
	}
	
	@Test
	public void test8() {
		String[] args = {"vga", "mbp", "vga", "vga", "vga"};
		Double total = dius.run(args);
		Assert.assertEquals(new Double("1489.99"), total);
	}

}
