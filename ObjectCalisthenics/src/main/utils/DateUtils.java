package main.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils
{

  public static Date currentDate()
  {
    Calendar calendar = createCalendarInstance();
    return calendar.getTime();
  }
  
  public static Date yesterdayDate()
  {
    Calendar calendar = createCalendarInstance();
    calendar.add(Calendar.DATE, -1);
    return calendar.getTime();
  }

  public static boolean areSameDay(Date date1,
                                   Date date2)
  {
    Calendar c1 = removeTimeInfoFromDate(date1);
    Calendar c2 = removeTimeInfoFromDate(date2);
    return c1.equals(c2);
  }

  public static Calendar removeTimeInfoFromDate(Date date)
  {
    Calendar calendar = createCalendarInstance();
    calendar.setTime(date);
    return new GregorianCalendar(calendar.get(Calendar.YEAR),
                                 calendar.get(Calendar.MONTH),
                                 calendar.get(Calendar.DAY_OF_MONTH));
  }

  private static Calendar createCalendarInstance()
  {
    return Calendar.getInstance();
  }
}
