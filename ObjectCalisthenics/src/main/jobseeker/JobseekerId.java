package main.jobseeker;

import java.util.concurrent.atomic.AtomicInteger;

public class JobseekerId
{
  private int                  id;
  private static AtomicInteger counter = new AtomicInteger(0);

  public JobseekerId()
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
    if (!(obj instanceof JobseekerId))
      return false;
    JobseekerId other = (JobseekerId) obj;
    return id == other.id;
  }

  private static int nextId()
  {
    return counter.getAndIncrement();
  }

  @Override
  public String toString()
  {
    return String.valueOf(id);
  }
}
