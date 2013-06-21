package main;

public class ATSJob implements Job
{

  private final String title;
  private final int    id;

  public ATSJob(String title) throws NullPointerException
  {
    if (title == null)
      throw new NullPointerException("Title for a job cannot be null");
    if (title.equals(""))
      throw new IllegalArgumentException("Title for a job cannot be empty");
    this.title = title;
    this.id = IdGenerator.createId();
  }

  @Override
  public boolean requiresResume()
  {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void display()
  {
    // TODO Auto-generated method stub
    System.out.println("ATS Job :-" + title + " (ID = " + id + ")");
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    return result;
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
