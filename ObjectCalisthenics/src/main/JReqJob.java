package main;

public class JReqJob implements Job
{

  private final String title;
  private final int    id;

  public JReqJob(String title) throws IllegalArgumentException
  {
    if (title == null || title.equals(""))
      throw new IllegalArgumentException("Title for a job cannot be null or empty");
    this.title = title;
    this.id = IdGenerator.createId();
  }

  @Override
  public boolean requiresResume()
  {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public void display()
  {
    // TODO Auto-generated method stub
    System.out.println("JReq Job :-" + title + " (ID = " + id + ")");
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
    JReqJob other = (JReqJob) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString()
  {
    return "JReqJob :- " + title;
  }
}
