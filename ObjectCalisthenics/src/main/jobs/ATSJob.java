package main.jobs;

import main.utils.IdGenerator;

public class ATSJob implements Job
{

  private final String title;
  private final JobId    id;

  public ATSJob(String title) throws IllegalArgumentException
  {
    if (title == null)
      throw new IllegalArgumentException("Title for a job cannot be null");
    if (title.equals(""))
      throw new IllegalArgumentException("Title for a job cannot be empty");
    this.title = title;
    this.id = new JobId(IdGenerator.createId());
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
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ATSJob other = (ATSJob) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "ATSJob :- " + title;
  }

}
