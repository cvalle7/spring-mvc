package com.formacion.nttdata.hello.servicio;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Service;

@Service
public class HomeService {
	
	public String normalFecha(Locale locale) {
		
		Date date = new Date();

		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		return formattedDate;
		
	}
	
	public String calculoFecha(Locale locale, int numero) {
		
		Date date = new Date();

		Calendar c = Calendar.getInstance();

		c.setTime(date);
		
		c.add(Calendar.DATE, numero);
		
		Date fecha = c.getTime();
		
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(fecha);
		
		return formattedDate;
		
	}

}
