package main;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator
{

  private static AtomicInteger counter = new AtomicInteger(0);

  public static int createId()
  {
    return counter.getAndIncrement();
  }

}
