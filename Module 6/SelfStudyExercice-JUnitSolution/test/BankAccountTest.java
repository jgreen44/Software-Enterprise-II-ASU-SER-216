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
 * This is a test case class used in testing BankAccount class.
 */
@RunWith(Parameterized.class)
public class BankAccountTest {
	
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

    public BankAccountTest(int acctTypeInput, double rateExpected)
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
	 * Test for interest rate on unknown account type.
	 * 
	 * Test method for {@link core.BankAccount#getInterestRate()}.
	 */
	@Test
	public void testGetInterestRate() {
		testAccount.setAccountType(8);
		assertEquals("Acct Type 8", 0, testAccount.getInterestRate(),0);
		testAccount.setAccountType(1);
		assertEquals("Acct type 1", 0.5, testAccount.getInterestRate(),0);
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
	 * Test for interest rate on account type 1 "Savings".
	 * 
	 * Test method for {@link core.BankAccount#getInterestRate()}.
	 */
	@Test
	public void testGetInterestRate1() {
		testAccount1.setAccountType(1);
		assertEquals(0.5, testAccount1.getInterestRate(),0);
	}
	
	/**
	 * Test for interest rate on account type 2 "Award Savings".
	 * 
	 * Test method for {@link core.BankAccount#getInterestRate()}.
	 */
	@Test
	public void testGetInterestRate2() {
		testAccount1.setAccountType(2);
		assertEquals(4.5, testAccount1.getInterestRate(),0);
	}
	
	/**
	 * Test for interest rate on account type 3 "Checking".
	 * 
	 * Test method for {@link core.BankAccount#getInterestRate()}.
	 */
	@Test
	public void testGetInterestRate3() {
		testAccount1.setAccountType(3);
		assertEquals(0.75, testAccount1.getInterestRate(), 0);
	}
	
	/**
	 * Test for interest rate on account type 4 "Credit Card".
	 * 
	 * Test method for {@link core.BankAccount#getInterestRate()}.
	 */
	@Test
	public void testGetInterestRate4() {
		testAccount1.setAccountType(4);
		assertEquals(15, testAccount1.getInterestRate(),0);
	}

	/**
	 * Test for setBalance exception.
	 * 
	 * Test method for {@link core.BankAccount#setBalance()}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetBalance() {
		testAccount.setBalance(-4);
		testAccount1.setBalance(40);
		assertEquals(40, testAccount.getBalance(),0.01);
	}
	
	/**
	 * Test for setBalance exception.
	 * 
	 * Test method for {@link core.BankAccount#setBalance()}.
	 */
	public void testSetBalance1() {
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
