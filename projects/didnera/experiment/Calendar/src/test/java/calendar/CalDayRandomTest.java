package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for CalDay class.
 */

public class CalDayRandomTest {
	
    /**
     * Generate Random Tests that tests CalDay Class.
     */
	 @Test
	  public void radnomtest()  throws Throwable  {
		  long randomseed =System.currentTimeMillis(); //10
		Random random = new Random(randomseed);
		 for(int i = 0; i < 9000;i++){
							   //hr,min,day,mon,yr,title,desc
							   
			int a1 = ValuesGenerator.getRandomIntBetween(random,-5,70);
			int a2 = ValuesGenerator.getRandomIntBetween(random,-5,70);
			int a3= ValuesGenerator.getRandomIntBetween(random,-5,70);
			 Appt appt1 = new Appt(a1,45,04,02,2018,"Tester","testDay1");
			 Appt appt2 = new Appt(a2,02,06,02,2018,"Testing2","testDay2");
			 Appt appt3 = new Appt(a3,30,06,02,2018,"Testing3","testDay3");
			 
			 
			 GregorianCalendar aday = new GregorianCalendar(2001,11,29);
			 CalDay anotherCalDay = new CalDay(aday);
			 
			 anotherCalDay.addAppt(appt1);
			 anotherCalDay.addAppt(appt2);
			 anotherCalDay.addAppt(appt3);
			 
			 int counter=0;
			 if(appt1.getValid()){
				 counter++;
			 }
			if(appt2.getValid()){
				counter++;
			}
			if(appt3.getValid()){
				counter++;
			}
			assertEquals(counter,anotherCalDay.getSizeAppts());
			 
		 }
	 }


	
}
