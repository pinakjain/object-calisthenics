package main.resume;

public class Resume
{

  private final String resume;

  public Resume(String resume)
  {
    if(this.resume == null || this.resume.equals("")) throw new IllegalArgumentException("Resume cannot be null or empty string");
    this.resume = resume;
  }
}
