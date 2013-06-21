package main;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ApplicationDate
{
  public static Date createDate()
  {
    Calendar calendar = Calendar.getInstance();
    return calendar.getTime();
  }

  public static boolean compareDate(Date date1,
                                    Date date2)
  {
    Calendar c1 = removeTimeInfoFromDate(date1);
    Calendar c2 = removeTimeInfoFromDate(date2);
    return c1.equals(c2);
  }

  public static Calendar removeTimeInfoFromDate(Date date)
  {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return new GregorianCalendar(calendar.get(Calendar.YEAR),
                                 calendar.get(Calendar.MONTH),
                                 calendar.get(Calendar.DAY_OF_MONTH));
  }

}
