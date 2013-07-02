package main.jobs;

public class JobTitle
{
  private final String title;

  public JobTitle(String title)
  {
    if (title == null || title.equals(""))
      throw new IllegalArgumentException("Job Title cannot be null or emoty");
    this.title = title;
  }

  @Override
  public String toString()
  {
    return title;
  }

}
