package com.wsloan.fanLiWang.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExcelException extends Exception {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcelException() {
	        // TODO Auto-generated constructor stub
	    }

	    public ExcelException(String message) {
	        super(message);
	        // TODO Auto-generated constructor stub
	    }

	    public ExcelException(Throwable cause) {
	        super(cause);
	        // TODO Auto-generated constructor stub
	    }

	    public ExcelException(String message, Throwable cause) {
	        super(message, cause);
	        // TODO Auto-generated constructor stub
	    }



	    /*public static void main(String[] args) {
			String d = "2004-1-1";
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");*//*** 加一天*//*
			try {Date dd = df.parse(d);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dd);
				calendar.add(Calendar.DAY_OF_MONTH, 1);//加一天
				String ss = df.format(calendar.getTime());
				System.out.println("增加一天之后：" + df.format(calendar.getTime()));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
*/
	
}
