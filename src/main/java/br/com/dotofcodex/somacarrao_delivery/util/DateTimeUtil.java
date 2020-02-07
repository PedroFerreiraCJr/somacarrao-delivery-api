package br.com.dotofcodex.somacarrao_delivery.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {

	private static final ZoneId AMERICA_FORTALEZA;
	private static final String DATE_FORMAT_FULL_PATTERN;
	private static final SimpleDateFormat SDF;
	private static final DateTimeFormatter DATE_TIME_FORMATTER;

	static {
		AMERICA_FORTALEZA = ZoneId.of("America/Fortaleza");
		DATE_FORMAT_FULL_PATTERN = "dd/MM/yyyy HH:mm:ss:SSS";
		SDF = new SimpleDateFormat(DATE_FORMAT_FULL_PATTERN);
		DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss:SSS");
	}

	public static Date now() {
		OffsetDateTime odt = OffsetDateTime.now();
		synchronized (odt) {
			try {
				return SDF.parse(odt.atZoneSameInstant(AMERICA_FORTALEZA).format(DATE_TIME_FORMATTER));
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public static Date nowPlusMinutes(long minutes) {
		OffsetDateTime odt = OffsetDateTime.now();
		synchronized (odt) {
			try {
				return SDF.parse(
						odt.atZoneSameInstant(AMERICA_FORTALEZA).plusMinutes(minutes).format(DATE_TIME_FORMATTER));
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public static String dateToString(Date date) {
		return SDF.format(date);
	}
	
	public static Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

}
