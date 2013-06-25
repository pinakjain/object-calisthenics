package main.jobs;

public class JobId
{
  private int id;

  public JobId(int id)
  {
    this.id = id;
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
    JobId other = (JobId) obj;
    return id == other.id;
  }

}
