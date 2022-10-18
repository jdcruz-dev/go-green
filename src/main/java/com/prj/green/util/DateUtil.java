package com.prj.green.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

	public static LocalDateTime convertStringToLocalDateTime(String dateToConvert) {
		
		try {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
			LocalDateTime dateTime = LocalDateTime.parse(dateToConvert);

			return dateTime;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
