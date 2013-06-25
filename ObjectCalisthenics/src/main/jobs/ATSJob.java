package main.jobs;

public class ATSJob implements Job
{

  private final JobTitle title;
  private final JobId    id;

  public ATSJob(String title)
  {
    this.title = new JobTitle(title);
    this.id = new JobId();
  }

  @Override
  public boolean requiresResume()
  {
    return false;
  }

  @Override
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

}
