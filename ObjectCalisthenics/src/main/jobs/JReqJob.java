package main.jobs;

import main.display.JobDisplayer;

public class JReqJob implements Job
{

  private final JobTitle title;
  private final JobId  id;

  public JReqJob(String title)
  {
    this.title = new JobTitle(title);
    this.id = JobId.createJobId();
  }

  @Override
  public boolean requiresResume()
  {
    return true;
  }

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

  @Override
  public void display(JobDisplayer displayer)
  {
    displayer.display(title);
  }
}
