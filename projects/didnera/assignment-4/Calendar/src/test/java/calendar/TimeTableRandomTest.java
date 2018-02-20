package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	
	long randomseed =System.currentTimeMillis(); //10
    Random random = new Random(randomseed);
	
	public int[] chooserecurance(){
		
		int choice=ValuesGenerator.getRandomIntBetween(random,0,3);
		if(choice==0){
			 int [] rec_arr = {2,3,4}; 
			 return rec_arr;
		}
		else if(choice==1){
				 int [] rec_arr2 = {1};
				 return rec_arr2;
		}
		else{
			 int [] newy = new int[0];
			 return newy;
		}
	}
    /**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		 long randomseed =System.currentTimeMillis(); //10
		Random random = new Random(randomseed);
		 for(int i = 0; i < 1000;i++){
				LinkedList<Appt> listAppts = new LinkedList<Appt>();
				TimeTable timeTable = new TimeTable();
				LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				
				GregorianCalendar now = new GregorianCalendar(2018,02,1);	
				GregorianCalendar later = new GregorianCalendar(2022,10,12);	
				
				int randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
				int randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
				int randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
				int randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
								   //hr,min,day,mon,yr,title,desc
				 Appt appt1 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Tester","testDay1");
				 
				randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
				randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
				randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
				randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
				 Appt appt17 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Tester","testDay1");
				 
				randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
				randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
				randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
				randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
				 Appt appt2 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing2","testDay2");
				 
				randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
				randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
				randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
				randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
				 Appt appt3 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing3","testDay3");
				 
				randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
				randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
				randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
				randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
				 Appt appt21 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing2","testDay2");
				 
				randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
				randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
				randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
				randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
				 Appt appt31 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing3","testDay3");
				 
				 int [] rec_arr = {2,3,4}; 
				 int [] rec_arr2 = {1};
				 int [] newy = new int[0];
				 
				 appt1.setRecurrence(chooserecurance(), Appt.RECUR_BY_WEEKLY, 1, 4);
				 appt17.setRecurrence(chooserecurance(), Appt.RECUR_BY_WEEKLY, 1, 2);
				 appt2.setRecurrence(chooserecurance(),Appt.RECUR_BY_MONTHLY, 1, 3);
				 appt3.setRecurrence(chooserecurance(),Appt.RECUR_BY_YEARLY, 1, 3);
				 appt21.setRecurrence(chooserecurance(),Appt.RECUR_BY_MONTHLY, 1, 0);
				 appt31.setRecurrence(chooserecurance(),Appt.RECUR_BY_YEARLY, 1, 12);
				 
				 listAppts.add(appt1);
				 listAppts.add(appt17);
				 listAppts.add(appt2);
				 listAppts.add(appt3); 	
				 listAppts.add(appt21);
				 calDays = timeTable.getApptRange(listAppts, now, later);
		 }
	 }
	 
	 @Test (expected=DateOutOfRangeException.class)
	  public void radnomtestErrorExpected()  throws Throwable  {
		 long randomseed =System.currentTimeMillis(); //10
		Random random = new Random(randomseed);
		 for(int i = 0; i < 100;i++){
				LinkedList<Appt> listAppts = new LinkedList<Appt>();
				TimeTable timeTable = new TimeTable();
				LinkedList<CalDay> calDays = new LinkedList<CalDay>();
				
				GregorianCalendar now = new GregorianCalendar(2018,02,1);	
				GregorianCalendar later = new GregorianCalendar(2022,10,12);	
				
								   //hr,min,day,mon,yr,title,desc
				 Appt appt1 = new Appt(12,45,04,02,2018,"Tester","testDay1");
				 
				 int [] rec_arr = {2,3,4}; 
				 int [] rec_arr2 = {1};
				 int [] newy = new int[0];
								//array of days, //how often    //       //num recurrances
				 appt1.setRecurrence(rec_arr, Appt.RECUR_BY_WEEKLY, 1, 4);
				 
				 listAppts.add(appt1);
				 calDays = timeTable.getApptRange(listAppts, later, now);
		 }
	 }

		 @Test 
	  public void radnomtestDelete()  throws Throwable  {
		 long randomseed =System.currentTimeMillis(); //10
		Random random = new Random(randomseed);
		 for(int i = 0; i < 9000;i++){
				//testing deleteAppt()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
								//hr,min,day,mon,yr,title,desc
			int randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			int randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
			int randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			int randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
							   //hr,min,day,mon,yr,title,desc
			 Appt appt1 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Tester","testDay1");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
			randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
			 Appt appt17 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Tester","testDay1");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
			randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
			 Appt appt2 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing2","testDay2");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
			randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
			 Appt appt3 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing3","testDay3");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomhour=ValuesGenerator.getRandomIntBetween(random,-2,26);
			randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			randomday=ValuesGenerator.getRandomIntBetween(random,-1,31);
			 Appt appt21 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing2","testDay2");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomhour=ValuesGenerator.getRandomIntBetween(random,1,26);
			randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			randomday=ValuesGenerator.getRandomIntBetween(random,1,20);
			 Appt appt31 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing3","testDay3");
			  
			 
			int[] recurDaysArr5={2,3,4};
			appt1.setRecurrence( recurDaysArr5, Appt.RECUR_BY_YEARLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			int[] recurDaysArr2={2,3,4};
			appt2.setRecurrence( recurDaysArr2, Appt.RECUR_BY_MONTHLY, 2, Appt.RECUR_NUMBER_FOREVER);
						 			 
			int[] recurDaysArr={2,3,4};
			appt3.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 int[] recurDaysArr31={2,3,4};
			 appt31.setRecurrence( recurDaysArr31, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			listAppts.add(appt1);
			listAppts.add(appt17);
			listAppts.add(appt2);
			listAppts.add(appt3); 	
			listAppts.add(appt21);
			
			 TimeTable timeTable=new TimeTable();
			
			
			//delete a particular appointment from the list
			LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(0));
			
			 /* int counter=0;
			 if(appt1.getValid()){
				 counter++;
			 }
			 if(appt17.getValid()){
				 counter++;
			 }
			if(appt2.getValid()){
				counter++;
			}
			if(appt21.getValid()){
				counter++;
			}
			if(appt3.getValid()){
				counter++;
			}
			if(counter>1){
				counter--;
			}
			 assertEquals(counter,listDeletedAppts.size()); */
			 
			
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
			 
			 
			 //passing an app that isn't in the list 
			 LinkedList<Appt> anothertest5=timeTable.deleteAppt(listAppts, appt31);
			  assertNull(timeTable.deleteAppt(listAppts, appt31));
			 
			 
			 TimeTable timeTable2=new TimeTable();
			

			//passing an empty appt list
			 LinkedList<Appt> listApptsEmpty = new LinkedList<Appt>();
			 LinkedList<Appt> anothertest12=timeTable2.deleteAppt(listApptsEmpty, appt2);
			 assertNull(timeTable2.deleteAppt(listApptsEmpty, appt2));
			 
		 }
		 
		 
	 }
	 
	 
	 	 @Test 
	  public void radnomtestDeleteIncreadCollisiontest()  throws Throwable  {
		 long randomseed =System.currentTimeMillis(); //10
		Random random = new Random(randomseed);
		 for(int i = 0; i < 9000;i++){
				//testing deleteAppt()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
								//hr,min,day,mon,yr,title,desc
			int randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			int randomhour=ValuesGenerator.getRandomIntBetween(random,2,22);
			int randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			int randomday=ValuesGenerator.getRandomIntBetween(random,1,31);
							   //hr,min,day,mon,yr,title,desc
			 Appt appt1 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Tester","testDay1");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			 Appt appt17 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Tester","testDay1");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomhour=ValuesGenerator.getRandomIntBetween(random,1,23);
			 Appt appt2 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing2","testDay2");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomday=ValuesGenerator.getRandomIntBetween(random,1,31);
			 Appt appt3 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing3","testDay3");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			 Appt appt21 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing2","testDay2");
			 
			randomyear=ValuesGenerator.getRandomIntBetween(random,2016,2025);
			randomhour=ValuesGenerator.getRandomIntBetween(random,1,26);
			randommonth=ValuesGenerator.getRandomIntBetween(random,1,12);
			randomday=ValuesGenerator.getRandomIntBetween(random,1,20);
			 Appt appt31 = new Appt(randomhour,45,randomday,randommonth,randomyear,"Testing3","testDay3");
			  
			listAppts.add(appt1);
			listAppts.add(appt17);
			listAppts.add(appt2);
			listAppts.add(appt3); 	
			listAppts.add(appt21);
			
			 TimeTable timeTable=new TimeTable();
			
			
			//delete a particular appointment from the list
			LinkedList<Appt> listDeletedAppts=timeTable.deleteAppt(listAppts, listAppts.get(1));
			
			
			 
		 }
		 
		 
	 }
	
	
	 /* @Test 
	  public void radnomtestDelete2()  throws Throwable  {
		 long randomseed =System.currentTimeMillis(); //10
		Random random = new Random(randomseed);
		 for(int i = 0; i < 100;i++){
				//testing deleteAppt()
		  LinkedList<Appt> listAppts = new LinkedList<Appt>();
			
			int thisMonth;
			int thisYear;
			int thisDay;
			
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
			 Appt appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);			
			 
			 listAppts.add(appt);
			  
			 startHour=14;
			 startMinute=30;
			 startDay=thisDay;  	
			 startMonth=thisMonth; 	
			 startYear=thisYear; 	
			 title="Class";
			 description="Rescheduled class.";
			 //Construct a new Appointment object with the initial data	 
			appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
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
			 appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
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
			 appt = new Appt(startHour,startMinute,startDay,startMonth,startYear,title,description);
			 int[] recurDaysArr={2,3,4};
			 appt.setRecurrence( recurDaysArr, Appt.RECUR_BY_WEEKLY, 2, Appt.RECUR_NUMBER_FOREVER);
			
			 listAppts.add(appt);
						
			 TimeTable timeTable=new TimeTable();
			
			
			//delete a particular appointment from the list
			
			
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
		 
		 
	 }*/
}
