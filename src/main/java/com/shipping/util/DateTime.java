package com.shipping.util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateTime implements Cloneable, Comparable, Serializable {
	private Calendar calender;
	private SimpleDateFormat format;

	public DateTime() {
		this.calender = Calendar.getInstance();
	}

	/*
	 * public DateTime(String dateStr) { SimpleDateFormat sdf = new
	 * SimpleDateFormat("dd/MM/yyyy"); try { date = sdf.parse(dateStr); } catch
	 * (ParseException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * } }
	 */

	public Date getDate() {
		return this.calender.getTime();
	}

	public String getDateStr() {
		return (new SimpleDateFormat("dd-MMM-yyyy")).format(this.calender.getTime());
	}

	public void setTimeZone(TimeZone tz) {
		this.calender.setTimeZone(tz);
	}

	public Timestamp getTimestamp() {
		Timestamp result = null;
		if (this.calender != null) {
			long ts = this.calender.getTime().getTime();
			result = new Timestamp(ts);
		}
		return result;
	}

	public int hashCode() {
		return this.getDate().hashCode();
	}

	public boolean equals(Object obj) {
		if (obj instanceof DateTime) {
			DateTime dt = (DateTime) obj;
			if (dt.getDate().getTime() == this.getDate().getTime()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
