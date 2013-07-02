package main.utils;

import java.util.Calendar;
import java.util.Date;

public class ApplicationDateGenerator implements DateGenerator
{

  private static Calendar createCalendarInstance()
  {
    return Calendar.getInstance();
  }

  @Override
  public Date applicationDate()
  {
    Calendar calendar = createCalendarInstance();
    return calendar.getTime();
  }
}
