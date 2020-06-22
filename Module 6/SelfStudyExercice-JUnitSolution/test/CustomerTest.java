package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Customer;

/**
 * This is a test case class used in testing Customer class.
 */
public class CustomerTest {
	private Customer testCustomer;

	/**
	 * Setup method to create Customer object before each test
	 * 
	 * @throws java.lang.Exception	Throws general exception
	 */
	@Before
	public void setUp() throws Exception {
		testCustomer = new Customer("George Washington","12345 1st ST", "Tempe", "AZ", "85202");
	}

	/**
	 * Tear down method to dispose of Customer object after each test
	 * 
	 * @throws java.lang.Exception	Throws general exception
	 */
	@After
	public void tearDown() throws Exception {
		testCustomer = null;
	}

	/**
	 * Test for displayAddress method of Customer class
	 * 
	 * Test method for {@link core.Customer#displayAddress()}.
	 */
	@Test
	public void testDisplayAddress() {
		assertEquals("125 1st ST\nTempe, AZ 85202",testCustomer.displayAddress());
	}

	/**
	 * Test for displayAddressLabel method of Customer class
	 * 
	 * Test method for {@link core.Customer#displayAddressLabel()}.
	 */
	@Test
	public void testDisplayAddressLabel() {
		assertEquals("George Washington\n12345 1st ST\nTempe, AZ 85202",testCustomer.displayAddressLabel());
	}

}
