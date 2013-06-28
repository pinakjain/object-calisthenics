package main.utils;

import java.util.Date;

public class TestApplicationDateGenerator implements DateGenerator
{
  private Date date;

  public TestApplicationDateGenerator(Date date)
  {
    if(date == null) throw new IllegalArgumentException("Date cannot be null");
    this.date = date;
  }

  @Override
  public Date applicationDate()
  {
    return date;
  }

 
}
