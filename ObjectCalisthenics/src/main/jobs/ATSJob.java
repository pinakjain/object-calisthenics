package main.jobs;

import main.display.JobDisplayer;

public class ATSJob implements Job
{

  private final JobTitle title;
  private final JobId    id;

  public ATSJob(String title)
  {
    this.title = new JobTitle(title);
    this.id = JobId.createJobId();
  }

  @Override
  public boolean requiresResume()
  {
    return false;
  }

  public void display()
  {
    System.out.println("ATS Job :-" + title + " (ID = " + id + ")");
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
    if (!(obj instanceof ATSJob))
      return false;
    ATSJob other = (ATSJob) obj;
    return id.equals(other.id);
  }

  @Override
  public String toString()
  {
    return "ATSJob :- " + title;
  }

  @Override
  public void display(JobDisplayer displayer)
  {
    displayer.display(title);
  }

}