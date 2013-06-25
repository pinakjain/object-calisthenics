package main.jobs;

public class JReqJob implements Job
{

  private final JobTitle title;
  private final JobId  id;

  public JReqJob(String title)
  {
    this.title = new JobTitle(title);
    this.id = new JobId();
  }

  @Override
  public boolean requiresResume()
  {
    return true;
  }

  @Override
  public void display()
  {
    System.out.println("JReq Job :-" + title + " (ID = " + id + ")");
  }

  @Override
  public int hashCode()
  {
    return id.hashCode();
  }

  @Override
  public boolean equals(Object obj)
  {
    if (this == obj)
      return true;
    if (!(obj instanceof JReqJob))
      return false;
    JReqJob other = (JReqJob) obj;
    return id.equals(other.id);
  }

  @Override
  public String toString()
  {
    return "JReqJob :- " + title;
  }
}
