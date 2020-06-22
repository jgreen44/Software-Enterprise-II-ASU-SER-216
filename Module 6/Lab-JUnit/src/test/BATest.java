package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Arrays;
import java.util.Collection;

import core.BankAccount;

/**
 * @author skbansa2
 * This is a test case class used in testing BankAccount class using Parameterized testing.
*/

	@RunWith(Parameterized.class)
	public class BATest {
		
		private static BankAccount testAccount;
		
		private BankAccount testAccount1;
		

		@Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { 0, 0 }, { 1, 0.5 }, { 2, 4.5 }, { 3, 1 }, { 4, 15 }, { 5, 0 }, { 6, 0 }  
	           });
	    };

	    private int acctTypeInput;

	    private double rateExpected;

	    public BATest(int acctTypeInput, double rateExpected)
	    {
	    	this.acctTypeInput = acctTypeInput;
	    	this.rateExpected = rateExpected;
	    }
	    
		/**
		 * @throws java.lang.Exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {
			testAccount = new BankAccount();
		}

		/**
		 * @throws java.lang.Exception
		 */
		@AfterClass
		public static void tearDownAfterClass() throws Exception {
			testAccount = null;
		}

		
		
		/**
		 * Setup method to create a new BankAccount object before each test.
		 * 
		 * @throws java.lang.Exception  Throws general exception
		 */
		@Before
		public void setUp() throws Exception {
			testAccount1 = new BankAccount();
		}

		/**
		 * Tear down method to clear the BankAccount object after each test.
		 * 
		 * @throws java.lang.Exception	Throws general exception
		 */
		@After
		public void tearDown() throws Exception {
			testAccount1 = null;
		}
		
		/**
		 * Test for interest rate using Parameterized testing.
		 * 
		 * Test method for {@link core.BankAccount#getInterestRate()}.
		 */
		@Test
		public void testGetInterestRateParameterized() {
			testAccount.setAccountType(acctTypeInput);
			assertEquals(rateExpected, testAccount.getInterestRate(),0);
		}
				
		/**
		 * Test for setBalance - for testaccount1.
		 * 
		 * Test method for {@link core.BankAccount#setBalance()}.
		 */
		public void testSetBalance() {
			testAccount1.setBalance(40);
			assertEquals(40, testAccount1.getBalance(),0.01);
		}
		
		
		/**
		 * Test for calculated total balance.
		 * 
		 * Test method for {@link core.BankAccount#calculateTotalBalance()}.
		 */
		@Test
		public void testCalculateTotalBalance() {
			testAccount.setAccountType(3);
			testAccount.setBalance(100);
			assertEquals(101, testAccount.calculateTotalBalance(),0);
		}
}
