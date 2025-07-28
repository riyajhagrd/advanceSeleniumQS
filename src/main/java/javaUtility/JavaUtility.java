package javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	public int getRandonNumber() {
		Random ran = new Random();
		int ranCount = ran.nextInt(1000);
		return ranCount;
		
	}
	
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
		String currentDate = sim.format(date);
		return currentDate;
	}
	
	public String getRequiredDate(int days) {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM-dd-YYYY");
		
		sim.format(date);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String dateRequired = sim.format(cal.getTime());
		
		return dateRequired;
		
		
	}

}
