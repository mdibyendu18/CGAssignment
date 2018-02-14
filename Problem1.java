package com.cg.assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;

/* Write a function that takes two Date parameters as inputs, 
 * say fromdate and todate, and the function returns the first 
 * day of the fromdate's month and last day of todate's month. 
 * Make sure that the last day does not exceed today's date in any case
 */
public class Problem1 {

	public static void returnDateMethod(Date fromDate, Date toDate) throws ParseException {
		

			Date curDate = new Date();			
			Calendar ctoDate = Calendar.getInstance();
			ctoDate.setTime(toDate);
			ctoDate.set(Calendar.DAY_OF_MONTH, ctoDate.getActualMaximum(Calendar.DAY_OF_MONTH));
			String tDate = "";
			if(curDate.before(ctoDate.getTime())) {
				ctoDate.setTime(curDate);
				tDate = ctoDate.get(Calendar.YEAR) + "-" + (ctoDate.get(Calendar.MONTH) + 1)  + "-"
						+ ctoDate.get(Calendar.DATE);
			} else {
				tDate = ctoDate.get(Calendar.YEAR) + "-" + (ctoDate.get(Calendar.MONTH) + 1)  + "-"
							+ ctoDate.get(Calendar.DATE);
			}
			
			Calendar cfromDate = Calendar.getInstance();
			cfromDate.setTime(fromDate);
			cfromDate.set(Calendar.DAY_OF_MONTH, cfromDate.getActualMinimum(Calendar.DAY_OF_MONTH));

			String fDate = cfromDate.get(Calendar.YEAR) + "-" + (cfromDate.get(Calendar.MONTH) + 1)  + "-"
					+ cfromDate.get(Calendar.DATE);
			System.out.println("from Date: "+fDate);
 			System.out.println("to Date: "+tDate);
 			

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expectedPattern = "yyyy-MM-dd";
	    SimpleDateFormat formatter = new SimpleDateFormat(expectedPattern);
	    Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the fromDate in the format yyy-MM-dd");
			String fDate = sc.nextLine();
			Date fromDate = formatter.parse(fDate);
			System.out.println("Enter the toDate in the format yyy-MM-dd");
			String tDate = sc.nextLine();
			Date toDate = formatter.parse(tDate);
			//Map<String,String> map = returnDateMethod(fromDate, toDate);
			returnDateMethod(fromDate, toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.close();

	}

}
