package main.recruiter;

import java.util.concurrent.atomic.AtomicInteger;

public class RecruiterId
{
  private int                  id;
  private static AtomicInteger counter = new AtomicInteger(0);

  public RecruiterId()
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
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    RecruiterId other = (RecruiterId) obj;
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
