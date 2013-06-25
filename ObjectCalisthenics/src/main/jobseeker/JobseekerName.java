package main.jobseeker;

public class JobseekerName
{
  private final String name;

  public JobseekerName(String name)
  {
    if (name == null || name.equals(""))
      throw new IllegalArgumentException("Jobseeker name cannot be null or empty");
    this.name = name;
  }

  @Override
  public String toString()
  {
    return name;
  }

}
