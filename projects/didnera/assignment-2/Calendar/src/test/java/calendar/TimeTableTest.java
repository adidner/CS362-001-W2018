package calendar;
/**
 *  This class provides a basic set of test cases for the
 *  TimeTable class.
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;


import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTableTest {



	 @Test
	  public void test00()  throws Throwable  {
	 //testing getApptRange()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
			  
	
			
			 
			 //listAppts.add(appt);
			  
		  // create another appointment
			 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			int[] recurDaysArr5={2,3,4};
			appt.setRecurrence( recurDaysArr5, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 

			 
			 //listAppts.add(appt);
			 // create another appointment
			 startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr2={1,3,4};
			 appt.setRecurrence( recurDaysArr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 
			
			 
			 //listAppts.add(appt);
			 // create another appointment
			 startHour=16;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Visit";
			 description="Visiting my parents!";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr={};
			 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
		  
			
			 listAppts.add(appt);
			
			
		
			 //get a list of appointments for one day, which is today
			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			//GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
			GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay+1);
			tomorrow.add(Calendar.DAY_OF_MONTH,1);
			//String todatDate=today.get(Calendar.MONTH)+ "/"+ today.get(Calendar.DAY_OF_MONTH)+"/"+today.get(Calendar.YEAR);
			//String tomorrowDate=tomorrow.get(Calendar.MONTH)+ "/"+ tomorrow.get(Calendar.DAY_OF_MONTH)+"/"+tomorrow.get(Calendar.YEAR);

			
			
			TimeTable timeTable=new TimeTable();
			//Create a linked list of calendar days to return
			LinkedList<CalDay> calDays = new LinkedList<CalDay>();
			
				
			//getting an overall return null by having a second parameter of 0
			calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			assertEquals(2,timeTable.getApptRange(listAppts, today, tomorrow).size());
	}


	@Test
	  public void test015()  throws Throwable  {
		  //testing getNextApptOccurrence()
		  //pivate, only called by other functions
		  
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			thisDay=28;
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
			int[] recurDaysArrs={1,2,4,5};
			 appt.setRecurrence( recurDaysArrs, Appt.RECUR_BY_WEEKLY, 2, 5);
			 
			 listAppts.add(appt);
			  
		 	
		
			 //get a list of appointments for one day, which is today
			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			//GregorianCalendar tomorrow = (GregorianCalendar)today.clone();
			GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth+1,thisDay+1);
			//tomorrow.add(Calendar.DAY_OF_MONTH,1);
			
			
			
			TimeTable timeTable=new TimeTable();
			//Create a linked list of calendar days to return
			LinkedList<CalDay> calDays = new LinkedList<CalDay>();
			
			calDays = timeTable.getApptRange(listAppts, today, tomorrow); 
			assertEquals(29,timeTable.getApptRange(listAppts, today, tomorrow).size());
	  }
	

	  @Test
	  public void test01()  throws Throwable  {
		  //testing getNextApptOccurrence()
		  //pivate, only called by other functions
		  
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			thisDay=28;
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
			int[] recurDaysArrs={1,2,4,5};
			 appt.setRecurrence( recurDaysArrs, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			 
	
			
			 
			 listAppts.add(appt);
			  
		  // create another appointment
			 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			int[] recurDaysArr5={1,2,3,4};
			appt.setRecurrence( recurDaysArr5, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 

			

			// create another appointment
			 startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr2={1,3,4};
			 appt.setRecurrence( recurDaysArr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			

			 
			 
			 startHour=15;
			 startMinute=30;
			 startDay=thisDay+1;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Birthday Party";
			 description="This is my birthday party.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			int[] recurDaysArrs77={1,2};
			 appt.setRecurrence( recurDaysArrs77, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
	
			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			
			GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth+1,thisDay+1);
			
			
			
			
			TimeTable timeTable=new TimeTable();
			//Create a linked list of calendar days to return
			LinkedList<CalDay> calDays = new LinkedList<CalDay>();
			
			calDays = timeTable.getApptRange(listAppts, today, tomorrow); 
			assertEquals(29,timeTable.getApptRange(listAppts, today, tomorrow).size());
	  }
	  @Test
	  public void test011()  throws Throwable  {
		  		  
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			thisDay=20;
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
			int[] recurDaysArrs={};
			 appt.setRecurrence( recurDaysArrs, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			 
	
			
			 
			 listAppts.add(appt);
			 listAppts.add(appt);
			 
			
			
		
			 //get a list of appointments for one day, which is today
			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth+1,thisDay+7);
			
			TimeTable timeTable=new TimeTable();
			
			//Create a linked list of calendar days to return
			LinkedList<CalDay> calDays = new LinkedList<CalDay>();
			
			 
	  }
	  @Test
	  public void test02()  throws Throwable  {
		  //testing permute()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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

			
			 
			 listAppts.add(appt);
			  
		  // create another appointment
			 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			int[] recurDaysArr5={2,3,4};
			appt.setRecurrence( recurDaysArr5, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			 
			 listAppts.add(appt);
			 
			 
			 
			 // create another appointment
			 startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr2={2,3,4};
			 appt.setRecurrence( recurDaysArr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 
			
			 
			 listAppts.add(appt);
			 // create another appointment
			 startHour=16;
			 startMinute=30;
			 startDay=thisDay+1;		
			 startMonth=thisMonth+1;	
			 startYear=thisYear;	
			 title="Visit";
			 description="Visiting my parents!";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr={2,3,4};
			 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
		  
			 listAppts.add(appt);
			
			
			
			TimeTable timeTable=new TimeTable();
			
			int[] pv = {0,0,2,1};
			timeTable.permute(listAppts,pv);
			assertEquals(4,timeTable.permute(listAppts,pv).size());
			//assertNotNull(timeTable.permute(listAppts,pv));
			
	  }
	  @Test(expected=IllegalArgumentException.class)
	  public void test021()  throws Throwable  {
		  //testing permute()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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

			
			 
			 listAppts.add(appt);
			  
		  // create another appointment
			 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			int[] recurDaysArr5={2,3,4};
			appt.setRecurrence( recurDaysArr5, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			 
			 listAppts.add(appt);
			 
			 
			 
			 // create another appointment
			 startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr2={2,3,4};
			 appt.setRecurrence( recurDaysArr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 
			
			 
			 listAppts.add(appt);
			 // create another appointment
			 startHour=16;
			 startMinute=30;
			 startDay=thisDay+1;		
			 startMonth=thisMonth+1;	
			 startYear=thisYear;	
			 title="Visit";
			 description="Visiting my parents!";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr={2,3,4};
			 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
		  
			 listAppts.add(appt);
			
			
			
			TimeTable timeTable=new TimeTable();
			
			//throws the illegalArgument Exception in permute()
			//because wrong size of array
			int[] pv = {0,0,1};
			timeTable.permute(listAppts,pv);
	  }
	  
	  @Test
	  public void test04()  throws Throwable  {
		  //testing getApptRange()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
			  
	
			
			 
			 listAppts.add(appt);
			  
		  // create another appointment
			 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			int[] recurDaysArr5={2,3,4};
			appt.setRecurrence( recurDaysArr5, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 

			 
			 listAppts.add(appt);
			 // create another appointment
			 startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr2={2,3,4};
			 appt.setRecurrence( recurDaysArr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 
			
			 
			 listAppts.add(appt);
			 // create another appointment
			 startHour=16;
			 startMinute=30;
			 startDay=thisDay+1;		
			 startMonth=thisMonth+1;	
			 startYear=thisYear;	
			 title="Visit";
			 description="Visiting my parents!";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr={2,3,4};
			 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
		  
			 appt.toString();
			 listAppts.add(appt);
			
			
		

			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay+1);
			tomorrow.add(Calendar.DAY_OF_MONTH,1);
			
			
			
			TimeTable timeTable=new TimeTable();
			LinkedList<CalDay> calDays = new LinkedList<CalDay>();

			
			
			calDays = new LinkedList<CalDay>();
			calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			for (int i = 0; i < calDays.size(); i++)
				calDays.get(i).toString();
			
			 
			
			calDays.get(0).getSizeAppts();
			
			
			
			//Testing an invalid appt
			appt.setStartHour(300);
			listAppts.add(appt);
			calDays = timeTable.getApptRange(listAppts, today, tomorrow);
			assertNotNull(timeTable.getApptRange(listAppts, today, tomorrow));
			
			
			//getApptOccurences can't actually ever check if the first and 
			//last day its passed are in order because the getApptRange function
			//which calls it already checks that and throws a DateOutOfRangeException if that happens
			
			
			
			startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr7={};
			 appt.setRecurrence( recurDaysArr7, 0, 2, Appt.RECUR_NUMBER_FOREVER);
			
			  LinkedList<Appt> listAppts3 = new LinkedList<Appt>();
			 
			 
			 listAppts3.add(appt);
			
			
			//getting an overall return null by having a second parameter of 0
			calDays = timeTable.getApptRange(listAppts3, today, tomorrow);
			assertEquals(2,timeTable.getApptRange(listAppts3, today, tomorrow).size());
			
			
		  
	  }
	  @Test(expected=DateOutOfRangeException.class)
	  public void test042()  throws Throwable  {
		  //testing getApptRange()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
			 
			 listAppts.add(appt);
			  
		
			GregorianCalendar today = new GregorianCalendar(thisYear,thisMonth,thisDay);
			GregorianCalendar tomorrow = new GregorianCalendar(thisYear,thisMonth,thisDay+1);
			tomorrow.add(Calendar.DAY_OF_MONTH,1);
			
			
			
			TimeTable timeTable=new TimeTable();
			//Create a linked list of calendar days to return
			LinkedList<CalDay> calDays = new LinkedList<CalDay>();

			
			
			//getApptOccurences can't actually ever check if the first and 
			//last day its passed are in order because the getApptRange function
			//which calls it already checks that and throws a DateOutOfRangeException if that happens
			calDays = timeTable.getApptRange(listAppts, tomorrow, today);
			
		  
	  }
	  
	  @Test
	  public void test05()  throws Throwable  {
		  //testing deleteAppt()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = rightnow.get(Calendar.MONTH)+1;
			thisYear = rightnow.get(Calendar.YEAR);
			thisDay = rightnow.get(Calendar.DAY_OF_MONTH);
			
			 int startHour=15;
			 int startMinute=30;
			 int startDay=thisDay+1;  	
			 int startMonth=thisMonth; 	
			 int startYear=thisYear; 	
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
			 
			 listAppts.add(appt);
			  
			 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			int[] recurDaysArr5={2,3,4};
			appt.setRecurrence( recurDaysArr5, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 listAppts.add(appt);
			 
			 startHour=13;
			 startMinute=30;
			 startDay=thisDay;		
			 startMonth=thisMonth;	
			 startYear=thisYear;	
			 title="Meeting Today";
			 description="Meeting with the students.";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr2={2,3,4};
			 appt.setRecurrence( recurDaysArr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 listAppts.add(appt);
			 
			 
			 // create another appointment
			 startHour=16;
			 startMinute=30;
			 startDay=thisDay+1;		
			 startMonth=thisMonth+1;	
			 startYear=thisYear;	
			 title="Visit";
			 description="Visiting my parents!";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr={2,3,4};
			 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 listAppts.add(appt);
						
			 TimeTable timeTable=new TimeTable();
			
			
			//delete a particular appointment from the list
			
				listAppts.get(2);
			
			LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(2));
			 assertEquals(3,listDeletedAppts.size());
			
			//testing delete casses null
			 LinkedList<Appt> anothertest=timeTable.deleteAppt(null, null);
			 assertNull(timeTable.deleteAppt(null, null));
			 LinkedList<Appt> anothertest1=timeTable.deleteAppt(listAppts, null);
			 assertNull(timeTable.deleteAppt(listAppts, null));
			 LinkedList<Appt> anothertest2=timeTable.deleteAppt(null, listAppts.get(2));
			 assertNull(timeTable.deleteAppt(null, listAppts.get(2)));
			 
			 
			 //delete cases invalid appt
			 listAppts.get(2).setStartHour(300);
			 LinkedList<Appt> anothertest3=timeTable.deleteAppt(listAppts, listAppts.get(2));
			 assertNull(timeTable.deleteAppt(listAppts, listAppts.get(2)));
			 
			  // create another appointment
			 startHour=16;
			 startMinute=30;
			 startDay=thisDay+1;		
			 startMonth=thisMonth+1;	
			 startYear=thisYear;	
			 title="Visit";
			 description="Visiting my parents!";
			 //Construct a new Appointment object with the initial data	 
			 appt = new Appt(startHour,
					  startMinute ,
					  startDay ,
					  startMonth ,
					  startYear ,
					  title,
					 description);
			 int[] recurDaysArr12={2,3,4};
			 appt.setRecurrence( recurDaysArr12, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			 
			 //passing an app that isn't in the list 
			 LinkedList<Appt> anothertest5=timeTable.deleteAppt(listAppts, appt);
			 assertNull(timeTable.deleteAppt(listAppts, appt));
			 
			 
			 TimeTable timeTable2=new TimeTable();
			

			//passing an empty appt list
			 LinkedList<Appt> listApptsEmpty = new LinkedList<Appt>();
			 //listApptsEmpty.add(appt);
			 LinkedList<Appt> anothertest12=timeTable2.deleteAppt(listApptsEmpty, appt);
			 assertNull(timeTable2.deleteAppt(listApptsEmpty, appt));
			
	  }
		
		
}
//add more unit tests as you needed

