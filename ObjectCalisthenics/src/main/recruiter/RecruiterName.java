package main.recruiter;

public class RecruiterName
{
  private final String name;

  public RecruiterName(String name)
  {
    if (name == null || name.equals(""))
      throw new IllegalArgumentException("Recruiter name cannot be null or empty");
    this.name = name;
  }

  @Override
  public String toString()
  {
    return name;
  }

}
