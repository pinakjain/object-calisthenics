package main.jobs;

import main.utils.IdGenerator;

public class JReqJob implements Job
{

  private final String title;
  private final JobId  id;

  public JReqJob(String title)
  {
    if (title == null || title.equals(""))
      throw new IllegalArgumentException("Title for a job cannot be null or empty");
    this.title = title;
    this.id = new JobId(IdGenerator.createId());
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
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
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
