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
		 
		 
		 
		 appt.setStartHour(500);
		 anotherCalDay.addAppt(appt);
		 assertEquals(anotherCalDay.getAppts(),test);
		 assertEquals(anotherCalDay.getAppts().get(0),appt);
		 
		 appt.setStartHour(15);
		 anotherCalDay.addAppt(appt);
		 test.add(appt);
		 assertEquals(anotherCalDay.getAppts(),test);
		 assertEquals(anotherCalDay.getAppts().get(0),appt);
		 
		 appt.setStartHour(23);
		 anotherCalDay.addAppt(appt);
		 test.add(appt);
		 assertEquals(anotherCalDay.getAppts(),test);
		 assertEquals(anotherCalDay.getAppts().get(0).getStartHour(),23);
		assertEquals(anotherCalDay.getAppts().get(1).getStartHour(),23);
		assertEquals(anotherCalDay.getAppts().get(2).getStartHour(),23);
		  
		 //testing appt.size()
		assertEquals(anotherCalDay.getSizeAppts(),3);
	}
	
	
	@Test
	  public void test032()  throws Throwable  {

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
        
		int startHour2=23;
		 int startMinute2=31;
		 int startDay2=23;  	
		 int startMonth2=11; 	
		 int startYear2=11; 	
		 String title2="Class";
		 String description2="Rescheduled class.";
        Appt appt2 = new Appt(startHour2,startMinute2,startDay2,startMonth2,startYear2,title2,description2);
        
		int startHour3=15;
		 int startMinute3=31;
		 int startDay3=22;  	
		 int startMonth3=11; 	
		 int startYear3=11; 	
		 String title3="Class";
		 String description3="Rescheduled class.";
        Appt appt3 = new Appt(startHour3,startMinute3,startDay3,startMonth3,startYear3,title3,description3);
        
		int startHour4=15;
		 int startMinute4=31;
		 int startDay4=22;  	
		 int startMonth4=11; 	
		 int startYear4=11; 	
		 String title4="Class";
		 String description4="Rescheduled class.";
        Appt appt4 = new Appt(startHour4,startMinute4,startDay4,startMonth4,startYear4,title4,description4);
        
		int startHour45=15;
		 int startMinute45=31;
		 int startDay45=22;  	
		 int startMonth45=11; 	
		 int startYear45=11; 	
		 String title45="Class";
		 String description45="Rescheduled class.";
        Appt appt45 = new Appt(startHour45,startMinute45,startDay45,startMonth45,startYear45,title45,description45);
        
		int startHour5=15;
		 int startMinute5=31;
		 int startDay5=22;  	
		 int startMonth5=11; 	
		 int startYear5=11; 	
		 String title5="Class";
		 String description5="Rescheduled class.";
        Appt appt5 = new Appt(startHour5,startMinute5,startDay5,startMonth5,startYear5,title5,description5);
        
				 
		 	 
		 appt.setStartHour(15);
		 anotherCalDay.addAppt(appt);
		 assertEquals(anotherCalDay.getAppts().get(0).getStartHour(),15);
		 
		 appt2.setStartHour(21);
		 anotherCalDay.addAppt(appt2);
		 assertEquals(anotherCalDay.getAppts().get(0).getStartHour(),15);
		 assertEquals(anotherCalDay.getAppts().get(1).getStartHour(),21);
		
		appt5.setStartHour(19);
		anotherCalDay.addAppt(appt5);
		assertEquals(anotherCalDay.getAppts().get(0).getStartHour(),15);
		assertEquals(anotherCalDay.getAppts().get(1).getStartHour(),19);
		assertEquals(anotherCalDay.getAppts().get(2).getStartHour(),21);

		
		 appt3.setStartHour(23);
		 anotherCalDay.addAppt(appt3);
		 assertEquals(anotherCalDay.getAppts().get(0).getStartHour(),15);
		 assertEquals(anotherCalDay.getAppts().get(1).getStartHour(),19);
		 assertEquals(anotherCalDay.getAppts().get(2).getStartHour(),21);
		 assertEquals(anotherCalDay.getAppts().get(3).getStartHour(),23);
		
		 
		 
		 appt4.setStartHour(20);
		 anotherCalDay.addAppt(appt4);
		 assertEquals(anotherCalDay.getAppts().get(0).getStartHour(),15);
		 assertEquals(anotherCalDay.getAppts().get(1).getStartHour(),19);
		 assertEquals(anotherCalDay.getAppts().get(2).getStartHour(),20);		 
		 assertEquals(anotherCalDay.getAppts().get(3).getStartHour(),21);
		 assertEquals(anotherCalDay.getAppts().get(4).getStartHour(),23);
		 
		 //pass in another 20 and a 19 to try and kill it
		
		appt45.setStartHour(20);
		anotherCalDay.addAppt(appt45);
		assertEquals(anotherCalDay.getAppts().get(0).getStartHour(),15);
		assertEquals(anotherCalDay.getAppts().get(1).getStartHour(),19);
		assertEquals(anotherCalDay.getAppts().get(2).getStartHour(),20);
		assertEquals(anotherCalDay.getAppts().get(3).getStartHour(),20);
		assertEquals(anotherCalDay.getAppts().get(4).getStartHour(),21);
		assertEquals(anotherCalDay.getAppts().get(5).getStartHour(),23);
		 
		 
		
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
		
		
		anotherCalDay.addAppt(appt);
		anotherCalDay.toString();
	}
	
	
//add more unit tests as you needed	
}
