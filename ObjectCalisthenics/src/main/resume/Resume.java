package main.resume;

public class Resume
{

  public Resume(String resume)
  {
    if(resume == null || resume.equals("")) throw new IllegalArgumentException("Resume cannot be null or empty string");
  }
}
