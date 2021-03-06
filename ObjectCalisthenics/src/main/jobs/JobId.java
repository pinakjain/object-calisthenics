package main.jobs;

import java.util.concurrent.atomic.AtomicInteger;

public class JobId
{
  private int                  id;
  private static AtomicInteger counter = new AtomicInteger(0);

  public JobId()
  {
    this.id = nextId();
  }

  @Override
  public int hashCode()
  {
    return 31 + id;
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (!(obj instanceof JobId))
      return false;
    JobId other = (JobId) obj;
    return id == other.id;
  }

  private static int nextId()
  {
    return counter.getAndIncrement();
  }
  
  public static JobId createJobId(){
    return new JobId();
 }
  
  @Override
  public String toString()
  {
    return String.valueOf(id);
  }

}
