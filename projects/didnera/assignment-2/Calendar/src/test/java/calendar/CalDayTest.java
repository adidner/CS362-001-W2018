package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  CalDay class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalDayTest {

	
	@Test
	  public void test01()  throws Throwable  {
		  //testing the defualt constructor for CalDay
		  CalDay newCalDay = new CalDay();
		  assertFalse(newCalDay.isValid());
		  
	}
	
	@Test
	  public void test02()  throws Throwable  {
		  //creating a gregorianCalendar
		  GregorianCalendar aday = new GregorianCalendar(2001,11,29);
		  
		  //Creating a valid CalDay object
		  CalDay anotherCalDay = new CalDay(aday);
		  assertEquals(anotherCalDay.getYear(),2001);
		  assertEquals(anotherCalDay.getMonth(),11);
		  assertEquals(anotherCalDay.getDay(),29);
		  assertTrue(anotherCalDay.isValid());
	}
	
	@Test
	  public void test03()  throws Throwable  {

		  GregorianCalendar aday = new GregorianCalendar(2001,11,29);
		  CalDay anotherCalDay = new CalDay(aday);
		 	  
		 int startHour=14;
		 int startMinute=30;
		 int startDay=10;  	
		 int startMonth=10; 	
		 int startYear=10; 	
		 String title="Class";
		 String description="Rescheduled class.";
        Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
        
		//test the addAppt function
		 anotherCalDay.addAppt(appt);
		 LinkedList<Appt> test = new LinkedList<Appt>();
		 test.add(appt);
		 assertEquals(anotherCalDay.getAppts(),test);
		 
		 
		 //
		 appt.setStartHour(500);
		 anotherCalDay.addAppt(appt);
		 assertEquals(anotherCalDay.getAppts(),test);
		 
		 appt.setStartHour(15);
		 anotherCalDay.addAppt(appt);
		 test.add(appt);
		 assertEquals(anotherCalDay.getAppts(),test);
		
		  
	}
	
	@Test
	  public void test04()  throws Throwable  {
		 
		 CalDay newCalDay = new CalDay();
		 GregorianCalendar aday = new GregorianCalendar(2001,11,29);
		 CalDay anotherCalDay = new CalDay(aday);

		 int startHour=14;
		 int startMinute=30;
		 int startDay=10;  	
		 int startMonth=10; 	
		 int startYear=10; 	
		 String title="Class";
		 String description="Rescheduled class.";
        Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
        
		 
		//creating an invalid iterator
		assertEquals(newCalDay.iterator(),null);
		
		//creating a valid iterator
		anotherCalDay.iterator();
		assertNotNull(anotherCalDay.iterator());	  
	}
	
	@Test
	  public void test05()  throws Throwable  {
		 GregorianCalendar aday = new GregorianCalendar(2001,11,29);	  
		 
		  CalDay anotherCalDay = new CalDay(aday);
		  		  
		  
		 int startHour=14;
		 int startMinute=30;
		 int startDay=10;  	
		 int startMonth=10; 	
		 int startYear=10; 	
		 String title="Class";
		 String description="Rescheduled class.";
        Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
        
		/*  appt.setStartHour(55);		  
		  anotherCalDay.addAppt(appt);
		  appt.setStartHour(10);
		  anotherCalDay.addAppt(appt);
		  appt.setStartHour(11);
		  anotherCalDay.addAppt(appt);
		  appt.setStartHour(22);
		  anotherCalDay.addAppt(appt);
		  
		   appt.setStartHour(55);		  
		  anotherCalDay.addAppt(appt);
		  appt.setStartHour(10);
		  anotherCalDay.addAppt(appt);
		  appt.setStartHour(11);
		  anotherCalDay.addAppt(appt);
		  appt.setStartHour(22);
		  anotherCalDay.addAppt(appt); */
		 
		  
	}
	
	
	@Test
	  public void test06()  throws Throwable  {
		 GregorianCalendar aday = new GregorianCalendar(2001,11,29);	  
		 
		  CalDay anotherCalDay = new CalDay(aday);
		
			CalDay fake = new CalDay();
			
		  
		 int startHour=14;
		 int startMinute=30;
		 int startDay=10;  	
		 int startMonth=10; 	
		 int startYear=10; 	
		 String title="Class";
		 String description="Rescheduled class.";
        Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
        
		//testing toString()
		assertEquals(anotherCalDay.toString(),"\t --- 11/29/2001 --- \n --- -------- Appointments ------------ --- \n\n");
		
		//toString on a null CalDay
		fake.toString();
	}
	
	
//add more unit tests as you needed	
}
