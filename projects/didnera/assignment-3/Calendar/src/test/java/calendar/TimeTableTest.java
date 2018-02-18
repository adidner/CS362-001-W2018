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
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,8);	
		GregorianCalendar later = new GregorianCalendar(2018,02,15);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Testing2","testDay2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Testing3","testDay3");
		 
		 int [] rec_arr = {2,3,4}; 
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt3.setRecurrence(rec_arr,Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);	
		 
			
		//getting an overall return null by having a second parameter of 0
		calDays = timeTable.getApptRange(listAppts, now, later);
	}
	
	@Test
	  public void test000()  throws Throwable  {
	 //testing getApptRange()
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,8);	
		GregorianCalendar later = new GregorianCalendar(2018,02,15);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt15 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Testing2","testDay2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Testing3","testDay3");
		 
		 int [] rec_arr = {2,3,4}; 
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 2, 3);
		 appt15.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 2, 3);
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 2, 3);
		 appt3.setRecurrence(rec_arr,Appt.RECUR_BY_YEARLY, 2, 3);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt15);
		 listAppts.add(appt2);
		 listAppts.add(appt3);	
		 
			
		//getting an overall return null by having a second parameter of 0
		calDays = timeTable.getApptRange(listAppts, now, later);
	}
	
	
	@Test
	  public void test0017()  throws Throwable  {
	 //testing getApptRange()
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,8);	
		GregorianCalendar later = new GregorianCalendar(2018,02,22);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt15 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt17 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Testing2","testDay2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Testing3","testDay3");
		 
		 int [] rec_arr = {2,3,4}; 
		 int [] newy = new int[0];
						//array of days, //how often    //       //num recurrances
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 1, 3);
		 appt15.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 1, 3);
		 appt17.setRecurrence(newy, Appt.RECUR_BY_WEEKLY, 1, 3);
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 1, 3);
		 appt3.setRecurrence(rec_arr,Appt.RECUR_BY_YEARLY, 1, 3);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt15);
		 //listAppts.add(appt17);
		  listAppts.add(appt2);
		  listAppts.add(appt3); 	
		 
			
		//getting an overall return null by having a second parameter of 0
		calDays = timeTable.getApptRange(listAppts, now, later);
		assertEquals(calDays.size(),14);
		assertEquals(calDays.get(0).getSizeAppts(),0);
		assertEquals(calDays.get(1).getSizeAppts(),0);
		assertEquals(calDays.get(2).getSizeAppts(),0);
		assertEquals(calDays.get(3).getSizeAppts(),0);
		assertEquals(calDays.get(4).getSizeAppts(),0);
		assertEquals(calDays.get(5).getSizeAppts(),0);
		assertEquals(calDays.get(6).getSizeAppts(),0);
		assertEquals(calDays.get(7).getSizeAppts(),0);
		assertEquals(calDays.get(8).getSizeAppts(),0);
		assertEquals(calDays.get(9).getSizeAppts(),0);
		assertEquals(calDays.get(10).getSizeAppts(),0);
		assertEquals(calDays.get(11).getSizeAppts(),0);
		assertEquals(calDays.get(12).getSizeAppts(),0);	
		assertEquals(calDays.get(13).getSizeAppts(),0);	
		
		
		/* TimeTable timetable = new TimeTable();
		
		LinkedList<CalDay> eventList = timetable.getApptRange(listAppts,now,later); // appts is the Linkedlist instance.
		CalDay eventFromList = eventList.get(0);
		assertTrue(eventFromList.getAppts().contains(appt1));
		assertTrue(eventFromList.getAppts().contains(appt2));
		try {
			timetable.getApptRange(listAppts, later, now);
		} catch (DateOutOfRangeException x) {
			assertTrue(x.getMessage().contains("Exception"));
		} */
		
	} 
	
	
	@Test
	  public void test00177()  throws Throwable  {
	 //testing getApptRange()
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,1);	
		GregorianCalendar later = new GregorianCalendar(2022,10,12);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt15 = new Appt(12,45,03,01,2018,"Tester","testDay1");
		 Appt appt17 = new Appt(12,45,02,9,2018,"Tester","testDay1");
		 Appt appt2 = new Appt(17,02,05,4,2018,"Testing2","testDay2");
		 Appt appt3 = new Appt(21,30,07,12,2018,"Testing3","testDay3");
		 Appt appt21 = new Appt(17,02,05,4,2018,"Testing2","testDay2");
		 Appt appt31 = new Appt(21,30,07,12,2018,"Testing3","testDay3");
		 
		 int [] rec_arr = {2,3,4}; 
		 int [] rec_arr2 = {1};
		 int [] newy = new int[0];
						//array of days, //how often    //       //num recurrances
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 1, 4);
		 appt15.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 1, 4);
		 appt17.setRecurrence(newy, Appt.RECUR_BY_WEEKLY, 1, 2);
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 1, 3);
		 appt3.setRecurrence(rec_arr2,Appt.RECUR_BY_YEARLY, 1, 3);
		 appt21.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 1, 0);
		 appt31.setRecurrence(rec_arr2,Appt.RECUR_BY_YEARLY, 1, 12);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt15);
		 listAppts.add(appt17);
		 listAppts.add(appt2);
		 listAppts.add(appt3); 	
		 listAppts.add(appt21);
		 //listAppts.add(appt31); 	
		 
			
		//getting an overall return null by having a second parameter of 0
		calDays = timeTable.getApptRange(listAppts, now, later);
		assertEquals(calDays.size(),1717);
		  
		assertEquals(calDays.get(65).getSizeAppts(),2);
		assertEquals(calDays.get(96).getSizeAppts(),1);
		assertEquals(calDays.get(126).getSizeAppts(),1);
		assertEquals(calDays.get(157).getSizeAppts(),1);
		assertEquals(calDays.get(215).getSizeAppts(),1);
		assertEquals(calDays.get(222).getSizeAppts(),1);
		assertEquals(calDays.get(229).getSizeAppts(),1);
		assertEquals(calDays.get(312).getSizeAppts(),1); 
		assertEquals(calDays.get(677).getSizeAppts(),1);
		assertEquals(calDays.get(1043).getSizeAppts(),1);
		assertEquals(calDays.get(1408).getSizeAppts(),1);
		for(int i =0; i< calDays.size();i++){
			//System.out.println(i);
			if(i!=65 && i!=96 && i!=126 && i!=157 && i!=215 && i!=222 && i!=229 && i!=312 && i!=677 && i!=1043 && i!=1408){
				assertEquals(calDays.get(i).getSizeAppts(),0);
			}			
		} 
		
	} 
	
	
	@Test
	  public void test0017712()  throws Throwable  {
	 //testing getApptRange()
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,1);	
		GregorianCalendar later = new GregorianCalendar(2018,02,7);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,01,02,2018,"Tester","testDay1");
		 Appt appt15 = new Appt(12,45,01,02,2018,"Tester","testDay1");
		 
		 
		 int [] rec_arr = {2,3,4}; 
		 int [] rec_arr2 = {1};
		 int [] newy = new int[0];
		 
		 listAppts.add(appt1);
		 listAppts.add(appt15);
		  	
		 
			
		//getting an overall return null by having a second parameter of 0
		calDays = timeTable.getApptRange(listAppts, now, later);
		assertEquals(calDays.size(),6);
		  
		//assertEquals(calDays.get(0).getSizeAppts(),1);
		//assertEquals(calDays.get(3).getSizeAppts(),1);
		for(int i =0; i< calDays.size();i++){
			//System.out.println(i);
			if(i!=0 && i!=3){
				assertEquals(calDays.get(i).getSizeAppts(),0);
			}			
		}  
		
	} 
	
	@Test
	  public void test001779()  throws Throwable  {
	 //testing getApptRange()
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2017,02,1);	
		GregorianCalendar later = new GregorianCalendar(2020,10,12);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt15 = new Appt(12,45,03,01,2018,"Tester","testDay1");
		 
		 
		 int [] rec_arr = {2,3,4}; 
		 int [] rec_arr2 = {1};
		 
						//array of days, //how often    //       //num recurrances
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 1, 4);
		 appt15.setRecurrence(rec_arr2, Appt.RECUR_BY_WEEKLY, 2, 3);
		 
		 
		 listAppts.add(appt1);
		 listAppts.add(appt15);
			
		 
			
		//getting an overall return null by having a second parameter of 0
		calDays = timeTable.getApptRange(listAppts, now, later);
		assertEquals(calDays.size(),1352);
		
		
		
		
		assertEquals(calDays.get(339).getSizeAppts(),1);
		assertEquals(calDays.get(340).getSizeAppts(),1);
		assertEquals(calDays.get(341).getSizeAppts(),0);
		assertEquals(calDays.get(347).getSizeAppts(),1);
		assertEquals(calDays.get(354).getSizeAppts(),1);
		for(int i =0; i< calDays.size();i++){
			//System.out.println(i);
			if(i!=339 && i!=340 && i!=341 && i!=347 && i!=354){
				assertEquals(calDays.get(i).getSizeAppts(),0);
			}			
		}  
		
	} 


		@Test
	  public void test07()  throws Throwable  {
	 //testing getApptRange()
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,8);	
		GregorianCalendar later = new GregorianCalendar(2018,02,25);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(1222,45,04,02,2018,"Tester","testDay1");
		 Appt appt2 = new Appt(1722,02,06,02,2018,"Testing2","testDay2");
		 Appt appt3 = new Appt(2122,30,06,02,2018,"Testing3","testDay3");
		 
		 int [] rec_arr = {2,3,4}; 
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 2, 5);
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 2, 9);
		 appt3.setRecurrence(rec_arr,Appt.RECUR_BY_YEARLY, 2, 2);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);	
		 
		calDays = timeTable.getApptRange(listAppts, now, later);
		//not valid appst?
		//assertEquals(0,calDays.get(0).getAppts().get(2).getstartHour());
		assertEquals(calDays.get(1).getSizeAppts(),0);
		
		//trying to target line number 55 in timetable
	}

	
	 
	  @Test(expected=DateOutOfRangeException.class)
	  public void test042()  throws Throwable  {
		  //testing getApptRange()
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,8);	
		GregorianCalendar later = new GregorianCalendar(2018,02,15);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Testing2","testDay2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Testing3","testDay3");
		 
		 int [] rec_arr = {2,3,4}; 
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt3.setRecurrence(rec_arr,Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);	
			  
			
			
			//getApptOccurences can't actually ever check if the first and 
			//last day its passed are in order because the getApptRange function
			//which calls it already checks that and throws a DateOutOfRangeException if that happens
			calDays = timeTable.getApptRange(listAppts, later, now);
	  }
	  
	  
	  @Test //delete
	  public void test05()  throws Throwable  {
		  //testing deleteAppt()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = 2+1;
			thisYear = 2018;
			thisDay = 6;
			
			
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
			 assertEquals(listDeletedAppts.get(0).getStartHour(),15);
			 assertEquals(listDeletedAppts.get(1).getStartHour(),14);
			 assertEquals(listDeletedAppts.get(2).getStartHour(),16);
			 
			
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
		
		
	 @Test(expected=IllegalArgumentException.class)//permute
	  public void test021()  throws Throwable  {
		  //testing permute()
		 
		LinkedList<Appt> listAppts = new LinkedList<Appt>();
		TimeTable timeTable = new TimeTable();
		LinkedList<CalDay> calDays = new LinkedList<CalDay>();
		
		GregorianCalendar now = new GregorianCalendar(2018,02,8);	
		GregorianCalendar later = new GregorianCalendar(2018,02,15);	
		
						   //hr,min,day,mon,yr,title,desc
		 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
		 Appt appt2 = new Appt(17,02,06,02,2018,"Testing2","testDay2");
		 Appt appt3 = new Appt(21,30,06,02,2018,"Testing3","testDay3");
		 
		 int [] rec_arr = {2,3,4}; 
		 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt2.setRecurrence(rec_arr,Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 appt3.setRecurrence(rec_arr,Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
		 
		 listAppts.add(appt1);
		 listAppts.add(appt2);
		 listAppts.add(appt3);	
			
			//throws the illegalArgument Exception in permute()
			//because wrong size of array
			int[] pv = {0,1};
			timeTable.permute(listAppts,pv);
	  }	
		
	 @Test //also permute
	  public void test02()  throws Throwable  {
		  //testing permute()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
			//get todays date
			Calendar rightnow = Calendar.getInstance();
			//current month/year/date is today
			thisMonth = 2+1;
			thisYear = 2018;
			thisDay = 6;
			
			
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
			//TimeTable timeTableMod=new TimeTable();
			 LinkedList<Appt> modlist = new LinkedList<Appt>();
			
			int[] pv = {2,1,0,3};
			assertEquals(listAppts.get(0).getStartHour(), 15);
			assertEquals(listAppts.get(1).getStartHour(), 14);
			assertEquals(listAppts.get(2).getStartHour(), 13);
			assertEquals(listAppts.get(3).getStartHour(), 16);
			modlist=timeTable.permute(listAppts,pv);
			assertEquals(modlist.get(0).getStartHour(), 15);
			assertEquals(modlist.get(1).getStartHour(), 14);
			assertEquals(modlist.get(2).getStartHour(), 13);
			assertEquals(modlist.get(3).getStartHour(), 16);
			
			
			
			//assertNotNull(timeTable.permute(listAppts,pv));	
	  }	
}
//add more unit tests as you needed

 