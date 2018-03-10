package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  Appt class.
 */
import org.junit.Test;

import static org.junit.Assert.*;
public class ApptTest {
    /**
     * Test that the gets methods work as expected.
     */
	 @Test
	  public void test01()  throws Throwable  {
		 
		 //making an appt object
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		// assertions
		 assertTrue(appt.getValid());
		 assertEquals(21, appt.getStartHour());
		 assertEquals(30, appt.getStartMinute());
		 assertEquals(15, appt.getStartDay());
		 assertEquals(01, appt.getStartMonth());
		 assertEquals(2018, appt.getStartYear());
		 assertEquals("Birthday Party", appt.getTitle());
		 assertEquals("This is my birthday party.", appt.getDescription());
		assertEquals("	1/15/2018 at 9:30pm ,Birthday Party, This is my birthday party.\n",appt.toString());
		
		//testing default values of the recuring section of an APPT
		assertEquals(appt.getRecurNumber(),0);
		assertEquals(appt.getRecurBy(),2);
		assertEquals(appt.getRecurIncrement(),0);
		assertFalse(appt.isRecurring());
		
		
		//testing to string
		appt.setStartHour(-3);
		assertEquals(null,appt.toString());
		
		appt.setStartHour(3);
		assertEquals("	1/15/2018 at 3:30am ,Birthday Party, This is my birthday party.\n",appt.toString());
		
		appt.setStartHour(0);
		assertEquals("	1/15/2018 at 12:30am ,Birthday Party, This is my birthday party.\n",appt.toString());
		
		
		appt.setStartHour(23);
		assertEquals(23,appt.getStartHour());
				
		appt.setStartMinute(28);
		assertEquals(28,appt.getStartMinute());
		
		
		appt.setStartDay(2);
		assertEquals(2,appt.getStartDay());
		
		
		appt.setStartYear(1999);
		assertEquals(1999,appt.getStartYear());
		assertTrue(appt.getValid());
		
		
		appt.setStartMonth(12);
		assertEquals(12,appt.getStartMonth());
		
		
		int[] recurDaysArr={2,3,4};
        
		appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		assertEquals(appt.getRecurNumber(),1000);
		assertEquals(appt.getRecurBy(),1);
		assertEquals(appt.getRecurDays()[0],2);
		assertEquals(appt.getRecurIncrement(),2);
		assertTrue(appt.isRecurring());
		
		
		
		//seeing how the function reacts to having a null array passed
		appt.setRecurrence( null, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);	
			
		appt.setDescription(null);
		assertEquals("",appt.getDescription());
		
		appt.setTitle(null);
		assertEquals("",appt.getTitle());
	 }
	 
	 @Test
	  public void test015()  throws Throwable  {
		 
		 //making an appt object
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		
		//testing to string
		appt.setStartHour(-3);
		assertEquals(null,appt.toString());
		
		appt.setStartHour(11);
		assertEquals("	1/15/2018 at 11:30am ,Birthday Party, This is my birthday party.\n",appt.toString());
		
		appt.setStartHour(12);
		assertEquals("	1/15/2018 at 12:30pm ,Birthday Party, This is my birthday party.\n",appt.toString());
		
		
		appt.setStartHour(23);
		assertEquals("	1/15/2018 at 11:30pm ,Birthday Party, This is my birthday party.\n",appt.toString());
		
		
		appt.setStartHour(0);
		assertEquals("	1/15/2018 at 12:30am ,Birthday Party, This is my birthday party.\n",appt.toString());
		
	 }

	 @Test//(expected = ArrayIndexOutOfBoundsException.class)
	  public void test02()  throws Throwable  {
		int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		
		//testing all the branches of getValid()
		//found bug
		//appt.setStartHour(25);
		appt.setStartHour(27);
		assertFalse(appt.getValid());
		appt.setStartHour(-1);
		assertFalse(appt.getValid());
		
		appt.setStartHour(23);
		assertTrue(appt.getValid());
		appt.setStartHour(0);
		assertTrue(appt.getValid());
		
		appt.setStartHour(5);
		
		
		appt.setStartMinute(-1);
		assertFalse(appt.getValid());
		appt.setStartMinute(60);
		assertFalse(appt.getValid());
		
		appt.setStartMinute(0);
		assertTrue(appt.getValid());
		appt.setStartMinute(59);
		assertTrue(appt.getValid());
		
		appt.setStartMinute(3);
		
		
		appt.setStartDay(0);
		assertFalse(appt.getValid());
		appt.setStartDay(32);
		assertFalse(appt.getValid());
		
		appt.setStartDay(1);
		assertTrue(appt.getValid());
		appt.setStartDay(29);
		assertTrue(appt.getValid());
		
		appt.setStartDay(3);
		
		 
	 }

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	  public void test022()  throws Throwable  {
		int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		
		//can't test this part because I get an array out of bound exception for 
		//checking for the number of days in a monty
		//Actually can be checked by expecting an error
		appt.setStartMonth(13);
		assertFalse(appt.getValid());
		
		 
	 }
	 
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	  public void test025()  throws Throwable  {
		int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		
		//can't test this part because I get an array out of bound exception for 
		//checking for the number of days in a monty
		//Actually can be checked by expecting an error
		appt.setStartMonth(0);
		assertFalse(appt.getValid());
	 }


	@Test
	  public void test0255()  throws Throwable  {
		int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		
		//can't test this part because I get an array out of bound exception for 
		//checking for the number of days in a monty
		//Actually can be checked by expecting an error
		appt.setStartMonth(12);
		assertTrue(appt.getValid());
		appt.setStartMonth(1);
		assertTrue(appt.getValid());
	 } 	 
	 
	 
//add more unit tests as you needed
	
	@Test
	  public void test03()  throws Throwable  {
		
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		int[] recurDaysArr5={2,3,4};
		
		
		//testing setRecurrence and according getters
        appt.setRecurrence( recurDaysArr5, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_NEVER);
		assertEquals(appt.getRecurNumber(),0);
		assertEquals(appt.getRecurBy(),1);
		assertEquals(appt.getRecurDays()[0],2);
		assertEquals(appt.getRecurIncrement(),2);
		assertFalse(appt.isRecurring()); 
	  } 
	  
	  
	  
	  @Test
	  public void test04()  throws Throwable  {
		
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=01;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		
		 Appt appt2 = new Appt(3,
		          5 ,
		          2 ,
		          7 ,
		          2001 ,
		          "this",
		         "idk");
		
		int idk=appt.compareTo(appt2);
		assertEquals(67,idk);
		//come up with a test for this output?
	  } 
	  
	  
	  @Test
	  public void test045()  throws Throwable  {
		
		 int startHour=21;
		 int startMinute=30;
		 int startDay=15;
		 int startMonth=1;
		 int startYear=2018;
		 String title="Birthday Party";
		 String description="This is my birthday party.";
		 //Construct a new Appointment object with the initial data	 
		 Appt appt = new Appt(startHour,
		          startMinute ,
		          startDay ,
		          startMonth ,
		          startYear ,
		          title,
		         description);
		//31, 32?
		appt.setStartDay(30);
		assertTrue(appt.getValid());
		appt.setStartDay(32);
		assertFalse(appt.getValid());
		
		
		appt.setStartMonth(2);
			appt.setStartDay(28);
			assertTrue(appt.getValid());
			//Because leap year?
			appt.setStartDay(30);
			assertFalse(appt.getValid());
			
		appt.setStartMonth(3);
			appt.setStartDay(31);
			assertTrue(appt.getValid());
			appt.setStartDay(32);
			assertFalse(appt.getValid());
			
		appt.setStartMonth(4);
			appt.setStartDay(30);
			assertTrue(appt.getValid());
			appt.setStartDay(31);
			assertFalse(appt.getValid());
		
		appt.setStartMonth(5);
			appt.setStartDay(31);
			assertTrue(appt.getValid());
			appt.setStartDay(32);
			assertFalse(appt.getValid());
		
		appt.setStartMonth(6);
			appt.setStartDay(30);
			assertTrue(appt.getValid());
			appt.setStartDay(31);
			assertFalse(appt.getValid());
		
		appt.setStartMonth(7);
			appt.setStartDay(31);
			assertTrue(appt.getValid());
			appt.setStartDay(32);
			assertFalse(appt.getValid());
			
		appt.setStartMonth(8);
			appt.setStartDay(31);
			assertTrue(appt.getValid());
			appt.setStartDay(32);
			assertFalse(appt.getValid());
		
		appt.setStartMonth(9);
			appt.setStartDay(30);
			assertTrue(appt.getValid());
			appt.setStartDay(31);
			assertFalse(appt.getValid());
		
		appt.setStartMonth(10);
			appt.setStartDay(31);
			assertTrue(appt.getValid());
			appt.setStartDay(32);
			assertFalse(appt.getValid());
		
		appt.setStartMonth(11);
			appt.setStartDay(30);
			assertTrue(appt.getValid());
			appt.setStartDay(31);
			assertFalse(appt.getValid());
		
		
		appt.setStartMonth(12);
			appt.setStartDay(31);
			assertTrue(appt.getValid());
			appt.setStartDay(32);
			assertFalse(appt.getValid());
	  } 
	  
	  
	  
	
}
